package com.example.demo.DTO;

        public class RoomDTO {

        private String roomNumber;
        private String roomType;
        private Double price;

        public RoomDTO() {}

        public RoomDTO(String roomNumber, String roomType, Double price) {
            this.roomNumber = roomNumber;
            this.roomType = roomType;
            this.price = price;
        }

            public RoomDTO(Long id, String roomNumber, String roomType, boolean booked) {
            }

        public String getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(String roomNumber) {
            this.roomNumber = roomNumber;
        }

        public String getRoomType() {
            return roomType;
        }

        public void setRoomType(String roomType) {
            this.roomType = roomType;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "RoomDTO [roomNumber=" + roomNumber + ", roomType=" + roomType + ", price=" + price + "]";
        }


        }
