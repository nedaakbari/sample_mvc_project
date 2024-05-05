package org.example.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = GET) // {/persons?count=10&max=8}
    public String getAll() {
        return "views/index";
    }
}
