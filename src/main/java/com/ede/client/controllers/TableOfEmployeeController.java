package com.ede.client.controllers;

import com.ede.client.entity.Department;
import com.ede.client.entity.Employee;
import com.ede.client.impl.EmployeeDAO;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class TableOfEmployeeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Employee> table;

    @FXML
    private TableColumn<Employee, Long> idCol;

    @FXML
    private TableColumn<Employee, String> nameCol;

    @FXML
    private TableColumn<Employee, Date> birthCol;

    @FXML
    private TableColumn<Employee, String> phoneCol;

    @FXML
    private TableColumn<Employee, String> advantagesCol;

    @FXML
    private TableColumn<Employee, Boolean> isExperiencedCol;

    @FXML
    private TableColumn<Employee, Integer> salaryCol;

    @FXML
    private TableColumn<Employee, Department> nameOfDepartment;

    @FXML
    private Button sortButton;

    @FXML
    private ChoiceBox<?> sortChoiceBox;

    @FXML
    private Button addButton;

    @FXML
    private Button refreshTableButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button editButton;

//    private FormForAddEmployeeController formForAddEmployeeController;


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
            case "deleteButton":
                EmployeeDAO employeeDAO = new EmployeeDAO();
                employeeDAO.delete(table.getSelectionModel().getSelectedItem());
                table.getItems().remove(table.getSelectionModel().getSelectedItem());
                break;
            case "sortButton": {
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
    void addNewEmployee(ActionEvent actionEvent) {
        try {
            Stage stage=new Stage();
            Parent rootAdmin= FXMLLoader.load(getClass().getResource("/fxml/FormForAddEmployee.fxml"));
            stage.setTitle("Добавление нового сотрудника");
            stage.setScene(new Scene(rootAdmin, 800, 600));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.showAndWait();
        } catch (IOException ex){
            ex.printStackTrace();
        }

    }

    void initTable(){
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("fio"));
        birthCol.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        advantagesCol.setCellValueFactory(new PropertyValueFactory<>("advantages"));
        isExperiencedCol.setCellValueFactory(new PropertyValueFactory<>("Experienced"));
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));
        nameOfDepartment.setCellValueFactory(new PropertyValueFactory<>("DepartmentID"));
        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<Employee> employeeList = employeeDAO.findAll();
        for (Employee employee : employeeList){
            table.getItems().add(employee);
        }

    }
}
