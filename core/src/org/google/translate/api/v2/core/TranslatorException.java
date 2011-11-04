package org.google.translate.api.v2.core;

import org.google.translate.api.v2.core.model.ApiError;

/**
 * A wrapper for an error response from the Google Translate API
 */
public class TranslatorException extends Exception {

    private ApiError error;

    public TranslatorException(ApiError error) {
        super(error.toString());
        this.error = error;
    }

    @SuppressWarnings("UnusedDeclaration")
    public ApiError getError() {
        return error;
    }
}
