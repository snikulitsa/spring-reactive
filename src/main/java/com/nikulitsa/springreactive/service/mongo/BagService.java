package com.nikulitsa.springreactive.service.mongo;

import com.nikulitsa.springreactive.model.mongo.BagWithItemsDTO;
import reactor.core.publisher.Mono;

public interface BagService {

    Mono<BagWithItemsDTO> getBugWithItems(String badId);
}
