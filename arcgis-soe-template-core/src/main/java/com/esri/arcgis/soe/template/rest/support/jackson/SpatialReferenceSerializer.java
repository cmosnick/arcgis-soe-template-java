package com.esri.arcgis.soe.template.rest.support.jackson;

import com.esri.arcgis.geometry.ISpatialReference;
import com.esri.arcgis.soe.template.rest.json.JSONGeometryMapper;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@SuppressWarnings("serial")
public class SpatialReferenceSerializer extends
        AbstractSerializer<ISpatialReference> {

    private JSONGeometryMapper geometryMapper = new JSONGeometryMapper();

    public SpatialReferenceSerializer(ObjectMapper objectMapper) {
        super(objectMapper, ISpatialReference.class);
    }

    @Override
    public String serialize(ISpatialReference value) throws IOException,
            JsonGenerationException {

        String json = this.geometryMapper.writeSpatialReference(value);
        return json;
    }

}
