package com.lozinska.iq.service.impl;

import com.lozinska.iq.entity.Question;
import com.lozinska.iq.repository.QuestionRepository;
import com.lozinska.iq.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private  final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question getQuestionByID (Integer questionID){
        return questionRepository.findById(questionID).orElseThrow(RuntimeException::new);
    }

    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }

    public Question createQuestion(Question question){
        return questionRepository.save(question);
    }

    public Question updateQuestion(Question question){
        return questionRepository.saveAndFlush(question);
    }

    public void deleteQuestion(Integer questionID){
        questionRepository.deleteById(questionID);
    }
}
