package com.nikulitsa.springreactive.service.mongo;

import com.nikulitsa.springreactive.model.mongo.Item;
import reactor.core.publisher.Flux;

public interface ItemService {

    Flux<Item> findAllByBagId(String bagId);
}
