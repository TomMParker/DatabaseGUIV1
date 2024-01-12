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

    // Getters
    public int getAppointmentID() {
        return appointmentID.get();
    }

    public String getAnimalID() {
        return animalID.get();
    }

    public LocalDateTime getAppointmentStartTime() {
        return appointmentStartTime.get();
    }

    public String getStaffID() {
        return staffID.get();
    }

    public String getBranchName() {
        return branchName.get();
    }

    public String getService() {
        return service.get();
    }

    // Setters
    public void setAppointmentID(int appointmentID) {
        this.appointmentID.set(appointmentID);
    }

    public void setAnimalID(String animalID) {
        this.animalID.set(animalID);
    }

    public void setAppointmentStartTime(LocalDateTime appointmentStartTime) {
        this.appointmentStartTime.set(appointmentStartTime);
    }

    public void setStaffID(String staffID) {
        this.staffID.set(staffID);
    }

    public void setBranchName(String branchName) {
        this.branchName.set(branchName);
    }

    public void setService(String service) {
        this.service.set(service);
    }

    // Property getters (used for binding with TableView)
    public SimpleIntegerProperty appointmentIDProperty() {
        return appointmentID;
    }

    public SimpleStringProperty animalIDProperty() {
        return animalID;
    }

    public SimpleObjectProperty<LocalDateTime> appointmentStartTimeProperty() {
        return appointmentStartTime;
    }

    public SimpleStringProperty staffIDProperty() {
        return staffID;
    }

    public SimpleStringProperty branchNameProperty() {
        return branchName;
    }

    public SimpleStringProperty serviceProperty() {
        return service;
    }
}
