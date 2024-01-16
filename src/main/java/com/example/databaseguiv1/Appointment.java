package com.example.databaseguiv1;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import java.time.LocalDateTime;

public class Appointment {
    private SimpleIntegerProperty appointmentID;
    private SimpleStringProperty animalID;
    private SimpleObjectProperty<LocalDateTime> appointmentStartTime;
    private SimpleStringProperty staffID;
    private SimpleStringProperty branchName;
    private SimpleStringProperty service;

    public Appointment(int appointmentID, String animalID, LocalDateTime appointmentStartTime, String staffID, String branchName, String service) {
        this.appointmentID = new SimpleIntegerProperty(appointmentID);
        this.animalID = new SimpleStringProperty(animalID);
        this.appointmentStartTime = new SimpleObjectProperty<>(appointmentStartTime);
        this.staffID = new SimpleStringProperty(staffID);
        this.branchName = new SimpleStringProperty(branchName);
        this.service = new SimpleStringProperty(service);
    }

    public int getAppointmentID() {
        return appointmentID.get();
    }

    public SimpleIntegerProperty appointmentIDProperty() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID.set(appointmentID);
    }

    public String getAnimalID() {
        return animalID.get();
    }

    public SimpleStringProperty animalIDProperty() {
        return animalID;
    }

    public void setAnimalID(String animalID) {
        this.animalID.set(animalID);
    }

    public LocalDateTime getAppointmentStartTime() {
        return appointmentStartTime.get();
    }

    public SimpleObjectProperty<LocalDateTime> appointmentStartTimeProperty() {
        return appointmentStartTime;
    }

    public void setAppointmentStartTime(LocalDateTime appointmentStartTime) {
        this.appointmentStartTime.set(appointmentStartTime);
    }

    public String getStaffID() {
        return staffID.get();
    }

    public SimpleStringProperty staffIDProperty() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID.set(staffID);
    }

    public String getBranchName() {
        return branchName.get();
    }

    public SimpleStringProperty branchNameProperty() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName.set(branchName);
    }

    public String getService() {
        return service.get();
    }

    public SimpleStringProperty serviceProperty() {
        return service;
    }

    public void setService(String service) {
        this.service.set(service);
    }
}


