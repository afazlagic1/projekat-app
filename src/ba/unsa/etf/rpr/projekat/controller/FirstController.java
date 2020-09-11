package ba.unsa.etf.rpr.projekat.controller;

import ba.unsa.etf.rpr.projekat.ChangeableLanguage;
import ba.unsa.etf.rpr.projekat.data.Admin;
import ba.unsa.etf.rpr.projekat.data.KindergartenDAO;
import ba.unsa.etf.rpr.projekat.data.MaritalStatus;
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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class FirstController implements ChangeableLanguage {
    public PasswordField passwordField;
    public TextField usernameField;
    public TextField surnameField;
    public TextField nameField;
    public ChoiceBox<MaritalStatus> statusBox;
    public TextField phoneNumberField;
    private ObservableList<MaritalStatus> statusObservableList;
    private ImageView imageView;
    public Button btnRegister;
    public Button btnLogin;
    public CheckMenuItem BS, EN;
    private KindergartenDAO kindergartenDAO = KindergartenDAO.getInstance();

    public FirstController() {

    }

    @FXML
    public void initialize() {
        EN.setSelected(true);
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
            if(EN.isSelected())
                alert.setContentText("Please enter your username before login. :)");
            else
                alert.setContentText("Molim Vas upišite svoje korisničko ime. :)");
            alert.showAndWait();
        }
        else if(passwordField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("INVALID LOGIN");
            if(EN.isSelected())
                alert.setContentText("Please enter your password before login. :)");
            else
                alert.setContentText("Molim Vas upišite svoju lozinku. :)");
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

                ba.unsa.etf.rpr.projekat.data.Parent parent = kindergartenDAO.getParentByUsername(usernameField.getText(), passwordField.getText());

                Stage stage = new Stage();
                Parent root = null;
                ResourceBundle resourceBundle = ResourceBundle.getBundle("TranslationParent");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/parent.fxml"), resourceBundle);
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
            if(EN.isSelected())
                alert.setContentText("Please enter your username before you register. :)");
            else
                alert.setContentText("Molimo popunite sve prije registracije. :)");
            alert.showAndWait();
        }
        else if(passwordField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("INVALID REGISTER");
            if(EN.isSelected())
                alert.setContentText("Please enter your password before you register. :)");
            else
                alert.setContentText("Molimo popunite sve prije registracije. :)");
            alert.showAndWait();
        }
        else if(nameField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("INVALID REGISTER");
            if(EN.isSelected())
                alert.setContentText("Please enter your name before you register. :)");
            else
                alert.setContentText("Molimo popunite sve prije registracije. :)");
            alert.showAndWait();
        }
        else if(surnameField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("INVALID REGISTER");
            if(EN.isSelected())
                alert.setContentText("Please enter your surname before you register. :)");
            else
                alert.setContentText("Molimo popunite sve prije registracije. :)");
            alert.showAndWait();
        }
        else if(statusBox.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("INVALID REGISTER");
            if(EN.isSelected())
                alert.setContentText("Please enter your marital status before you register. :)");
            else
                alert.setContentText("Molimo popunite sve prije registracije. :)");
            alert.showAndWait();
        }
        else if(phoneNumberField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("INVALID REGISTER");
            if(EN.isSelected())
                alert.setContentText("Please enter your phone number before you register. :)");
            else
                alert.setContentText("Molimo popunite sve prije registracije. :)");
            alert.showAndWait();
        }
        else {
            if(kindergartenDAO.registerCheckIfUsernameTaken(usernameField.getText())) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("INVALID REGISTER");
                if(EN.isSelected())
                    alert.setContentText("That username is already taken, sorry. :)");
                else
                    alert.setContentText("To korisničko ime je zauzeto, žao nam je. :)");
                alert.showAndWait();
            }
            else {
                //ovdje otvoriti novi prozor za roditelja
                //prije toga dodavanje u bazu
                ba.unsa.etf.rpr.projekat.data.Parent parent = kindergartenDAO.addNewParentDB(nameField.getText(), surnameField.getText(), usernameField.getText(), passwordField.getText(), statusBox.getValue().toString(), phoneNumberField.getText());
                ResourceBundle resourceBundle = ResourceBundle.getBundle("TranslationParent");
                Stage stage = new Stage();
                Parent root = null;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/parent.fxml"), resourceBundle);
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

    public void translate() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("TranslationFirst");
        Stage stage = (Stage) usernameField.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/first.fxml"), resourceBundle);
        loader.setController(this);
        try {
            stage.setScene(new Scene(loader.load(), 700, 400));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeToBS(ActionEvent actionEvent) {
        if(BS.isSelected()) {
            Locale.setDefault(new Locale("bs", "BA"));
            translate();
            BS.setSelected(true);
            EN.setSelected(false);
        }
        else {
            Locale.setDefault(new Locale("en_US", "ENG"));
            translate();
            EN.setSelected(true);
            BS.setSelected(false);
        }
    }

    public void changeToEN(ActionEvent actionEvent) {
        if(EN.isSelected()) {
            Locale.setDefault(new Locale("en_US", "ENG"));
            translate();
            BS.setSelected(false);
            EN.setSelected(true);
        }
        else {
            Locale.setDefault(new Locale("bs", "BA"));
            translate();
            BS.setSelected(true);
            EN.setSelected(false);
        }
    }

    public void alertAbout(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if(BS.isSelected())
            alert.setContentText("Dobro došli u Kindergarten!" + "\n" + "Ova aplikacija je namijenjena roditeljima koji žele upisati svoje dijete/svoju djecu u baš naš vrtić." + "\n"
            + "Zašto baš ovaj pitate se?\nOsim toga što se nalazimo na pristupačnoj lokaciji (centar) i besplatnog parkinga za sve roditelje, imamo i izvrsne učitelje uvijek spremne posvetiti se svakom djetetu pojedinačno." +
                    " Za doručak i ručak su obezbijeđeni kvalitetni, raznovrsni i zdravi obroci, i naš meni se mijenja svake sedmice."+ "\n" +
                    "Vaše je samo da se registrujete i upišete svoje dijete.\n Mi ćemo vas kontaktirati ukoliko budemo imali nekih pitanja prije vašeg prvog dolaska u naše prostorije!" + "\nNadamo se da ćemo uskoro upoznati vas i vašu djecu! :)");
        else
            alert.setContentText("Welcome to Kindergarten!" + "\n" + "This app is intended to be used by parents who wish to register their child/ children to our place." + "\n"
                    + "Why this one you wonder?\nBesides the convinient location (center) and the free parking space for all parents, we also have excellent teachers always ready to put their best effort." +
                    " For breakfast and lunch we serve high-quality, various and healthy meals and our menu changes every week."+ "\n" +
                    "You only need to register your child.\n We'll contact you in case we have any questions before your first arrival here!" + "\nWe are looking forward meeting you and your children! :)");
        if(BS.isSelected())
            alert.setTitle("O aplikaciji");
        else
            alert.setTitle("About");
        alert.setHeaderText("Kindergarten");
        alert.showAndWait();
    }
}
