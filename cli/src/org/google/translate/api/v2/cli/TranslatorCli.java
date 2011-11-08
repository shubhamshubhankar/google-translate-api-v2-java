package org.google.translate.api.v2.cli;

import org.apache.commons.cli.*;
import org.google.translate.api.v2.cli.model.Detections;
import org.google.translate.api.v2.cli.model.Languages;
import org.google.translate.api.v2.cli.model.Translations;
import org.google.translate.api.v2.core.Translator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

/**
 * The main class of the Google Translate API v2 CLI
 */
public class TranslatorCli {

    private static final Options OPTIONS = new Options();
    private static final Logger LOGGER = LoggerFactory.getLogger(TranslatorCli.class);
    private static final String VERBOSE_ARG = "-" + TranslatorOption.VERBOSE.getOpt();

    static {
        for (TranslatorOption translatorOption : TranslatorOption.values()) {
            OPTIONS.addOption(translatorOption.getOption());
        }
    }

    public static void main(String[] args) throws Exception {

        // Manually searching for the verbose option to print the raw arguments before parsing
        boolean verbose = false;
        for (String arg : args) {
            if (VERBOSE_ARG.equals(arg)) {
                verbose = true;
                break;
            }
        }
        if (verbose) {
            printVerbose("Raw arguments: " + Arrays.toString(args));
        }

        CommandLine commandLine;
        Parser parser = new GnuParser();
        try {
            commandLine = parser.parse(OPTIONS, args);
        } catch (ParseException e) {
            printHelp();
            throw e;
        }

        if (verbose) {
            StringBuilder message = new StringBuilder("Parsed options: ");
            for (Option option : commandLine.getOptions()) {
                if (option != null) {
                    String optionName = (option.getLongOpt() != null) ? option.getLongOpt() : option.getOpt();
                    message.append(optionName);
                    String[] optionValues = option.getValues();
                    if (optionValues != null) {
                        message.append('=');
                        if (optionValues.length == 1) {
                            message.append('\'').append(optionValues[0]).append('\'');
                        } else {
                            message.append(Arrays.toString(optionValues));
                        }
                    }
                    message.append(' ');
                }
            }
            printVerbose(message.toString());
        }


        if (TranslatorOption.HELP.isOn(commandLine) || args.length == 0) {
            printVersion();
            printHelp();
            return;
        }

        if (TranslatorOption.VERSION.isOn(commandLine)) {
            printVersion();
            return;
        }

        String apiKey = TranslatorOption.API_KEY.getOptionValue(commandLine);
        if (apiKey == null) {
            throw new MissingOptionException(TranslatorOption.API_KEY + " (" + TranslatorOption.API_KEY.getOption().getDescription() + ")");
        }

        Translator translator = null;
        try {
            translator = new Translator(apiKey);

            String outputFormatValue = TranslatorOption.OUTPUT.getOptionValue(commandLine, TranslatorOption.Settings.DEFAULT_OUTPUT.label);
            OutputFormat outputFormat = OutputFormat.fromLabel(outputFormatValue);
            if (outputFormat == null) {
                throw new IllegalArgumentException("Invalid value for option " + TranslatorOption.OUTPUT + ": " + TranslatorOption.OUTPUT.getOption().getDescription());
            }

            if (TranslatorOption.LANGUAGES.isOn(commandLine)) {
                String targetLanguage = TranslatorOption.TARGET_LANGUAGE.getOptionValue(commandLine);
                if (verbose) {
                    printVerbose("Requesting languages with targetLanguage = '" + targetLanguage + "'");
                }
                Languages languages = new Languages(translator.languages(targetLanguage));
                print(outputFormat.format(languages));
            }

            if (TranslatorOption.DETECT.isOn(commandLine)) {
                String[] sourceTexts = TranslatorOption.DETECT.getOptionValues(commandLine);
                if (verbose) {
                    printVerbose("Requesting detect with sourceTexts = " + Arrays.toString(sourceTexts));
                }
                Detections detections = new Detections(translator.detect(sourceTexts));
                print(outputFormat.format(detections));
            }

            if (TranslatorOption.TRANSLATE.isOn(commandLine)) {
                String[] sourceTexts = TranslatorOption.TRANSLATE.getOptionValues(commandLine);
                String sourceLanguage = TranslatorOption.SOURCE_LANGUAGE.getOptionValue(commandLine);
                String targetLanguage = TranslatorOption.TARGET_LANGUAGE.getOptionValue(commandLine);

                if (targetLanguage == null) {
                    throw new MissingOptionException(TranslatorOption.TARGET_LANGUAGE + " (" + TranslatorOption.TARGET_LANGUAGE.getOption().getDescription() + ")");
                }
                if (verbose) {
                    printVerbose("Requesting translate with sourceTexts = " + Arrays.toString(sourceTexts) + ", sourceLanguage = '" + sourceLanguage + "' and targetLanguage = '" + targetLanguage + "'");
                }
                Translations translations = new Translations(translator.translate(sourceTexts, sourceLanguage, targetLanguage));
                print(outputFormat.format(translations));
            }

        } finally {
            close(translator);
        }
    }

    private static void printVerbose(String text) {
        print("VERBOSE: " + text);
    }

    private static void printVersion() throws IOException {
        print(extractVersion(TranslatorCli.class) + ", " + extractVersion(Translator.class));
    }

    private static void print(String text) {
        System.out.println(text);
    }

    private static String extractVersion(Class<?> clazz) throws IOException {
        InputStream inputStream = null;
        try {
            String className = clazz.getSimpleName() + ".class";
            String classPath = clazz.getResource(className).toString();
            if (!classPath.startsWith("jar")) {
                // Class not from JAR
                return "Development";
            }
            String manifestPath = classPath.substring(0, classPath.lastIndexOf("!") + 1) + "/META-INF/MANIFEST.MF";
            inputStream = new URL(manifestPath).openStream();
            Manifest manifest = new Manifest(inputStream);

            Attributes commonAttributes = manifest.getAttributes("common");
            return commonAttributes.getValue("Implementation-Title") + " version " + commonAttributes.getValue("Implementation-Version");
        } finally {
            close(inputStream);
        }
    }

    private static void printHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp(
                "java -jar google-translate-api-v2-java-cli-0.5.jar"
                , null
                , OPTIONS
                , "Examples:\n" +
                "--apiKey YOUR_GOOGLE_API_KEY --translate \"Hello\" \"Hola\" --targetLanguage iw\n" +
                "--apiKey YOUR_GOOGLE_API_KEY --detect \"Hello\" \"Hola\" --output xml\n" +
                "--apiKey YOUR_GOOGLE_API_KEY --languages --targetLanguage en\n"
                , true);
    }

    private static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                LOGGER.warn("Exception closing resource ", e);
            }
        }
    }
}
