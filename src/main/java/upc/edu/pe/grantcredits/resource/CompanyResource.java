package upc.edu.pe.grantcredits.resource;
import upc.edu.pe.grantcredits.domain.model.AuditModel;

public class CompanyResource extends AuditModel {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String phonenumber;

    public CompanyResource setId(Long id){
        this.id = id;
        return this;
    }
    public Long getId(){return id;}

    public String getUsername() {
        return username;
    }

    public CompanyResource setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CompanyResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CompanyResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public CompanyResource setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
        return this;
    }


}
