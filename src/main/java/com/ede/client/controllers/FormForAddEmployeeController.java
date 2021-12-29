package com.ede.client.controllers;

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
    private ComboBox<?> nameDepartment;

    @FXML
    private TextField phoneNumber;

    @FXML
    private DatePicker dayOfBirth;

    @FXML
    private ChoiceBox<?> isExperience;

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

    }

    @FXML
    void initialize() {}

}
