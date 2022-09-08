package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.PetType;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class StudentCreator {


    @Bean
    public Set<Student> initializeStudents() {
        Set<Student> students = new HashSet<>();
        students.add(Student.builder().name("Hermione").houseType(HouseType.GRYFFINDOR).petType(PetType.CAT).build());
        students.add(Student.builder().name("Harry").houseType(HouseType.GRYFFINDOR).petType(PetType.OWL).build());
        students.add(Student.builder().name("Ron").houseType(HouseType.GRYFFINDOR).petType(PetType.RAT).build());
        students.add(Student.builder().name("Kevin").houseType(HouseType.GRYFFINDOR).petType(PetType.NONE).build());
        students.add(Student.builder().name("Terry").houseType(HouseType.GRYFFINDOR).petType(PetType.RAT).build());
        students.add(Student.builder().name("Luna").houseType(HouseType.RAVENCLAW).petType(PetType.RAT).build());
        students.add(Student.builder().name("Draco").houseType(HouseType.SLYTHERIN).petType(PetType.NONE).build());
        students.add(Student.builder().name("Tom").houseType(HouseType.SLYTHERIN).petType(PetType.NONE).build());
        students.add(Student.builder().name("Pansy").houseType(HouseType.SLYTHERIN).petType(PetType.NONE).build());
        students.add(Student.builder().name("Vincent").houseType(HouseType.SLYTHERIN).petType(PetType.NONE).build());
        students.add(Student.builder().name("Gregory").houseType(HouseType.SLYTHERIN).petType(PetType.NONE).build());
        students.add(Student.builder().name("Cedric").houseType(HouseType.HUFFLEPUFF).petType(PetType.OWL).build());
        return students;
    }

    public StudentCreator() {
    }
}
