package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.eclipse.persistence.annotations.CascadeOnDelete;

@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)    
    private int employeeId;
    
    @Basic 
    private String dni;
    private String name;
    private String lastName;
    private String adress;
    private String workPosition;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    
    //@JoinColumn
    @OneToOne(cascade = CascadeType.PERSIST)
    User user;
    //private 
    
    @OneToMany
    List<Reservation> reservationEmp = new ArrayList<>();

    public Employee(int employeeId, String dni, String name, String lastName, String adress, String workPosition, Date birthDate, User user) {
        this.employeeId = employeeId;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.adress = adress;
        this.workPosition = workPosition;
        this.birthDate = birthDate;
        this.user = user;
    }

    public Employee() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public void setWorkPosition(String workPosition) {
        this.workPosition = workPosition;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Reservation> getReservationEmp() {
        return reservationEmp;
    }
    
    
    
    
    
    
    
    
}
