package ba.unsa.etf.rpr.projekat.data;

import ba.unsa.etf.rpr.projekat.InvalidYearsOldException;

public class Child {
    private int id = -1;
    private String name;
    private String surname;
    private Parent parent1;
    private int yo;
    private Classroom classroom;

    @Override
    public String toString() {
        return name + " " + surname + "\n";
    }

    public Child() {
        name = "";
        surname = "";
        parent1 = null;
        yo = 1;
        classroom = null;
    }

    public Child(int id, String name, String surname, Parent parent1, int yo, Classroom classroom) throws InvalidYearsOldException {
        if(!(yo >= 1 && yo <= 6))
            throw new InvalidYearsOldException("Invalid yo entry for the child.");
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.parent1 = parent1;
        this.yo = yo;
        this.classroom = classroom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYo() {
        return yo;
    }

    public void setYo(int yo) throws InvalidYearsOldException {
        if(!(yo >= 1 && yo <= 6))
            throw new InvalidYearsOldException("Invalid yo entry for the child.");
        this.yo = yo;
    }

    public Parent getParent1() {
        return parent1;
    }

    public void setParent1(Parent parent1) {
        this.parent1 = parent1;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
