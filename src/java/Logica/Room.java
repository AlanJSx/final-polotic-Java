package Logica;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Room implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int idRoom;
    
    @Basic
    private int roomNumber;
    private int hotelFloor;
    private String roomName;
    private String roomType;
    private double roomPrice; 
    
    @OneToMany
    List<Reservation> reservationRoom = new ArrayList<>();

    public Room() {
    }

    public Room(int idRoom, int roomNumber, int hotelFloor, String roomName, String roomType, double roomPrice) {
        this.idRoom = idRoom;
        this.roomNumber = roomNumber;
        this.hotelFloor = hotelFloor;
        this.roomName = roomName;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getHotelFloor() {
        return hotelFloor;
    }

    public void setHotelFloor(int hotelFloor) {
        this.hotelFloor = hotelFloor;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }
    
    
    
    
    
}
