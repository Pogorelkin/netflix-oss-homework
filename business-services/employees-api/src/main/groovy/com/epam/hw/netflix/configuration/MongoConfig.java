package com.epam.hw.netflix.configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("classpath:mongodb.properties")
public class MongoConfig extends AbstractMongoConfiguration {
    @Value("${spring.data.mongodb.database}")
    private String database;
    @Value("${spring.data.mongodb.host}")
    private String host;
    @Value("${spring.data.mongodb..port}")
    private String port;
    @Value("${spring.data.mongodb..username}")
    private String username;
    @Value("${spring.data.mongodb..password}")
    private String password;

    @Override
    @Bean
    public MongoClient mongoClient() {
        List<MongoCredential> allCred = new ArrayList<>();
        allCred.add(MongoCredential.createCredential(username, database, password.toCharArray()));
        return new MongoClient(new ServerAddress(host, Integer.parseInt(port)), allCred);
    }

    @Override
    protected String getDatabaseName() {
        return database;
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), getDatabaseName());
    }
}
