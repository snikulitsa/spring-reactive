package com.nikulitsa.springreactive.controller;

import com.nikulitsa.springreactive.model.mongo.Purchase;
import com.nikulitsa.springreactive.service.mongo.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Sergei Nikulitsa
 */
@RestController
@RequestMapping("/api/bitCoin/purchase")
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService service;

    @PostMapping
    public Mono<Purchase> createPurchase() {
        return service.createPurchase();
    }

    @GetMapping("/getAllPurchases")
    public Flux<Purchase> getAllPurchases() {
        return service.getAllPurchases();
    }
}
