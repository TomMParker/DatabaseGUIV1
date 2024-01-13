package com.example.databaseguiv1;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;


public class PaymentController {
    @FXML
    private TableView<Payment> paymentTableView;

    @FXML
    private TableColumn<Payment, Integer> paymentRefColumn;
    @FXML
    private TableColumn<Payment, String> paymentTypeColumn;
    @FXML
    private TableColumn<Payment, BigDecimal> paymentAmountColumn;
    @FXML
    private TableColumn<Payment, LocalDate> paymentDateColumn;
    @FXML
    private TableColumn<Payment, Integer> appointmentIDColumn;
    @FXML
    private TableColumn<Payment, Integer> voucherIDColumn;
    @FXML
    private TableColumn<Payment, String> customerIDColumn;


    @FXML
    public void initialize() {

        paymentRefColumn.setCellValueFactory(new PropertyValueFactory<>("paymentRef"));
        paymentTypeColumn.setCellValueFactory(new PropertyValueFactory<>("paymentType"));
        paymentAmountColumn.setCellValueFactory(new PropertyValueFactory<>("paymentAmount"));
        paymentDateColumn.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        appointmentIDColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
        voucherIDColumn.setCellValueFactory(new PropertyValueFactory<>("voucherID"));
        customerIDColumn.setCellValueFactory(new PropertyValueFactory<>("customerID"));


        loadPayments();

    }

    @FXML
    public void loadPayments() {
        String url = "jdbc:mysql://brighton.reclaimhosting.com:3306/tp558_DariasDogsV2";
        String username = "tp558_select";
        String password = "P_;2,}lafy}r";
        String sqlQuery = "SELECT * FROM tPayment";


        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {

            ObservableList<Payment> payments = FXCollections.observableArrayList();

            while (resultSet.next()) {

                Payment payment = new Payment(
                        resultSet.getInt("paymentRef"),
                        resultSet.getString("paymentType"),
                        resultSet.getBigDecimal("paymentAmount"),
                        resultSet.getObject("paymentDate", LocalDate.class),
                        resultSet.getInt("appointmentID"),
                        resultSet.getInt("voucherID"),
                        resultSet.getString("customerID")

                );
                payments.add(payment);

            }

            paymentTableView.setItems(payments);
            paymentTableView.refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
