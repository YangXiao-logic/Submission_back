package com.submission.collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication(scanBasePackages = {"com.submission.collection","com.submission.common"})
public class CollectApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollectApplication.class, args);
    }

}
