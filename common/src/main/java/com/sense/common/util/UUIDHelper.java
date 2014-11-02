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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by brianenochson .
 */
public class UUIDHelper {

    public static UUID getUUID() {

        UUID uuid = UUID.randomUUID();
        return uuid;
    }

    public static UUID fromString(String id) {
        return UUID.fromString(id);
    }

    public static List<String> convertStringList(List<UUID> inList) {

        List<String> list = new ArrayList<>();
        for(UUID inUUID : inList) {

            list.add(inUUID.toString());
        }
        return list;
    }
}
