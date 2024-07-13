package com.mysite.seouldensity.answer;

import com.mysite.seouldensity.place.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class AnswerController {
    private final AnswerService answerService;
    private final PlaceService placeService;

}
