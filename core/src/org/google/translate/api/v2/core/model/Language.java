package org.google.translate.api.v2.core.model;

/**
 * Represents a Google Translate API Language
 */
@SuppressWarnings("UnusedDeclaration")
public class Language {
    /**
     * The language code
     */
    private String language;
    /**
     * The language name if the targetLanguage parameter was passed to {@link org.google.translate.api.v2.core.Translator#languages(java.lang.String)},
     * null otherwise.
     */
    private String name;

    /**
     * @return {@link #language}
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language {@link #language}
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return {@link #name}
     */
    public String getName() {
        return name;
    }

    /**
     * @param name {@link #name}
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String str = "Language{" +
                "language='" + language + '\'';
        if (name != null) {
            str += ", name='" + name + '\'';
        }
        str += '}';
        return str;
    }
}
