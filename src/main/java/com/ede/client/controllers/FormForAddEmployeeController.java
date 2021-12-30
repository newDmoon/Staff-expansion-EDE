package com.ede.client.controllers;

import com.ede.client.entity.Department;
import com.ede.client.entity.Employee;
import com.ede.client.impl.DepartmentDAO;
import com.ede.client.impl.EmployeeDAO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class FormForAddEmployeeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Font x1;

    @FXML
    private TextField textName;

    @FXML
    private TextField textEducation;

    @FXML
    private Insets x2;

    @FXML
    private ChoiceBox<Department> nameDepartment;

    @FXML
    private TextField phoneNumber;

    @FXML
    private DatePicker dayOfBirth;

    @FXML
    private ChoiceBox<Boolean> isExperience;

    @FXML
    private TextField salary;

    @FXML
    private Font x111;

    @FXML
    private Font x11;

    @FXML
    private Font x112;

    @FXML
    private Font x1121;

    @FXML
    void actionClose(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void actionSave(ActionEvent event) {
        Date date = Date.valueOf(dayOfBirth.getValue());
        System.out.println(nameDepartment.getSelectionModel().getSelectedItem());
        Employee employee = new Employee(date,phoneNumber.getText()
                ,textName.getText()
                ,textEducation.getText()
                ,isExperience.getValue()
                ,Integer.parseInt(salary.getText())
                ,nameDepartment.getValue());
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.save(employee);
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        isExperience.getItems().add(true);
        isExperience.getItems().add(false);
        initCheckBoxDepartment();
    }
    void initCheckBoxDepartment(){
        DepartmentDAO departmentDAO = new DepartmentDAO();
        List<Department> departmentList = departmentDAO.findAll();
        nameDepartment.setItems(FXCollections.observableArrayList(departmentList));
    }

}
