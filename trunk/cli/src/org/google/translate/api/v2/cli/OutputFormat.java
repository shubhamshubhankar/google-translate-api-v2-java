package org.google.translate.api.v2.cli;

/**
 * The available formats for the output CLI option
 */
public enum OutputFormat {
    PLAIN {
        @Override
        public String format(Object o) throws Exception {
            return o.toString();
        }
    },
    XML {
        @Override
        public String format(Object o) throws Exception {
            return Utils.toXml(o);
        }
    },
    JSON {
        @Override
        public String format(Object o) throws Exception {
            return Utils.toJson(o);
        }
    };

    public final String label = this.name().toLowerCase();

    public static OutputFormat fromLabel(String label) {
        for (OutputFormat outputFormat : values()) {
            if (outputFormat.label.equals(label)) {
                return outputFormat;
            }
        }
        return null;
    }

    public abstract String format(Object o) throws Exception;
}
