package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @RequestMapping(value = "/controller")
    public String controller(@RequestParam(value = "keyword") String keyword) {
        if(keyword.equals("123456")) {
            return "controller";
        } else {
            return "404";
        }
    }
    @RequestMapping(value = "/admin")
    public String admin() {
        return "admin";
    }
}
