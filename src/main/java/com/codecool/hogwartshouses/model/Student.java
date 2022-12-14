package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.PetType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class Student {

    private String name;
    private HouseType houseType;
    private PetType petType;

    private int roomNr;

    public Student(String name, HouseType houseType, PetType petType, int roomNr) {
        this.name = name;
        this.houseType = houseType;
        this.petType = petType;
        this.roomNr = roomNr;
    }

    @Override
    public String toString() {
        return name + " (pet: " + String.valueOf(petType).toLowerCase() + ")";
    }
}
