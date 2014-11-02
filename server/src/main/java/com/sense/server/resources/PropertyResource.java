package com.sense.server.resources;

import com.codahale.metrics.annotation.Timed;
import com.sense.persistence.model.app.Property;
import com.sense.service.service.PropertyService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/properties")
@Produces(MediaType.APPLICATION_JSON)
public class PropertyResource {

    private PropertyService propertyService;

    public PropertyResource(PropertyService propertyService) {

        this.propertyService = propertyService;
    }

    @GET
    @Timed
    @Path("/all")
    public List<Property> getProperty() {

        return propertyService.getProperties();
     }
}
