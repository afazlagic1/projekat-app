package ba.unsa.etf.rpr.projekat;

public class Parent extends User {
    private MaritalStatus status;
    private int phoneNumber;

    public Parent() {
        status = MaritalStatus.SINGLE;
        phoneNumber = 0;
    }

    public Parent(MaritalStatus status, int phoneNumber) {
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
