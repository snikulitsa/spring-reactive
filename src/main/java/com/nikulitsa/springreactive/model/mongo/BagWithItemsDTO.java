package com.nikulitsa.springreactive.model.mongo;

import lombok.Data;

import java.util.List;

@Data
public class BagWithItemsDTO {

    private final String id;
    private final String title;

    private final List<Item> items;
}
