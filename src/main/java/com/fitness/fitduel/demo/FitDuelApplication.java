package com.fitness.fitduel.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FitDuelApplication {

    @RequestMapping("/hello")
    @ResponseBody
    String hello() {
        return "Hello from Heroku Test!!!!!!";
    }

    public static void main(String[] args) {
		SpringApplication.run(FitDuelApplication.class, args);
	}
}
