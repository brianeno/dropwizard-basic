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

package com.sense.common.util;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by brianenochson.
 */
@Slf4j
public class AuditInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object [] args = invocation.getArguments();
        StringBuilder bldr = new StringBuilder("Audit Log: " + invocation.getMethod().getName() +
                " called with args [");

        if(args != null) {

            for(Object arg : args) {
                bldr.append("(");
                bldr.append(arg.toString());
                bldr.append(")");
            }
            bldr.append("]");
        }
        log.info(bldr.toString());
        return invocation.proceed();
    }
}
