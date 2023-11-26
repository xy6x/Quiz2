package com.example.quiz2.ModelQuiz2;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    @NotEmpty(message = "please enter name ")
    private String name;
    @NotEmpty(message = "please enter id ")
    private String id;
    @NotEmpty(message = "please enter major ")
    private String major;
    @NotNull(message = "please enter age ")
    private  int age ;
}
