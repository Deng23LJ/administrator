package com.entity;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Administrator {

    private int id;
    private String adminName;
    private String adminPassword;
    private int adminGrade;
    private String adminDepartment;
}
