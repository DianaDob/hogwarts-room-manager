package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Controller
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping("/rooms")
    public String getAllRooms(Model model){
        Set<Room> rooms = roomService.getAll();
        TreeSet<Room> sortedRooms = new TreeSet<>(rooms);
        model.addAttribute("rooms", sortedRooms);
        return "rooms";
    }

    @PostMapping("/rooms")
    public void addRoom(@RequestBody Room room){
        roomService.addRoom(room);
    }

}
