package com.lozinska.iq.dto;

import com.lozinska.iq.entity.Test;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestResource {

    private Integer id;

    private Integer testResult;


    public static TestResource of (Test test){
        TestResource testResource = new TestResource();
        testResource.setId(test.getId());
        testResource.setTestResult(test.getTestResult());
        return testResource;
    }
}
