package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("rooms/available")
    public String getAvailableRooms(Model model){
        Set<Room> availableRooms = roomService.getAvailable();
        TreeSet<Room> sortedAvailableRooms = new TreeSet<>(availableRooms);
        model.addAttribute("rooms", sortedAvailableRooms);
        return "available_rooms";
    }

    @GetMapping("/rooms/rat-owners")
    public String getRatSafeRooms(Model model){
        Set<Room> safeRooms = roomService.getSafe();
        TreeSet<Room> sortedSafeRooms = new TreeSet<>(safeRooms);
        model.addAttribute("rooms", sortedSafeRooms);
        return "rooms";
    }

    @PostMapping("/rooms")
    public void addRoom(@RequestBody Room room){
        roomService.addRoom(room);
    }

    @GetMapping("/rooms/{roomId}")
    public String getRoomById(@PathVariable int roomId, Model model){
        Room room = roomService.getRoomById(roomId);
        model.addAttribute("room", room);
        return "room";
    }

    @DeleteMapping("/rooms/{roomId}")
    @ResponseBody
    public void deleteRoom(@PathVariable int roomId){
        roomService.deleteRoom(roomId);
    }

    @PutMapping("/rooms/{roomId}")
    @ResponseBody
    public void renovateRoom(@PathVariable int roomId){
        roomService.renovateRoom(roomId);
    }
}
