package com.nikulitsa.springreactive.service;

import com.nikulitsa.springreactive.model.Entity;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author Sergei Nikulitsa
 */
@Service
@RequiredArgsConstructor
public class EntityServiceImpl implements EntityService {

    @Override
    public Single<Entity> getEntity() {
        return Single.just(mockEntity());
    }

    @Override
    public Mono<Entity> getEntityWebFlux() {
        return Mono.just(mockEntity());
    }

    private Entity mockEntity() {
        return new Entity("lol", "kek");
    }
}
