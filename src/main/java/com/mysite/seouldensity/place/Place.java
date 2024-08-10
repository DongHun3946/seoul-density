package com.mysite.seouldensity.place;
import com.mysite.seouldensity.answer.Answer;
import java.util.*;

import com.mysite.seouldensity.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String placeName;

    @NonNull
    private String placeCode;

    @NonNull
    private String category;

    @NonNull
    private String imagePath;

    @OneToMany(mappedBy = "place", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

}
