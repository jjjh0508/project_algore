package com.algore.application.kitchenguide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kitchenguide")
public class KitchenguideController {

    @GetMapping("/mainview")
    public String mainview() {
        return "kitchenguide/mainview";
    }

}
