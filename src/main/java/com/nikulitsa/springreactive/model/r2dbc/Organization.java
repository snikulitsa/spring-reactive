package com.nikulitsa.springreactive.model.r2dbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author Sergei Nikulitsa
 */
@Data
@AllArgsConstructor
public class Organization {

    @Id
    private Long id;
    private String name;
}
