package com.example.pjwebback;

import com.example.pjwebback.entities.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.regex.Pattern;

@SpringBootApplication
@CrossOrigin
public class PjWebBackApplication {


    public static void main(String[] args) {
//        Pattern pattern = Pattern.compile("(^$)|");
//        System.out.println(pattern.matcher("АІВЇяє").matches());
        SpringApplication.run(PjWebBackApplication.class, args);
    }

}
