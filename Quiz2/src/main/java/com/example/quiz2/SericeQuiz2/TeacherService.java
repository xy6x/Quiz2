package com.example.quiz2.SericeQuiz2;

import com.example.quiz2.ModelQuiz2.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class TeacherService {
    public ArrayList<Teacher> tea = new ArrayList<>();

    public ArrayList<Teacher>  getTeacher(){
        return tea;
    }
    public void addTeacher(Teacher teacher){
        tea.add(teacher);

    }

    public  boolean updateTeacher(String id){
        for (Teacher t:tea) {
            if (t.getId().equals(id)) {
                t.setId(id);
                return true;
            }

        }
        return false;
    }
    public  boolean deleteTeacher(String id){
        for (int i = 0; i < tea.size(); i++) {
            if (tea.get(i).getId().equals(id)) {
                tea.remove(id);
                return true;
            }
        }

        return false;
    }
    public ArrayList<Teacher> searchTeacher(String id){
        ArrayList<Teacher> t =new ArrayList<>();
        for (int i = 0; i <tea.size() ; i++) {
            if (tea.get(i).getId().equals(id)) {
                t.add(tea.get(i));
            }

        }
        return t;
    }
}

