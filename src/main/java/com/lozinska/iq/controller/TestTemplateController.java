package com.lozinska.iq.controller;

import com.lozinska.iq.entity.TestTemplate;
import com.lozinska.iq.service.TestTemplateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/testTemplate")
public class TestTemplateController {

    private final TestTemplateService testTemplateService;

    public TestTemplateController(TestTemplateService testTemplateService) {
        this.testTemplateService = testTemplateService;
    }

    @GetMapping
    public ResponseEntity<List<TestTemplate>> getAllTestTemplates() {
        List<TestTemplate> result = testTemplateService.getTestTemplateList();
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<List<TestTemplate>> createTestTemplateList() {
        List<TestTemplate> result = testTemplateService.createTestTemplateList();
        return ResponseEntity.ok(result);
    }

}
