package com.lozinska.iq.dto;

import com.lozinska.iq.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDTO {
    private Integer id;
    private String name;

    public static RoleDTO changeRoleToRoleDTO(Role role) {
        RoleDTO newRoleDTO = new RoleDTO();
        newRoleDTO.setId(role.getId());
        newRoleDTO.setName(role.getName());

        return newRoleDTO;
    }
}
