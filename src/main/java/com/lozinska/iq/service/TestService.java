package com.lozinska.iq.service;

import com.lozinska.iq.entity.Test;

import java.util.List;

public interface TestService {

    List<Test> findByUserId (Integer userId);

    Test findByTestID(Integer testID);

    List<Test> getAllTests();

    Test startTest();

    void deleteTest(Integer testID);
}
