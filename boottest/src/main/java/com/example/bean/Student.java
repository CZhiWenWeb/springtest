package com.example.bean;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Student {
    private Integer sno;

    private String sname;

    private String ssex;

    private LocalDate time;
}