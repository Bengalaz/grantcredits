package upc.edu.pe.grantcredits.resource;

import com.sun.istack.internal.NotNull;

import javax.persistence.Column;
import java.util.Date;

public class SaveCustomerResource {
    @NotNull
    private String name;

    @NotNull
    private String lastname;

    @NotNull
    private Date date_of_birthday;

    @NotNull
    private String gender;

    @NotNull
    private String email;

    @NotNull
    @Column(unique = true)
    private String dni;

    public String getName() {
        return name;
    }

    public SaveCustomerResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public SaveCustomerResource setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public Date getDate_of_birthday() {
        return date_of_birthday;
    }

    public SaveCustomerResource setDate_of_birthday(Date date_of_birthday) {
        this.date_of_birthday = date_of_birthday;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public SaveCustomerResource setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SaveCustomerResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getDni() {
        return dni;
    }

    public SaveCustomerResource setDni(String dni) {
        this.dni = dni;
        return this;
    }
}
