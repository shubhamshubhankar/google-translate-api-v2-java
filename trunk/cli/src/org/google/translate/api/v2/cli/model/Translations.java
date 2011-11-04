package org.google.translate.api.v2.cli.model;

import org.google.translate.api.v2.core.model.Translation;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

/**
 * Acts as a root for the {@link #translations} array - so it can be printed
 */
@XmlRootElement
@SuppressWarnings("UnusedDeclaration")
public class Translations {

    /**
     * The result of the {@link org.google.translate.api.v2.core.Translator#translate(String, String, String)} and
     * {@link org.google.translate.api.v2.core.Translator#translate(String[], String, String)} methods.
     */
    private Translation[] translations;

    public Translations() {
    }

    public Translations(Translation[] translations) {
        this.translations = translations;
    }

    @XmlElement(name = "translation")
    public Translation[] getTranslations() {
        return translations;
    }

    public void setTranslations(Translation[] translations) {
        this.translations = translations;
    }

    @Override
    public String toString() {
        return "Translations" +
                (translations == null ? null : Arrays.toString(translations));
    }
}
