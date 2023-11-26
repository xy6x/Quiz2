package com.example.quiz2.SericeQuiz2;

import com.example.quiz2.ModelQuiz2.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

     public ArrayList<Student> stu = new ArrayList<>();

     public ArrayList<Student> getStudent(){
          return stu;
     }
     public void addStudent(Student student){
        stu.add(student);

     }

    public  boolean updateStudent(String id){
        for (Student s:stu) {
            if (s.getId().equals(id)) {
                s.setId(id);
                return true;
            }

        }
        return false;
    }
    public  boolean deleteStudent(String id){
        for (int i = 0; i < stu.size(); i++) {
            if (stu.get(i).getId().equals(id)) {
                stu.remove(id);
                return true;
            }
        }

        return false;
    }
    public ArrayList<Student> searchStudent(String name){
        ArrayList<Student> t =new ArrayList<>();
        for (int i = 0; i <stu.size() ; i++) {
            if (stu.get(i).getName().equals(name)) {
                t.add(stu.get(i));
            }

        }
        return t;
    }
}
