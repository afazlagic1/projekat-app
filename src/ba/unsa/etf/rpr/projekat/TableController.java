package ba.unsa.etf.rpr.projekat;

import javafx.beans.value.ObservableObjectValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableController {
    public TableView parentTableView;
    public Button addBtn;
    public Button changeBtn;
    public Button deleteBtn;
    public TableColumn idCol;
    public TableColumn nameCol;
    public TableColumn surnameCol;
    public TableColumn usernameCol;
    public TableColumn passwordCol;
    public TableColumn statusCol;
    public TableColumn phoneNumberCol;
    private KindergartenDAO kindergartenDAO = KindergartenDAO.getInstance();
    private ObservableList<Parent> parents = FXCollections.observableArrayList(kindergartenDAO.getAllParentsDB());
    private ObservableObjectValue<Parent> parent;


    public TableController() {

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

    public void addAction(ActionEvent actionEvent) {

    }

    public void changeAction(ActionEvent actionEvent) {

    }

    public void deleteAction(ActionEvent actionEvent) {

    }
}
