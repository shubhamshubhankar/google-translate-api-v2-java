package org.google.translate.api.v2.cli.model;

import org.google.translate.api.v2.core.model.Detection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

/**
 * Acts as a root for the {@link #detections} matrix - so it can be printed
 */
@XmlRootElement
@SuppressWarnings("UnusedDeclaration")
public class Detections {

    /**
     * The result of the {@link org.google.translate.api.v2.core.Translator#detect(String[])} method.
     */
    private Detection[][] detections;

    public Detections() {
    }

    public Detections(Detection[][] detections) {
        this.detections = detections;
    }

    @XmlElement(name = "detection")
    public Detection[][] getDetections() {
        return detections;
    }

    public void setDetections(Detection[][] detections) {
        this.detections = detections;
    }

    @Override
    public String toString() {
        return "Detections" +
                (detections == null ? null : Arrays.deepToString(detections));
    }
}
