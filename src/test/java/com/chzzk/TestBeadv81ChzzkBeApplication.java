package com.chzzk;

import org.springframework.boot.SpringApplication;

public class TestBeadv81ChzzkBeApplication {

    public static void main(String[] args) {
        SpringApplication.from(Beadv81ChzzkBeApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
