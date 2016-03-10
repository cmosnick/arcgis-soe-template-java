package com.esri.arcgis.soe.template.rest.support.jackson;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

@SuppressWarnings("serial")
public abstract class AbstractSerializer<T> extends StdSerializer<T> {

    private ObjectMapper objectMapper;

    protected AbstractSerializer(ObjectMapper objectMapper, Class<T> t) {
        super(t);
        this.objectMapper = objectMapper;
    }

    @Override
    public void serialize(T value, JsonGenerator jgen,
                          SerializerProvider provider) throws IOException,
            JsonGenerationException {
        String content = serialize(value);
        JsonNode node = this.objectMapper.readTree(content);
        jgen.writeTree(node);
    }

    protected abstract String serialize(T value) throws IOException,
            JsonGenerationException;

}
