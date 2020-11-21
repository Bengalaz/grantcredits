package upc.edu.pe.grantcredits.resource;


import upc.edu.pe.grantcredits.domain.model.AuditModel;
import java.util.Date;

public class ReportDetailResource extends AuditModel {

    private Long id;
    private Date expires_at;
    private String description;

    public Long getId() {
        return id;
    }

    public ReportDetailResource setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getExpires_at() {
        return expires_at;
    }

    public ReportDetailResource setExpires_at(Date expires_at) {
        this.expires_at = expires_at;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ReportDetailResource setDescription(String description) {
        this.description = description;
        return this;
    }

}
