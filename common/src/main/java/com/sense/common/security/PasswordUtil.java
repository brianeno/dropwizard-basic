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

import com.sun.jersey.core.util.Base64;
import org.mindrot.jbcrypt.BCrypt;


/**
 * http://www.mindrot.org/projects/jBCrypt/
 *
 * Created by brianenochson.
 */
public class PasswordUtil {

    public static String getHash(String plainText) {

        String hashed = BCrypt.hashpw(plainText, BCrypt.gensalt());
        return hashed;
    }

    public static boolean matches(String plainText, String hashpass) {
        boolean matches = false;
        if (BCrypt.checkpw(plainText, hashpass)) {
            matches = true;
        }
        return matches;
    }

    public static String encodeBase64(String userName, String password) {
        String encode = createEncodedText(userName, password);
        return encode;
    }

    public static String [] decodeBase64(String encoded) {
        String [] decode = decode(encoded);
        return decode;
    }

    private static String[] decode(final String encodedString) {
        final byte[] decodedBytes = Base64.decode(encodedString.getBytes());
        final String pair = new String(decodedBytes);
        final String[] userDetails = pair.split(":", 2);
        return userDetails;
    }

    private static String createEncodedText(final String username, final String password) {
        final String pair = username + ":" + password;
        final byte[] encodedBytes = Base64.encode(pair.getBytes());
        return new String(encodedBytes);
    }

    public static void main(String [] args) {
        String ret = encodeBase64("brianenoch4", "secret");
        System.out.println(ret);
        String [] res = decodeBase64(ret);
        System.out.println(res[0] + "/" + res[1]);
    }
}
