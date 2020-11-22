package upc.edu.pe.grantcredits.domain.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "line_of_credit_details")
public class LineOfCreditDetail extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Date expires_at;

    @NotNull
    private String description;

    public Long getId() {
        return id;
    }

    public LineOfCreditDetail setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getExpires_at() {
        return expires_at;
    }

    public LineOfCreditDetail setExpires_at(Date expires_at) {
        this.expires_at = expires_at;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public LineOfCreditDetail setDescription(String description) {
        this.description = description;
        return this;
    }
}
