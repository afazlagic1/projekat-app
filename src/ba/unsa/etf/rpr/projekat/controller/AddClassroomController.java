package ba.unsa.etf.rpr.projekat.controller;

import ba.unsa.etf.rpr.projekat.data.KindergartenDAO;
import ba.unsa.etf.rpr.projekat.data.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class AddClassroomController {
    public Button addBtnClassroom;
    public Button cancelBtn;
    public ChoiceBox<Teacher> choiceTeacher;
    private KindergartenDAO kindergartenDAO = KindergartenDAO.getInstance();
    private ObservableList<Teacher> teachers = FXCollections.observableArrayList(kindergartenDAO.getAllTeachersDB());

    public AddClassroomController() {

    }

    @FXML
    public void initialize() {
        choiceTeacher.setItems(teachers);
    }

    public void addNewClassroomAction(ActionEvent actionEvent) {
        if(choiceTeacher.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setContentText("Please choose teacher before you add new classroom.");
            alert.showAndWait();
        }
        else {
            kindergartenDAO.addNewClassroomDB(choiceTeacher.getValue());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("SUCCESS");
            alert.setContentText("You successfully added a new classroom!");
            alert.showAndWait();
            cancelAction(actionEvent);
        }
    }

    public void cancelAction(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }
}
