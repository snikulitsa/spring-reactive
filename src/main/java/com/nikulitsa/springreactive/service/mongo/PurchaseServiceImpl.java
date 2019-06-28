package com.nikulitsa.springreactive.service.mongo;

import com.nikulitsa.springreactive.model.mongo.Purchase;
import com.nikulitsa.springreactive.repository.mongo.PurchaseRepository;
import com.nikulitsa.springreactive.service.BitCoinService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;

/**
 * @author Sergei Nikulitsa
 */
@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private final BitCoinService bitCoinService;
    private final PurchaseRepository repository;

    @Override
    public Mono<Purchase> createPurchase() {
        return bitCoinService.bitCoin().flatMap(bitCoinResponse -> {
                val purchase = new Purchase(
                    "BitCoin",
                    bitCoinResponse.getData().getAmount(),
                    Instant.now()
                );
                return repository.save(purchase);
        });
    }

    @Override
    public Flux<Purchase> getAllPurchases() {
        return repository.findAll();
    }
}
