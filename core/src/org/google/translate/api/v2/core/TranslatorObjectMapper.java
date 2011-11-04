package org.google.translate.api.v2.core;

import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.DeserializationProblemHandler;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * An Object Mapper that handles the conversion from and to JSON.
 */
public class TranslatorObjectMapper extends ObjectMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(TranslatorObjectMapper.class);
    /**
     * The singleton instance of this class.
     */
    private static final TranslatorObjectMapper INSTANCE = new TranslatorObjectMapper();

    /**
     * Creates the Object Mapper with JAXB annotations and logging of unknown properties.
     */
    private TranslatorObjectMapper() {
        // Use JAXB annotations to allow transforming API objects to XML in the future
        setAnnotationIntrospector(new JaxbAnnotationIntrospector());
        // Adding a deserialization to log a warning for missing properties
        getDeserializationConfig().addHandler(new DeserializationProblemHandler() {
            @Override
            public boolean handleUnknownProperty(DeserializationContext context, JsonDeserializer<?> deSerializer, Object beanOrClass, String propertyName) throws IOException {
                String className = (beanOrClass instanceof Class) ? ((Class) beanOrClass).getName() : beanOrClass.getClass().getName();
                LOGGER.warn("Unknown property while de-serializing: " + className + "." + propertyName);
                context.getParser().skipChildren();
                return true;
            }
        });
    }

    /**
     * @return {@link #INSTANCE}
     */
    public static TranslatorObjectMapper instance() {
        return INSTANCE;
    }
}
