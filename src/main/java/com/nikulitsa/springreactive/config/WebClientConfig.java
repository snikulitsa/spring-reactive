package com.nikulitsa.springreactive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Sergei Nikulitsa
 */
@Configuration
public class WebClientConfig {

    public static final String REACTIVE_HTTP_CLIENT_BEAN = "reactiveHttpClient";

    @Bean(REACTIVE_HTTP_CLIENT_BEAN)
    public WebClient webClient() {
        return WebClient.builder()
            .clientConnector(new ReactorClientHttpConnector())
            .build();
    }
}
