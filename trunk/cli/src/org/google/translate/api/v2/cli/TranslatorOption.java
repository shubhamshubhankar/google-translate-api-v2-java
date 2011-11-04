package org.google.translate.api.v2.cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;

public enum TranslatorOption {
    API_KEY(TranslatorCoreOptions.API_KEY, "Every request your application sends to the Google Translate API must identify your application to Google, using an API key (http://code.google.com/apis/language/translate/v2/using_rest.html#auth)"),

    TRANSLATE(TranslatorCoreOptions.TRANSLATE, "Translates source texts. Must be used with the " + TranslatorCoreOptions.TARGET_LANGUAGE + " to indicate the language to translate to, can also be used with the optional " + TranslatorCoreOptions.SOURCE_LANGUAGE + " option"),

    DETECT(TranslatorCoreOptions.DETECT, "Detects the language of source texts"),

    LANGUAGES(TranslatorCoreOptions.LANGUAGES, "Shows the supported languages that can be used in " + TranslatorCoreOptions.SOURCE_LANGUAGE + " and " + TranslatorCoreOptions.TARGET_LANGUAGE + " options. Can be used with the " + TranslatorCoreOptions.TARGET_LANGUAGE + " to show the names of the supported languages in addition to the codes"),

    SOURCE_LANGUAGE(TranslatorCoreOptions.SOURCE_LANGUAGE, "The language code of the source language. Used with the " + TranslatorCoreOptions.TRANSLATE + " option as the language from which to translate. If not mentioned, the source language will be auto detected"),

    TARGET_LANGUAGE(TranslatorCoreOptions.TARGET_LANGUAGE, "The language code of the target language. Mandatory when using with the " + TranslatorCoreOptions.TRANSLATE + " option, optional when using with the " + TranslatorCoreOptions.LANGUAGES + " option"),

    OUTPUT(TranslatorCoreOptions.OUTPUT, "The format of the output. Possible values are " + Settings.SUPPORTED_OUTPUTS),

    VERSION(TranslatorCoreOptions.VERSION, "Shows the version of the TranslatorCli and Translator core"),

    HELP(TranslatorCoreOptions.HELP, "Shows this help message");

    private TranslatorCoreOptions option;

    private TranslatorOption(TranslatorCoreOptions option, String description) {
        this.option = option;
        this.option.getOption().setDescription(description);
    }

    public Option getOption() {
        return option.getOption();
    }

    public String getOpt() {
        return option.getOption().getOpt();
    }

    public boolean isOn(CommandLine commandLine) {
        return commandLine.hasOption(getOpt());
    }

    public String getOptionValue(CommandLine commandLine) {
        return getOptionValue(commandLine, null);
    }

    public String getOptionValue(CommandLine commandLine, String defaultValue) {
        return commandLine.getOptionValue(getOpt(), defaultValue);
    }

    public String[] getOptionValues(CommandLine commandLine) {
        return commandLine.getOptionValues(getOpt());
    }

    @Override
    public String toString() {
        return option.getOption().getLongOpt();
    }


    public static class Settings {
        public static final OutputFormat DEFAULT_OUTPUT = OutputFormat.PLAIN;
        public static final String SUPPORTED_OUTPUTS;

        static {
            String comma = "";
            String supportedOutputFormats = "";
            for (OutputFormat outputFormat : OutputFormat.values()) {
                supportedOutputFormats += comma + "'" + outputFormat.label + "'";
                if (outputFormat == DEFAULT_OUTPUT) {
                    supportedOutputFormats += " (default)";
                }
                comma = ", ";
            }
            SUPPORTED_OUTPUTS = supportedOutputFormats;
        }
    }
}
