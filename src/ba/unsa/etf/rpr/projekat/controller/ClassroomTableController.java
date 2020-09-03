package ba.unsa.etf.rpr.projekat.controller;

import ba.unsa.etf.rpr.projekat.KindergartenDAO;
import ba.unsa.etf.rpr.projekat.data.Classroom;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.SimpleTimeZone;

public class ClassroomTableController {
    public TableView<Classroom> classroomTableView;
    public TableColumn idCol;
    public TableColumn childrenCol;
    public TableColumn<Classroom, String> teacherCol;
    private KindergartenDAO kindergartenDAO = KindergartenDAO.getInstance();
    private ObservableList<Classroom> classrooms = FXCollections.observableArrayList(kindergartenDAO.getAllClassrooms());

    @FXML
    public void initialize() {
        classroomTableView.setItems(classrooms);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        childrenCol.setCellValueFactory(new PropertyValueFactory<>("children"));
        teacherCol.setCellValueFactory((TableColumn.CellDataFeatures<Classroom, String> x) -> new SimpleStringProperty(x.getValue().getTeacher().getName()));
    }

    public void changeAction(ActionEvent actionEvent) {

    }

    public void deleteAction(ActionEvent actionEvent) {

    }

    public void addAction(ActionEvent actionEvent) {

    }
}
