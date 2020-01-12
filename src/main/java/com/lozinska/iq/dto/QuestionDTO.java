package com.lozinska.iq.dto;

import com.lozinska.iq.entity.Question;

//@Getter
//@Setter
//@NoArgsConstructor
public class QuestionDTO {

    private Integer id;

    private String questionBody;

    private String answerBody;

    private String pictureLink;

    private Integer testNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionBody() {
        return questionBody;
    }

    public void setQuestionBody(String questionBody) {
        this.questionBody = questionBody;
    }

    public String getAnswerBody() {
        return answerBody;
    }

    public void setAnswerBody(String answerBody) {
        this.answerBody = answerBody;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public Integer getTestNumber() {
        return testNumber;
    }

    public void setTestNumber(Integer testNumber) {
        this.testNumber = testNumber;
    }

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
