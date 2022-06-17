package com.elsa.DataStatistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DataStatisticsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataStatisticsApplication.class, args);
    }

}
