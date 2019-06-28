package com.nikulitsa.springreactive.actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import com.nikulitsa.springreactive.service.BitCoinService;
import lombok.RequiredArgsConstructor;

/**
 * @author Sergei Nikulitsa
 */
@RequiredArgsConstructor
public class Requestor extends AbstractActor {

    private final ActorRef printerActor;
    private final BitCoinService bitCoinService;

    @Override
    public Receive createReceive() {
        return receiveBuilder()
            .match(
                GetBitCoin.class,
                getBitCoin -> printerActor.tell(
                    new Printer.CryptoPrice(bitCoinService.bitCoin()),
                    getSelf()
                )
            )
            .build();
    }

    public static Props props(ActorRef printerActor, BitCoinService bitCoinService) {
        return Props.create(Requestor.class, () -> new Requestor(printerActor, bitCoinService));
    }

    public static final class GetBitCoin {
    }
}
