package ba.unsa.etf.rpr.projekat;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ParentController {
    public Button registerBtn;
    public TextField nameF;
    public TextField surnameF;
    public TextField yoF;

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
            alert.setContentText("Please enter the name of your child. :)");
            alert.showAndWait();
        }
        else if(surnameF.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please enter the surname of your child. :)");
            alert.showAndWait();
        }
        else if(yoF.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please enter the surname of your child. :)");
            alert.showAndWait();
        }
        else if(!yoF.getText().equals("1") && !yoF.getText().equals("2") && !yoF.getText().equals("3") && !yoF.getText().equals("4") && yoF.getText().equals("5") && yoF.getText().equals("6")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("The years range for children is from 1 to 6. :)");
            alert.showAndWait();
        }
        else {
            //registrovati i dodati dijete u novi razred

        }
    }
}
