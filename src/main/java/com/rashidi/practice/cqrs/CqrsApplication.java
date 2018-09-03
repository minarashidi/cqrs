package com.rashidi.practice.cqrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.rashidi")
public class CqrsApplication {

  public static void main(String[] args) {
    SpringApplication.run(CqrsApplication.class, args);
  }
}
