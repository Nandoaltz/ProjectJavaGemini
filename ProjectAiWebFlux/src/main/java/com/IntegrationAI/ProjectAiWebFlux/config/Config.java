package com.IntegrationAI.ProjectAiWebFlux.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Config {

    @Value("${gemini.api.key}")
    private String apiKey;

    @Value("${uri.ia}")
    private String uriIA;

    @Bean
    public WebClient Config(WebClient.Builder builder ){
       return   builder
               .baseUrl(uriIA)
               .build();
    }

}
