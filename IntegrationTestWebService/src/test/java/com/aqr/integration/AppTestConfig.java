package com.aqr.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.io.File;

/**
 * Created by Oleksii_Migunov on 10/17/2015.
 */
@Configuration
public class AppTestConfig {

//   @Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        dataSource.setDriverClassName("org.h2.Driver");
//        dataSource.setUrl("jdbc:h2:~/test;MODE=MSSQLServer;INIT=RUNSCRIPT FROM 'classpath:01_test_user.sql'");
//        dataSource.setUsername("root");
//        dataSource.setPassword("");
//
//        return dataSource;
//    }

   @Bean
    public DataSource getDataSource(){
        return new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setType(EmbeddedDatabaseType.H2)
                .setScriptEncoding("UTF-8")
                .ignoreFailedDrops(true)
                .addScript("01_test_user.sql")
                .build();
    }
}
