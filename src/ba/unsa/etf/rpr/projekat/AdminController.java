package ba.unsa.etf.rpr.projekat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {
    public Button adminTableBtn;
    public Button childTableBtn;
    public Button parentTableBtn;
    public Button classroomTableBtn;
    public Button teacherTableBtn;
    public Label labelWelcomeAdmin;
    private Admin activeAdmin;

    public AdminController(Admin admin) {
        activeAdmin = admin;
    }

    @FXML
    public void initialize() {
        labelWelcomeAdmin.setText("Welcome back, " + activeAdmin.toString());
    }

    public void openParentTable(ActionEvent actionEvent) {
        Stage stage = new Stage();
        Parent root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/table.fxml"));
        TableController tableController = new TableController();
        loader.setController(tableController);
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("Parent table");
        stage.setScene(new Scene(root, 700, 400));
        stage.setResizable(false);
        stage.show();
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
