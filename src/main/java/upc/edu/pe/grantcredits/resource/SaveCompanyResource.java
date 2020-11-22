package upc.edu.pe.grantcredits.resource;

import javax.validation.constraints.NotNull;
import javax.persistence.Column;

public class SaveCompanyResource {
    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    private String password;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String phonenumber;

    public String getUsername() {
        return username;
    }

    public SaveCompanyResource setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SaveCompanyResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SaveCompanyResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public SaveCompanyResource setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
        return this;
    }
}
