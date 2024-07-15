package com.mysite.seouldensity.answer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.mysite.seouldensity.place.Place;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    public void create(Place place, String content){
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setPlace(place);
        this.answerRepository.save(answer);
    }
}
