package ba.unsa.etf.rpr.projekat.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    @Test
    void testToString() {
        Admin admin = new Admin();
        admin.setName("Saoirse");
        admin.setSurname("Ronan");
        assertEquals("Saoirse Ronan", admin.toString());
    }
}