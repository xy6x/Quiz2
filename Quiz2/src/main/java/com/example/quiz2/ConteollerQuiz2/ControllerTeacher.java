package com.example.quiz2.ConteollerQuiz2;

import com.example.quiz2.ModelQuiz2.Student;
import com.example.quiz2.ModelQuiz2.Teacher;
import com.example.quiz2.SericeQuiz2.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/tea")
@RequiredArgsConstructor
public class ControllerTeacher {
    private  final TeacherService teacherService;
    @GetMapping("/get")
    public ArrayList<Teacher> get(){
        return teacherService.getTeacher();
    }@PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody Teacher teacher , Errors errors){
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.OK).body("added user");
    }
    @PutMapping("/put/{id}")
    public ResponseEntity updateTeacher(@PathVariable String id ,@RequestBody Teacher teacher , Errors errors){
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        teacherService.updateTeacher(id);
        return ResponseEntity.status(HttpStatus.OK).body("Update user");

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable String id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(HttpStatus.OK).body("delete user");
    }
    @GetMapping("search/{id}")
    public ResponseEntity searchTeacher(@PathVariable String id){
        ArrayList<Teacher> s = teacherService.searchTeacher(id);
        return ResponseEntity.status(HttpStatus.OK).body(s);

    }

}
