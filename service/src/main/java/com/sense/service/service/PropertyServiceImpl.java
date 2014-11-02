package com.sense.service.service;

import com.google.inject.Inject;
import com.sense.persistence.dao.PropertyDao;
import com.sense.persistence.model.app.Property;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 *
 * Created by brianenochson.
 */
@Slf4j
public class PropertyServiceImpl implements PropertyService {

    private final PropertyDao propertyDao;

    @Inject
    public PropertyServiceImpl(PropertyDao propertyDao) {

        this.propertyDao = propertyDao;
    }

    @Override
    public List<Property> getProperties() {

        List<Property> list = propertyDao.getProperties();
        return list;
    }
}
