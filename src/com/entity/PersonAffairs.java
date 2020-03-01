package com.entity;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PersonAffairs {

    private int id;
    private String type;
    private String username;
    private String transactionDate;
    private String affairContent;
    private String sectionA;
    private String sectionB;
    private String remark;
}
