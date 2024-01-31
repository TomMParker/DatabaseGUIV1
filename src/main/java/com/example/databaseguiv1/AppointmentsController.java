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
    private TextField appointmentIDTextField;
    @FXML
    private TextField serviceTextField;
    @FXML TextField appointmentStartTimeTextField;

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

        String sqlQuery = "SELECT * FROM tAppointment";

        try (Connection connection = DatabaseConnection.databaseConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {

            ObservableList<Appointment> appointments = FXCollections.observableArrayList();

            while (resultSet.next()) {

                Appointment appointment = new Appointment(
                        resultSet.getInt("appointmentID"),
                        resultSet.getString("animalID"),
                        resultSet.getTimestamp("appointmentStartTime").toLocalDateTime(),
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


    private void insertAppointment(Appointment appointment) {
        String url = "jdbc:mysql://brighton.reclaimhosting.com:3306/tp558_DariasDogsV2";
        String username = "tp558_select";
        String password = "P_;2,}lafy}r";
        String sqlQuery = "INSERT INTO tAppointment (animalID, appointmentStartTime, staffID, branchName, service) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.databaseConnection();
             PreparedStatement ps = connection.prepareStatement(sqlQuery)) {

            ps.setString(1, appointment.getAnimalID());
            ps.setTimestamp(2, Timestamp.valueOf(appointment.getAppointmentStartTime()));
            ps.setString(3, appointment.getStaffID());
            ps.setString(4, appointment.getBranchName());
            ps.setString(5, appointment.getService());
            boolean status = ps.execute();

            if (status==false){ //thought this would work other way round but displays correct message when added succesfully now
                System.out.println("Added successfully");
            } else{
                System.out.println("Not added");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleNewAppointment() {
        try {
            String animalID = animalIDTextField.getText();
            String staffID = staffIDTextField.getText();
            String branchName = branchNameTextField.getText();
            String service = serviceTextField.getText();
            LocalDateTime appointmentStartTime = LocalDateTime.parse(appointmentStartTimeTextField.getText());

            Appointment addAppointment = new Appointment(0, animalID, appointmentStartTime, staffID, branchName, service);

            insertAppointment(addAppointment);

            loadAppointments();

            clearTextFields();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void handleRemoveAppointment() {
        try {
            int appointmentID = Integer.parseInt(appointmentIDTextField.getText());

            removeAppointment(appointmentID);

            loadAppointments();

            clearTextFields();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void removeAppointment(int appointmentID) {

        try (Connection connection = DatabaseConnection.databaseConnection()) {
            CallableStatement statement = connection.prepareCall("{CALL pr_removeAppointment(?)}");
            statement.setInt(1, appointmentID);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleEditAppointment() {
        try {
            int appointmentId = Integer.parseInt(appointmentIDTextField.getText());
            String animalID = animalIDTextField.getText();
            String staffID = staffIDTextField.getText();
            String branchName = branchNameTextField.getText();
            String service = serviceTextField.getText();
            LocalDateTime appointmentStartTime = LocalDateTime.parse(appointmentStartTimeTextField.getText());

            Appointment updatedAppointment = new Appointment(appointmentId, animalID, appointmentStartTime, staffID, branchName, service);

            editAppointment(updatedAppointment);

            loadAppointments();

            clearTextFields();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void editAppointment(Appointment appointment) {

        String sqlQuery = "UPDATE tAppointment SET animalID=?, appointmentStartTime=?, staffID=?, branchName=?, service=? WHERE appointmentID=?";

        try (Connection connection = DatabaseConnection.databaseConnection();
             PreparedStatement ps = connection.prepareStatement(sqlQuery)) {

            ps.setString(1, appointment.getAnimalID());
            ps.setTimestamp(2, Timestamp.valueOf(appointment.getAppointmentStartTime()));
            ps.setString(3, appointment.getStaffID());
            ps.setString(4, appointment.getBranchName());
            ps.setString(5, appointment.getService());
            ps.setInt(6, appointment.getAppointmentID());
            int status = ps.executeUpdate();

            if (status > 0) {
                System.out.println("Appointment updated successfully");
            } else {
                System.out.println("Appointment update failed");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private void clearTextFields() {
        animalIDTextField.clear();
        appointmentStartTimeTextField.clear();
        staffIDTextField.clear();
        branchNameTextField.clear();
        serviceTextField.clear();
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
                        //resultSet.getDate("appointmentStartTime"), // removed as causing errors, set to null - other search fields work
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

