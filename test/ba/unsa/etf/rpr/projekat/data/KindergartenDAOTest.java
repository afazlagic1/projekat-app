package ba.unsa.etf.rpr.projekat.data;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

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
        KindergartenDAO kindergartenDAO = KindergartenDAO.getInstance();
        assertTrue(kindergartenDAO.registerCheckIfUsernameTaken("afazlagic1"));
        assertTrue(kindergartenDAO.registerCheckIfUsernameTaken("nata15"));
        assertFalse(kindergartenDAO.registerCheckIfUsernameTaken("maya4"));
    }

    @Test
    void addNewParentDB() {
        KindergartenDAO.removeInstance();
        File file = new File("baza.db");
        file.delete();
        KindergartenDAO kindergartenDAO = KindergartenDAO.getInstance();
        assertFalse(kindergartenDAO.registerCheckIfUsernameTaken("dinok"));
        Parent parent = kindergartenDAO.addNewParentDB("Dino", "Kovacevic", "dinok", "12345", "single", "33245661");
        assertTrue(kindergartenDAO.registerCheckIfUsernameTaken("dinok"));
    }

    @Test
    void getAllParentsDB() {
        KindergartenDAO.removeInstance();
        File file = new File("baza.db");
        file.delete();
        KindergartenDAO kindergartenDAO = KindergartenDAO.getInstance();
        ArrayList<Parent> parents = kindergartenDAO.getAllParentsDB();
        parents.forEach(x -> assertTrue(kindergartenDAO.registerCheckIfUsernameTaken(x.getUsername())));
    }

    @Test
    void addNewChildDB() {
        KindergartenDAO.removeInstance();
        File file = new File("baza.db");
        file.delete();
        KindergartenDAO kindergartenDAO = KindergartenDAO.getInstance();
        Parent parent = kindergartenDAO.addNewParentDB("Dario", "Love", "dario", "111155", "married", "2132947");
        kindergartenDAO.addNewChildDB(parent, "Mia", "Love", 6);
        kindergartenDAO.addNewChildDB(parent, "Sarah", "Love", 99);
        ArrayList<Child> children = kindergartenDAO.getChildrenDB();
        children.stream().anyMatch(child -> child.getParent1().getUsername().equals(parent.getUsername()));
        children.stream().noneMatch(child -> child.getParent1().getUsername().equals(parent.getUsername()));
    }

    @Test
    void getParentByUsername() {
        KindergartenDAO.removeInstance();
        File file = new File("baza.db");
        file.delete();
        KindergartenDAO kindergartenDAO = KindergartenDAO.getInstance();
        Parent parent = kindergartenDAO.getParentByUsername("a", "a");
        assertEquals(null, parent);
        parent = kindergartenDAO.getParentByUsername("dino1921", "0000");
        assertNotEquals(null, parent);
    }

    @Test
    void getAdminByUsername() {
        KindergartenDAO.removeInstance();
        File file = new File("baza.db");
        file.delete();
        KindergartenDAO kindergartenDAO = KindergartenDAO.getInstance();
        Admin admin = kindergartenDAO.getAdminByUsername("afazlagic1", "123");
        Admin admin1 = kindergartenDAO.getAdminByUsername("nata15", "1111");
        assertNotEquals(null, admin);
        assertEquals(null, admin1);
    }

    @Test
    void addNewClassroomDB() {
        KindergartenDAO.removeInstance();
        File file = new File("baza.db");
        file.delete();
        KindergartenDAO kindergartenDAO = KindergartenDAO.getInstance();
        int id = kindergartenDAO.addNewTeacherDB("Walter", "White", "63333");
        Teacher teacher = new Teacher(id, "Walter", "White", 63333);
        int id1 = kindergartenDAO.addNewClassroomDB(teacher);
        assertTrue(kindergartenDAO.getAllTeachersDB().stream().anyMatch(teacher1 -> teacher1.getId() == teacher.getId() && teacher1.getName().equals(teacher.getName()) && teacher1.getSurname().equals(teacher.getSurname()) && teacher1.getPhoneNumber() == teacher.getPhoneNumber()));
        assertTrue(kindergartenDAO.getAllClassrooms().stream().anyMatch(classroom -> classroom.getId() == id1 && classroom.getTeacher().getId() == id));
    }
}