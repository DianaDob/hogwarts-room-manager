package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.model.types.HouseType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@Builder
public class Room implements Comparable<Room>{
    private int roomId;
    private Set<Student> students;
    private HouseType houseType;

    public Room(int roomId, Set<Student> students, HouseType houseType) {
        this.roomId = roomId;
        this.students = students;
        this.houseType = houseType;
    }

    @Override
    public int compareTo(Room o) {
        if (this.roomId > o.roomId) {

            // if current object is greater,then return 1
            return 1;
        }
        else if (this.roomId < o.roomId) {

            // if current object is greater,then return -1
            return -1;
        }
        else {

            // if current object is equal to o,then return 0
            return 0;
        }
    }
}
