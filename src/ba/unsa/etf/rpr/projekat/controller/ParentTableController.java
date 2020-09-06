package ba.unsa.etf.rpr.projekat.controller;

import ba.unsa.etf.rpr.projekat.KindergartenDAO;
import ba.unsa.etf.rpr.projekat.data.Parent;
import javafx.beans.value.ObservableObjectValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ParentTableController {
    public TableView parentTableView;
    public TableColumn idCol;
    public TableColumn nameCol;
    public TableColumn surnameCol;
    public TableColumn usernameCol;
    public TableColumn passwordCol;
    public TableColumn statusCol;
    public TableColumn phoneNumberCol;
    private KindergartenDAO kindergartenDAO = KindergartenDAO.getInstance();
    private ObservableList<Parent> parents = FXCollections.observableArrayList(kindergartenDAO.getAllParentsDB());


    public ParentTableController() {

    }

    @FXML
    public void initialize() {
        parentTableView.setItems(parents);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameCol.setCellValueFactory(new PropertyValueFactory<>("surname"));
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
    }
}
