package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Room;

import java.util.Set;

public interface RoomDAO {

    Set<Room> getAll();

    Set<Room> getAvailable();

    Set<Room> getSafe();

    void addRoom(Room room);

    Room getRoomById(int roomId);

    void deleteRoom(int roomId);

    void renovateRoom(int roomId);

}