package com.nikulitsa.springreactive.controller;

import com.nikulitsa.springreactive.model.BitCoinResponse;
import com.nikulitsa.springreactive.service.BitCoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Sergei Nikulitsa
 */
@RestController
@RequestMapping("/api/bitCoin")
@RequiredArgsConstructor
public class BitCoinController {

    private final BitCoinService service;

    @GetMapping
    public Mono<BitCoinResponse> bitCoin() {
        return service.bitCoin();
    }
}
