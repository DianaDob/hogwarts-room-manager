package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.data_sample.RoomCreator;
import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping("/rooms")
    public String getAllRooms(Model model){
        Set<Room> rooms = roomService.getAll();
        model.addAttribute("rooms", rooms);
        return "rooms";
    }

}
