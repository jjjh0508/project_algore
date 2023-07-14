package com.algore.application.kitchenguide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kitchenguide") //스프링 프레임워크에서 빈으로 인식
public class KitchenguideController {

<<<<<<< Updated upstream
    @GetMapping("/mainview")
    public String mainview() {
        return "kitchenguide/mainview";
=======
    @GetMapping("/main")
    public void main() {
    }

    @GetMapping("/trimwrite")
    public String trimwrite() {
        return "kitchenguide/trimwrite";
    }

    @GetMapping("/trimread")
    public String trimread() {
        return "kitchenguide/trimread";
>>>>>>> Stashed changes
    }

}
