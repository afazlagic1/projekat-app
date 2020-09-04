package ba.unsa.etf.rpr.projekat.data;

import ba.unsa.etf.rpr.projekat.InvalidYearsOldException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChildTest {

    @Test
    void testToString() {
        Parent parent = new Parent(MaritalStatus.DIVORCED, 061333333);
        Child child = new Child();
        child.setName("Brock");
        child.setSurname("Cantillo");
        assertEquals("Brock Cantillo\n", child.toString());
    }

    @Test
    void setYo() {
        Child child = new Child();
        assertThrows(InvalidYearsOldException.class, () -> child.setYo(20));
        assertThrows(InvalidYearsOldException.class, () -> child.setYo(0));
        assertThrows(InvalidYearsOldException.class, () -> child.setYo(-3));
        assertDoesNotThrow(() -> child.setYo(6));
        assertDoesNotThrow(() -> child.setYo(1));
    }

    @Test
    void testConstructor() {
        Parent parent = new Parent(1, "Xenophilius", "Lovegood", "xeno12", "luna", MaritalStatus.WIDOWED, 3333133);
        assertThrows(InvalidYearsOldException.class, () -> new Child(1, "Luna", "Lovegood", parent, 17, null));
    }
}