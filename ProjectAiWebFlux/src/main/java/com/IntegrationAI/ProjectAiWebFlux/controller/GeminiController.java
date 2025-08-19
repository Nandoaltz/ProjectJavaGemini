package com.IntegrationAI.ProjectAiWebFlux.controller;
import com.IntegrationAI.ProjectAiWebFlux.service.GeminiService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/gerar")
public class GeminiController {

    private final GeminiService geminiService;

    public GeminiController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @PostMapping
    public Mono<String> responseApiGemini(){
        return geminiService.resposta();
    }
}
