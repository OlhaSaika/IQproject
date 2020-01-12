package com.lozinska.iq.repository;

import com.lozinska.iq.entity.TestTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestTemplateRepository extends JpaRepository<TestTemplate, Integer> {

    Optional<TestTemplate> findByTestNumber(Integer testNumber);
}
