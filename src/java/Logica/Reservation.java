/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long reservationId;
    
    @Basic
    private int numberPeople;
    private int numberNights;
    private double cost;
    @Temporal(TemporalType.DATE)
    private Date checkIn;
    @Temporal(TemporalType.DATE)
    private Date checkOut;
    
    //@JoinColumn
    @ManyToOne //(cascade = CascadeType.MERGE)
    Room roomId;  
        
    //@OneToOne(cascade = CascadeType.PERSIST)
    //@JoinColumn
    @ManyToOne
    Guest guest;
      
    
    //@JoinColumn
    @ManyToOne//(cascade = CascadeType.MERGE)
    Employee employeeId;

    public Reservation() {
    }

    public Reservation(long reservationId, int numberPeople, int numberNights, double cost, Date checkIn, Date checkOut, Room roomId, Guest guest, Employee employeeId) {
        this.reservationId = reservationId;
        this.numberPeople = numberPeople;
        this.numberNights = numberNights;
        this.cost = cost;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomId = roomId;
        this.guest = guest;
        this.employeeId = employeeId;
    }

    public long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public int getNumberPeople() {
        return numberPeople;
    }

    public void setNumberPeople(int numberPeople) {
        this.numberPeople = numberPeople;
    }

    public int getNumberNights() {
        return numberNights;
    }

    public void setNumberNights(int numberNights) {
        this.numberNights = numberNights;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }
    
    
    
    
    
}
