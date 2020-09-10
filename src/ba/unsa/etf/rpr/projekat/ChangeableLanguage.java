package ba.unsa.etf.rpr.projekat;

import javafx.event.ActionEvent;

public interface ChangeableLanguage {
    void alertAbout(ActionEvent actionEvent);
    void changeToBS(ActionEvent actionEvent);
    void changeToEN(ActionEvent actionEvent);
    void translate();
}
