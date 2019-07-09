package com.nikulitsa.springreactive.model.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Bag {

    @Id
    private String id;
    private String title;
}
