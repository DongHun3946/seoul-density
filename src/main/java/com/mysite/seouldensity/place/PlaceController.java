package com.mysite.seouldensity.place;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;

@RequestMapping("/seoulDensity")
@RequiredArgsConstructor
@Controller
public class PlaceController {
    private final PlaceService placeService;

    @GetMapping("/list")
    public String list(Model model){
        List<Place> placeList = this.placeService.getList();
        model.addAttribute("placeList", placeList);
        return "main";
    }
}
