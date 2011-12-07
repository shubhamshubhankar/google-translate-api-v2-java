package org.google.translate.api.v2.core.model;

/**
 * Represents a Google Translate API Language
 */
@SuppressWarnings("UnusedDeclaration")
public class Language extends AbstractResponseObject implements Comparable<Language> {
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

    /**
     * If {@link #name} of this and other is not null - compare using the name,
     * otherwise compare using the {@link #language}.
     *
     * @param other the object to compare tp
     * @return {@link String#compareTo(String)} on the {@link #name} or the {@link #language}.
     */
    @Override
    public int compareTo(Language other) {
        return (name != null && other.name != null)
                ? name.compareTo(other.name)
                : language.compareTo(other.language);
    }

    @Override
    public String toString() {
        if (checkToStringFormat(SHORT_TO_STRING_FORMAT)) {
            return (name != null) ? name : language;
        }
        String str = "Language{" +
                "language='" + language + '\'';
        if (name != null || checkToStringFormat(FULL_TO_STRING_FORMAT)) {
            str += ", name='" + name + '\'';
        }
        return str + '}';
    }
}
