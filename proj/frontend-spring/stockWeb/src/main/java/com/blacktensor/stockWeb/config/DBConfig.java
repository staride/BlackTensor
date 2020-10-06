package com.blacktensor.stockWeb.config;

import lombok.extern.java.Log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

    private static final Logger log = LoggerFactory.getLogger(DBConfig.class);

    @Bean
    public DataSource dataSource(){

        log.debug("Data Source Init");

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        dataSource.setUrl("jdbc:mariadb://localhost:3306/BlackTensorStock");
        dataSource.setUsername("blackTensorStock");
        dataSource.setPassword("456123");

        return dataSource;
    }
}
