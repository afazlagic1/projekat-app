package ba.unsa.etf.rpr.projekat.data;

import ba.unsa.etf.rpr.projekat.data.Classroom;

public class Teacher {
    private int id = -1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name = "";
    private String surname = "";
    private String username = "";
    private int phoneNumber = 0;
    private Classroom classroom = null;

    public Teacher() {
    }

    public Teacher(int id, String name, String surname, String email, int phoneNumber, Classroom classroom) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = email;
        this.phoneNumber = phoneNumber;
        this.classroom = classroom;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
