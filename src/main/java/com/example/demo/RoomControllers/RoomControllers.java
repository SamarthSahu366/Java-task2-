package com.example.demo.RoomControllers;

import com.example.demo.DTO.RoomDTO;
import com.example.demo.Service.RoomService;
import com.example.demo.Entity.RoomEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomControllers {


    final private RoomService roomService;

    public RoomControllers(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(path = "/rooms")
    public List<RoomDTO> getAllRooms() {
        return roomService.getAllRooms();
    }

    @PostMapping(path = "/rooms/book/{roomId}")
    public String bookRoom(@PathVariable Long roomId) {
        return roomService.bookRoom(roomId);
    }

    @PutMapping("/{roomId}")
    public RoomEntity updateRoom(@PathVariable Long roomId, @RequestBody String roomType) {
        return roomService.updateRoom(roomId, roomType);
    }

    @PatchMapping("/{roomId}")
    public String patchRoom(@PathVariable Long roomId, @RequestBody String roomUpdateDetails) {
        return roomService.patchRoom(roomId, roomUpdateDetails);
    }
}
