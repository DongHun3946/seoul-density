package com.mysite.seouldensity.answer;

import com.mysite.seouldensity.DataNotFoundException;
import com.mysite.seouldensity.user.User;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import com.mysite.seouldensity.place.Place;

import java.time.LocalDateTime;
import java.util.*;

@RequiredArgsConstructor
@Service
@Builder
@Setter
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
    public Answer getAnswer(Integer id){
        Optional<Answer> answer = this.answerRepository.findById(id);
        if(answer.isPresent()){
            return answer.get();
        }
        else{
            throw new DataNotFoundException("answer not found");
        }
    }
    public void modify(Answer answer, String content){
        answer.setContent(content);
        answer.setModifyDate(LocalDateTime.now());
        this.answerRepository.save(answer);
    }
}
