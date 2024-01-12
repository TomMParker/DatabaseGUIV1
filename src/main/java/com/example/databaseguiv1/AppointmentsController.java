package com.example.databaseguiv1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
import java.time.LocalDateTime;

public class AppointmentsController {

    @FXML
    private TableView<Appointment> appointmentsTableView;

    @FXML
    private TableColumn<Appointment, Integer> appointmentIDColumn;
    @FXML
    private TableColumn<Appointment, String> animalIDColumn;
    @FXML
    private TableColumn<Appointment, LocalDateTime> appointmentStartTimeColumn;
    @FXML
    private TableColumn<Appointment, String> staffIDColumn;
    @FXML
    private TableColumn<Appointment, String> branchNameColumn;
    @FXML
    private TableColumn<Appointment, String> serviceColumn;

    @FXML
    public void initialize() {

        appointmentIDColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
        animalIDColumn.setCellValueFactory(new PropertyValueFactory<>("animalID"));
        staffIDColumn.setCellValueFactory(new PropertyValueFactory<>("staffID"));
        branchNameColumn.setCellValueFactory(new PropertyValueFactory<>("branchName"));
        serviceColumn.setCellValueFactory(new PropertyValueFactory<>("service"));

        appointmentStartTimeColumn.setCellValueFactory(cellData -> cellData.getValue().appointmentStartTimeProperty());

        loadAppointments();
    }

    private void loadAppointments() {
        String url = "jdbc:mysql://brighton.reclaimhosting.com:3306/tp558_DariasDogsV2";
        String username = "tp558_select";
        String password = "P_;2,}lafy}r";
        String sqlQuery = "SELECT * FROM tAppointment";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {

            ObservableList<Appointment> appointments = FXCollections.observableArrayList();

            while (resultSet.next()) {

                Timestamp timestamp = resultSet.getTimestamp("appointmentStartTime");
                LocalDateTime appointmentStartTime = timestamp != null ? timestamp.toLocalDateTime() : null;

                Appointment appointment = new Appointment(
                        resultSet.getInt("appointmentID"),
                        resultSet.getString("animalID"),
                        appointmentStartTime,
                        resultSet.getString("StaffID"),
                        resultSet.getString("branchName"),
                        resultSet.getString("service")
                );
                appointments.add(appointment);

            }

            appointmentsTableView.setItems(appointments);
            appointmentsTableView.refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Methods for loading appointments from the database
}
