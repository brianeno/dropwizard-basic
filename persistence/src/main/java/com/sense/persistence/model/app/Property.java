/**
 * @preserve Copyright (c) 2014 Sense Inc. as an unpublished
 * work. Neither this material nor any portion hereof may be copied or
 * distributed without the express written consent of Sense Inc.
 *
 * This material also contains proprietary and confidential information
 * of Sense Inc. and its suppliers, and may not be used by or
 * disclosed to any person, in whole or in part, without the prior written
 * consent of Sense Inc.
 */
package com.sense.persistence.model.app;

import lombok.Getter;
import lombok.ToString;

/**
 * Created by brianenochson.
 */
@ToString(includeFieldNames=true)
public class Property {

    @Getter private String name;
    @Getter private String value;
    @Getter private int enabled;

    public Property(String name, String value, int enabled) {
        this.name = name;
        this.value = value;
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Property property = (Property) o;

        if (!name.equals(property.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
