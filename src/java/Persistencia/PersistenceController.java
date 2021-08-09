package Persistencia;

import Logica.Employee;
import Logica.Guest;
import Logica.Reservation;
import Logica.Room;
import Logica.User;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PersistenceController {
    EmployeeJpaController employeeJpa = new EmployeeJpaController();
    UserJpaController userJpa = new UserJpaController();
    RoomJpaController roomJpa = new RoomJpaController();
    ReservationJpaController reservationJpa = new ReservationJpaController();
    GuestJpaController guestJpa = new GuestJpaController();
    
    public void newRoom(Room room){
        roomJpa.create(room);
    }
    
    public void registerEmployee(Employee employee){
        employeeJpa.create(employee);
    }
    
    public List<User> getUser() {
        return userJpa.findUserEntities();
    }
    
        
    public void newReservation(Reservation reservation){
        reservationJpa.create(reservation);
    }

    public List<Employee> getEmployees() {
        return employeeJpa.findEmployeeEntities();
    }

    public Room findRoom(int selectedRoom) {
        return roomJpa.findRoom(selectedRoom);
    }

    public List<Room> getRoomList() {
        return roomJpa.findRoomEntities();
    }

    public List<Guest> getGuest() {
        return guestJpa.findGuestEntities();
    }
    
    public void newGuest(Guest guest){
        guestJpa.create(guest);
    }

    public List<Reservation> getReservationList() {
        return reservationJpa.findReservationEntities();
    }

    public List getEmployeeReservation(){
        Employee employee = new Employee();
        return employee.getReservationEmp();
    }

    public Room getRoomId(int id) {
        return roomJpa.findRoom(id);
    }

    public Employee getEmployeeById(int id){
        return employeeJpa.findEmployee(id);
    }

    public void updateRoom(Room room) {
        try {
            roomJpa.edit(room);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteRoom(int roomId) {
        try {
            roomJpa.destroy(roomId);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
