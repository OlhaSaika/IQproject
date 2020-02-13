package com.lozinska.iq.service.impl;

import com.lozinska.iq.entity.Role;
import com.lozinska.iq.repository.RoleRepository;
import com.lozinska.iq.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public Role addRole(Role role) {
        return roleRepository.save(role);
    }
}
