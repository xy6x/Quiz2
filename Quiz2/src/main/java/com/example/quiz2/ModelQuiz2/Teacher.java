package com.example.quiz2.ModelQuiz2;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    @NotEmpty(message = "please enter name ")
    @Size(min = 4)
    private String name ;
    @NotEmpty(message = "please enter id ")
@Size(min = 5 ,max = 10)
    private String id;
    @NotEmpty(message = "please enter Salary ")
@Max(50000)
    private double salary ;
    @Max(55)
    @NotEmpty(message = "please enter age ")
    private int age;

}
