package com.mysite.seouldensity.answer;

import com.mysite.seouldensity.user.User;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.mysite.seouldensity.place.Place;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
@Builder
public class AnswerService {
    private final AnswerRepository answerRepository;
    public Answer create(Place place, String content, User author){
        Answer answer = Answer.builder()
                .content(content)
                .createDate(LocalDateTime.now())
                .place(place)
                .author(author)
                .build();
        this.answerRepository.save(answer);
        return answer;
    }
}
