package model.People;

import model.School;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name="Human")
public class Human {
    private Integer id;
    private String ic;
    private String name;
    private String contact;
    private String emergencyContact;
    private LocalDate dob;
    private String gender;
    private String address;
    private String email;
    private Boolean active;
    private School school;

    public Human() {}

    public Human(Integer id, String ic, String name, String contact, String emergencyContact, LocalDate dob,
                 String address, String gender, String email, Boolean active, School school) {
        this.id = id;
        this.ic = ic;
        this.name = name;
        this.contact = contact;
        this.emergencyContact = emergencyContact;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.active = active;
        this.school = school;
    }

    public String toString() {
        return name;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="HUMAN_ID")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="IC", nullable=false, length=200)
    public String getIc() {
        return ic;
    }
    public void setIc(String ic) {
        this.ic = ic;
    }

    @Column(name="NAME", nullable=false, length=200)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name="CONTACT", nullable=false, length=200)
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }

    @Column(name="EMERGENCY_CONTACT", nullable=false, length=200)
    public String getEmergencyContact() {
        return emergencyContact;
    }
    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    @Column(name="DATE_OF_BIRTH")
    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Column(name="ADDRESS", nullable=false, length=200)
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name="GENDER", nullable=false, length=200)
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name="EMAIL", nullable=false, length=200)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="ACTIVE", nullable=false, length=200)
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    public School getSchool() {
        return school;
    }
    public void setSchool(School school) {
        this.school = school;
    }


}
