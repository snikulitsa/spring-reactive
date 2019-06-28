package com.nikulitsa.springreactive.service.mongo;

import com.nikulitsa.springreactive.model.mongo.Purchase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Sergei Nikulitsa
 */
public interface PurchaseService {

    Mono<Purchase> createPurchase();

    Flux<Purchase> getAllPurchases();
}
