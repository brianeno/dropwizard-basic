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

import com.sense.common.http.HttpError;
import com.sun.jersey.api.core.ExtendedUriInfo;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by brianenochson.
 */
@Slf4j
public class SecurityFilter  implements ContainerRequestFilter {
    @Context ExtendedUriInfo extendedUriInfo;
    private final static String SECURE = "secure";

    @Override
    public ContainerRequest filter(ContainerRequest request) {
        List<PathSegment> segments = extendedUriInfo.getPathSegments();
        //AbstractResourceMethod rm = extendedUriInfo.getMatchedMethod();
        for(PathSegment segment : segments) {
            //boolean methodIsSecured = extendedUriInfo.getMatchedMethod()
            //.isAnnotationPresent(Timed.class);//
            if(SECURE.equals(segment.getPath())) {
                String token = request.getHeaderValue(HttpHeaders.AUTHORIZATION);
                if (token == null) {
                    HttpError httpError = new HttpError.HttpErrorBuilder(Response.Status.UNAUTHORIZED).
                            type(HttpError.ERROR_TYPE).
                            code(HttpError.ErrorCode.AUTHORIZATION_HEADER_NOT_PRESENT).
                            message("Authorization header was not specified").build();
                    Response.ResponseBuilder builder = Response.status(Response.Status.UNAUTHORIZED).entity(httpError);
                    throw new WebApplicationException(builder.build());
                }
                else {
                    log.debug("Passed in authorization token of '{}'", token);
                }
                //TODO check token
                break;
            }
        }
        return request;
    }
}