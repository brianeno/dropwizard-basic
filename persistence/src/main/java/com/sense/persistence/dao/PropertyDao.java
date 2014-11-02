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
package com.sense.persistence.dao;

import com.sense.persistence.dao.mapper.PropertyMapper;
import com.sense.persistence.model.app.Property;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * JDBI SQL Object Interface  that specifies DB functions and mapping classes where
 * needed for loading properties.
 * <p>
 * Created by benochso.
 */
public interface PropertyDao {

    /**
     * This returns properties.
     * @return List
     */
    @SqlQuery("select name, value, enabled from appl_property")
    @Mapper(PropertyMapper.class)
    public List<Property> getProperties();
}
