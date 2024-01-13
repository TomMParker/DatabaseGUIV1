package com.example.databaseguiv1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
public class branchController {
    @FXML
    private TableView<Branch> branchTableView;

    @FXML
    private TableColumn<Branch, String> branchNameColumn;
    @FXML
    private TableColumn<Branch, String> branchAddress1Column;
    @FXML
    private TableColumn<Branch, String> branchAddress2Column;
    @FXML
    private TableColumn<Branch, String> branchPostcodeColumn;


    @FXML
    public void initialize() {

        branchNameColumn.setCellValueFactory(new PropertyValueFactory<>("branchName"));
        branchAddress1Column.setCellValueFactory(new PropertyValueFactory<>("branchAddress1"));
        branchAddress2Column.setCellValueFactory(new PropertyValueFactory<>("branchAddress2"));
        branchPostcodeColumn.setCellValueFactory(new PropertyValueFactory<>("branchPostcode"));

        loadBranches();

    }

    private void loadBranches(){
        String url = "jdbc:mysql://brighton.reclaimhosting.com:3306/tp558_DariasDogsV2";
        String username = "tp558_select";
        String password = "P_;2,}lafy}r";
        String sqlQuery = "SELECT * FROM tBranch";


        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {

            ObservableList<Branch> branches = FXCollections.observableArrayList();

            while (resultSet.next()) {

                Branch branch = new Branch(
                        resultSet.getString("branchName"),
                        resultSet.getString("branchAddress1"),
                        resultSet.getString("branchAddress2"),
                        resultSet.getString("branchPostcode")

                );
                branches.add(branch);

            }

            branchTableView.setItems(branches);
            branchTableView.refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
