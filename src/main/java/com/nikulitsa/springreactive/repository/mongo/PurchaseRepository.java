package com.nikulitsa.springreactive.repository.mongo;

import com.nikulitsa.springreactive.model.mongo.Purchase;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sergei Nikulitsa
 */
@Repository
public interface PurchaseRepository extends ReactiveCrudRepository<Purchase, String> {
}
