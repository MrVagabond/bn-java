package com.mrzj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mrzj.mapper")
public class MySQLTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySQLTestApplication.class);
    }
}
