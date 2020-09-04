package ba.unsa.etf.rpr.projekat.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {

    @Test
    void testToString() {
        Teacher teacher = new Teacher();
        teacher.setName("John");
        teacher.setSurname("Keating");
        assertEquals("John Keating", teacher.toString());
    }
}