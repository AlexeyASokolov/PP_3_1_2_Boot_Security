package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    @GetMapping("/")
    public String sayHello(ModelMap modelMap) {
        List<String> messages = new ArrayList<>();
        messages.add("Welcome on my page!");
        messages.add("Click the button to authenticate and authorize!");
        modelMap.addAttribute("messages", messages);
        return "hello";
    }
}
