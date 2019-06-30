package com.nikulitsa.springreactive.controller;

import com.nikulitsa.springreactive.model.mongo.Bag;
import com.nikulitsa.springreactive.model.mongo.BagWithItemsDTO;
import com.nikulitsa.springreactive.service.mongo.BagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/bag")
@RequiredArgsConstructor
public class BagController {

    private final BagService service;

    @GetMapping("/{bagId}/withItems")
    public Mono<BagWithItemsDTO> bagWithItems(@PathVariable String bagId) {
        return service.getBugWithItems(bagId);
    }

    @PutMapping
    public Mono<Bag> save(Bag bag) {
        return service.save(bag);
    }
}
