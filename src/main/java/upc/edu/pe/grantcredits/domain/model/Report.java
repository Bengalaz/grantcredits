package upc.edu.pe.grantcredits.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Entity
@Table(name = "reports")
public class Report extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Double totalmoney;

    @NotNull
    private String coin_type;

    @NotNull
    private Integer time;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Company company;

    public Long getId() {
        return id;
    }

    public Report setId(Long id) {
        this.id = id;
        return this;
    }

    public Double getTotalmoney() {
        return totalmoney;
    }

    public Report setTotalmoney(Double totalmoney) {
        this.totalmoney = totalmoney;
        return this;
    }

    public String getCoin_type() {
        return coin_type;
    }

    public Report setCoin_type(String coin_type) {
        this.coin_type = coin_type;
        return this;
    }

    public Integer getTime() {
        return time;
    }

    public Report setTime(Integer time) {
        this.time = time;
        return this;
    }


}
