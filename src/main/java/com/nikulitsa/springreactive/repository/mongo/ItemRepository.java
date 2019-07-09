package com.nikulitsa.springreactive.repository.mongo;

import com.nikulitsa.springreactive.model.mongo.Item;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ItemRepository extends ReactiveCrudRepository<Item, String> {

    Flux<Item> findAllByBagId(String bagId);
}
