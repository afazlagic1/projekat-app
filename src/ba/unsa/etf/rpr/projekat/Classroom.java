package ba.unsa.etf.rpr.projekat;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private int id = -1;
    private List<Child> children = new ArrayList<>();
    private Teacher teacher = null;
    private static int capacity = 15;

    public Classroom(int id, List<Child> children, Teacher teacher) {
        this.id = id;
        this.children = children;
        this.teacher = teacher;
    }

    public Classroom() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public static int getCapacity() {
        return capacity;
    }

    public static void setCapacity(int capacity) {
        Classroom.capacity = capacity;
    }
}
