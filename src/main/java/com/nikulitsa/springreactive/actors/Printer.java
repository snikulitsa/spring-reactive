package com.nikulitsa.springreactive.actors;

import akka.actor.AbstractActor;
import akka.actor.Props;
import com.nikulitsa.springreactive.model.BitCoinResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

/**
 * @author Sergei Nikulitsa
 */
public class Printer extends AbstractActor {

    private static final Logger LOGGER = LoggerFactory.getLogger(Printer.class);

    public static Props props() {
        return Props.create(Printer.class, Printer::new);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
            .match(
                CryptoPrice.class,
                message -> message.getMessage()
                    .subscribe(payload -> LOGGER.info(payload.toString()))
            )
            .build();
    }

    @RequiredArgsConstructor
    @Getter
    public static class CryptoPrice {
        private final Mono<BitCoinResponse> message;
    }
}
