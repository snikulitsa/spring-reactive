package com.nikulitsa.springreactive.repository;

import com.nikulitsa.springreactive.model.Organization;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sergei Nikulitsa
 */
@Repository
public interface OrganizationRepository extends ReactiveCrudRepository<Organization, Long> {
}
