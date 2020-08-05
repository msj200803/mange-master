package com.stp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.stp.mapper")
public class MangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MangeApplication.class, args);
    }

}
