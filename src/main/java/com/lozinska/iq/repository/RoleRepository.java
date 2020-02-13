package com.lozinska.iq.repository;

import com.lozinska.iq.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findFirstByName(String name);
}
