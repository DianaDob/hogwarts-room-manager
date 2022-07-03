package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.service.DAO.RoomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoomService {

    @Autowired
    private RoomDAO roomDAO;

    public Set<Room> getAll(){
        return roomDAO.getAll();
    }

    public void addRoom(Room room){
        roomDAO.addRoom(room);
    }

    public Room getRoomById(int roomId) {
        return roomDAO.getRoomById(roomId);
    }

    public void deleteRoom(int roomId) {
        roomDAO.deleteRoom(roomId);
    }

    public void renovateRoom(int roomId) {
        roomDAO.renovateRoom(roomId);
    }
}
