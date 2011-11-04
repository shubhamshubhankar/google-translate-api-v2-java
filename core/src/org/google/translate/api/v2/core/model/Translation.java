package org.google.translate.api.v2.core.model;

/**
 * Represents a Google Translate API translation
 */
@SuppressWarnings("UnusedDeclaration")
public class Translation {
    /**
     * The translated text
     */
    private String translatedText;
    /**
     * The detected source language or null if null sourceLanguage was passed to the
     * {@link org.google.translate.api.v2.core.Translator#translate(java.lang.String, java.lang.String, java.lang.String)} method.
     */
    private String detectedSourceLanguage;

    /**
     * @return {@link #translatedText}
     */
    public String getTranslatedText() {
        return translatedText;
    }

    /**
     * @param translatedText {@link #translatedText}
     */
    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }

    /**
     * @return {@link #detectedSourceLanguage}
     */
    public String getDetectedSourceLanguage() {
        return detectedSourceLanguage;
    }

    /**
     * @param detectedSourceLanguage {@link #detectedSourceLanguage}
     */
    public void setDetectedSourceLanguage(String detectedSourceLanguage) {
        this.detectedSourceLanguage = detectedSourceLanguage;
    }

    @Override
    public String toString() {
        return "Translation{" +
                "translatedText='" + translatedText + '\'' +
                ", detectedSourceLanguage='" + detectedSourceLanguage + '\'' +
                '}';
    }
}
