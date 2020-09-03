package ba.unsa.etf.rpr.projekat.data;

import ba.unsa.etf.rpr.projekat.data.Classroom;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Teacher {
    private int id = -1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private SimpleStringProperty name = new SimpleStringProperty("");
    private SimpleStringProperty surname = new SimpleStringProperty("");
    private SimpleIntegerProperty phoneNumber = new SimpleIntegerProperty(0);

    public Teacher() {
    }

    @Override
    public String toString() {
        return name.getValue() + " " + surname.getValue();
    }

    public Teacher(int id, String name, String surname, int phoneNumber) {
        this.id = id;
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.phoneNumber = new SimpleIntegerProperty(phoneNumber);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public SimpleStringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public int getPhoneNumber() {
        return phoneNumber.get();
    }

    public SimpleIntegerProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }
}
