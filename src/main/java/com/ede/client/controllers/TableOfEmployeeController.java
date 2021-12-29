package com.ede.client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class TableOfEmployeeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> birthCol;

    @FXML
    private TableColumn<?, ?> phoneCol;

    @FXML
    private TableColumn<?, ?> advantagesCol;

    @FXML
    private TableColumn<?, ?> isExperiencedCol;

    @FXML
    private TableColumn<?, ?> salaryCol;

    @FXML
    private TableColumn<?, ?> nameOfDepartment;

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


    }

    @FXML
    void actionButtonPressed(ActionEvent actionEvent) {

        Object source = actionEvent.getSource();


        Button clickedButton = (Button) source;

        System.out.println(clickedButton.getId());

        switch (clickedButton.getId()) {
            case "addButton": {

            }
            break;
            case "editButton": {

            }
            break;
            case "deleteButton": {

            }
            break;

            case "sortButton": {

            }
            break;

            case "refreshTableButton": {
                table.refresh();
            }
            break;
        }
    }




}
