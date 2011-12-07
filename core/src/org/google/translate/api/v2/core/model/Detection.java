package org.google.translate.api.v2.core.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * Represents a Google Translate API Detection.
 *
 * @see org.google.translate.api.v2.core.Translator#detect(String[])
 */
@SuppressWarnings("UnusedDeclaration")
public class Detection extends AbstractResponseObject implements Comparable<Detection> {
    /**
     * The language code associated with the given text.
     * @see Language
     */
    private String language;

    /**
     * A boolean representing whether or not the detection interval believes the language code is reliable for the given text.
     */
    private boolean reliable;

    /**
     * A numeric value between 0-1.0 that represents the confidence level in the language code for the given text.
     */
    private float confidence;

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
     * @return {@link #reliable}
     */
    @XmlElement(name = "isReliable")
    public boolean isReliable() {
        return reliable;
    }

    /**
     * @param reliable {@link #reliable}
     */
    public void setReliable(boolean reliable) {
        this.reliable = reliable;
    }

    /**
     * @return {@link #confidence}
     */
    public float getConfidence() {
        return confidence;
    }

    /**
     * @param confidence {@link #confidence}
     */
    public void setConfidence(float confidence) {
        this.confidence = confidence;
    }

    /**
     * Compares using the {@link #confidence}
     *
     * @param other the object to compare tp
     * @return the value 0 if confidence is equal, 1 if this confidence is greater, -1 if this confidence is greater
     */
    @Override
    public int compareTo(Detection other) {
        return Float.compare(this.confidence, other.confidence);
    }

    @Override
    public String toString() {
        if (checkToStringFormat(SHORT_TO_STRING_FORMAT)) {
            return language;
        }
        return "Detection{" +
                "language='" + language + '\'' +
                ", reliable=" + reliable +
                ", confidence=" + confidence +
                '}';
    }
}
