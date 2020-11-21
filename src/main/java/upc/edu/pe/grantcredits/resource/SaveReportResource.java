package upc.edu.pe.grantcredits.resource;

import com.sun.istack.internal.NotNull;

public class SaveReportResource {
    @NotNull
    private Double totalmoney;

    @NotNull
    private String coin_type;

    @NotNull
    private Integer time;

    public Double getTotalmoney() {
        return totalmoney;
    }

    public SaveReportResource setTotalmoney(Double totalmoney) {
        this.totalmoney = totalmoney;
        return this;
    }

    public String getCoin_type() {
        return coin_type;
    }

    public SaveReportResource setCoin_type(String coin_type) {
        this.coin_type = coin_type;
        return this;
    }

    public Integer getTime() {
        return time;
    }

    public SaveReportResource setTime(Integer time) {
        this.time = time;
        return this;
    }
}
