package org.google.translate.api.v2.core.model;

/**
 * A super class for all root classes that represent a Google API response
 */
@SuppressWarnings("UnusedDeclaration")
public abstract class AbstractResponse {
    /**
     * Contains error info from Google Translate API.
     * Null if everything was OK.
     */
    private ApiError error;

    /**
     * @return {@link #error}
     */
    public ApiError getError() {
        return error;
    }

    /**
     * @param error {@link #error}
     */
    public void setError(ApiError error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "AbstractResponse{" +
                "error=" + error +
                '}';
    }
}
