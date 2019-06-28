package com.nikulitsa.springreactive.service;

import com.nikulitsa.springreactive.model.Entity;
import io.reactivex.Single;
import reactor.core.publisher.Mono;

/**
 * @author Sergei Nikulitsa
 */
public interface EntityService {

    Single<Entity> getEntity();

    Mono<Entity> getEntityWebFlux();
}
