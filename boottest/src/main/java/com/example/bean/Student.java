package com.example.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class Student implements Serializable {
    private static final long serialVersionUID = 5241384970410762221L;
    @Id
    private Integer sno;

    private String sname;

    private String ssex;

    private LocalDate time;
}