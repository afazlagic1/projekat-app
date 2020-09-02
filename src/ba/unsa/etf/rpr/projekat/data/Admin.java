package ba.unsa.etf.rpr.projekat.data;

public class Admin extends User {
    public Admin() {
        super();
    }
    public Admin(int id, String name, String surname, String username, String password) {
        super(id, name, surname, username, password);
    }

    @Override
    public String toString() {
        return super.getName() + " " + super.getSurname();
    }
}
