package com.lozinska.iq.controller;

import com.lozinska.iq.dto.TestDTO;
import com.lozinska.iq.entity.Test;
import com.lozinska.iq.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.lozinska.iq.dto.TestDTO.changeTestToTestDTO;

@RestController
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping
    public List<Test> findByUserId(Integer userId) {
        return testService.findByUserId(userId);
    }

    @GetMapping("/{testID}")
    public ResponseEntity<TestDTO> findByTestID(@PathVariable Integer testID) {
        Test result = testService.findByTestID(testID);
        return ResponseEntity.ok(changeTestToTestDTO(result));
    }

    @GetMapping("/all")
    public ResponseEntity<List<TestDTO>> getAllTests() {
        List<Test> result = testService.getAllTests();
        List<TestDTO> resultDTO = new ArrayList<>();
        for (Test test : result) {
            resultDTO.add(changeTestToTestDTO(test));
        }
        return ResponseEntity.ok(resultDTO);
    }

    @PostMapping
    public ResponseEntity<TestDTO> startTest() {
        Test newTest = testService.startTest();
//        newTest.setUser(testDTO.getUser());

        return ResponseEntity.ok(changeTestToTestDTO(newTest));
    }

    @DeleteMapping("/{testID}")
    public ResponseEntity<String> deleteTest(@PathVariable Integer testID) {
        testService.deleteTest(testID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
