package com.esri.arcgis.soe.template.rest.support.jackson;

import com.esri.arcgis.geometry.IEnvelope;
import com.esri.arcgis.soe.template.rest.json.JSONGeometryMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@SuppressWarnings("serial")
public class EnvelopeDeserializer extends AbstractDeserializer<IEnvelope> {

    private JSONGeometryMapper geometryMapper = new JSONGeometryMapper();

    protected EnvelopeDeserializer(ObjectMapper objectMapper) {
        super(IEnvelope.class, objectMapper);
    }

    @Override
    protected IEnvelope deserialize(String json) throws IOException,
            JsonProcessingException {
        return this.geometryMapper.readEnvelope(json);
    }

}
