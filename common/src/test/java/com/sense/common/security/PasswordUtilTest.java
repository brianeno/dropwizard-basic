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

package com.sense.common.security;

import junit.framework.TestCase;

public class PasswordUtilTest extends TestCase {

    private String testpass = "password";
    public void setUp() throws Exception {
        super.setUp();

    }

    public void tearDown() throws Exception {

    }

    public void testGetHash() throws Exception {

        String hash = PasswordUtil.getHash(testpass);
        assertNotNull(hash);
    }

    public void testMatches() throws Exception {
        String hash = PasswordUtil.getHash(testpass);
        assertTrue(PasswordUtil.matches(testpass, hash));
    }

    public void testDoesNotMatchesDifferent() throws Exception {
        String hash = PasswordUtil.getHash(testpass);
        assertFalse(PasswordUtil.matches(testpass + "1", hash));
    }

    public void testDoesNotMatchesCase() throws Exception {
        String hash = PasswordUtil.getHash(testpass);
        assertFalse(PasswordUtil.matches(testpass.toUpperCase(), hash));
    }

    public void testDoesNotMatchesSpace() throws Exception {
        String hash = PasswordUtil.getHash(testpass);
        assertFalse(PasswordUtil.matches(testpass + " ", hash));
    }

    public void testDoesNotMatchesSpecialCha() throws Exception {
        String hash = PasswordUtil.getHash(testpass + "$");
        assertTrue(PasswordUtil.matches(testpass + "$", hash));
    }
}