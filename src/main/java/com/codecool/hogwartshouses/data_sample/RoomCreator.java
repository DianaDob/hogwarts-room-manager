package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.HouseType;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class RoomCreator {




    private final Set<Student> allStudents;
    private static final int ROOM_CAPACITY = 4;



    @Bean
    public Set<Room> initializeRooms() {
        Set<Room> rooms = new HashSet<>();
        Set<Student> gryffindorStudents = createStudentSetForRoom(HouseType.GRYFFINDOR);
        Set<Student> hufflepuffStudents = createStudentSetForRoom(HouseType.HUFFLEPUFF);
        Set<Student> ravenclawStudents = createStudentSetForRoom(HouseType.RAVENCLAW);
        Set<Student> slytherinStudents = createStudentSetForRoom(HouseType.SLYTHERIN);

        rooms.add(Room.builder().roomId(1).students(gryffindorStudents).houseType(HouseType.GRYFFINDOR).build());
        rooms.add(Room.builder().roomId(2).students(hufflepuffStudents).houseType(HouseType.HUFFLEPUFF).build());
        rooms.add(Room.builder().roomId(3).students(ravenclawStudents).houseType(HouseType.RAVENCLAW).build());
        rooms.add(Room.builder().roomId(4).students(slytherinStudents).houseType(HouseType.SLYTHERIN).build());
        return rooms;
    //TODO
    }



    public RoomCreator(Set<Student> allStudents) {
        this.allStudents = allStudents;
    }

    private Set<Student> createStudentSetForRoom(HouseType houseType){
        Set<Student> students = new HashSet<>(ROOM_CAPACITY);
        for(Student student : allStudents){
            if(student.getHouseType().equals(houseType)){
               students.add(student);
            }
        }
        return students;
    }


}
