package ba.unsa.etf.rpr.projekat;

public class Child {
    private int id = -1;
    private String name;
    private String surname;
    private Parent parent1;
    private Parent parent2;
    private int yo;

    public Child() {
        name = "";
        surname = "";
        parent1 = null;
        parent2 = null;
        yo = 0;
    }

    public Child(int id, String name, String surname, Parent parent1, Parent parent2, int yo) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.parent1 = parent1;
        this.parent2 = parent2;
        this.yo = yo;
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

    public void setYo(int yo) {
        this.yo = yo;
    }

    public Parent getParent1() {
        return parent1;
    }

    public void setParent1(Parent parent1) {
        this.parent1 = parent1;
    }

    public Parent getParent2() {
        return parent2;
    }

    public void setParent2(Parent parent2) {
        this.parent2 = parent2;
    }
}
