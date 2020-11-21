package upc.edu.pe.grantcredits.resource;

import upc.edu.pe.grantcredits.domain.model.AuditModel;
import java.util.Date;

public class CustomerResource extends AuditModel {

    private Long id;
    private String name;
    private String lastname;
    private Date date_of_birthday;
    private String gender;
    private String email;
    private String dni;

    public Long getId() { return id;  }

    public CustomerResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CustomerResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public CustomerResource setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public Date getDate_of_birthday() {
        return date_of_birthday;
    }

    public CustomerResource setDate_of_birthday(Date date_of_birthday) {
        this.date_of_birthday = date_of_birthday;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public CustomerResource setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CustomerResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getDni() {
        return dni;
    }

    public CustomerResource setDni(String dni) {
        this.dni = dni;
        return this;
    }


}
