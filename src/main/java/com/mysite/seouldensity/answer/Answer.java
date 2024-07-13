package com.mysite.seouldensity.answer;

import com.mysite.seouldensity.place.Place;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;  //생성 날짜

    private LocalDateTime modifyDate;  //수정 날짜

    @ManyToOne
    private Place place;
}
