package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.data_sample.RoomCreator;
import com.codecool.hogwartshouses.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public void addRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public Room getRoomById(int roomId) {
        Set<Room> rooms = this.getAll();
        for(Room room : rooms){
            if(room.getRoomId() == (roomId)){
                return room;
            }
        }
        return null;

    }

    @Override
    public void deleteRoom(int roomId) {
        Set<Room> rooms = this.getAll();
        Room roomToDelete = null;
        for(Room room : rooms){
            if(room.getRoomId() == (roomId)){
                roomToDelete = room;
            }
        }
        rooms.remove(roomToDelete);
    }
}
