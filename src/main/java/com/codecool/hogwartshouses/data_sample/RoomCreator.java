package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.service.DAO.RoomMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class RoomCreator {



    /*@Bean
    public Set<Room> getRooms(){
        Set<Room> rooms = new HashSet<>();
        rooms.add(Room.builder().roomId(2).houseType(HouseType.HUFFLEPUFF).build());
        rooms.add(new Room(1, HouseType.GRYFFINDOR));
        return rooms;
    }*/

    @Bean
    public Set<Room> initializeRooms() {
        Set<Room> rooms = new HashSet<>();
        rooms.add(Room.builder().roomId(1).houseType(HouseType.GRYFFINDOR).build());
        rooms.add(Room.builder().roomId(2).houseType(HouseType.HUFFLEPUFF).build());
        rooms.add(Room.builder().roomId(3).houseType(HouseType.RAVENCLAW).build());
        rooms.add(Room.builder().roomId(4).houseType(HouseType.SLYTHERIN).build());
        return rooms;
    //TODO
    }


    /*public RoomCreator() {
        initializeRooms();
    }*/


}
