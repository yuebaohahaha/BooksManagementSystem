package com.example.datastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class DatastructureApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatastructureApplication.class, args);
    }
    
}
