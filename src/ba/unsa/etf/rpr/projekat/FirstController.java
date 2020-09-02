package ba.unsa.etf.rpr.projekat;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FirstController {
    public PasswordField passwordField;
    public TextField usernameField;
    public TextField surnameField;
    public TextField nameField;
    public ChoiceBox<MaritalStatus> statusBox;
    public TextField phoneNumberField;
    private ObservableList<MaritalStatus> statusObservableList;
    public Button btnRegister;
    public Button btnLogin;
    private KindergartenDAO kindergartenDAO = KindergartenDAO.getInstance();

    public FirstController() {

    }

    @FXML
    public void initialize() {
        phoneNumberField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if(!newValue.matches("\\d*"))
                    phoneNumberField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
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

                Admin admin = kindergartenDAO.getAdminByUsername(usernameField.getText(), passwordField.getText());

                Stage stage = new Stage();
                Parent root = null;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/admin.fxml"));
                AdminController adminController = new AdminController(admin);
                loader.setController(adminController);
                try {
                    root = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.setTitle("Admin");
                stage.setScene(new Scene(root, 700, 400));
                stage.setResizable(false);
                stage.show();
            } else if (kindergartenDAO.loginCheckIfParent(usernameField.getText(), passwordField.getText())) {
                //ovdje otvoriti novi prozor za roditelja

                ba.unsa.etf.rpr.projekat.Parent parent = kindergartenDAO.getParentByUsername(usernameField.getText(), passwordField.getText());

                Stage stage = new Stage();
                Parent root = null;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/parent.fxml"));
                ParentController parentController = new ParentController(parent);
                loader.setController(parentController);
                try {
                    root = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.setTitle("Parent");
                stage.setScene(new Scene(root, 700, 400));
                stage.setResizable(false);
                stage.show();
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
        else if(phoneNumberField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("INVALID REGISTER");
            alert.setContentText("Please enter your phone number before you register. :)");
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
                //prije toga dodavanje u bazu
                ba.unsa.etf.rpr.projekat.Parent parent = kindergartenDAO.addNewParentDB(nameField.getText(), surnameField.getText(), usernameField.getText(), passwordField.getText(), statusBox.getValue().toString(), phoneNumberField.getText());

                Stage stage = new Stage();
                Parent root = null;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/parent.fxml"));
                ParentController parentController = new ParentController(parent);
                loader.setController(parentController);
                try {
                    root = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.setTitle("Parent");
                stage.setScene(new Scene(root, 700, 400));
                stage.setResizable(false);
                stage.show();
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
