package com.lozinska.iq.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lozinska.iq.entity.Test;
import com.lozinska.iq.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TestDTO {

    private Integer id;

    @JsonIgnore
    private Date timeStart;

    @JsonIgnore
    private Date timeEnd;

    private Integer testResult;

    private User user;


    public static TestDTO changeTestToTestDTO(Test test) {
        TestDTO newTestDTO = new TestDTO();
        newTestDTO.setId(test.getId());
        newTestDTO.setTimeStart(test.getTimeStart());
        newTestDTO.setTimeEnd(test.getTimeEnd());
        newTestDTO.setTestResult(test.getTestResult());
        newTestDTO.setUser(test.getUser());

        return newTestDTO;
    }

}
