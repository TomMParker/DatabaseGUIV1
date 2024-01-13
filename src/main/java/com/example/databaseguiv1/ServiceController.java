package com.example.databaseguiv1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;

public class ServiceController {

    @FXML
    private TableView<Service> serviceTableView;
    @FXML
    private TableColumn<Service, String> serviceColumn;
    @FXML
    private TableColumn<Service, BigDecimal> costColumn;
    @FXML
    private TableColumn<Service, Integer> durationColumn;

    @FXML
    public void initialize() {

        serviceColumn.setCellValueFactory(new PropertyValueFactory<>("service"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));

        loadServices();

    }

    @FXML
    public void loadServices() {
        String url = "jdbc:mysql://brighton.reclaimhosting.com:3306/tp558_DariasDogsV2";
        String username = "tp558_select";
        String password = "P_;2,}lafy}r";
        String sqlQuery = "SELECT * FROM tService";


        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {

            ObservableList<Service> services = FXCollections.observableArrayList();

            while (resultSet.next()) {

                Service service = new Service(
                        resultSet.getString("service"),
                        resultSet.getBigDecimal("cost"),
                        resultSet.getInt("duration")


                );
                services.add(service);

            }

            serviceTableView.setItems(services);
            serviceTableView.refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
