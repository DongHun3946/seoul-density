package com.mysite.seouldensity.answer;

import com.mysite.seouldensity.place.PlaceService;
import com.mysite.seouldensity.user.User;
import com.mysite.seouldensity.user.UserService;
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
import java.security.Principal;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
    private final AnswerService answerService;
    private final PlaceService placeService;
    private final UserService userService;
    @PostMapping("/create/{id}")
    public String answerCreate(Model model, @PathVariable("id") Integer id,
                               @Valid AnswerForm answerForm, BindingResult bindingResult,
                               Principal principal){
        Place place = this.placeService.getPlace(id);
        User siteUser = this.userService.getUser(principal.getName());
        if(bindingResult.hasErrors()){
            model.addAttribute("place", place);
            return "place_detail";
        }
        this.answerService.create(place, answerForm.getContent(), siteUser);
        return String.format("redirect:/seoulDensity/detail/%s", id);
    }
}
