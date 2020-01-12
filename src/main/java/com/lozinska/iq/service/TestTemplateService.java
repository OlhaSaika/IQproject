package com.lozinska.iq.service;

import com.lozinska.iq.entity.TestTemplate;

import java.util.List;

public interface TestTemplateService {
    List<TestTemplate> createTestTemplateList();

    List<TestTemplate> getTestTemplateList();

    TestTemplate findTestTemplateByTestNumber(Integer testNumber);
}
