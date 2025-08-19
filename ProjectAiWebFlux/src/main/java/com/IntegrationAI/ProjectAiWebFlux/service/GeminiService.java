package com.IntegrationAI.ProjectAiWebFlux.service;

import com.IntegrationAI.ProjectAiWebFlux.request.Contents;
import com.IntegrationAI.ProjectAiWebFlux.request.Parts;
import com.IntegrationAI.ProjectAiWebFlux.request.TextApi;
import com.IntegrationAI.ProjectAiWebFlux.response.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class GeminiService {

    private final WebClient build;

    @Value("${API_KEY}")
    private String apikey;

    public GeminiService(WebClient build) {
        this.build = build;
    }

    public Mono<String> resposta() {
        TextApi prompt = new TextApi("Conte uma piada de 5 palavras");
        Parts parts = new Parts(List.of(prompt));
        Contents contents = new Contents(List.of(parts));

        return build.post()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("/v1beta/models/gemini-1.5-flash-latest:generateContent")
                                .queryParam("key", apikey).build())
                .bodyValue(contents)
                .retrieve()
                .bodyToMono(ResponseContent.class)
                .map(resposta -> resposta
                        .candidates()
                        .get(0)
                        .content().parts().get(0).text());
    }
}
