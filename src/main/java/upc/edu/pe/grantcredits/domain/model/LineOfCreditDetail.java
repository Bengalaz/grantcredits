package upc.edu.pe.grantcredits.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lineOfCredit_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private LineOfCredit lineOfCredit;

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

    public LineOfCredit getLineOfCredit() {
        return lineOfCredit;
    }

    public LineOfCreditDetail setLineOfCredit(LineOfCredit lineOfCredit) {
        this.lineOfCredit = lineOfCredit;
        return this;
    }
}
