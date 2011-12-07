package org.google.translate.api.v2.core.model;

@SuppressWarnings("UnusedDeclaration")
public abstract class AbstractResponseObject {

    public static final String TO_STRING_FORMAT = "org.google.translate.api.v2.core.model.toString";

    public static final String SHORT_TO_STRING_FORMAT = "short";
    public static final String LONG_TO_STRING_FORMAT = "long";
    public static final String FULL_TO_STRING_FORMAT = "full";

    protected boolean checkToStringFormat(String format) {
        // Getting from System every time to allow changing it on the fly
        return System.getProperty(TO_STRING_FORMAT, SHORT_TO_STRING_FORMAT).equals(format);
    }
}
