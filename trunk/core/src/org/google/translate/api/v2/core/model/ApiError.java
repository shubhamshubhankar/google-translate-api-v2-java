package org.google.translate.api.v2.core.model;

import java.util.Arrays;

/**
 * Represents a Google Translate API error.
 * <pre>
 * {
 *  "error": {
 *      "errors": [
 *          {
 *          "domain": "global",
 *          "reason": "invalid",
 *          "message": "Invalid Value"
 *          }
 *      ],
 *      "code": 400,
 *      "message": "Invalid Value"
 *  }
 * }
 * </pre>
 */
@SuppressWarnings("UnusedDeclaration")
public class ApiError {
    private int code;
    private String message;
    private ErrorEntry[] errors;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorEntry[] getErrors() {
        return errors;
    }

    public void setErrors(ErrorEntry[] errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "ApiError{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", errors=" + (errors == null ? null : Arrays.asList(errors)) +
                '}';
    }

    public static class ErrorEntry {
        private String domain;
        private String reason;
        private String message;

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "ErrorEntry{" +
                    "domain='" + domain + '\'' +
                    ", reason='" + reason + '\'' +
                    ", message='" + message + '\'' +
                    '}';
        }
    }
}
