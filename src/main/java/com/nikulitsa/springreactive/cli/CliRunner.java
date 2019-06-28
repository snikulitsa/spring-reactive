package com.nikulitsa.springreactive.cli;

import com.nikulitsa.springreactive.config.properties.CliRunnersProperties;
import com.nikulitsa.springreactive.model.BitCoinResponse;
import com.nikulitsa.springreactive.observer.SomeObserver;
import com.nikulitsa.springreactive.service.BitCoinService;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * @author Sergei Nikulitsa
 */
@Component
@RequiredArgsConstructor
public class CliRunner implements CommandLineRunner {

    private final BitCoinService service;
    private final CliRunnersProperties properties;

    @Override
    public void run(String... args) throws Exception {
        if (properties.isRxJavaSandboxEnabled()) {
            Observable<Long> clock = Observable.interval(5, TimeUnit.SECONDS, Schedulers.io());
            Observable<Mono<BitCoinResponse>> clockWork = clock.map(tick -> service.bitCoin());
            clockWork.subscribe(SomeObserver.getInstance());
        }
    }

}
