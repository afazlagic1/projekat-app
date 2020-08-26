package ba.unsa.etf.rpr.projekat;

public class Parent extends User {
    private MaritalStatus status;
    private int phoneNumber;

    public Parent() {
        super();
        status = MaritalStatus.SINGLE;
        phoneNumber = 0;
    }

    public Parent(MaritalStatus status, int phoneNumber) {
        super();
        this.status = status;
        this.phoneNumber = phoneNumber;
    }
    public Parent(int id, String name, String surname, String email, String password, MaritalStatus status, int phoneNumber) {
        super(id, name, surname, email, password);
        this.status = status;
        this.phoneNumber = phoneNumber;
    }

    public MaritalStatus getStatus() {
        return status;
    }

    public void setStatus(MaritalStatus status) {
        this.status = status;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
