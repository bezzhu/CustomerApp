package com.example.demo.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
public class Home {

    @RequestMapping("/")
    public String home(){
        return "Application is works!!!" + new Date();
    }

}
