package ba.unsa.etf.rpr.projekat;

public class Child {
    private String name;
    private String surname;
    private Parent parent;
    private int yo;

    public Child() {
        name = "";
        surname = "";
        parent = null;
        yo = 0;
    }

    public Child(String name, String surname, Parent parent, int yo) {
        this.name = name;
        this.surname = surname;
        this.parent = parent;
        this.yo = yo;
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

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public int getYo() {
        return yo;
    }

    public void setYo(int yo) {
        this.yo = yo;
    }
}
