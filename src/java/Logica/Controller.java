package Logica;

import Persistencia.PersistenceController;
import java.sql.Date;
import java.util.List;


public class Controller {
    PersistenceController perControl = new PersistenceController();
    
    public List<Room> getRoomList(){
        return perControl.getRoomList();
    }
        
    public void newRoom(String roomName, int roomNumber, int hotelFloor, String roomType, double roomPrice) {
        Room room = new Room();
        room.setRoomName(roomName);
        room.setRoomNumber(roomNumber);
        room.setHotelFloor(hotelFloor);
        room.setRoomType(roomType);
        room.setRoomPrice(roomPrice);
        
        perControl.newRoom(room);
        
    } 
    
    public void newEmployee(String employeeName, String employeeLastName, String employeeDni, Date birthDate, String adress, String workPosition, String username, String password) {
        Employee employee = new Employee();
        
        employee.setName(employeeName);
        employee.setLastName(employeeLastName);
        employee.setDni(employeeDni);
        employee.setBirthDate(birthDate);
        employee.setAdress(adress);
        employee.setWorkPosition(workPosition);
        
        User user = new User();
        
        user.setUserName(username);
        user.setPassword(password);
        
        employee.setUser(user);
        
        perControl.registerEmployee(employee);
    }
    
    public boolean validateUser(String jspUser, String jspPassword) {
        List<User> userList = perControl.getUser();
        for (User user : userList){
            if (user.getUserName().equals(jspUser) && user.getPassword().equals(jspPassword)){
                return true;
            }
        }
        return false;
    }
    
    public void newReservation(String dni, String name, String lastName, String adress, String career, String birthDate, String checkIn, String checkOut, int numberPeople, int numberNights, String selectedRoom, String userEmployee) {
        System.out.println("Llego a new servation ");
        
        Guest guest = new Guest();
        Room room;
        
        Employee employee;
        
        employee = findEmployeeByUser(userEmployee);
      
            
        Reservation reservation = new Reservation();
        int roomId = Integer.parseInt(selectedRoom.replace(" ","")); 
        room = perControl.findRoom(roomId);
         
        System.out.println("Encontro esta habitacion " + room.getRoomName());

        
        guest.setDni(dni);
        guest.setName(name);
        guest.setLastName(lastName);
        guest.setAdress(adress);
        guest.setBirthDate(Date.valueOf(birthDate));
        guest.setCareer(career);
        perControl.newGuest(guest);
        
        reservation.setGuest(guest);
        reservation.setRoomId(room);
        reservation.setNumberPeople(numberPeople);
        reservation.setNumberNights(numberNights);
        reservation.setCheckIn(Date.valueOf(checkIn));
        reservation.setCheckOut(Date.valueOf(checkOut));
        reservation.setCost(2);
        reservation.setEmployeeId(employee);
        
        perControl.newReservation(reservation);
        
        
        
    }
    
    public boolean findGuestDni(String dni){
        List<Guest> guestList = perControl.getGuest();    
        for (Guest guest : guestList){
            if (guest.getDni().equals(dni)){             
                return true;
            }
        }
        return false;
    }
    
    public Employee findEmployeeByUser(String username){
        Employee sessionEmployee = new Employee(); 
        List<Employee> employeeList = perControl.getEmployees();
        User user;
        
        for (Employee employeeN : employeeList){
            user = employeeN.getUser();
            if(user.getUserName().equals(username)){
                sessionEmployee = employeeN;  
                return sessionEmployee;
            }
        }    
        return sessionEmployee;
    }
    
    public Guest findGuestByDni(String dni){
        List<Guest> guestList = perControl.getGuest();
        Guest guest = new Guest();
        for (Guest guestL : guestList){
            if(guestL.getDni().equals(dni)){
                guest = guestL;
                return guest;
            }
        }
        return guest;
    }
    
    
    public void newReservationG(String dni, String checkIn, String checkOut, int numberPeople, int numberNights, String selectedRoom, String userEmployee) {
        System.out.println("Llego a new servationG ");
        
        Guest guest; 
        guest = findGuestByDni(dni);
        System.out.println(guest.getName());
        Room room;
        
        Employee employee;
        
        employee = findEmployeeByUser(userEmployee);
      
            
        Reservation reservation = new Reservation();
        int roomId = Integer.parseInt(selectedRoom.replace(" ","")); 
        room = perControl.findRoom(roomId);
         
        System.out.println("Encontro esta habitacion " + room.getRoomName());
     
        
        reservation.setGuest(guest);
        reservation.setRoomId(room);
        reservation.setNumberPeople(numberPeople);
        reservation.setNumberNights(numberNights);
        reservation.setCheckIn(Date.valueOf(checkIn));
        reservation.setCheckOut(Date.valueOf(checkOut));
        reservation.setCost(2);
        reservation.setEmployeeId(employee);
        
        perControl.newReservation(reservation);        
 
        
        
    }
    

    

}
