package org.google.translate.api.v2.cli;

import org.google.translate.api.v2.cli.model.Detections;
import org.google.translate.api.v2.cli.model.Languages;
import org.google.translate.api.v2.cli.model.Translations;
import org.google.translate.api.v2.core.TranslatorObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class Utils {
    public static final JAXBContext JAXB_CONTEXT;

    static {
        try {
            JAXB_CONTEXT = JAXBContext.newInstance(Translations.class, Detections.class, Languages.class);
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static String toXml(Object o) throws JAXBException {
        Writer writer = new StringWriter();
        Marshaller marshaller = JAXB_CONTEXT.createMarshaller();
        applySystemProperty(marshaller, Marshaller.JAXB_ENCODING);
        applySystemProperty(marshaller, Marshaller.JAXB_FORMATTED_OUTPUT);
        marshaller.marshal(o, writer);
        return writer.toString();
    }

    private static void applySystemProperty(Marshaller marshaller, String propertyKey) throws PropertyException {
        String propertyValue = System.getProperty(propertyKey);
        if (propertyValue != null) {
            marshaller.setProperty(propertyKey, propertyValue);
        }
    }

    public static String toJson(Object o) throws IOException {
        Writer writer = new StringWriter();
        TranslatorObjectMapper.instance().writeValue(writer, o);
        return writer.toString();
    }
}
