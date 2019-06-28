package com.nikulitsa.springreactive.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author Sergei Nikulitsa
 */
@Data
@AllArgsConstructor
public class Employee {

    @Id
    private Long id;
    private String name;
    protected Long salary;
    private Long organizationId;
}
