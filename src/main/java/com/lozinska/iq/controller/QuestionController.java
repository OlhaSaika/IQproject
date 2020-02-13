package com.lozinska.iq.controller;

import com.lozinska.iq.dto.QuestionDTO;
import com.lozinska.iq.entity.Question;
import com.lozinska.iq.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.lozinska.iq.dto.QuestionDTO.changeQuestionToQuestionDTO;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/{questionID}")
    public ResponseEntity<QuestionDTO> getQuestionByID(@PathVariable Integer questionID) {
        Question question = questionService.getQuestionByID(questionID);
    return ResponseEntity.ok(changeQuestionToQuestionDTO(question));
    }


    @GetMapping
    public ResponseEntity<List<QuestionDTO>> getAllQuestions() {
        List<Question> result = questionService.getAllQuestions();
        List<QuestionDTO> resultDTO = new ArrayList<>();
        for (Question question : result) {
           resultDTO.add(changeQuestionToQuestionDTO(question));
        }
        return ResponseEntity.ok(resultDTO);
    }

    @PostMapping
    public ResponseEntity<QuestionDTO> createQuestion(@RequestBody QuestionDTO questionDTO) {
        Question newQuestion = new Question();
        newQuestion.setQuestionBody(questionDTO.getQuestionBody());
        newQuestion.setAnswerBody(questionDTO.getAnswerBody());
        newQuestion.setPictureLink(questionDTO.getPictureLink());
        newQuestion.setTestNumber(questionDTO.getTestNumber());

       Question createdQuestion = questionService.createQuestion(newQuestion);

        return ResponseEntity.ok(changeQuestionToQuestionDTO(createdQuestion));
    }

    @PatchMapping
    public ResponseEntity<QuestionDTO> updateQuestion(@RequestBody QuestionDTO questionDTO) {
        Question newQuestion = new Question();
        newQuestion.setId(questionDTO.getId());
        newQuestion.setQuestionBody(questionDTO.getQuestionBody());
        newQuestion.setAnswerBody(questionDTO.getAnswerBody());
        newQuestion.setPictureLink(questionDTO.getPictureLink());

        Question updatedQuestion = questionService.updateQuestion(newQuestion);

        return ResponseEntity.ok(changeQuestionToQuestionDTO(updatedQuestion));
    }

    @DeleteMapping("/{questionID}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer questionID){
        questionService.deleteQuestion(questionID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
