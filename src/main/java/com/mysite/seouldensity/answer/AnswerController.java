package com.mysite.seouldensity.answer;

import com.mysite.seouldensity.place.PlaceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mysite.seouldensity.place.Place;

import javax.naming.Binding;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
    private final AnswerService answerService;
    private final PlaceService placeService;

    @PostMapping("/create/{id}")
    public String answerCreate(Model model, @PathVariable("id") Integer id,
                               @Valid AnswerForm answerForm, BindingResult bindingResult){
        Place place = this.placeService.getPlace(id);
        if(bindingResult.hasErrors()){
            model.addAttribute("place", place);
            return "place_detail";
        }
        this.answerService.create(place, answerForm.getContent());
        return String.format("redirect:/seoulDensity/detail/%s", id);
    }
}
