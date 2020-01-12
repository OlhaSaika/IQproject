package com.lozinska.iq.dto;

import com.lozinska.iq.entity.Test;

public class TestResource {

    private Integer id;

    private Integer testResult;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTestResult() {
        return testResult;
    }

    public void setTestResult(Integer testResult) {
        this.testResult = testResult;
    }

    public static TestResource of (Test test){
        TestResource testResource = new TestResource();
        testResource.setId(test.getId());
        testResource.setTestResult(test.getTestResult());
        return testResource;
    }
}
