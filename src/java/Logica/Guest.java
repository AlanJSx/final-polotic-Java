package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Guest implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)    
    private int guestId;
    @Basic 
    private String dni;
    private String name;
    private String lastName;
    private String adress;
    private String career;
    
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    
    @OneToMany
    List<Reservation> reservationList = new ArrayList<>();

    public Guest() {
    }

    public Guest(int guestId, String dni, String name, String lastName, String adress, String career, Date birthDate) {
        this.guestId = guestId;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.adress = adress;
        this.career = career;
        this.birthDate = birthDate;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
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

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }
    
    
    
    
    
}
