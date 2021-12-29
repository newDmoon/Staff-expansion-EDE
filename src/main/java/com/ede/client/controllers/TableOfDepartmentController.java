package com.ede.client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TableOfDepartmentController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private TableColumn<?, ?> nameOfDepartment;

    @FXML
    private TableColumn<?, ?> numberOfEmployee;

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

    }

    @FXML
    void actionButtonPressed(ActionEvent actionEvent) {

        Object source = actionEvent.getSource();

        Button clickedButton = (Button) source;

        System.out.println(clickedButton.getId());

        switch (clickedButton.getId()) {
//            case "addButton": {
//
//            }
//            break;

            case "editButton": {

            }

            break;
            case "deleteButton": {

            }
            break;

            case "refreshTableButton": {
                table.refresh();
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
}
