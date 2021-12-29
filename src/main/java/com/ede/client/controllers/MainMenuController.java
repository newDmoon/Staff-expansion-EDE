package com.ede.client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public void Exit(ActionEvent actionEvent){
        close(actionEvent);
        System.exit(0);
    }

    private void close(ActionEvent actionEvent){
        Node source=(Node) actionEvent.getSource();
        Stage stage2=(Stage) source.getScene().getWindow();
        stage2.close();
    }


    @FXML
    void ShowTableOfDepartment(ActionEvent actionEvent) {
        try {

            Stage stage = new Stage();

            FXMLLoader fxml = new FXMLLoader(getClass().getResource("/fxml/TableOfDepartment.fxml"));
            Parent rootAdmin = fxml.load();
            stage.setTitle("Таблица отделов");
            stage.setScene(new Scene(rootAdmin, 900, 660));
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());

            stage.show();

        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    @FXML
    void ShowTableOfEmployee(ActionEvent actionEvent) {
        try {

            Stage stage = new Stage();

            FXMLLoader fxml = new FXMLLoader(getClass().getResource("/fxml/TableOfEmployee.fxml"));
            Parent rootAdmin = fxml.load();
            stage.setTitle("Таблица сотрудников");
            stage.setScene(new Scene(rootAdmin, 1350, 700));
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());

            stage.show();

        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    @FXML
    void initialize() {

    }
}
