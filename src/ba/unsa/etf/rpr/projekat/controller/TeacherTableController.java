package ba.unsa.etf.rpr.projekat.controller;

import ba.unsa.etf.rpr.projekat.KindergartenDAO;
import ba.unsa.etf.rpr.projekat.data.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

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

    public void addTeacherAction(ActionEvent actionEvent) {
        Stage stage = new Stage();
        Parent root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/addTeacher.fxml"));
        AddTeacherController tableController = new AddTeacherController();
        loader.setController(tableController);
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("Add new teacher");
        stage.setScene(new Scene(root, 300, 300));
        stage.setResizable(false);
        stage.show();

        stage.setOnHiding(windowEvent -> {
            teachers = FXCollections.observableArrayList(kindergartenDAO.getAllTeachersDB());
            teacherTableView.setItems(teachers);
        });
    }
}
