package com.lozinska.iq.dto;

import com.lozinska.iq.entity.Question;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDTO {

    private Integer id;

    private String questionBody;

    private String answerBody;

    private String pictureLink;

    private Integer testNumber;


    public static QuestionDTO changeQuestionToQuestionDTO (Question question){
        QuestionDTO newQuestionDTO = new QuestionDTO();
        newQuestionDTO.setId(question.getId());
        newQuestionDTO.setAnswerBody(question.getAnswerBody());
        newQuestionDTO.setPictureLink(question.getPictureLink());
        newQuestionDTO.setQuestionBody(question.getQuestionBody());
        newQuestionDTO.setTestNumber(question.getTestNumber());
        return newQuestionDTO;
    }

}
