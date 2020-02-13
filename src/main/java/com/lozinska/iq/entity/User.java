package com.lozinska.iq.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table (name="_user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @NotEmpty
    @Size(min = 2, max = 30)
    private String username;

    @NotBlank
    @NotEmpty
    @Size(min = 6)
    private String password;

    private String userPhoto;

    @NotBlank
    @NotEmpty
    @Email
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @OneToMany
    private List<Test> tests;

}
