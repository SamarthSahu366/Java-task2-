package com.example.demo.Service;

import com.example.demo.DTO.RoomDTO;
import com.example.demo.Entity.RoomEntity;
import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<RoomDTO> getAllRooms() {
        List<RoomEntity> rooms = roomRepository.findAll(); // Retrieve all rooms from the database
        return rooms.stream()
                .map(room -> new RoomDTO(room.getId(), room.getRoomNumber(), room.getRoomType(), room.isBooked()))
                .collect(Collectors.toList()); // Convert entities to DTOs
    }

    public String bookRoom(Long roomId) {
        Optional<RoomEntity> roomOptional = roomRepository.findById(roomId);
        if (roomOptional.isPresent()) {
            RoomEntity room = roomOptional.get();

            roomRepository.save(room); // Save the updated room
            return "Room booked successfully.";
        }
        return "Room not found.";
    }

    public RoomEntity updateRoom(Long roomId, String roomType) {
        Optional<RoomEntity> roomOptional = roomRepository.findById(roomId);
        if (roomOptional.isPresent()) {
            RoomEntity room = roomOptional.get();
            room.setRoomType(roomType);
            return roomRepository.save(room);
        } else {
            throw new UserNotFoundException("Room with ID " + roomId + " not found.");
        }
    }

    public String patchRoom(Long roomId, String roomUpdateDetails) {
        Optional<RoomEntity> roomOptional = roomRepository.findById(roomId);
        if (roomOptional.isPresent()) {
            RoomEntity room = roomOptional.get();
            return "Room updated successfully";
        } else {
            throw new UserNotFoundException("Room with ID " + roomId + " not found.");
        }
    }
}
