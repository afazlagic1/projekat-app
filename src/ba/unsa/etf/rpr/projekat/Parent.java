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

    public Parent(int id, String name, String surname, String username, String password, String maritalStatus, int phoneNumber) {
        super(id, name, surname, username, password);
        this.phoneNumber = phoneNumber;
        //this.status = MaritalStatus.valueOf(maritalStatus);
        if(maritalStatus.equalsIgnoreCase("married"))
            this.status = MaritalStatus.MARRIED;
        else if(maritalStatus.equalsIgnoreCase("divorced"))
            this.status = MaritalStatus.DIVORCED;
        else if(maritalStatus.equalsIgnoreCase("widowed"))
            this.status = MaritalStatus.WIDOWED;
        else if(maritalStatus.equalsIgnoreCase("single"))
            this.status = MaritalStatus.SINGLE;
    }

    public Parent(int id, String name, String surname, String username, String password, MaritalStatus status, int phoneNumber) {
        super(id, name, surname, username, password);
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

    @Override
    public String toString() {
        return super.getName() + " " + super.getSurname() + ", id: " + super.getId();
    }
}
