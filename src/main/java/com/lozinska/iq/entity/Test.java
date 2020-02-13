package com.lozinska.iq.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date timeStart;

    private Date timeEnd;

    private Integer testResult;

    @OneToOne
    private User user;

    @OneToOne
    private TestTemplate testTemplate;

}
