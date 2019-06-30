package com.nikulitsa.springreactive.config;

import com.nikulitsa.springreactive.model.mongo.BagWithItemsDTO;
import com.nikulitsa.springreactive.service.mongo.BagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
