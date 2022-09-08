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

    private static int roomNumber = 4;

    private static final HouseType[] HOUSES = HouseType.values();

    @Bean
    public Set<Room> initializeRooms() {
        Set<Room> initialRooms = new HashSet<>();
        for(int i = 0; i < roomNumber; i++){
            Set<Student> studentsForRoom = createStudentSetForRoom(HOUSES[i], i+1);
            initialRooms.add(Room.builder().roomId(i+1).students(studentsForRoom).houseType(HOUSES[i]).build());
        }
        Set<Room> extraRooms = assignRoomToRoomlessStudents(findRoomlessStudents());

        Set<Room> allRooms = new HashSet<>();
        allRooms.addAll(initialRooms);
        allRooms.addAll(extraRooms);
        setIfRoomIsFull(allRooms);

        return allRooms;
    }

    private void setIfRoomIsFull(Set<Room> allRooms) {
        for(Room room : allRooms){
            if(room.getStudents().size() == ROOM_CAPACITY){
                room.setFull(true);
            }
        }
    }

    private Set<Student> findRoomlessStudents() {
        Set<Student> roomlessStudents = new HashSet<>();
        for(Student student : allStudents){
            if(student.getRoomNr() == 0){
                roomlessStudents.add(student);
            }
        }
        return roomlessStudents;
    }

    private Set<Room> assignRoomToRoomlessStudents(Set<Student> roomlessStudents){
        Set<Room> newRooms = new HashSet<>();
        for(Student student : roomlessStudents){
            Set<Student> studentForRoom = new HashSet<>();
            studentForRoom.add(student);
            newRooms.add(Room.builder().roomId(++roomNumber).students(studentForRoom).houseType(student.getHouseType()).build());
            student.setRoomNr(roomNumber);
        }
        return newRooms;
    }

    public RoomCreator(Set<Student> allStudents) {
        this.allStudents = allStudents;
    }

    private Set<Student> createStudentSetForRoom(HouseType houseType, int roomId){
        Set<Student> students = new HashSet<>(ROOM_CAPACITY);
        for(Student student : allStudents){
            if(student.getHouseType().equals(houseType) && students.size() < ROOM_CAPACITY){
               students.add(student);
                student.setRoomNr(roomId);
            }
        }
        return students;
    }


}
