package ba.unsa.etf.rpr.projekat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class FirstController {
    public PasswordField passwordField;
    public TextField emailField;
    public TextField surnameField;
    public TextField nameField;
    public ChoiceBox<MaritalStatus> statusBox;
    private ObservableList<MaritalStatus> statusObservableList;
    public Button btnRegister;
    public Button btnLogin;

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

    public void onLoginClick() {

    }

    public void onRegisterClick() {

    }
}
