package com.example.databaseguiv1;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Payment {
    private SimpleIntegerProperty paymentRef;
    private SimpleStringProperty paymentType;
    private SimpleObjectProperty<BigDecimal> paymentAmount;
    private SimpleObjectProperty<LocalDate> paymentDate;
    private SimpleIntegerProperty appointmentID;
    private SimpleIntegerProperty voucherID;
    private SimpleStringProperty customerID;

    public Payment(int paymentRef, String paymentType, BigDecimal paymentAmount, LocalDate paymentDate, int appointmentID, int voucherID, String customerID) {
        this.paymentRef = new SimpleIntegerProperty(paymentRef);
        this.paymentType = new SimpleStringProperty(paymentType);
        this.paymentAmount = new SimpleObjectProperty<>(paymentAmount);
        this.paymentDate = new SimpleObjectProperty<>(paymentDate);
        this.appointmentID = new SimpleIntegerProperty(appointmentID);
        this.voucherID = new SimpleIntegerProperty(voucherID);
        this.customerID = new SimpleStringProperty(customerID);
    }

    public int getPaymentRef() {
        return paymentRef.get();
    }

    public SimpleIntegerProperty paymentRefProperty() {
        return paymentRef;
    }

    public void setPaymentRef(int paymentRef) {
        this.paymentRef.set(paymentRef);
    }

    public String getPaymentType() {
        return paymentType.get();
    }

    public SimpleStringProperty paymentTypeProperty() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType.set(paymentType);
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount.get();
    }

    public SimpleObjectProperty<BigDecimal> paymentAmountProperty() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount.set(paymentAmount);
    }

    public LocalDate getPaymentDate() {
        return paymentDate.get();
    }

    public SimpleObjectProperty<LocalDate> paymentDateProperty() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate.set(paymentDate);
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

    public int getVoucherID() {
        return voucherID.get();
    }

    public SimpleIntegerProperty voucherIDProperty() {
        return voucherID;
    }

    public void setVoucherID(int voucherID) {
        this.voucherID.set(voucherID);
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
}
