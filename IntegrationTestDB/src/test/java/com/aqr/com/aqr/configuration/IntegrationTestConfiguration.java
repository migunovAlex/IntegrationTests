package com.aqr.com.aqr.configuration;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

/**
 * Created by Oleksii_Migunov on 10/14/2015.
 */
@Configuration
public class IntegrationTestConfiguration {

    @Autowired
    private Environment environment;

    @Value("${integration.db.driver}")
    private String driver;

    @Value("${integration.db.url}")
    private String serverDbURL;

    @Value("${integration.db.user}")
    private String serverDbUser;

    @Value("${integration.db.password}")
    private String serverDbPassword;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(driver);
        dataSource.setUrl(serverDbURL);
        dataSource.setUsername(serverDbUser);
        dataSource.setPassword(serverDbPassword);

        return dataSource;
    }


}
