package ba.unsa.etf.rpr.projekat.data;

import javafx.beans.property.SimpleStringProperty;

public abstract class User {
    private int id = -1;
    private SimpleStringProperty name;
    private SimpleStringProperty surname;
    private SimpleStringProperty username;
    private SimpleStringProperty password;

    public User() {
        name = new SimpleStringProperty("");
        surname = new SimpleStringProperty("");
        username = new SimpleStringProperty("");
        password = new SimpleStringProperty("");
    }

    public User(int id, String name, String surname, String username, String password) {
        this.id = id;
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUsername() {
        return username.get();
    }

    public SimpleStringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
}
