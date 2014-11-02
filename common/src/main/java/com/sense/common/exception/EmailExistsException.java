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
package com.sense.common.exception;

import java.io.Serializable;

/**
 * Created by brianenochson.
 */
public class EmailExistsException extends Exception implements Serializable {

    public EmailExistsException() {
        super();
    }

    public EmailExistsException(String message) {
        super(message);
    }

    public EmailExistsException(Throwable cause, String message) {
        super(message, cause);
    }
}
