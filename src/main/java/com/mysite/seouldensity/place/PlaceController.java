package com.mysite.seouldensity.place;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@RequestMapping("/seoulDensity")
@RequiredArgsConstructor
@Controller
public class PlaceController {
    private final PlaceService placeService;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value="page", defaultValue = "0") int page){
        Page<Place> paging = this.placeService.getList(page);
        List<Place> places = paging.getContent();
        Map<String, String> placePopulations = placeService.getPlacePopulation(places);

        model.addAttribute("paging", paging);
        model.addAttribute("placePopulations", placePopulations);
        return "main";
    }
    @GetMapping(value="/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        Place place = this.placeService.getPlace(id);
        model.addAttribute("place", place);
        return "place_detail";
    }
}
