package com.nikita.klimkin.testTaskJarSoft.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.nikita.klimkin.testTaskJarSoft.config.WebSecurityConfig;

import java.io.IOException;

public class JsonDeserializer extends com.fasterxml.jackson.databind.JsonDeserializer<String> {
    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        String encoderPassword = WebSecurityConfig.PASSWORD_ENCODER.encode(node.asText());
        return encoderPassword;
    }
}
