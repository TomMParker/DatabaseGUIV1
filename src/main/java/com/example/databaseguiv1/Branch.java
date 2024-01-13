package com.example.databaseguiv1;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Branch {
    private SimpleStringProperty branchName;
    private SimpleStringProperty branchAddress1;
    private SimpleStringProperty branchAddress2;
    private SimpleStringProperty branchPostcode;

    public Branch (String branchName, String branchAddress1, String branchAddress2, String branchPostcode){
        this.branchName = new SimpleStringProperty(branchName);
        this.branchAddress1 = new SimpleStringProperty(branchAddress1);
        this.branchAddress2 = new SimpleStringProperty(branchAddress2);
        this.branchPostcode = new SimpleStringProperty(branchPostcode);
    }

    //Getters

    public String getBranchName(){
        return branchName.get();
    }

    public String getbranchAddress1(){
        return branchAddress1.get();
    }
    public String getbranchAddress2(){
        return branchAddress2.get();
    }

    public String getPostcode(){
        return branchPostcode.get();
    }

    //Setters


    public void setBranchName(String branchName) {
        this.branchName.set(branchName);
    }

    public void setBranchAddress1(String branchAddress1) {
        this.branchAddress1.set(branchAddress1);
    }

    public void setBranchAddress2(String branchAddress2) {
        this.branchAddress2.set(branchAddress2);
    }

    public void setBranchPostcode(String branchPostcode) {
        this.branchPostcode.set(branchPostcode);
    }


    // Property getters (for TableView)

    /*private SimpleStringProperty branchName;
    private SimpleStringProperty branchAddress1;
    private SimpleStringProperty branchAddress2;
    private SimpleStringProperty branchPostcode;
    Property
    */


    public SimpleStringProperty branchNameProperty(){
        return branchName;
    }

    public SimpleStringProperty branchAddress1Property(){
        return branchAddress1;
    }

    public SimpleStringProperty branchAddress2Property(){
        return branchAddress2;
    }

    public SimpleStringProperty branchPostcodeProperty(){
        return branchPostcode;
    }


}
