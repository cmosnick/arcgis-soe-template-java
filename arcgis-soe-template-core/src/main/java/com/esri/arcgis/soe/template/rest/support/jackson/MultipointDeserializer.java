package com.esri.arcgis.soe.template.rest.support.jackson;

import com.esri.arcgis.geometry.IMultipoint;
import com.esri.arcgis.soe.template.rest.json.JSONGeometryMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@SuppressWarnings("serial")
public class MultipointDeserializer extends AbstractDeserializer<IMultipoint> {

    private JSONGeometryMapper geometryMapper = new JSONGeometryMapper();

    protected MultipointDeserializer(ObjectMapper objectMapper) {
        super(IMultipoint.class, objectMapper);
    }

    @Override
    protected IMultipoint deserialize(String json) throws IOException,
            JsonProcessingException {
        return this.geometryMapper.readMultipoint(json);
    }

}
