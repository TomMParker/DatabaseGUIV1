package com.example.databaseguiv1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
import java.time.LocalDateTime;

public class AnimalController {

    @FXML
    private TableView<Animal> animalsTableView;

    @FXML
    private TableColumn<Animal, String> animalIDColumn;
    @FXML
    private TableColumn<Animal, String> animalNameColumn;
    @FXML
    private TableColumn<Animal, String> animalTypeColumn;
    @FXML
    private TableColumn<Animal, String> breedColumn;
    @FXML
    private TableColumn<Animal, Integer> animalWeightKGColumn;
    @FXML
    private TableColumn<Animal, String> animalInfoColumn;

    @FXML
    private TableColumn<Animal, String> customerIDColumn;

    @FXML
    private TextField animalIDTextField;

    @FXML
    private TextField animalNameTextField;
    @FXML
    private TextField animalTypeTextField;
    @FXML
    private TextField breedTextField;
    @FXML
    private TextField animalWeightKGTextField;
    @FXML
    private TextField animalInfoTextField;
    @FXML
    private TextField customerIDTextField;


    @FXML
    public void initialize() {

        animalIDColumn.setCellValueFactory(new PropertyValueFactory<>("animalID"));
        animalNameColumn.setCellValueFactory(new PropertyValueFactory<>("animalName"));
        animalTypeColumn.setCellValueFactory(new PropertyValueFactory<>("animalType"));
        breedColumn.setCellValueFactory(new PropertyValueFactory<>("breed"));
        animalWeightKGColumn.setCellValueFactory(new PropertyValueFactory<>("animalWeightKG"));
        animalInfoColumn.setCellValueFactory(new PropertyValueFactory<>("animalInfo"));
        customerIDColumn.setCellValueFactory(new PropertyValueFactory<>("customerID"));

        loadAnimals();
    }

    private void loadAnimals() {
        String url = "jdbc:mysql://brighton.reclaimhosting.com:3306/tp558_DariasDogsV2";
        String username = "tp558_select";
        String password = "P_;2,}lafy}r";
        String sqlQuery = "SELECT * FROM tAnimal";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {

            ObservableList<Animal> animals = FXCollections.observableArrayList();

            while (resultSet.next()) {

                Animal animal = new Animal(
                        resultSet.getString("animalID"),
                        resultSet.getString("animalName"),
                        resultSet.getString("animalType"),
                        resultSet.getString("breed"),
                        resultSet.getInt("animalWeightKG"),
                        resultSet.getString("animalInfo"),
                        resultSet.getString("customerID")
                );
                animals.add(animal);

            }

            animalsTableView.setItems(animals);
            animalsTableView.refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleQuery() throws SQLException {
        String animalID = animalIDTextField.getText();
        String animalName = animalNameTextField.getText();
        String animalType = animalTypeTextField.getText();
        String breed = breedTextField.getText();
        String animalWeightKG = animalWeightKGTextField.getText();
        String animalInfo = animalInfoTextField.getText();
        String branchName = customerIDTextField.getText();
        String customerID = breedTextField.getText();

        queryAnimals(animalID, animalName, animalType, breed,animalWeightKG,animalInfo,branchName,customerID);
    }

    private void queryAnimals(String animalID, String animalName, String animalType, String breed,
                              String animalWeightKG,String animalInfo,String branchName,String customerID) throws SQLException {

        String url = "jdbc:mysql://brighton.reclaimhosting.com:3306/tp558_DariasDogsV2";
        String username = "tp558_select";
        String password = "P_;2,}lafy}r";

        //query for SQL search, uses % wildcards
        /*String sqlQuery = "SELECT * FROM tAnimal WHERE "
                + "animalID LIKE '%" + animalID + "%' AND "
                + "animalName LIKE '%" + animalName + "%' AND "
                + "animalType LIKE '%" + animalType + "%' AND "
                + "breed LIKE '%" + breed + "%' AND "
                + "animalWeightKG LIKE '%" + animalWeightKG + "%' AND "
                + "animalInfo LIKE '%" + animalInfo + "%' AND "
                + "branchName LIKE '%" + branchName + "%' AND "
                + "customerID LIKE '%" + customerID + "%";*/

        String sqlQuery = "SELECT * FROM tAnimal WHERE "
                + "animalID LIKE '%" + animalID + "%' AND "
                + "animalName LIKE '%" + animalName + "%' AND "
                + "animalType LIKE '%" + animalType + "%' AND "
                + "breed LIKE '%" + breed + "%' AND "
                + "animalWeightKG LIKE '%" + animalWeightKG + "%' AND "
                + "animalInfo LIKE '%" + animalInfo + "%'";

        if (!customerID.isEmpty()) {
            sqlQuery += " AND customerID = '" + customerID + "'";
        }


        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {

            ResultSet resultSet = statement.executeQuery();
            ObservableList<Animal> queriedAnimals = FXCollections.observableArrayList(); // new list to displau

            while (resultSet.next()) {

                Animal animal = new Animal(
                        resultSet.getString("animalID"),
                        resultSet.getString("animalName"),
                        resultSet.getString("animalType"),
                        resultSet.getString("breed"),
                        resultSet.getInt("animalWeightKG"),
                        resultSet.getString("animalInfo"),
                        resultSet.getString("customerID"));


                queriedAnimals.add(animal); // Add animal to the filtered list
            }

            animalsTableView.setItems(queriedAnimals);
        }

    }

}