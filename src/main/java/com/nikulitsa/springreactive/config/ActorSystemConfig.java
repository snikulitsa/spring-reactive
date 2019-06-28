package com.nikulitsa.springreactive.config;

import akka.actor.ActorSystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Sergei Nikulitsa
 */
@Configuration
public class ActorSystemConfig {

    private static final String ACTOR_SYSTEM_NAME = "AkkaActorSystem";

    @Bean
    public ActorSystem actorSystem() {
        return ActorSystem.create(ACTOR_SYSTEM_NAME);
    }
}
