package com.nikulitsa.springreactive.repository.mongo;

import com.nikulitsa.springreactive.model.mongo.Bag;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BagRepository extends ReactiveCrudRepository<Bag, String> {
}
