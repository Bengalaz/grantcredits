package upc.edu.pe.grantcredits.resource;

import com.sun.istack.internal.NotNull;

public class SaveLineOfCredit {
    @NotNull
    private Double moneybalance;

    @NotNull
    private String type_rate;

    @NotNull
    private Double maintenance;

    @NotNull
    private String time_maintenance;

    @NotNull
    private Double interest_rate;

    @NotNull
    private Double delivery;

    @NotNull
    private String delivery_time;

    public Double getMoneybalance() {
        return moneybalance;
    }

    public SaveLineOfCredit setMoneybalance(Double moneybalance) {
        this.moneybalance = moneybalance;
        return this;
    }

    public String getType_rate() {
        return type_rate;
    }

    public SaveLineOfCredit setType_rate(String type_rate) {
        this.type_rate = type_rate;
        return this;
    }

    public Double getMaintenance() {
        return maintenance;
    }

    public SaveLineOfCredit setMaintenance(Double maintenance) {
        this.maintenance = maintenance;
        return this;
    }

    public String getTime_maintenance() {
        return time_maintenance;
    }

    public SaveLineOfCredit setTime_maintenance(String time_maintenance) {
        this.time_maintenance = time_maintenance;
        return this;
    }

    public Double getInterest_rate() {
        return interest_rate;
    }

    public SaveLineOfCredit setInterest_rate(Double interest_rate) {
        this.interest_rate = interest_rate;
        return this;
    }

    public Double getDelivery() {
        return delivery;
    }

    public SaveLineOfCredit setDelivery(Double delivery) {
        this.delivery = delivery;
        return this;
    }

    public String getDelivery_time() {
        return delivery_time;
    }

    public SaveLineOfCredit setDelivery_time(String delivery_time) {
        this.delivery_time = delivery_time;
        return this;
    }


}
