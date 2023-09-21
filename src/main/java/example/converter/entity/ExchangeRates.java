package example.converter.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class ExchangeRates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int baseValueId;
    private int targetValueId;
    private double rate;

    public ExchangeRates() {
    }

    public ExchangeRates(int baseValueId, int targetValueId, double rate) {
        this.baseValueId = baseValueId;
        this.targetValueId = targetValueId;
        this.rate = rate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getBaseValueId() {
        return baseValueId;
    }

    public void setBaseValueId(int baseValueId) {
        this.baseValueId = baseValueId;
    }

    public int getTargetValueId() {
        return targetValueId;
    }

    public void setTargetValueId(int targetValueId) {
        this.targetValueId = targetValueId;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeRates that = (ExchangeRates) o;
        return baseValueId == that.baseValueId && targetValueId == that.targetValueId && Double.compare(rate, that.rate) == 0 && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, baseValueId, targetValueId, rate);
    }

    @Override
    public String toString() {
        return "ExchangeRates{" +
                "id=" + id +
                ", baseValueId=" + baseValueId +
                ", targetValueId=" + targetValueId +
                ", rate=" + rate +
                '}';
    }
}
