package com.nikulitsa.springreactive.controller;

import com.nikulitsa.springreactive.model.mongo.Item;
import com.nikulitsa.springreactive.service.mongo.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService service;

    @PutMapping
    public Mono<Item> save(@RequestBody Item item) {
        return service.save(item);
    }
}
