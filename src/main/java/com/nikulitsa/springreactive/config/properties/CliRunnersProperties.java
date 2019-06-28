package com.nikulitsa.springreactive.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Sergei Nikulitsa
 */
@Data
@Configuration
@ConfigurationProperties("reactive.sandbox")
public class CliRunnersProperties {

    private boolean akkaSandboxEnabled;
    private boolean rxJavaSandboxEnabled;
}
