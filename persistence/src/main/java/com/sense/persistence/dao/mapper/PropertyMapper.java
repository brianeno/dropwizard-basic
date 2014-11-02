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
package com.sense.persistence.dao.mapper;

import com.sense.persistence.model.app.Property;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Mapper class that defined mapping of result set to Java object. Specified in
 * SQL Object interface using @Mapper annotation.
 * Created by benochso.
 */
public class PropertyMapper implements ResultSetMapper<Property> {

    @Override
    public Property map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Property(r.getString("NAME"),
                r.getString("VALUE"),
                r.getInt("ENABLED"));
    }
}

