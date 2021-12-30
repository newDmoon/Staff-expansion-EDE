package com.ede.client.controllers;

import com.ede.client.entity.Department;
import com.ede.client.entity.Employee;
import com.ede.client.impl.DepartmentDAO;
import com.ede.client.impl.EmployeeDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class FormForAddDepartmentController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Font x1;

    @FXML
    private TextField textName;

    @FXML
    void actionClose(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void actionSave(ActionEvent event) {
        Department department = new Department(textName.getText());
        DepartmentDAO departmentDAO = new DepartmentDAO();
        departmentDAO.save(department);
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {

    }

}
