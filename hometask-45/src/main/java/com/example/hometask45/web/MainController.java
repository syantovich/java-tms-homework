package com.example.hometask45.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/task")
    public String task() {
        return "task";
    }

    @GetMapping("/order")
    public String order() {
        return "order";
    }
}
