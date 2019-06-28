package com.nikulitsa.springreactive.config;

import com.nikulitsa.springreactive.config.properties.ReactiveDataBaseConnectionProperties;
import com.nikulitsa.springreactive.repository.OrganizationRepository;
import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.connectionfactory.R2dbcTransactionManager;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.r2dbc.repository.support.R2dbcRepositoryFactory;

/**
 * @author Sergei Nikulitsa
 */
// TODO does not working, because org.springframework.transaction.reactive package
//      not present in org.springframework:spring-tx:5.1.8.RELEASE
// @Configuration
// @EnableConfigurationProperties(ReactiveDataBaseConnectionProperties.class)
// @EnableR2dbcRepositories(basePackageClasses = {OrganizationRepository.class})
@RequiredArgsConstructor
public class DataBaseConfig extends AbstractR2dbcConfiguration {

    private final ReactiveDataBaseConnectionProperties dataSourceProperties;

    // @Bean
    // public OrganizationRepository organizationRepository(R2dbcRepositoryFactory factory) {
    //     return factory.getRepository(OrganizationRepository.class);
    // }

    // public R2dbcRepositoryFactory r2dbcRepositoryFactory(DatabaseClient databaseClient) {
    //     RelationalMappingContext relationalMappingContext = new RelationalMappingContext();
    //     relationalMappingContext.afterPropertiesSet();
    //     return new R2dbcRepositoryFactory(databaseClient, relationalMappingContext);
    // }

    // @Bean
    // public R2dbcTransactionManager transactionManager(ConnectionFactory connectionFactory) {
    //     return new R2dbcTransactionManager(connectionFactory);
    // }

    @Bean
    public DatabaseClient databaseClient(ConnectionFactory connectionFactory) {
        return DatabaseClient.builder()
            .connectionFactory(connectionFactory)
            .build();
    }

    @Bean
    @Override
    public ConnectionFactory connectionFactory() {
        val config = PostgresqlConnectionConfiguration.builder()
            .username(dataSourceProperties.getUsername())
            .password(dataSourceProperties.getPassword())
            .host(dataSourceProperties.getHost())
            .port(dataSourceProperties.getPort())
            .database(dataSourceProperties.getDatabase())
            .build();
        return new PostgresqlConnectionFactory(config);
    }
}
