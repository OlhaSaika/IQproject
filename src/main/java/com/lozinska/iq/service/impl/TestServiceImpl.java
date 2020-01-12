package com.lozinska.iq.service.impl;

import com.lozinska.iq.entity.Test;
import com.lozinska.iq.repository.TestRepository;
import com.lozinska.iq.repository.TestTemplateRepository;
import com.lozinska.iq.service.TestService;
import com.lozinska.iq.service.TestTemplateService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;
    private final TestTemplateRepository testTemplateRepository;
    private final TestTemplateService testTemplateService;

    public TestServiceImpl(TestRepository testRepository, TestTemplateRepository testTemplateRepository, TestTemplateService testTemplateService) {
        this.testRepository = testRepository;
        this.testTemplateRepository = testTemplateRepository;
        this.testTemplateService = testTemplateService;
    }

    @Override
    public List<Test> findByUserId(Integer userId) {
        return testRepository.findByUserId(userId);
    }

    public Test findByTestID(Integer testID) {
        return testRepository.findById(testID).orElseThrow(RuntimeException::new);
    }

    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

@Override
    public Test startTest() {
        Test newTest = new Test();
        newTest.setTestTemplate(testTemplateService.findTestTemplateByTestNumber(1));
        newTest.setTimeStart(new Date());
//        test.setUser(Principal);
        return testRepository.save(newTest);
    }

    public void deleteTest(Integer testID){
        testRepository.deleteById(testID);
    }

//    public Test generatedTest()
}
