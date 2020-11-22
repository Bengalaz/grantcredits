package upc.edu.pe.grantcredits.resource;

import javax.validation.constraints.NotNull;

import java.util.Date;

public class SaveReportDetailResource {
    @NotNull
    private Date expires_at;

    @NotNull
    private String description;

    public Date getExpires_at() {
        return expires_at;
    }

    public SaveReportDetailResource setExpires_at(Date expires_at) {
        this.expires_at = expires_at;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SaveReportDetailResource setDescription(String description) {
        this.description = description;
        return this;
    }


}
