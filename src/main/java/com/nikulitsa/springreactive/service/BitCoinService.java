package com.nikulitsa.springreactive.service;

import com.nikulitsa.springreactive.model.BitCoinResponse;
import reactor.core.publisher.Mono;

/**
 * @author Sergei Nikulitsa
 */
public interface BitCoinService {

    Mono<BitCoinResponse> bitCoin();
}
