package ba.unsa.etf.rpr.projekat.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.Start;

import static org.junit.jupiter.api.Assertions.*;

import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.util.ResourceBundle;

@ExtendWith(ApplicationExtension.class)
class TeacherTableControllerTest {

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
    void addTeacherAction(FxRobot fxRobot) {
        loginAdmin(fxRobot);
        fxRobot.clickOn("#teacherTableBtn");
        fxRobot.clickOn("#addBtn");
        fxRobot.clickOn("#nameF");
        fxRobot.write("Ema");
        fxRobot.clickOn("#surnameF");
        fxRobot.write("Walker");
        fxRobot.clickOn("#phoneF");
        fxRobot.write("123456");
        fxRobot.clickOn("#add");
        fxRobot.clickOn("OK");
        assertNotNull(fxRobot.lookup("Ema"));
        assertNotNull(fxRobot.lookup("Walker"));
    }
}