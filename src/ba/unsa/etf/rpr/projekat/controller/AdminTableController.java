package ba.unsa.etf.rpr.projekat.controller;


import ba.unsa.etf.rpr.projekat.KindergartenDAO;
import ba.unsa.etf.rpr.projekat.data.Admin;
import ba.unsa.etf.rpr.projekat.data.Parent;
import javafx.beans.value.ObservableObjectValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminTableController {
    public TableView adminTableView;
    public TableColumn idCol;
    public TableColumn nameCol;
    public TableColumn surnameCol;
    public TableColumn usernameCol;
    public TableColumn passwordCol;
    private KindergartenDAO kindergartenDAO = KindergartenDAO.getInstance();
    private ObservableList<Admin> admins = FXCollections.observableArrayList(kindergartenDAO.getAllAdminsDB());
    private ObservableObjectValue<Admin> admin;

    @FXML
    public void initialize() {
        adminTableView.setItems(admins);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameCol.setCellValueFactory(new PropertyValueFactory<>("surname"));
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));
    }

    public void changeAction(ActionEvent actionEvent) {

    }

    public void deleteAction(ActionEvent actionEvent) {

    }

    public void addAction(ActionEvent actionEvent) {

    }
}
