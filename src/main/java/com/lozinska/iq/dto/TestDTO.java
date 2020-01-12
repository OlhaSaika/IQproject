package com.lozinska.iq.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lozinska.iq.entity.Test;
import com.lozinska.iq.entity.User;

import java.util.Date;

public class TestDTO {

    private Integer id;

    @JsonIgnore
    private Date timeStart;

    @JsonIgnore
    private Date timeEnd;

    private Integer testResult;

    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Integer getTestResult() {
        return testResult;
    }

    public void setTestResult(Integer testResult) {
        this.testResult = testResult;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static TestDTO changeTestToTestDTO(Test test) {
        TestDTO newTestDTO = new TestDTO();
        newTestDTO.setId(test.getId());
        newTestDTO.setTimeStart(test.getTimeStart());
        newTestDTO.setTimeEnd(test.getTimeEnd());
        newTestDTO.setTestResult(test.getTestResult());
        newTestDTO.setUser(test.getUser());

        return newTestDTO;
    }

//    public static TestDTO changeTestToTestDTO2 (Test test){
//        TestDTO newTestDTO = new TestDTO();
//        newTestDTO.setId(test.getId());
//        newTestDTO.setTestResult(test.getTestResult());
//        newTestDTO.setUser(test.getUser());
//
//        return newTestDTO;
//    }
}
