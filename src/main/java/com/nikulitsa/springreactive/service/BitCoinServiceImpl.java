package com.nikulitsa.springreactive.service;

import com.nikulitsa.springreactive.model.BitCoinResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author Sergei Nikulitsa
 */
@Service
@RequiredArgsConstructor
public class BitCoinServiceImpl implements BitCoinService {

    private final WebClient webClient;

    @Override
    public Mono<BitCoinResponse> bitCoin() {
        return webClient
            .get()
            .uri("https://api.coinbase.com/v2/prices/BTC-USD/buy")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .flatMap(clientResponse -> clientResponse.bodyToMono(BitCoinResponse.class));
    }
}
