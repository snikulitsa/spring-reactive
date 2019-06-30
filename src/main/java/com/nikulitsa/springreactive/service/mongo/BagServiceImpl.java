package com.nikulitsa.springreactive.service.mongo;

import com.nikulitsa.springreactive.model.mongo.Bag;
import com.nikulitsa.springreactive.model.mongo.BagWithItemsDTO;
import com.nikulitsa.springreactive.model.mongo.Item;
import com.nikulitsa.springreactive.repository.mongo.BagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BagServiceImpl implements BagService {

    private final BagRepository bagRepository;
    private final ItemService itemService;

    @Override
    public Mono<BagWithItemsDTO> getBugWithItems(String bagId) {

        Mono<Bag> bag = bagRepository.findById(bagId);
        Flux<Item> items = itemService.findAllByBagId(bagId);

        // TODO not sure it is right...
        return bag
                .zipWith(items.collectList())
                .map((tuple) -> {
                    Bag bagFromTuple = tuple.getT1();
                    List<Item> itemList = tuple.getT2();
                    return new BagWithItemsDTO(
                            bagFromTuple.getId(),
                            bagFromTuple.getTitle(),
                            itemList
                    );
                });
    }
}
