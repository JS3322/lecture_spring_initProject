package com.example.initproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private long id;
    private String name;

}

//public class Member {
//
//}
