package com.uisrael.DigitalRecipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @GetMapping("/base")
    public String index() {
        return "base/index";
    }
}
