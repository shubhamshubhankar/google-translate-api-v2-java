package org.google.translate.api.v2.cli;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;

@SuppressWarnings("AccessStaticViaInstance")
enum TranslatorCoreOptions {
    API_KEY(OptionBuilder
            .withArgName("api-key")
            .hasArg()
            .withLongOpt("apiKey")
            .create("ak")),

    TRANSLATE(OptionBuilder
            .withArgName("source-texts")
            .hasArgs()
            .withLongOpt("translate")
            .create("t")),

    DETECT(OptionBuilder
            .withArgName("source-texts")
            .hasArgs()
            .withLongOpt("detect")
            .create("d")),

    LANGUAGES(OptionBuilder
            .withLongOpt("languages")
            .create("l")),

    SOURCE_LANGUAGE(OptionBuilder
            .withArgName("language")
            .hasArgs()
            .withLongOpt("sourceLanguage")
            .create("sl")),

    TARGET_LANGUAGE(OptionBuilder
            .withArgName("language")
            .hasArgs()
            .withLongOpt("targetLanguage")
            .create("tl")),

    OUTPUT(OptionBuilder
            .withArgName("format")
            .hasArg()
            .withLongOpt("output")
            .create("o")),

    VERSION(OptionBuilder
            .withLongOpt("version")
            .create("v")),

    HELP(OptionBuilder
            .withLongOpt("help")
            .create("h"));

    private Option option;

    TranslatorCoreOptions(Option option) {
        this.option = option;
    }

    public Option getOption() {
        return option;
    }


    @Override
    public String toString() {
        return "'" + option.getLongOpt() + "'";
    }
}
