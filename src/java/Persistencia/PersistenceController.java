package Persistencia;

import Logica.Employee;
import Logica.Guest;
import Logica.Reservation;
import Logica.Room;
import Logica.User;
import java.util.List;


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
}