package upc.edu.pe.grantcredits.resource;

import upc.edu.pe.grantcredits.domain.model.AuditModel;

public class LineOfCreditResource extends AuditModel {

    private Long id;
    private Double moneybalance;
    private String type_rate;
    private Double maintenance;
    private String time_maintenance;
    private Double interest_rate;
    private Double delivery;
    private String delivery_time;

    public Long getId() {
        return id;
    }

    public LineOfCreditResource setId(Long id) {
        this.id = id;
        return this;
    }

    public Double getMoneybalance() {
        return moneybalance;
    }

    public LineOfCreditResource setMoneybalance(Double moneybalance) {
        this.moneybalance = moneybalance;
        return this;
    }

    public String getType_rate() {
        return type_rate;
    }

    public LineOfCreditResource setType_rate(String type_rate) {
        this.type_rate = type_rate;
        return this;
    }

    public Double getMaintenance() {
        return maintenance;
    }

    public LineOfCreditResource setMaintenance(Double maintenance) {
        this.maintenance = maintenance;
        return this;
    }

    public String getTime_maintenance() {
        return time_maintenance;
    }

    public LineOfCreditResource setTime_maintenance(String time_maintenance) {
        this.time_maintenance = time_maintenance;
        return this;
    }

    public Double getInterest_rate() {
        return interest_rate;
    }

    public LineOfCreditResource setInterest_rate(Double interest_rate) {
        this.interest_rate = interest_rate;
        return this;
    }

    public Double getDelivery() {
        return delivery;
    }

    public LineOfCreditResource setDelivery(Double delivery) {
        this.delivery = delivery;
        return this;
    }

    public String getDelivery_time() {
        return delivery_time;
    }

    public LineOfCreditResource setDelivery_time(String delivery_time) {
        this.delivery_time = delivery_time;
        return this;
    }
}
