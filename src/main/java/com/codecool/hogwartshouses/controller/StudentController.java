package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public String getAllStudents(Model model){
        Set<Student> students = studentService.getAll();
        model.addAttribute("students", students);
        return "students";
    }


}
