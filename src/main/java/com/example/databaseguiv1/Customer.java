package com.example.databaseguiv1;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Customer {



    private SimpleStringProperty customerID ;
    private SimpleStringProperty customerFirstName;
    private SimpleStringProperty customerSecondName;
    private SimpleStringProperty customerEmail;
    private SimpleStringProperty customerMobile;
    private SimpleStringProperty customerHomePhone;
    private SimpleStringProperty customerAddress1;
    private SimpleStringProperty customerAddress2;
    private SimpleStringProperty customerPostcode;

    public Customer(String customerID, String customerFirstName, String customerSecondName, String customerEmail, String  customerMobile,
                    String customerHomePhone, String customerAddress1, String customerAddress2, String customerPostcode) {
        this.customerID = new SimpleStringProperty(customerID);
        this.customerFirstName = new SimpleStringProperty(customerFirstName);
        this.customerSecondName = new SimpleStringProperty(customerSecondName);
        this.customerEmail = new SimpleStringProperty(customerEmail);
        this.customerMobile = new SimpleStringProperty(customerMobile);
        this.customerHomePhone = new SimpleStringProperty(customerHomePhone);
        this.customerAddress1 = new SimpleStringProperty(customerAddress1);
        this.customerAddress2 = new SimpleStringProperty(customerAddress2);
        this.customerPostcode = new SimpleStringProperty(customerPostcode);
    }

    public String getCustomerID() {
        return customerID.get();
    }

    public SimpleStringProperty customerIDProperty() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID.set(customerID);
    }

    public String getCustomerFirstName() {
        return customerFirstName.get();
    }

    public SimpleStringProperty customerFirstNameProperty() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName.set(customerFirstName);
    }

    public String getCustomerSecondName() {
        return customerSecondName.get();
    }

    public SimpleStringProperty customerSecondNameProperty() {
        return customerSecondName;
    }

    public void setCustomerSecondName(String customerSecondName) {
        this.customerSecondName.set(customerSecondName);
    }

    public String getCustomerEmail() {
        return customerEmail.get();
    }

    public SimpleStringProperty customerEmailProperty() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail.set(customerEmail);
    }

    public String getCustomerMobile() {
        return customerMobile.get();
    }

    public SimpleStringProperty customerMobileProperty() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile.set(customerMobile);
    }

    public String getCustomerHomePhone() {
        return customerHomePhone.get();
    }

    public SimpleStringProperty customerHomePhoneProperty() {
        return customerHomePhone;
    }

    public void setCustomerHomePhone(String customerHomePhone) {
        this.customerHomePhone.set(customerHomePhone);
    }

    public String getCustomerAddress1() {
        return customerAddress1.get();
    }

    public SimpleStringProperty customerAddress1Property() {
        return customerAddress1;
    }

    public void setCustomerAddress1(String customerAddress1) {
        this.customerAddress1.set(customerAddress1);
    }

    public String getCustomerAddress2() {
        return customerAddress2.get();
    }

    public SimpleStringProperty customerAddress2Property() {
        return customerAddress2;
    }

    public void setCustomerAddress2(String customerAddress2) {
        this.customerAddress2.set(customerAddress2);
    }

    public String getCustomerPostcode() {
        return customerPostcode.get();
    }

    public SimpleStringProperty customerPostcodeProperty() {
        return customerPostcode;
    }

    public void setCustomerPostcode(String customerPostcode) {
        this.customerPostcode.set(customerPostcode);
    }

}
