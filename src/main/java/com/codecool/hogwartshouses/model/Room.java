package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.model.types.HouseType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@Builder
public class Room {
    private int roomId;
    //private Set<Student> students;
    private HouseType houseType;

    public Room(int roomId, HouseType houseType) {
        this.roomId = roomId;
        //this.students = students;
        this.houseType = houseType;
    }
}
