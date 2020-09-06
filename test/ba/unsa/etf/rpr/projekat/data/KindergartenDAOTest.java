package ba.unsa.etf.rpr.projekat.data;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class KindergartenDAOTest {

    @Test
    void loginCheckIfAdmin() {
        KindergartenDAO.removeInstance();
        File file = new File("baza.db");
        file.delete();
        KindergartenDAO kindergartenDAO = KindergartenDAO.getInstance();
        assertFalse(kindergartenDAO.loginCheckIfAdmin("nata15", "1111"));
        assertTrue(kindergartenDAO.loginCheckIfAdmin("afazlagic1", "123"));
    }

    @Test
    void loginCheckIfParent() {
        KindergartenDAO.removeInstance();
        File file = new File("baza.db");
        file.delete();
        KindergartenDAO kindergartenDAO = KindergartenDAO.getInstance();
        assertTrue(kindergartenDAO.loginCheckIfParent("nata15", "1111"));
        assertFalse(kindergartenDAO.loginCheckIfParent("afazlagic1", "123"));
    }

    @Test
    void registerCheckIfUsernameTaken() {
        KindergartenDAO.removeInstance();
        File file = new File("baza.db");
        file.delete();
    }

    @Test
    void addNewParentDB() {
        KindergartenDAO.removeInstance();
        File file = new File("baza.db");
        file.delete();
    }

    @Test
    void getAllParentsDB() {
        KindergartenDAO.removeInstance();
        File file = new File("baza.db");
        file.delete();
    }

    @Test
    void addNewChildDB() {
        KindergartenDAO.removeInstance();
        File file = new File("baza.db");
        file.delete();
    }

    @Test
    void getParentByUsername() {
        KindergartenDAO.removeInstance();
        File file = new File("baza.db");
        file.delete();
    }

    @Test
    void getAdminByUsername() {
        KindergartenDAO.removeInstance();
        File file = new File("baza.db");
        file.delete();
    }

    @Test
    void getAllAdminsDB() {
        KindergartenDAO.removeInstance();
        File file = new File("baza.db");
        file.delete();
    }

    @Test
    void getAllClassrooms() {
        KindergartenDAO.removeInstance();
        File file = new File("baza.db");
        file.delete();
    }

    @Test
    void getChildrenDB() {
        KindergartenDAO.removeInstance();
        File file = new File("baza.db");
        file.delete();
    }

    @Test
    void getAllTeachersDB() {
        KindergartenDAO.removeInstance();
        File file = new File("baza.db");
        file.delete();
    }

    @Test
    void addNewClassroomDB() {
        KindergartenDAO.removeInstance();
        File file = new File("baza.db");
        file.delete();
    }

    @Test
    void addNewTeacherDB() {
        KindergartenDAO.removeInstance();
        File file = new File("baza.db");
        file.delete();
    }
}