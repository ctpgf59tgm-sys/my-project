package com.human.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HTMLController {
    @RequestMapping(value = "/login.html")//127.0.0.1:8081/login.html

    public String login (){
        return "login";
    }
    @RequestMapping
    public String index(){
        return "index";
    }
    @RequestMapping("/user.html")
    public String user(){
        return "user";
    }
    @RequestMapping("/score.html")
    public String score(){
        return "score";
    }
}
