package org.google.translate.api.v2.core.model;

import java.util.Arrays;

/**
 * Represents a Google Translate API response for translate request.
 * <pre>
 * {
 *  "data": {
 *      "translations": [
 *          {
 *          "translatedText": "Hello",
 *          "detectedSourceLanguage": "es"
 *          }
 *      ]
 *  }
 * }
 * </pre>
 *
 * @see org.google.translate.api.v2.core.Translator#translate(java.lang.String, java.lang.String, java.lang.String)
 */
@SuppressWarnings("UnusedDeclaration")
public class TranslateResponse extends AbstractResponse {
    private TranslateResponseData data;

    public TranslateResponseData getData() {
        return data;
    }

    public void setData(TranslateResponseData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TranslateResponse{" +
                "data=" + data +
                '}';
    }

    public class TranslateResponseData {
        private Translation[] translations;

        public Translation[] getTranslations() {
            return translations;
        }

        public void setTranslations(Translation[] translations) {
            this.translations = translations;
        }

        @Override
        public String toString() {
            return "TranslateResponseData{" +
                    "translations=" + (translations == null ? null : Arrays.asList(translations)) +
                    '}';
        }
    }
}
