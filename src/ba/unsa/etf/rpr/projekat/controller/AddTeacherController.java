package ba.unsa.etf.rpr.projekat.controller;

import ba.unsa.etf.rpr.projekat.KindergartenDAO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddTeacherController {
    public TextField nameF;
    public TextField surnameF;
    public TextField phoneF;
    public Button add;
    public Button cancel;
    private KindergartenDAO kindergartenDAO = KindergartenDAO.getInstance();

    @FXML
    public void initialize() {
        phoneF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (!newValue.matches("\\d*"))
                    phoneF.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    public void addTeacherAction(ActionEvent actionEvent) {
        if(nameF.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setContentText("Please enter all the fields.");
            alert.showAndWait();
        }
        else if(surnameF.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setContentText("Please enter all the fields.");
            alert.showAndWait();
        }
        else if(phoneF.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setContentText("Please enter all the fields.");
            alert.showAndWait();
        }
        else {
            kindergartenDAO.addNewTeacherDB(nameF.getText(), surnameF.getText(), phoneF.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("SUCCESS");
            alert.setContentText("You successfully added a new teacher!");
            alert.showAndWait();
            cancelAction(actionEvent);
        }
    }

    public void cancelAction(ActionEvent actionEvent) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }
}
