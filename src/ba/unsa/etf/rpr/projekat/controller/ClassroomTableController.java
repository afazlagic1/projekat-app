package ba.unsa.etf.rpr.projekat.controller;

import ba.unsa.etf.rpr.projekat.KindergartenDAO;
import ba.unsa.etf.rpr.projekat.data.Classroom;
import ba.unsa.etf.rpr.projekat.data.Teacher;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;

public class ClassroomTableController {
    public TableView<Classroom> classroomTableView;
    public TableColumn idCol;
    public TableColumn childrenCol;
    public TableColumn<Classroom, String> teacherCol;
    public Button addBtn;
    private KindergartenDAO kindergartenDAO = KindergartenDAO.getInstance();
    private ObservableList<Classroom> classrooms = FXCollections.observableArrayList(kindergartenDAO.getAllClassrooms());

    @FXML
    public void initialize() {
        classroomTableView.setItems(classrooms);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        childrenCol.setCellValueFactory(new PropertyValueFactory<>("children"));
        teacherCol.setCellValueFactory((TableColumn.CellDataFeatures<Classroom, String> x) -> new SimpleStringProperty(x.getValue().getTeacher().getName()));
    }

    public void addAction(ActionEvent actionEvent) {
        Stage stage = new Stage();
        Parent root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/addClassroom.fxml"));
        AddClassroomController controller = new AddClassroomController();
        loader.setController(controller);
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("New classroom");
        stage.setScene(new Scene(root, 300, 300));
        stage.setResizable(false);
        stage.show();

        stage.setOnHiding(event -> {
            classrooms = FXCollections.observableArrayList(kindergartenDAO.getAllClassrooms());
            classroomTableView.setItems(classrooms);
        });
    }
}
