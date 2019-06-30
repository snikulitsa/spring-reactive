package com.nikulitsa.springreactive.service.mongo;

import com.nikulitsa.springreactive.model.mongo.Item;
import com.nikulitsa.springreactive.repository.mongo.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;

    @Override
    public Flux<Item> findAllByBagId(String bagId) {
        return repository.findAllByBagId(bagId);
    }
}
