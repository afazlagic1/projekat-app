package ba.unsa.etf.rpr.projekat.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;

import static org.junit.jupiter.api.Assertions.*;

import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.util.ResourceBundle;

@ExtendWith(ApplicationExtension.class)
class AdminControllerTest {

    @Start
    public void start(Stage stage) throws Exception {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("TranslationFirst");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/first.fxml"), resourceBundle);
        FirstController firstController = new FirstController();
        firstController.resetDatabase();
        loader.setController(firstController);
        Parent root = loader.load();
        stage.setTitle("Kindergarten");
        stage.setScene(new Scene(root, 700, 400));
        stage.setResizable(false);
        stage.show();
        stage.toFront();
    }

    void loginAdmin(FxRobot fxRobot) {
        fxRobot.clickOn("#passwordField");
        fxRobot.write("123");
        fxRobot.clickOn("#usernameField");
        KeyCode ctrl = KeyCode.CONTROL;
        if(System.getProperty("os.name").equals("Mac OS X"))
            ctrl = KeyCode.COMMAND;
        fxRobot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl);
        fxRobot.write("afazlagic1");
        fxRobot.clickOn("#btnLogin");
    }

    @Test
    void openParentTable(FxRobot robot) {
        loginAdmin(robot);
        robot.clickOn("#parentTableBtn");
        assertNotNull(robot.lookup("#parentTableView").queryAs(TableView.class));
    }

    @Test
    void openClassroomTable(FxRobot robot) {
        loginAdmin(robot);
        robot.clickOn("#classroomTableBtn");
        assertNotNull(robot.lookup("#classroomTableView").queryAs(TableView.class));
    }

    @Test
    void openChildTable(FxRobot robot) {
        loginAdmin(robot);
        robot.clickOn("#childTableBtn");
        assertNotNull(robot.lookup("#childTableView").queryAs(TableView.class));
    }

    @Test
    void openAdminTable(FxRobot robot) {
        loginAdmin(robot);
        robot.clickOn("#adminTableBtn");
        assertNotNull(robot.lookup("#adminTableView").queryAs(TableView.class));
    }

    @Test
    void openTeacherTable(FxRobot robot) {
        loginAdmin(robot);
        robot.clickOn("#teacherTableBtn");
        assertNotNull(robot.lookup("#teacherTableView").queryAs(TableView.class));
    }
}