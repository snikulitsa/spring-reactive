package com.nikulitsa.springreactive.observer;

import com.nikulitsa.springreactive.model.BitCoinResponse;
import io.reactivex.observers.DefaultObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

/**
 * @author Sergei Nikulitsa
 */
public class SomeObserver extends DefaultObserver<Mono<BitCoinResponse>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SomeObserver.class);

    public static SomeObserver getInstance() {
        return new SomeObserver();
    }

    @Override
    public void onNext(Mono<BitCoinResponse> responseMono) {
        responseMono.subscribe(this::logInfo);
    }

    @Override
    public void onError(Throwable e) {
        LOGGER.error(e.getMessage(), e);
    }

    @Override
    public void onComplete() {
        LOGGER.info("Finish!");
    }

    private void logInfo(BitCoinResponse response) {
        LOGGER.info(response.toString());
    }
}
