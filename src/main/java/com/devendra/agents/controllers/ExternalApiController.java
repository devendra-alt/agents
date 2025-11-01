package com.devendra.agents.controllers;

import com.devendra.agents.service.ExternalApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ExternalApiController {
    ExternalApiService externalApiService;
    public ExternalApiController(ExternalApiService externalApiService) {
        this.externalApiService = externalApiService;
    }
    @GetMapping("/external")
    public Mono<String> externalApi() {
        System.out.println("External API Call");
        return externalApiService.callExternalApi();
    }
}
