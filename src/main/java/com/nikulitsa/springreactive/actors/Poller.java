package com.nikulitsa.springreactive.actors;

import akka.actor.AbstractActorWithTimers;
import akka.actor.ActorRef;
import akka.actor.Props;
import lombok.RequiredArgsConstructor;

import java.time.Duration;

/**
 * @author Sergei Nikulitsa
 */
@RequiredArgsConstructor
public class Poller extends AbstractActorWithTimers {

    private static final Object TICK_KEY = "TICK_KEY";
    private final ActorRef requestorActor;

    @Override
    public Receive createReceive() {
        return receiveBuilder()
            .match(
                FirstTick.class,
                message -> getTimers()
                    .startTimerWithFixedDelay(
                        TICK_KEY,
                        new Tick(),
                        Duration.ofSeconds(5)
                    )
            )
            .match(
                Tick.class,
                message -> requestorActor
                    .tell(new Requestor.GetBitCoin(), getSelf())
            )
            .build();
    }

    public static Props props(ActorRef requestorActor) {
        return Props.create(Poller.class, () -> new Poller(requestorActor).start());
    }

    private Poller start() {
        getTimers().startSingleTimer(TICK_KEY, new FirstTick(), Duration.ofSeconds(7));
        return this;
    }

    private static final class FirstTick {
    }

    private static final class Tick {
    }
}
