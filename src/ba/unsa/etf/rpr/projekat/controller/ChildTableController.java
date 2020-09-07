package ba.unsa.etf.rpr.projekat.controller;

import ba.unsa.etf.rpr.projekat.data.KindergartenDAO;
import ba.unsa.etf.rpr.projekat.PrintReport;
import ba.unsa.etf.rpr.projekat.data.Child;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import net.sf.jasperreports.engine.JRException;

public class ChildTableController {
    public TableView<Child> childTableView;
    public TableColumn idCol;
    public TableColumn nameCol;
    public TableColumn surnameCol;
    public TableColumn<Child, String> parent1Col;
    public TableColumn yoCol;
    public TableColumn<Child, String> classroomCol;
    public Button printReportBtn;
    private KindergartenDAO kindergartenDAO = KindergartenDAO.getInstance();
    private ObservableList<Child> children = FXCollections.observableArrayList(kindergartenDAO.getChildrenDB());

    @FXML
    public void initialize() {
        childTableView.setItems(children);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameCol.setCellValueFactory(new PropertyValueFactory<>("surname"));
        parent1Col.setCellValueFactory((TableColumn.CellDataFeatures<Child, String> x) -> new SimpleStringProperty(x.getValue().getParent1().toString()));
        yoCol.setCellValueFactory(new PropertyValueFactory<>("yo"));
        classroomCol.setCellValueFactory((TableColumn.CellDataFeatures<Child, String> x) -> new SimpleStringProperty(x.getValue().getClassroom().getTeacher().toString()));
    }

    public void printReport(ActionEvent actionEvent) {
        try {
            new PrintReport().showReport(kindergartenDAO.getConnection());
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
