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
    
    private int numberPeople(String roomType){
        int numberPeople = 0;
        switch (roomType) {
        case "single":
            numberPeople = 1;
        break;

        case "doble":
            numberPeople = 2;
        break;

        case "triple":
            numberPeople = 3;    
        break;
        case "max":
            numberPeople = 6;   
        break;
        }
        return numberPeople;
    }
        
    public void newRoom(String roomName, int roomNumber, int hotelFloor, String roomType, double roomPrice) {
        Room room = new Room();
        room.setRoomName(roomName);
        room.setRoomNumber(roomNumber);
        room.setHotelFloor(hotelFloor);
        room.setRoomType(roomType);
        room.setRoomPrice(roomPrice);
        room.setMaxPeople(numberPeople(roomType));
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
    
    public void newReservation(String dni, String name, String lastName, String adress, String career, String birthDate, String checkIn, String checkOut, int numberPeople,  String selectedRoom, String userEmployee) throws ParseException {       
        Date guestCheckIn = convertStrintoDate(checkIn);
        Date guestCheckOut = convertStrintoDate(checkOut);
        
        
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
            
            int days = daysBetween(guestCheckIn, guestCheckOut);
            System.out.println("days: " + days);
            reservation.setNumberNights(days);


            reservation.setCheckIn(guestCheckIn);
            reservation.setCheckOut(guestCheckOut);
            //reservation.setCheckIn(Date.valueOf(checkIn));
            //reservation.setCheckOut(Date.valueOf(checkOut));
            double totalCost = days * getRoomPrice(roomId);
            reservation.setCost(totalCost);
            reservation.setEmployeeId(employee);

            perControl.newReservation(reservation);                                      

           
    }
    public int daysBetween(Date d1, Date d2){
             return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
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
    
    public Guest getGuest(String dni){
        List<Guest> guestList = perControl.getGuest();
        
        for (Guest guest : guestList){
            if (guest.getDni().equals(dni)){
                return guest;
            }
        }
        return null;
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
    
    
    public void newReservationG(String dni, String checkIn, String checkOut, int numberPeople, String selectedRoom, String userEmployee) {
        
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
        //int numberPeople = Integer.parseInt(people.replace(" ","")); 
        reservation.setNumberPeople(numberPeople);
        

        
        Date guestCheckIn = convertStrintoDate(checkIn);
        Date guestCheckOut = convertStrintoDate(checkOut);
        reservation.setCheckIn(guestCheckIn);
        reservation.setCheckOut(guestCheckOut);
        
        int days = daysBetween(guestCheckIn, guestCheckOut);
        System.out.println("days: " + days);
        reservation.setNumberNights(days);
        //reservation.setCheckIn(Date.valueOf(checkIn));
        //reservation.setCheckOut(Date.valueOf(checkOut));
        double totalCost = days * getRoomPrice(roomId);
        reservation.setCost(totalCost);
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
    
    public String convertDateString (Date dateDate){
        SimpleDateFormat formatNew = new SimpleDateFormat("yyyy-MM-dd");
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

    public List getRoomListByDate(int numberPeople, String in, String out) {
        Date checkIn = convertStrintoDate(in);
        Date checkOut = convertStrintoDate(out);
        List<Room> availableRoomList = new ArrayList<>();
        List<Reservation> reservationList = perControl.getReservationList();
        List<Room> roomList = perControl.getRoomList();
        
        if (!reservationList.isEmpty()){
            for (Room room : roomList){               
                int contador = 0;
                System.out.println(room.getRoomName());
                if(numberPeople <= room.getMaxPeople()){
                    for (Reservation reservation : reservationList){
                        Date reservationCheckIn = reservation.getCheckIn();
                        Date reservationCheckOut = reservation.getCheckOut();
                        if (checkIn.compareTo(reservationCheckOut) >= 0){
                            contador++; 
                        } else if(checkOut.compareTo(reservationCheckIn) <= 0){
                            contador++;
                        }
                        System.out.println(contador);
                        System.out.println(reservationList.size());
                        if (contador == reservationList.size()){
                            availableRoomList.add(room);
                        }    
                    }                                                                
                }                                         
            }
            return availableRoomList;    
        } else {
            for (Room room : roomList){
                if(numberPeople <= room.getMaxPeople()){
                    
                    availableRoomList.add(room);
                }
            }
            return availableRoomList;   
        }                             
    }

    public Room getRoom(int id) {       
        return perControl.getRoomId(id);      
    }
    
    public double getRoomPrice(int id){
        Room room = getRoom(id);
        return room.getRoomPrice();
    }

    public List<Guest> getGuestList() {
        return perControl.getGuest();
    }
    
    public List getReservationListFromTo(String from, String to){
        List<Reservation> reservationList = perControl.getReservationList();
        Date fromDate = convertStrintoDate(from);
        Date toDate = convertStrintoDate(to);
        List<Reservation> reservationFromTo = new ArrayList<>();
        if (!reservationList.isEmpty()){
            for (Reservation reservation : reservationList){
                Date checkIn = reservation.getCheckIn();
                    System.out.println(" Fecha checkIn " + checkIn);
                    System.out.println(" Fecha desde " + fromDate);
                    System.out.println(" Fecha Hasta " + toDate);
                if(checkIn.compareTo(fromDate) >= 0 && checkIn.compareTo(toDate) <= 0){
                    reservationFromTo.add(reservation);
                }
            }
            return reservationFromTo;
        } else {
            return reservationFromTo;
        }
    }

    public List<Reservation> getReservationByEmployee(String id) {       
        int employeeId = Integer.parseInt(id.replace(" ",""));
        
        List<Reservation> reservationList = perControl.getReservationList(); 
        List<Reservation> reservationEmployee = new ArrayList<>();
        if(!reservationList.isEmpty()){
            for(Reservation reservation : reservationList){   
                int employeeFoundId = reservation.getEmployeeId().getEmployeeId();
                if(employeeFoundId == employeeId){
                   reservationEmployee.add(reservation);
                } 
            }
        } else {
            return reservationEmployee;
        }
        return reservationEmployee; 
     
    }

    public List<Employee> getEmployeeList() {
        List<Employee> employeeList = perControl.getEmployees();
       // employeeList.remove(0);
        return employeeList;
    }
    
    public List<Reservation> getReservationByDateGuest(String from, String to, String guestDni){
        List<Reservation> reservationFromTo = getReservationListFromTo(from, to);
        
        // Creación de nueva lista para evitar errores al usar el metodo remove       
        List<Reservation> reservationByDateGuest = new ArrayList<>();
        
        if (!reservationFromTo.isEmpty()){
            for(Reservation reservation : reservationFromTo){
                String guestIdFound = reservation.getGuest().getDni();
                if(guestIdFound.equals(guestDni)){
                    reservationByDateGuest.add(reservation);
                }
            } 
            return reservationByDateGuest;
        } else {
            return reservationByDateGuest;
        }
            
              
    }
    
    
    
    // Carga de datos de prueba
    public void automaticTestData(){
        // Habitaciones
        newRoom("Habitacion 100", 100, 1, "single", 3500);
        newRoom("Habitacion 105", 105, 2, "doble", 4200);
        newRoom("Habitacion 108", 108, 1, "triple", 7000);
        newRoom("Habitacion 200", 200, 2, "max", 12000);
        newRoom("Habitacion 203", 203, 3, "doble", 5000);
        
        // Empleados
        newEmployee("Empleado 1", "Ape 1 ", "36789123", "2020-12-31", "calle1", "Gerente", "empleado1", "empleado1");
        newEmployee("Empleado 2", "Ape 2 ", "30789464", "1980-05-21", "calle2", "Recepcionista", "empleado2", "empleado2");
        newEmployee("Empleado 3", "Ape 3 ", "34654464", "1990-08-28", "calle3", "Recepcionista", "empleado3", "empleado3");
    
        
    }

    public void updateRoom(int roomId, String roomName, int roomNumber, String hotelFloor, String roomType, double roomPrice) {
        Room room = new Room();
        System.out.println(" Room Id " + "|" + roomId + "|");
        //int roomIdM = Integer.parseInt(roomId.replace(" ","")); 
        
        room.setIdRoom(roomId);
        room.setRoomName(roomName);
        room.setRoomNumber(roomNumber);
        
        int roomFloor = Integer.parseInt(hotelFloor.replace(" ","")); 
        room.setHotelFloor(roomFloor);
        room.setRoomType(roomType);
        room.setRoomPrice(roomPrice);
        room.setMaxPeople(numberPeople(roomType));
    
        
        perControl.updateRoom(room);

    }

    public void deleteRoom(int roomId) {
        perControl.deleteRoom(roomId);
    }



    public Employee getEmployee(int employeeId) {
        return perControl.getEmployeeById(employeeId);
    }

    public void updateEmployee(int employeeId, String employeeName, String employeeLastName, String employeeDni, String birthDate, String adress, String workPosition, int employeeIdUser,String username, String password) {
        Employee employee = new Employee();
        employee.setEmployeeId(employeeId);
        employee.setName(employeeName);
        employee.setLastName(employeeLastName);
        employee.setDni(employeeDni);

        Date birth = convertStrintoDate(birthDate);
        employee.setBirthDate(birth);
        employee.setAdress(adress);
        employee.setWorkPosition(workPosition);
        
        User user = new User();
        System.out.println("usuario "+ username);
        user.setUserId(employeeIdUser);
        user.setUserName(username);
        user.setPassword(password);
        
        employee.setUser(user);
        perControl.updateUser(user);        
        perControl.updateEmployee(employee);    
    }

    public Reservation getReservationById(int reservationId) {
        return perControl.getReservationById(reservationId);
    }

    public void deleteReservation(int reservationId) {
        perControl.deleteReservation(reservationId);
    }
    
    public void adminUserCount(){
         int counter = perControl.adminUserCount();
         if(counter == 0){
             createHotelAdministrator();
         }
    }
}
  
