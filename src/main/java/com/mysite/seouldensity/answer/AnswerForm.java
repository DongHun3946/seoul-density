package com.mysite.seouldensity.answer;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerForm {
    @NotEmpty(message = "내용은 필수항목입니다.")
    private String content;
}
