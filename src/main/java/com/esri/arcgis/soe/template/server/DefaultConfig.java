package com.esri.arcgis.soe.template.server;

import com.esri.arcgis.soe.template.rest.support.jackson.ObjectMapperFactory;
import com.esri.arcgis.soe.template.server.internal.RestDelegateMappingRegistry;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.inject.Inject;
import javax.inject.Singleton;

@Configuration
@ComponentScan("com.esri.arcgis.soe.template")
public class DefaultConfig {

    @Inject
    private Environment env;
    private final ObjectMapper objectMapper;

    public DefaultConfig() {
        objectMapper = new ObjectMapperFactory().create();
    }

    @Bean
    @Singleton
    public ObjectMapper objectMapper() {
        return objectMapper;
    }

    @Bean
    @Singleton
    public RestDelegateMappings restInterceptorMappings() {
        RestDelegateMappingRegistry registry = new RestDelegateMappingRegistry(
                objectMapper);
        registry.configureDefaultArgumentResolvers();
        registry.configureDefaultReturnValueHandlers();
        return registry;
    }
}
