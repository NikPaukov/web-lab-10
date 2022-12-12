package com.example.lab10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class PjWebBackApplication {


    public static void main(String[] args) {
//        Pattern pattern = Pattern.compile("(^$)|");
//        System.out.println(pattern.matcher("АІВЇяє").matches());
        SpringApplication.run(PjWebBackApplication.class, args);
    }

}
