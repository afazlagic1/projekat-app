package ba.unsa.etf.rpr.projekat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AdminController {
    public Button adminTableBtn;
    public Button childTableBtn;
    public Button parentTableBtn;
    public Button classroomTableBtn;
    public Button teacherTableBtn;
    public Label labelWelcomeAdmin;
    private Admin activeAdmin;

    @FXML
    public void initialize() {
        labelWelcomeAdmin.setText("Welcome back admin.");
    }

    public void openParentTable(ActionEvent actionEvent) {

    }
    public void openClassroomTable(ActionEvent actionEvent) {

    }
    public void openChildTable(ActionEvent actionEvent) {

    }
    public void openAdminTable(ActionEvent actionEvent) {

    }
    public void openTeacherTable(ActionEvent actionEvent) {

    }

}
