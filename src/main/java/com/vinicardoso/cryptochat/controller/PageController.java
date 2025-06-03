package com.vinicardoso.cryptochat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {

    @GetMapping("")
    public String index() {
        return "index.html";
    }


}
