package com.devendra.agents.service;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

@Service
public class ExternalApiService {

    private final WebClient webClient;
    public ExternalApiService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> callExternalApi() {
        return webClient.get().uri("https://httpbin.org/status/500").retrieve().bodyToMono(String.class)
                .retryWhen(Retry.backoff(3, Duration.ofSeconds(1))
                        .filter(throwable -> throwable instanceof WebClientResponseException)
                ).onErrorResume(ex -> Mono.just("Fallback Response"));
    }
}