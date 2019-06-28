package com.nikulitsa.springreactive.service;

import com.nikulitsa.springreactive.model.Organization;
import reactor.core.publisher.Flux;

/**
 * @author Sergei Nikulitsa
 */
public interface OrganizationService {
    Flux<Organization> all();
}
