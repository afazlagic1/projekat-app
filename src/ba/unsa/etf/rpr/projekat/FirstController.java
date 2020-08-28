package ba.unsa.etf.rpr.projekat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.File;
import java.util.ArrayList;

public class FirstController {
    public PasswordField passwordField;
    public TextField usernameField;
    public TextField surnameField;
    public TextField nameField;
    public ChoiceBox<MaritalStatus> statusBox;
    private ObservableList<MaritalStatus> statusObservableList;
    public Button btnRegister;
    public Button btnLogin;
    private KindergartenDAO kindergartenDAO = KindergartenDAO.getInstance();

    public FirstController() {

    }

    @FXML
    public void initialize() {
        ArrayList<MaritalStatus> arrayList = new ArrayList<>();
        arrayList.add(MaritalStatus.SINGLE);
        arrayList.add(MaritalStatus.MARRIED);
        arrayList.add(MaritalStatus.DIVORCED);
        arrayList.add(MaritalStatus.WIDOWED);
        statusObservableList = FXCollections.observableList(arrayList);
        statusBox.setItems(statusObservableList);
    }

    public void onLoginClick(ActionEvent actionEvent) {
        if(usernameField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("INVALID LOGIN");
            alert.setContentText("Please enter your username before login. :)");
            alert.showAndWait();
        }
        else if(passwordField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("INVALID LOGIN");
            alert.setContentText("Please enter your password before login. :)");
            alert.showAndWait();
        }
        else {
            if (kindergartenDAO.loginCheckIfAdmin(usernameField.getText(), passwordField.getText())) {
                //ovdje otvoriti novi prozor za admina
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ADMIN");
                alert.showAndWait();
            } else if (kindergartenDAO.loginCheckIfParent(usernameField.getText(), passwordField.getText())) {
                //ovdje otvoriti novi prozor za roditelja
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("PARENT");
                alert.showAndWait();
            } else {
                //ovdje otvoriti Alert o neispravnoj prijavi
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INVALID LOGIN");
                alert.showAndWait();
            }
        }
    }

    public void onRegisterClick(ActionEvent actionEvent) {
        if(usernameField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("INVALID REGISTER");
            alert.setContentText("Please enter your username before you register. :)");
            alert.showAndWait();
        }
        else if(passwordField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("INVALID REGISTER");
            alert.setContentText("Please enter your password before you register. :)");
            alert.showAndWait();
        }
        else if(nameField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("INVALID REGISTER");
            alert.setContentText("Please enter your name before you register. :)");
            alert.showAndWait();
        }
        else if(surnameField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("INVALID REGISTER");
            alert.setContentText("Please enter your surname before you register. :)");
            alert.showAndWait();
        }
        else if(statusBox.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("INVALID REGISTER");
            alert.setContentText("Please enter your marital status before you register. :)");
            alert.showAndWait();
        }
        else {
            if(kindergartenDAO.registerCheckIfUsernameTaken(usernameField.getText())) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("INVALID REGISTER");
                alert.setContentText("That username is already taken, sorry. :)");
                alert.showAndWait();
            }
            else {
                //ovdje otvoriti novi prozor za roditelja
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("PARENT");
                alert.showAndWait();
            }
        }
    }

    public void resetDatabase() {
        KindergartenDAO.removeInstance();
        File file = new File("baza.db");
        file.delete();
        kindergartenDAO = KindergartenDAO.getInstance();
    }
}
