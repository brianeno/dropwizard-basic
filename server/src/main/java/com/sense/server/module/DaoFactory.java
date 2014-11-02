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
package com.sense.server.module;

import com.sense.persistence.dao.PropertyDao;
import lombok.Getter;

/**
 * Factory class to return all of various DAO classes
 * Created by brianenochson.
 */
public class DaoFactory {

    @Getter private final PropertyDao propertyDao;
    public DaoFactory(PropertyDao propertyDao) {
        this.propertyDao = propertyDao;
    }
}
