package ba.unsa.etf.rpr.projekat.controller;

import ba.unsa.etf.rpr.projekat.KindergartenDAO;
import ba.unsa.etf.rpr.projekat.data.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TeacherTableController {
    public TableView<Teacher> teacherTableView;
    public TableColumn idCol;
    public TableColumn nameCol;
    public TableColumn surnameCol;
    public TableColumn phoneNumberCol;
    private KindergartenDAO kindergartenDAO = KindergartenDAO.getInstance();
    private ObservableList<Teacher> teachers = FXCollections.observableArrayList(kindergartenDAO.getAllTeachersDB());

    @FXML
    public void initialize() {
        teacherTableView.setItems(teachers);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameCol.setCellValueFactory(new PropertyValueFactory<>("surname"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
    }

}
