package com.esri.arcgis.soe.template.rest.support.jackson;

import com.esri.arcgis.geometry.IPolygon;
import com.esri.arcgis.soe.template.rest.json.JSONGeometryMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@SuppressWarnings("serial")
public class PolygonDeserializer extends AbstractDeserializer<IPolygon> {

    private JSONGeometryMapper geometryMapper = new JSONGeometryMapper();

    protected PolygonDeserializer(ObjectMapper objectMapper) {
        super(IPolygon.class, objectMapper);
    }

    @Override
    protected IPolygon deserialize(String json) throws IOException,
            JsonProcessingException {
        return this.geometryMapper.readPolygon(json);
    }

}
