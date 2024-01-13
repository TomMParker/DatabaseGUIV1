package com.example.databaseguiv1;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.math.BigDecimal;

public class Service {

    public String getService() {
        return service.get();
    }

    public SimpleStringProperty serviceProperty() {
        return service;
    }

    public void setService(String service) {
        this.service.set(service);
    }

    public BigDecimal getCost() {
        return cost.get();
    }

    public SimpleObjectProperty<BigDecimal> costProperty() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost.set(cost);
    }

    public int getDuration() {
        return duration.get();
    }

    public SimpleIntegerProperty durationProperty() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration.set(duration);
    }

    private SimpleStringProperty service;
    private SimpleObjectProperty<BigDecimal> cost;
    private SimpleIntegerProperty duration;

    public Service(String service, BigDecimal cost, Integer duration){

        this.service = new SimpleStringProperty(service);
        this.cost = new SimpleObjectProperty<>(cost);
        this.duration = new SimpleIntegerProperty(duration);
    }
}
