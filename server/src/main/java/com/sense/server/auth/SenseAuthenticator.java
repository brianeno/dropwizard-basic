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
package com.sense.server.auth;

import com.google.common.base.Optional;
import com.sense.common.util.UUIDHelper;
import com.sense.server.security.User;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

public class SenseAuthenticator implements Authenticator<BasicCredentials, User> {
    @Override
    public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
        //TO(BKE) check credentials external
        //if ("secret".equals(credentials.getPassword())) {
        return Optional.of(new User(credentials.getUsername(), credentials.getPassword(),
                    UUIDHelper.getUUID().toString(), null, null));
        //}
        //return Optional.absent();
    }
}
