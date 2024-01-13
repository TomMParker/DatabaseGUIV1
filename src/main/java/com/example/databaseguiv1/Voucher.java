package com.example.databaseguiv1;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Voucher {
    private final SimpleIntegerProperty voucherID; // for the voucherID

    public int getVoucherID() {
        return voucherID.get();
    }

    public SimpleIntegerProperty voucherIDProperty() {
        return voucherID;
    }

    public void setVoucherID(int voucherID) {
        this.voucherID.set(voucherID);
    }

    public boolean isVoucherActive() {
        return voucherActive.get();
    }

    public SimpleBooleanProperty voucherActiveProperty() {
        return voucherActive;
    }

    public void setVoucherActive(boolean voucherActive) {
        this.voucherActive.set(voucherActive);
    }

    private final SimpleBooleanProperty voucherActive; // for the voucherActive

    public Voucher(int voucherID, boolean voucherActive) {
        this.voucherID = new SimpleIntegerProperty(voucherID);
        this.voucherActive = new SimpleBooleanProperty(voucherActive);
    }
}
