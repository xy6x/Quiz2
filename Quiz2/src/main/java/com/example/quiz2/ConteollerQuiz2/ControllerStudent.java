package com.example.quiz2.ConteollerQuiz2;

import com.example.quiz2.ModelQuiz2.Student;
import com.example.quiz2.SericeQuiz2.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/stu")
@RequiredArgsConstructor
public class ControllerStudent {
    private final StudentService studentService;
    ArrayList<Student> students =new ArrayList<>();
    @GetMapping("/get")
    public ArrayList<Student> get(){
        return studentService.getStudent();
    }@PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student , Errors errors){
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body("added user");
    }
    @PutMapping("/put/{id}")
    public ResponseEntity updateStudent(@PathVariable String id ,@RequestBody Student student , Errors errors){
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        studentService.updateStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body("Update user");

    }

    @DeleteMapping("delete/{id}")
public ResponseEntity deleteStudent(@PathVariable String id){
    studentService.deleteStudent(id);
    return ResponseEntity.status(HttpStatus.OK).body("delete user");
}
@GetMapping("search/{name}")
public ResponseEntity searchStudent(@PathVariable String name){
       ArrayList<Student> s = studentService.searchStudent(name);
    return ResponseEntity.status(HttpStatus.OK).body(s);

}

}
