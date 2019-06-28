package com.nikulitsa.springreactive.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author Sergei Nikulitsa
 */
@Data
public class Item {

    @Id
    private Long id;
}
