package com.nikulitsa.springreactive.controller;

import com.nikulitsa.springreactive.model.Entity;
import com.nikulitsa.springreactive.service.EntityService;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Sergei Nikulitsa
 */
@RestController
@RequestMapping("/api/entity")
@RequiredArgsConstructor
public class EntityController {

    private final EntityService service;

    @GetMapping
    public Single<Entity> getEntity() {
        return service.getEntity();
    }

    @GetMapping("/webFlux")
    public Mono<Entity> getEntityWebFlux() {
        return service.getEntityWebFlux();
    }
}
