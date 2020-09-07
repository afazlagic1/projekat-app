package ba.unsa.etf.rpr.projekat.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)
class FirstControllerTest {

    @Start
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/first.fxml"));
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

    @Test
    void onLoginAdminTest(FxRobot fxRobot) {
        fxRobot.clickOn("#passwordField");
        fxRobot.write("123");
        fxRobot.clickOn("#usernameField");
        KeyCode ctrl = KeyCode.CONTROL;
        if(System.getProperty("os.name").equals("Mac OS X"))
            ctrl = KeyCode.COMMAND;
        fxRobot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl);
        fxRobot.write("afazlagic1");
        fxRobot.clickOn("#btnLogin");
        Label label = fxRobot.lookup("#labelWelcomeAdmin").queryAs(Label.class);
        assertNotNull(label);
    }

    @Test
    void onLoginParentTest(FxRobot fxRobot) {
        fxRobot.clickOn("#passwordField");
        fxRobot.write("1111");
        fxRobot.clickOn("#usernameField");
        KeyCode ctrl = KeyCode.CONTROL;
        if(System.getProperty("os.name").equals("Mac OS X"))
            ctrl = KeyCode.COMMAND;
        fxRobot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl);
        fxRobot.write("nata15");
        fxRobot.clickOn("#btnLogin");
        TextField textField = fxRobot.lookup("#yoF").queryAs(TextField.class);
        assertNotNull(textField);
    }

    @Test
    void onLoginNoOneAndFalseTest(FxRobot fxRobot) {
        fxRobot.clickOn("#btnLogin");
        assertNotNull(fxRobot.lookup("OK").queryAs(Button.class));
        fxRobot.clickOn("OK");

        KeyCode ctrl = KeyCode.CONTROL;
        if(System.getProperty("os.name").equals("Mac OS X"))
            ctrl = KeyCode.COMMAND;
        fxRobot.clickOn("#passwordField");
        fxRobot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl);
        fxRobot.write("neispravnalozinka");
        fxRobot.clickOn("#usernameField");
        fxRobot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl);
        fxRobot.write("afazlagic1");
        fxRobot.clickOn("#btnLogin");
        assertNotNull(fxRobot.lookup("OK").queryAs(Button.class));
    }

    @Test
    void onRegisterClickTest(FxRobot fxRobot) {
        fxRobot.clickOn("#btnRegister");
        assertNotNull(fxRobot.lookup("OK").queryAs(Button.class));
        fxRobot.clickOn("OK");

        KeyCode ctrl = KeyCode.CONTROL;
        if(System.getProperty("os.name").equals("Mac OS X"))
            ctrl = KeyCode.COMMAND;
        fxRobot.clickOn("#nameField");
        fxRobot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl);
        fxRobot.write("a");
        fxRobot.clickOn("#surnameField");
        fxRobot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl);
        fxRobot.write("f");
        fxRobot.clickOn("#usernameField");
        fxRobot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl);
        fxRobot.write("afazlagic1");
        fxRobot.clickOn("#passwordField");
        fxRobot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl);
        fxRobot.write("abcd");
        fxRobot.clickOn("#phoneNumberField");
        fxRobot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl);
        fxRobot.write("1234567");
        fxRobot.clickOn("#statusBox").clickOn("single");
        fxRobot.clickOn("#btnRegister");
        assertNotNull(fxRobot.lookup("OK").queryAs(Button.class));
        fxRobot.clickOn("OK");

        fxRobot.clickOn("#usernameField");
        fxRobot.press(ctrl).press(KeyCode.A).release(KeyCode.A).release(ctrl);
        fxRobot.write("nezauzetiUsername");
        fxRobot.clickOn("#btnRegister");
        assertNotNull(fxRobot.lookup("#yoF").queryAs(TextField.class));
    }
}