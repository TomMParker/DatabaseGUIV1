package com.example.databaseguiv1;

import javafx.beans.property.SimpleStringProperty;

public class Staff {
    private SimpleStringProperty staffID ;
    private SimpleStringProperty staffFirstName;
    private SimpleStringProperty staffSecondName;
    private SimpleStringProperty staffAddress1;
    private SimpleStringProperty staffAddress2;
    private SimpleStringProperty staffPostcode;
    private SimpleStringProperty staffTelephoneNumber;
    private SimpleStringProperty currentManagerStaffID;


    public String getStaffID() {
        return staffID.get();
    }

    public SimpleStringProperty staffIDProperty() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID.set(staffID);
    }

    public String getStaffFirstName() {
        return staffFirstName.get();
    }

    public SimpleStringProperty staffFirstNameProperty() {
        return staffFirstName;
    }

    public void setStaffFirstName(String staffFirstName) {
        this.staffFirstName.set(staffFirstName);
    }

    public String getStaffSecondName() {
        return staffSecondName.get();
    }

    public SimpleStringProperty staffSecondNameProperty() {
        return staffSecondName;
    }

    public void setStaffSecondName(String staffSecondName) {
        this.staffSecondName.set(staffSecondName);
    }

    public String getStaffAddress1() {
        return staffAddress1.get();
    }

    public SimpleStringProperty staffAddress1Property() {
        return staffAddress1;
    }

    public void setStaffAddress1(String staffAddress1) {
        this.staffAddress1.set(staffAddress1);
    }

    public String getStaffAddress2() {
        return staffAddress2.get();
    }

    public SimpleStringProperty staffAddress2Property() {
        return staffAddress2;
    }

    public void setStaffAddress2(String staffAddress2) {
        this.staffAddress2.set(staffAddress2);
    }

    public String getStaffPostcode() {
        return staffPostcode.get();
    }

    public SimpleStringProperty staffPostcodeProperty() {
        return staffPostcode;
    }

    public void setStaffPostcode(String staffPostcode) {
        this.staffPostcode.set(staffPostcode);
    }

    public String getStaffTelephoneNumber() {
        return staffTelephoneNumber.get();
    }

    public SimpleStringProperty staffTelephoneNumberProperty() {
        return staffTelephoneNumber;
    }

    public void setStaffTelephoneNumber(String staffTelephoneNumber) {
        this.staffTelephoneNumber.set(staffTelephoneNumber);
    }

    public String getCurrentManagerStaffID() {
        return currentManagerStaffID.get();
    }

    public SimpleStringProperty currentManagerStaffIDProperty() {
        return currentManagerStaffID;
    }

    public void setCurrentManagerStaffID(String currentManagerStaffID) {
        this.currentManagerStaffID.set(currentManagerStaffID);
    }

    public Staff(String staffID, String staffFirstName, String staffSecondName, String  staffAddress1,
                 String staffAddress2, String staffPostcode, String staffTelephoneNumber, String currentManagerStaffID) {
        this.staffID = new SimpleStringProperty(staffID);
        this.staffFirstName = new SimpleStringProperty(staffFirstName);
        this.staffSecondName = new SimpleStringProperty(staffSecondName);
        this.staffAddress1 = new SimpleStringProperty(staffAddress1);
        this.staffAddress2 = new SimpleStringProperty(staffAddress2);
        this.staffPostcode = new SimpleStringProperty(staffPostcode);
        this.staffTelephoneNumber = new SimpleStringProperty(staffTelephoneNumber);
        this.currentManagerStaffID = new SimpleStringProperty(currentManagerStaffID);
    }


}
