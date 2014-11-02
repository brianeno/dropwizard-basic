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

/**
 * Created by brianenochson.
 */
public class RequestCorrelation {

    public static final String CORRELATION_ID = "correlationId";

    private static final ThreadLocal<String> id = new ThreadLocal<>();

    public static String getId() {
        return id.get();
    }

    public static void setId(String correlationId) {
        id.set(correlationId);
    }
}