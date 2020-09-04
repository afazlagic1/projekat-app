package ba.unsa.etf.rpr.projekat.data;

import ba.unsa.etf.rpr.projekat.InvalidYearsOldException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ClassroomTest {

    @Test
    void setChildren() throws InvalidYearsOldException {
        ArrayList<Child> children = new ArrayList<>();
        for(int i = 0; i < 20; i++)
            children.add(new Child(1, "", "", new Parent(), 5, null));
        Classroom classroom = new Classroom(1, new ArrayList<>(), new Teacher());
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> classroom.setChildren(children));
    }

    @Test
    void addChildToClassroom() throws InvalidYearsOldException {
        Child child = new Child();
        ArrayList<Child> children = new ArrayList<>();
        Classroom classroom = new Classroom();
        for(int i = 0; i < 15; i++)
            children.add(new Child(1, "", "", new Parent(), 5, null));
        classroom.setChildren(children);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> classroom.addChildToClassroom(child));
    }

    @Test
    void setCapacity() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> Classroom.setCapacity(2), "It is not allowed to make the capacity smaller, because the transfer in some classrooms would possibly be necessary in that case.");
    }

    @Test
    void constructorTest() throws InvalidYearsOldException {
        ArrayList<Child> children = new ArrayList<>();
        for(int i = 0; i < 20; i++)
            children.add(new Child(1, "", "", new Parent(), 5, null));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> new Classroom(1, children, new Teacher()));
    }
}