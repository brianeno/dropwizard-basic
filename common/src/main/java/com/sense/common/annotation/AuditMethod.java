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

package com.sense.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by brianenochson.
 */
@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.METHOD)
public @interface AuditMethod {}