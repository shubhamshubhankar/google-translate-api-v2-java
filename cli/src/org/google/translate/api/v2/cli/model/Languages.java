package org.google.translate.api.v2.cli.model;

import org.google.translate.api.v2.core.model.Language;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

/**
 * Acts as a root for the {@link #languages} array - so it can be printed
 */
@XmlRootElement
@SuppressWarnings("UnusedDeclaration")
public class Languages {

    /**
     * The result of the {@link org.google.translate.api.v2.core.Translator#languages(String)} method.
     */
    private Language[] languages;

    public Languages() {
    }

    public Languages(Language[] languages) {
        this.languages = languages;
    }

    @XmlElement(name = "language")
    public Language[] getLanguages() {
        return languages;
    }

    public void setLanguages(Language[] languages) {
        this.languages = languages;
    }


    @Override
    public String toString() {
        return "Languages" +
                (languages == null ? null : Arrays.toString(languages));
    }
}
