package com.ede.client.controllers;

import com.ede.client.entity.Department;
import com.ede.client.entity.Employee;
import com.ede.client.impl.DepartmentDAO;
import com.ede.client.impl.EmployeeDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TableOfDepartmentController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Department> table;

    @FXML
    private TableColumn<Department, Long> idCol;

    @FXML
    private TableColumn<Department, String> nameOfDepartment;

    @FXML
    private TableColumn<Department, Integer> numberOfEmployee;

    @FXML
    private Button refreshTableButton;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button editButton;

    @FXML
    void initialize() {
        initTable();
    }

    @FXML
    void actionButtonPressed(ActionEvent actionEvent) {

        Object source = actionEvent.getSource();

        Button clickedButton = (Button) source;

        switch (clickedButton.getId()) {

            case "editButton": {

            }

            break;
            case "deleteButton": {
                DepartmentDAO departmentDAO = new DepartmentDAO();
                departmentDAO.delete(table.getSelectionModel().getSelectedItem());
                table.getItems().remove(table.getSelectionModel().getSelectedItem());
            }
            break;

            case "refreshTableButton": {
                table.getItems().clear();
                initTable();
            }
            break;
        }
    }

    @FXML
    void addNewDepartment(ActionEvent actionEvent) {
        try {
            Stage stage=new Stage();
            Parent rootAdmin= FXMLLoader.load(getClass().getResource("/fxml/FormForAddDepartment.fxml"));
            stage.setTitle("Добавление нового отдела");
            stage.setScene(new Scene(rootAdmin, 600, 300));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.showAndWait();
        } catch (IOException ex){
            ex.printStackTrace();
        }

    }

    void initTable(){
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameOfDepartment.setCellValueFactory(new PropertyValueFactory<>("information"));
        numberOfEmployee.setCellValueFactory(new PropertyValueFactory<>("CountOfEmployees"));
        DepartmentDAO departmentDAO = new DepartmentDAO();
        List<Department> departmentList = departmentDAO.findAll();
        for (Department department : departmentList){
            table.getItems().add(department);
        }

    }
}
