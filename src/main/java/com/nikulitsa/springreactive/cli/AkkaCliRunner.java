package com.nikulitsa.springreactive.cli;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.nikulitsa.springreactive.actors.Poller;
import com.nikulitsa.springreactive.actors.Printer;
import com.nikulitsa.springreactive.actors.Requestor;
import com.nikulitsa.springreactive.config.properties.CliRunnersProperties;
import com.nikulitsa.springreactive.service.BitCoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Sergei Nikulitsa
 */
@Component
@RequiredArgsConstructor
public class AkkaCliRunner implements CommandLineRunner {

    private final ActorSystem actorSystem;
    private final BitCoinService bitCoinService;
    private final CliRunnersProperties properties;

    @Override
    public void run(String... args) throws Exception {
        if (properties.isAkkaSandboxEnabled()) {
            final ActorRef printer = createPrinter();
            final ActorRef requestor = createRequestor(printer);
            final ActorRef poller = createPoller(requestor);
        }
    }

    private ActorRef createPrinter() {
        return actorSystem.actorOf(Printer.props(), "printer");
    }

    private ActorRef createRequestor(ActorRef printer) {
        return actorSystem.actorOf(Requestor.props(printer, bitCoinService), "requestor");
    }

    private ActorRef createPoller(ActorRef requestor) {
        return actorSystem.actorOf(Poller.props(requestor), "poller");
    }
}
