package com.lozinska.iq.service.impl;

import com.lozinska.iq.entity.Question;
import com.lozinska.iq.entity.TestTemplate;
import com.lozinska.iq.repository.QuestionRepository;
import com.lozinska.iq.repository.TestTemplateRepository;
import com.lozinska.iq.service.TestTemplateService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestTemplateTemplateServiceImpl implements TestTemplateService {

    private final TestTemplateRepository testTemplateRepository;

    private final QuestionRepository questionRepository;



    public TestTemplateTemplateServiceImpl(TestTemplateRepository testTemplateRepository,
                                           QuestionRepository questionRepository) {
        this.testTemplateRepository = testTemplateRepository;
        this.questionRepository = questionRepository;
    }

    private TestTemplate createTestTemplate(Integer testNumber) {
        TestTemplate testTemplate = new TestTemplate();
        testTemplate.setTestNumber(testNumber);
        List<Question> questions = questionRepository.findAll();
        List<Question> filteredQuestions = questions.stream().filter(question ->
            testNumber.equals(question.getTestNumber())).collect(Collectors.toList());
        testTemplate.setQuestions(filteredQuestions);
        if (testTemplate.getQuestions().size() != 40){
            throw new RuntimeException("Wrong question list size! " +
                "It was found " + filteredQuestions.size() + " guestions in "+  testNumber +
                " test. Each test should consists of 40 questions.");
        }
        testTemplateRepository.save(testTemplate);
        return testTemplate;

    }
    public List<TestTemplate> createTestTemplateList() {
        testTemplateRepository.deleteAll();
        List<TestTemplate> testTemplateList = new ArrayList<>();
        for (int i = 1; i <=8 ; i++) {
            testTemplateList.add(createTestTemplate(i));
        }
        return testTemplateList;
    }

    public List<TestTemplate> getTestTemplateList() {
        return testTemplateRepository.findAll();
    }

    @Override
    public TestTemplate findTestTemplateByTestNumber (Integer testNumber){
        return testTemplateRepository.findByTestNumber(testNumber).orElseThrow
            (()->new RuntimeException("Test template with test number " + testNumber + " not found!"));
    }
}
