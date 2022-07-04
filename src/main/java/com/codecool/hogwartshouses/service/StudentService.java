package com.codecool.hogwartshouses.service;


import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.service.DAO.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    public Set<Student> getAll(){
        return studentDAO.getAll();
    }

    public void addStudent(Student student){
        studentDAO.addStudent(student);
    }
}
