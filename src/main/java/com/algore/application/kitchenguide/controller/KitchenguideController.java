package com.algore.application.kitchenguide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kitchenguide")
public class KitchenguideController {

    @GetMapping("/main")
    public void main() {
    }

    @GetMapping("/repairwrite")
    public String repairwrite() {
        return "kitchenguide/repairwrite";
    }

    @GetMapping("/repairread")
    public String repairread() {
        return "kitchenguide/repairread";
    }

}
