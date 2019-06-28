package com.nikulitsa.springreactive.repository.r2dbc;

import com.nikulitsa.springreactive.model.r2dbc.Organization;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sergei Nikulitsa
 */
@Repository
public interface OrganizationRepository extends ReactiveCrudRepository<Organization, Long> {
}
