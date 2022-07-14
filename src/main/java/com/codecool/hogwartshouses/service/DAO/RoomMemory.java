package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.data_sample.RoomCreator;
import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.PetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class RoomMemory implements RoomDAO {


    @Autowired
    RoomCreator roomCreator;

    private Set<Room> rooms;

    public RoomMemory(Set<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public Set<Room> getAll() {
        return rooms;
    }

    @Override
    public Set<Room> getAvailable() {
        Set<Room> availableRooms = new HashSet<>();
        for(Room room : rooms){
            if(!room.isFull()){
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    @Override
    public Set<Room> getSafe() {
        Set<Room> safeRooms = new HashSet<>();

        for(Room room : rooms){

            boolean catOrOwlPresent = false;

            for(Student student : room.getStudents()){
                if(student.getPetType().equals(PetType.CAT) || student.getPetType().equals(PetType.OWL)){
                    catOrOwlPresent = true;
                    break;
                }
            }
            if(!catOrOwlPresent){
                safeRooms.add(room);
            }
        }
        return safeRooms;
    }

    @Override
    public void addRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public Room getRoomById(int roomId) {
        for(Room room : rooms){
            if(room.getRoomId() == (roomId)){
                return room;
            }
        }
        return null;

    }

    @Override
    public void deleteRoom(int roomId) {
        for(Room room : rooms){
            if(room.getRoomId() == (roomId)){
                rooms.remove(room);
            }
        }
    }

    @Override
    public void renovateRoom(int roomId) {
        for(Room room : rooms){
            if(room.getRoomId() == (roomId)){
                rooms.remove(room);
                room.setRenovated(true);
                rooms.add(room);
            }
        }
    }
}
