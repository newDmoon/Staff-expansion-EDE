package com.ede.client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.net.URL;
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

    }

    @FXML
    void initialize() {

    }


}
