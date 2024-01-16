package com.example.databaseguiv1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
import java.time.LocalDateTime;
import javafx.scene.control.TextField;

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
    private TextField animalIDTextField;
    @FXML
    private TextField staffIDTextField;
    @FXML
    private TextField branchNameTextField;
    @FXML
    private TextField serviceTextField;

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

    @FXML
    private void handleQuery() throws SQLException {
        String animalID = animalIDTextField.getText();
        String staffID = staffIDTextField.getText();
        String branchName = branchNameTextField.getText();
        String service = serviceTextField.getText();

        queryAppointments(animalID, staffID, branchName, service);
    }

    private void queryAppointments(String animalID, String staffID, String branchName, String service) throws SQLException {

        String url = "jdbc:mysql://brighton.reclaimhosting.com:3306/tp558_DariasDogsV2";
        String username = "tp558_select";
        String password = "P_;2,}lafy}r";

        //query for SQL search, uses % wildcards
        String sqlQuery = "SELECT * FROM tAppointment WHERE "
                + "animalID LIKE '%" + animalID + "%' AND "
                + "StaffID LIKE '%" + staffID + "%' AND "
                + "branchName LIKE '%" + branchName + "%' AND "
                + "service LIKE '%" + service + "%'";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {

            ResultSet resultSet = statement.executeQuery();
            ObservableList<Appointment> queriedAppointments = FXCollections.observableArrayList(); // new list to displau

            while (resultSet.next()) {

                Appointment appointment = new Appointment(
                        resultSet.getInt("appointmentID"),
                        resultSet.getString("animalID"),
                        //resultSet.getDate("appointmentStartTime"),
                        null,
                        resultSet.getString("StaffID"),
                        resultSet.getString("branchName"),
                        resultSet.getString("service"));


                queriedAppointments.add(appointment); // Add appointment to the filtered list
            }

            appointmentsTableView.setItems(queriedAppointments);
        }

    }
}
      /*  @FXML
        private void handleNewAppointment () {
            // Get data from text fields
            String animalID = animalIDTextField.getText();
            String staffID = staffIDTextField.getText();
            String branchName = branchNameTextField.getText();
            String service = serviceTextField.getText();

            // You need to parse the appointment start time from the text field, e.g., LocalDateTime.parse(startTimeTextField.getText(), DateTimeFormatter.ofPattern("your_date_time_format"))

            // Create a new Appointment object
            Appointment newAppointment = new Appointment(0, animalID, null, staffID, branchName, service);

            // Insert the new appointment into the database
            insertAppointment(newAppointment);

            // Refresh the table view
            loadAppointments();

            // Clear the text fields
            clearTextFields();
        }

        private void clearTextFields () {
            animalIDTextField.clear();
            staffIDTextField.clear();
            branchNameTextField.clear();
            serviceTextField.clear();

        }

        private void insertAppointment (Appointment appointment){
            String url = "jdbc:mysql://brighton.reclaimhosting.com:3306/tp558_DariasDogsV2";
            String username = "tp558_select";
            String password = "P_;2,}lafy}r";
            String sqlQuery = "INSERT INTO tAppointment (animalID, appointmentStartTime, staffID, branchName, service) VALUES (?, ?, ?, ?, ?)";

            try (Connection connection = DriverManager.getConnection(url, username, password);
                 PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

                preparedStatement.setString(1, appointment.getAnimalID());
                // Set other parameters for the appointment as needed

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("New appointment inserted successfully.");
                } else {
                    System.out.println("Failed to insert new appointment.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    } catch(
    SQLException e)

    {
        throw new RuntimeException(e);
    }*/

