package com.example.databaseguiv1;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDateTime;

public class Animal {

    private SimpleStringProperty animalID;
    private SimpleStringProperty animalName;
    private SimpleStringProperty animalType;
    private SimpleStringProperty breed;
    private SimpleIntegerProperty animalWeightKG;
    private SimpleStringProperty animalInfo;
    private SimpleStringProperty customerID;

    public Animal(String animalID, String animalName, String animalType, String breed,int  animalWeightKG, String animalInfo, String customerID) {
        this.animalID = new SimpleStringProperty(animalID);
        this.animalName = new SimpleStringProperty(animalName);
        this.animalType = new SimpleStringProperty(animalType);
        this.breed = new SimpleStringProperty(breed);
        this.animalWeightKG = new SimpleIntegerProperty(animalWeightKG);
        this.animalInfo = new SimpleStringProperty(animalInfo);
        this.customerID = new SimpleStringProperty(customerID);
    }

    // Getters
    public String getAnimalID() {
        return animalID.get();
    }

    public String getAnimalName() {
        return animalName.get();
    }

    public String getAnimalType() {
        return animalType.get();
    }

    public String getBreed() {
        return breed.get();
    }

    public int getAnimalWeightKG() {
        return animalWeightKG.get();
    }

    public String getAnimalInfo() {
        return animalInfo.get();
    }

    public String getCustomerID() {
        return customerID.get();
    }

    // Setters
    public void setAnimalID(String animalID) {
        this.animalID.set(animalID);
    }

    public void setAnimalName(String animalName) {
        this.animalName.set(animalName);
    }

    public void setAnimalType(String animalType) {
        this.animalType.set(animalType);
    }

    public void setBreed(String breed) {
        this.breed.set(breed);
    }

    public void setAnimalWeightKG(int animalWeightKG) {
        this.animalWeightKG.set(animalWeightKG);
    }

    public void setAnimalInfo(String animalInfo) {
        this.animalInfo.set(animalInfo);
    }

    public void setCustomerID(String customerID) {
        this.customerID.set(customerID);
    }

    // Property getters (for TableView)
    public SimpleStringProperty animalIDProperty() {
        return animalID;
    }

    public SimpleStringProperty animalNameProperty() {
        return animalName;
    }

    public SimpleStringProperty animalTypeProperty() {
        return animalType;
    }

    public SimpleStringProperty breedProperty() {
        return breed;
    }

    public SimpleIntegerProperty animalWeightKGProperty() {
        return animalWeightKG;
    }

    public SimpleStringProperty animalInfoProperty() {
        return animalInfo;
    }

    public SimpleStringProperty customerIDProperty() {
        return customerID;
    }





}
