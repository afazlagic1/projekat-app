package ba.unsa.etf.rpr.projekat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

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

            regenerateDatabase();

            try {
                giveAdminStatement = connection.prepareStatement("SELECT * FROM admin");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    private void regenerateDatabase() {
        Scanner ulaz = null;
        try {
            ulaz = new Scanner(new FileInputStream("baza.db.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String sqlUpit = "";
        while(ulaz.hasNext()) {
            sqlUpit += ulaz.nextLine();
            if(sqlUpit.charAt(sqlUpit.length() - 1) == ';') {
                Statement statement = null;
                try {
                    statement = connection.createStatement();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    statement.execute(sqlUpit);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                sqlUpit = "";
            }
        }
        ulaz.close();
    }
}
