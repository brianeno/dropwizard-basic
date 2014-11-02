/*******************************************************************************
 * @preserve Copyright (c) 2014 Sense Inc. as an unpublished
 * work. Neither this material nor any portion hereof may be copied or
 * distributed without the express written consent of Sense Inc.
 *
 * This material also contains proprietary and confidential information
 * of Sense Inc. and its suppliers, and may not be used by or
 * disclosed to any person, in whole or in part, without the prior written
 * consent of Sense Inc.
 ******************************************************************************/
package com.sense.common.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.ws.rs.core.Response;

/**
 * Created by brianenochson .
 */
public class HttpError {
    public static final String ERROR_TYPE = "ERROR";
    private @JsonProperty @Getter Response.Status status;
    private @JsonProperty @Getter String type;
    private @JsonProperty @Getter ErrorCode code;
    private @JsonProperty @Getter String message;

    public enum ErrorCode {
        CLIENTID_NOT_PRESENT,
        AUTHORIZATION_HEADER_NOT_PRESENT,
        MISSED_REQUIRED_PROPERTY,
        INTERNAL_SERVER_ERROR
    }

    public HttpError(HttpErrorBuilder httpErrorBuilder) {
        this.status = httpErrorBuilder.status;
        this.type = httpErrorBuilder.type;
        this.code = httpErrorBuilder.code;
        this.message = httpErrorBuilder.message;
    }

    public static class HttpErrorBuilder {
        private Response.Status status;
        private String type;
        private ErrorCode code;
        private String message;

        public HttpErrorBuilder(Response.Status status) {
            this.status = status;
        }

        public HttpErrorBuilder type(String type) {
            this.type = type;
            return this;
        }

        public HttpErrorBuilder code(ErrorCode code) {
            this.code = code;
            return this;
        }

        public HttpErrorBuilder message(String message) {
            this.message = message;
            return this;
        }

        public HttpError build() {
            return new HttpError(this);
        }
    }
}
