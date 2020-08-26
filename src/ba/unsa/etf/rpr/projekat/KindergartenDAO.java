package ba.unsa.etf.rpr.projekat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class KindergartenDAO {
    private static KindergartenDAO instance;
    private Connection connection;
    private PreparedStatement giveAdminStatement;

    public static KindergartenDAO getInstance() {
        if(instance == null)
            instance = new KindergartenDAO();
        return instance;
    }

    private KindergartenDAO() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:baza.db");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            giveAdminStatement = connection.prepareStatement("SELECT * FROM admin");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
