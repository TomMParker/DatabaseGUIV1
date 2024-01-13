package com.example.databaseguiv1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class VoucherController {

    @FXML
    private TableView<Voucher> voucherTableView;
    @FXML
    private TableColumn<Voucher, Integer> voucherIDColumn;
    @FXML
    private TableColumn<Voucher, Boolean> voucherActiveColumn;

    @FXML
    public void initialize() {

        voucherIDColumn.setCellValueFactory(new PropertyValueFactory<>("voucherID"));
        voucherActiveColumn.setCellValueFactory(new PropertyValueFactory<>("voucherActive"));

        loadVouchers();

    }
    @FXML
    public void loadVouchers() {
        String url = "jdbc:mysql://brighton.reclaimhosting.com:3306/tp558_DariasDogsV2";
        String username = "tp558_select";
        String password = "P_;2,}lafy}r";
        String sqlQuery = "SELECT * FROM tVoucher";


        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {

            ObservableList<Voucher> vouchers = FXCollections.observableArrayList();

            while (resultSet.next()) {

                Voucher voucher = new Voucher(
                        resultSet.getInt("voucherID"),
                        resultSet.getBoolean("voucherActive")


                );
                vouchers.add(voucher);

            }

            voucherTableView.setItems(vouchers);
            voucherTableView.refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
