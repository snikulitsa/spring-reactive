package com.nikulitsa.springreactive.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Sergei Nikulitsa
 */
@Data
@ConfigurationProperties("reactive.db")
public class ReactiveDataBaseConnectionProperties {

    private String username;
    private String password;
    private String host;
    private int port;
    private String database;
}
