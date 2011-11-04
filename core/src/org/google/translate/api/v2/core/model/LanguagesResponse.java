package org.google.translate.api.v2.core.model;

import java.util.Arrays;

/**
 * Represents a Google Translate API response for languages request.
 * <p/>
 * <pre>
 * {
 *  "data": {
 *      "languages": [
 *          {
 *          "language": "af",
 *          "name": "Afrikaans"
 *          },
 *          {
 *          "language": "yi",
 *          "name": "Yiddish"
 *          }
 *      ]
 *  }
 * }
 * </pre>
 *
 * @see org.google.translate.api.v2.core.Translator#languages(java.lang.String)
 */
@SuppressWarnings("UnusedDeclaration")
public class LanguagesResponse extends AbstractResponse {
    private LanguagesResponseData data;

    public LanguagesResponseData getData() {
        return data;
    }

    public void setData(LanguagesResponseData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LanguagesResponse{" +
                "data=" + data +
                '}';
    }

    public static class LanguagesResponseData {
        private Language[] languages;

        public Language[] getLanguages() {
            return languages;
        }

        public void setLanguages(Language[] languages) {
            this.languages = languages;
        }

        @Override
        public String toString() {
            return "LanguagesResponseData{" +
                    "languages=" + (languages == null ? null : Arrays.asList(languages)) +
                    '}';
        }
    }
}
