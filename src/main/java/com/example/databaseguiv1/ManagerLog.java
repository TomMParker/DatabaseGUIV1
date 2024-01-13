package com.example.databaseguiv1;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import java.time.LocalDate;


public class ManagerLog {
    private SimpleStringProperty managerLogID ;
    private SimpleStringProperty staffID;
    private SimpleStringProperty managerStaffID;
    private ObjectProperty<LocalDate> managerStartDate;
    private ObjectProperty<LocalDate> managerEndDate;

    public ManagerLog(String managerLogID, String staffID, String managerStaffID, LocalDate managerStartDate, LocalDate managerEndDate) {
        this.managerLogID = new SimpleStringProperty(managerLogID);
        this.staffID = new SimpleStringProperty(staffID);
        this.managerStaffID = new SimpleStringProperty(managerStaffID);
        this.managerStartDate = new SimpleObjectProperty<>(managerStartDate);
        this.managerEndDate = new SimpleObjectProperty<>(managerEndDate);
    }

    public String getManagerLogID() {
        return managerLogID.get();
    }

    public SimpleStringProperty managerLogIDProperty() {
        return managerLogID;
    }

    public void setManagerLogID(String managerLogID) {
        this.managerLogID.set(managerLogID);
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

    public String getManagerStaffID() {
        return managerStaffID.get();
    }

    public SimpleStringProperty managerStaffIDProperty() {
        return managerStaffID;
    }

    public void setManagerStaffID(String managerStaffID) {
        this.managerStaffID.set(managerStaffID);
    }

    public LocalDate getManagerStartDate() {
        return managerStartDate.get();
    }

    public ObjectProperty<LocalDate> managerStartDateProperty() {
        return managerStartDate;
    }

    public void setManagerStartDate(LocalDate managerStartDate) {
        this.managerStartDate.set(managerStartDate);
    }

    public LocalDate getManagerEndDate() {
        return managerEndDate.get();
    }

    public ObjectProperty<LocalDate> managerEndDateProperty() {
        return managerEndDate;
    }

    public void setManagerEndDate(LocalDate managerEndDate) {
        this.managerEndDate.set(managerEndDate);
    }
}
