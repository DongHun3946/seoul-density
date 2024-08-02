package com.mysite.seouldensity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
public class MainController {

    @GetMapping("/")
    public String root(){
        return "redirect:/seoulDensity/list";
    }
}
