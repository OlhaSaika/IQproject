package com.lozinska.iq.entity;


import javax.persistence.*;

@Entity
@Table
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer testNumber;

    private String questionBody;

    private String answerBody;

    private String pictureLink;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTestNumber() {
        return testNumber;
    }

    public void setTestNumber(Integer testNumber) {
        this.testNumber = testNumber;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Question question = (Question) o;

        if (id != null ? !id.equals(question.id) : question.id != null) {
            return false;
        }
        if (testNumber != null ? !testNumber.equals(question.testNumber) : question.testNumber != null) {
            return false;
        }
        if (questionBody != null ? !questionBody.equals(question.questionBody) : question.questionBody != null) {
            return false;
        }
        if (answerBody != null ? !answerBody.equals(question.answerBody) : question.answerBody != null) {
            return false;
        }
        return pictureLink != null ? pictureLink.equals(question.pictureLink) : question.pictureLink == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (testNumber != null ? testNumber.hashCode() : 0);
        result = 31 * result + (questionBody != null ? questionBody.hashCode() : 0);
        result = 31 * result + (answerBody != null ? answerBody.hashCode() : 0);
        result = 31 * result + (pictureLink != null ? pictureLink.hashCode() : 0);
        return result;
    }
}
