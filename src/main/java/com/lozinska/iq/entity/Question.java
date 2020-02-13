package com.lozinska.iq.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer testNumber;

    private String questionBody;

    private String answerBody;

    private String pictureLink;

}
