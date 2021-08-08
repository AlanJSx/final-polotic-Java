package Logica;


import Persistencia.PersistenceController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;




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
    
    public void newEmployee(String employeeName, String employeeLastName, String employeeDni, String birthDate, String adress, String workPosition, String username, String password) {
        Employee employee = new Employee();
        
        employee.setName(employeeName);
        employee.setLastName(employeeLastName);
        employee.setDni(employeeDni);

        Date birth = convertStrintoDate(birthDate);
        employee.setBirthDate(birth);
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
    
    public void newReservation(String dni, String name, String lastName, String adress, String career, String birthDate, String checkIn, String checkOut, int numberPeople, int numberNights, String selectedRoom, String userEmployee) throws ParseException {
        
        Date guestCheckIn = convertStrintoDate(checkIn);
        Date guestCheckOut = convertStrintoDate(checkOut);
        
        
        boolean disponible = checkDateReservation(guestCheckIn, guestCheckOut);
        
        Guest guest = new Guest();
        Room room;
        
        Employee employee;
        
        employee = findEmployeeByUser(userEmployee);
      
            
        Reservation reservation = new Reservation();
        int roomId = Integer.parseInt(selectedRoom.replace(" ","")); 
        room = perControl.findRoom(roomId);
        
        guest.setDni(dni);
        guest.setName(name);
        guest.setLastName(lastName);
        guest.setAdress(adress);
        Date guestBirthDate = convertStrintoDate(birthDate);
        guest.setBirthDate(guestBirthDate);
        //guest.setBirthDate(Date.valueOf(birthDate));
        guest.setCareer(career);
        perControl.newGuest(guest);
        
        reservation.setGuest(guest);
        reservation.setRoomId(room);
        reservation.setNumberPeople(numberPeople);
        reservation.setNumberNights(numberNights);

        
        reservation.setCheckIn(guestCheckIn);
        reservation.setCheckOut(guestCheckOut);
        //reservation.setCheckIn(Date.valueOf(checkIn));
        //reservation.setCheckOut(Date.valueOf(checkOut));
        reservation.setCost(2);
        reservation.setEmployeeId(employee);
        
        perControl.newReservation(reservation);
        
        
        
    }
    
        /*
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date reservationCheckIn = (Date) format.parse(checkIn);
        } catch (ParseException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Date reservationCheckout = (Date) format.parse(checkIn);
        } catch (ParseException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    */
        
    public boolean checkDateReservation(Date checkIn, Date checkOut){
                
        List<Reservation> reservationList = perControl.getReservationList();
        
        for (Reservation reservation : reservationList){
            Date checkInres = (Date) reservation.getCheckIn();
            Date checkOutres = (Date) reservation.getCheckOut();
            
            if (checkInres.before(checkIn) && checkOutres.before(checkIn) || (checkInres.after(checkOut) && checkOutres.after(checkOut))){
                System.out.println(true + " paso ");
                return true;
            }                                         
        }
        return false;
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
        
        Guest guest; 
        guest = findGuestByDni(dni);

        Room room;
        
        Employee employee;
        
        employee = findEmployeeByUser(userEmployee);
      
            
        Reservation reservation = new Reservation();
        int roomId = Integer.parseInt(selectedRoom.replace(" ","")); 
        room = perControl.findRoom(roomId);
  
        reservation.setGuest(guest);
        reservation.setRoomId(room);
        reservation.setNumberPeople(numberPeople);
        reservation.setNumberNights(numberNights);
        Date guestCheckIn = convertStrintoDate(checkIn);
        Date guestCheckOut = convertStrintoDate(checkOut);
        reservation.setCheckIn(guestCheckIn);
        reservation.setCheckOut(guestCheckOut);
        //reservation.setCheckIn(Date.valueOf(checkIn));
        //reservation.setCheckOut(Date.valueOf(checkOut));
        reservation.setCost(2);
        reservation.setEmployeeId(employee);
        
        perControl.newReservation(reservation);        
   
    }
    

    public void adminUser(){
        if (isHotelAdministrator("admin") == false) {
            createHotelAdministrator();
        }
    }    
        
        
    public boolean isHotelAdministrator(String adminUser){
        List <User> userList = perControl.getUser();
        if (userList.isEmpty()){
            return false;
        } else {
            for (User user : userList){
                if (user.getUserName().equals(adminUser)){
                    return true;
                }     
            }
        } 
        return false;
    }
    
    public void createHotelAdministrator(){
        Employee employee = new Employee();
        
        employee.setName("Hotel Administrator");
        employee.setLastName(" Hotel ");
        employee.setDni("");
        

 
//        employee.setBirthDate(Date.valueOf("2020-12-31"));
        String birthDate = "2020-12-31";
        Date employeeBirth = convertStrintoDate(birthDate);
        employee.setBirthDate(employeeBirth);
        employee.setAdress("Hotel Street");
        employee.setWorkPosition(" Hotel Administrator ");
        
        User user = new User();
        
        user.setUserName("admin");
        user.setPassword("admin");
        
        employee.setUser(user);
        
        perControl.registerEmployee(employee);
    }
    
    public List<Reservation> getReservationToday(){
        List<Reservation> reservationList = perControl.getReservationList();
        
        List<Reservation> reservationToday = new ArrayList<>();
        String today = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        
        for (Reservation reservation : reservationList){
            String reservationDate = new SimpleDateFormat("yyyy-MM-dd").format(reservation.getCheckIn());
            
            
            if(reservationDate.equals(today)){
                
                reservationToday.add(reservation);
            }
        }
        return reservationToday;
    }

    public String convertDatetoString (Date dateDate){
        SimpleDateFormat formatNew = new SimpleDateFormat("dd-MM-yyyy");
        String newDateString = formatNew.format(dateDate);
        
        return newDateString;
    }
    
    public Date convertStrintoDate(String stringDate){
        Date newDate = new Date();
        
        SimpleDateFormat formatDateNew = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            newDate = formatDateNew.parse(stringDate);
        } catch (ParseException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        formatDateNew.format(newDate);
        
        return newDate;
        
    }
}
