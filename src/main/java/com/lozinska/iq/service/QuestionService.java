package com.lozinska.iq.service;

import com.lozinska.iq.entity.Question;

import java.util.List;

public interface QuestionService {

    Question createQuestion(Question question);

    Question updateQuestion(Question question);

    Question getQuestionByID (Integer questionID);

     List<Question> getAllQuestions();

     void deleteQuestion(Integer questionID);
}
