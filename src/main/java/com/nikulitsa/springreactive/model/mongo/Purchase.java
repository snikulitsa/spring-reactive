package com.nikulitsa.springreactive.model.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

/**
 * @author Sergei Nikulitsa
 */
@Data
@Document
public class Purchase {

    @Id
    private String id;

    private final String name;
    private final String price;
    private final Instant createdAt;
}
