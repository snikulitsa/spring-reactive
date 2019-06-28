package com.nikulitsa.springreactive.service.r2dbc;

import com.nikulitsa.springreactive.model.r2dbc.Organization;
import reactor.core.publisher.Flux;

/**
 * @author Sergei Nikulitsa
 */
public interface OrganizationService {
    Flux<Organization> all();
}
