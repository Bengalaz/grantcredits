package upc.edu.pe.grantcredits.resource;


import upc.edu.pe.grantcredits.domain.model.AuditModel;

public class ReportResource extends AuditModel {

    private Long id;
    private Double totalmoney;
    private String coin_type;
    private Integer time;

    public Long getId() {
        return id;
    }

    public ReportResource setId(Long id) {
        this.id = id;
        return  this;
    }

    public Double getTotalmoney() {
        return totalmoney;
    }

    public ReportResource setTotalmoney(Double totalmoney) {
        this.totalmoney = totalmoney;
        return this;
    }

    public String getCoin_type() {
        return coin_type;
    }

    public ReportResource setCoin_type(String coin_type) {
        this.coin_type = coin_type;
        return this;
    }

    public Integer getTime() {
        return time;
    }

    public ReportResource setTime(Integer time) {
        this.time = time;
        return this;
    }

}
