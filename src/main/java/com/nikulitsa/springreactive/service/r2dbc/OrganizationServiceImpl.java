package com.nikulitsa.springreactive.service.r2dbc;

import com.nikulitsa.springreactive.model.r2dbc.Organization;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

/**
 * @author Sergei Nikulitsa
 */
@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    // private final OrganizationRepository repository;

    // TODO does not working, because org.springframework.transaction.reactive package
    //      not present in org.springframework:spring-tx:5.1.8.RELEASE
    @Transactional
    @Override
    public Flux<Organization> all() {
        // return repository.findAll();
        return null;
    }
}
