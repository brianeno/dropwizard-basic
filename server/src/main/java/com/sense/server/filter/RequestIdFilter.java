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

package com.sense.server.filter;

import com.sense.common.http.RequestClientId;
import com.sense.common.http.RequestCorrelation;
import com.sense.common.util.UUIDHelper;
import com.sun.jersey.api.core.ExtendedUriInfo;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import javax.ws.rs.core.Context;

/**
 * Created by brianenochson .
 */
@Slf4j
public class RequestIdFilter implements ContainerRequestFilter {
    @Context ExtendedUriInfo extendedUriInfo;

    @Override
    public ContainerRequest filter(ContainerRequest request) {
        // request a client id
        String clientId = request.getHeaderValue(RequestClientId.CLIENTID);
        /*
        if (clientId == null) {
            log.error("No client id provided");
            HttpError httpError = new HttpError.HttpErrorBuilder(Response.Status.UNAUTHORIZED).
                    type(HttpError.ERROR_TYPE).
                    code(HttpError.ErrorCode.CLIENTID_NOT_PRESENT).
                    message("Client Id was not specified").build();

            Response.ResponseBuilder builder = Response.status(Response.Status.UNAUTHORIZED).entity(httpError);
            throw new WebApplicationException(builder.build());
        }
        RequestClientId.setId(clientId);

        */
        // check for correlation id and create one if not specificed
        String corrId = request.getHeaderValue(RequestCorrelation.CORRELATION_ID);
        if (corrId == null) {
            corrId = UUIDHelper.getUUID().toString();
            log.debug("No correlation id passed in request, generated {}", corrId);
        }
        else {
            log.debug("Correlation passed in request id of {}", corrId);
        }
        RequestCorrelation.setId(corrId);
        MDC.put("CORR_ID", corrId);
        MDC.put("CLIENT_ID", clientId);
        return request;
    }
}