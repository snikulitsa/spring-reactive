package com.nikulitsa.springreactive.controller;

import com.nikulitsa.springreactive.model.r2dbc.Organization;
import com.nikulitsa.springreactive.service.r2dbc.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author Sergei Nikulitsa
 */
@RestController
@RequestMapping("/api/organization")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService service;

    @GetMapping("/all")
    public Flux<Organization> all() {
        return service.all();
    }
}
