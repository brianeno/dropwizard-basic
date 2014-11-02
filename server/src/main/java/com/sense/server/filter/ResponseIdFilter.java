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

import com.sense.common.http.RequestCorrelation;
import com.sun.jersey.api.core.ExtendedUriInfo;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.Context;

/**
 * Created by brianenochson .
 */
@Slf4j
public class ResponseIdFilter implements ContainerResponseFilter {
    @Context ExtendedUriInfo extendedUriInfo;

    @Override
    public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
        response.getHttpHeaders().add(RequestCorrelation.CORRELATION_ID, RequestCorrelation.getId());
        return response;
    }
}