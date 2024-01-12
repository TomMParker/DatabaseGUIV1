package com.example.databaseguiv1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
}