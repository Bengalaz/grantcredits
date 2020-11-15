package upc.edu.pe.grantcredits.domain.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "lines_of_credits")
public class LineOfCredit extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMoneybalance() {
        return moneybalance;
    }

    public void setMoneybalance(Double moneybalance) {
        this.moneybalance = moneybalance;
    }

    public String getType_rate() {
        return type_rate;
    }

    public void setType_rate(String type_rate) {
        this.type_rate = type_rate;
    }

    public Double getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(Double maintenance) {
        this.maintenance = maintenance;
    }

    public String getTime_maintenance() {
        return time_maintenance;
    }

    public void setTime_maintenance(String time_maintenance) {
        this.time_maintenance = time_maintenance;
    }

    public Double getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(Double interest_rate) {
        this.interest_rate = interest_rate;
    }

    public Double getDelivery() {
        return delivery;
    }

    public void setDelivery(Double delivery) {
        this.delivery = delivery;
    }

    public String getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(String delivery_time) {
        this.delivery_time = delivery_time;
    }


}
