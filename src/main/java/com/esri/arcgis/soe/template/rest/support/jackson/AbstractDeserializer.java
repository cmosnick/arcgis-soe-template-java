package com.esri.arcgis.soe.template.rest.support.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.io.StringWriter;

@SuppressWarnings("serial")
public abstract class AbstractDeserializer<T> extends StdDeserializer<T> {

    private ObjectMapper objectMapper;

    protected AbstractDeserializer(Class<T> vc, ObjectMapper objectMapper) {
        super(vc);
        this.objectMapper = objectMapper;
    }

    @Override
    public T deserialize(JsonParser jsonParser,
                         DeserializationContext deserializationContext) throws IOException,
            JsonProcessingException {
        ObjectCodec objectCodec = jsonParser.getCodec();
        JsonNode node = objectCodec.readTree(jsonParser);
        StringWriter writer = new StringWriter();
        this.objectMapper.writeValue(writer, node);
        writer.close();
        String json = writer.toString();
        T t = deserialize(json);
        return t;
    }

    protected abstract T deserialize(String json) throws IOException,
            JsonProcessingException;

}
