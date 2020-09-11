package ba.unsa.etf.rpr.projekat.controller;

import ba.unsa.etf.rpr.projekat.ChangeableLanguage;
import ba.unsa.etf.rpr.projekat.data.KindergartenDAO;
import ba.unsa.etf.rpr.projekat.data.Parent;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class ParentController implements ChangeableLanguage {
    public Button registerBtn;
    public TextField nameF;
    public TextField surnameF;
    public TextField yoF;
    private KindergartenDAO kindergartenDAO = KindergartenDAO.getInstance();
    private Parent parent;
    public CheckMenuItem BS, EN;
    public ParentController(Parent parent) {
        this.parent = parent;
    }

    @FXML
    public void initialize() {
        yoF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if(!newValue.matches("\\d*"))
                    yoF.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    public void registerAction(ActionEvent actionEvent) {
        if(nameF.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            if(EN.isSelected())
                alert.setContentText("Please enter the name of your child. :)");
            else
                alert.setContentText("Molim Vas da unesete ime djeteta. :)");
            alert.showAndWait();
        }
        else if(surnameF.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            if(EN.isSelected())
                alert.setContentText("Please enter the surname of your child. :)");
            else
                alert.setContentText("Molim Vas da unesete prezime djeteta. :)");
            alert.showAndWait();
        }
        else if(yoF.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            if(EN.isSelected())
                alert.setContentText("Please enter how old is your child. :)");
            else
                alert.setContentText("Molim Vas da unesete godine djeteta. :)");
            alert.showAndWait();
        }
        else if(!(Integer.parseInt(yoF.getText()) >= 1 && Integer.parseInt(yoF.getText()) <= 6)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            if(EN.isSelected())
                alert.setContentText("The years range for children is from 1 to 6. :)");
            else
                alert.setContentText("Djeca trebaju imati od 1 do 6 godina. :)");
            alert.showAndWait();
        }
        else {
            //registrovati i dodati dijete u novi razred
            System.out.println(parent.toString());
            kindergartenDAO.addNewChildDB(parent, nameF.getText(), surnameF.getText(), Integer.parseInt(yoF.getText()));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            if(EN.isSelected())
                alert.setContentText("You sucessfully registered your child!");
            else
                alert.setContentText("Uspješno ste registrovali svoje dijete!");
            alert.showAndWait();
        }
    }

    @Override
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

    @Override
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

    @Override
    public void translate() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("TranslationParent");
        Stage stage = (Stage) yoF.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/parent.fxml"), resourceBundle);
        loader.setController(this);
        try {
            stage.setScene(new Scene(loader.load(), 700, 400));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
