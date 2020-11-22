package upc.edu.pe.grantcredits.domain.model;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customers")
public class Customer extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private Date date_of_birthday;

    @NotNull
    private String gender;

    @NotNull
    private String email;

    @NotNull
    @Column(unique = true)
    private String dni;

    public Long getId() {
        return id;
    }

    public Customer setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Customer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Date getDate_of_birthday() {
        return date_of_birthday;
    }

    public Customer setDate_of_birthday(Date date_of_birthday) {
        this.date_of_birthday = date_of_birthday;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Customer setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getDni() {
        return dni;
    }

    public Customer setDni(String dni) {
        this.dni = dni;
        return this;
    }



}
