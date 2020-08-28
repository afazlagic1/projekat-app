package ba.unsa.etf.rpr.projekat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class KindergartenDAO {
    private static KindergartenDAO instance;
    private Connection connection;
    private PreparedStatement giveAdminsStatement, giveParentsStatement, giveAdminStatement, giveAdminByIdStatement, giveParentStatement, giveParentByIdStatement;

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
            giveAdminsStatement = connection.prepareStatement("SELECT admin.id, admin.name, admin.surname, admin.username, admin.password FROM admin");
        } catch (SQLException throwables) {
            regenerateDatabase();

            try {
                giveAdminsStatement = connection.prepareStatement("SELECT admin.id, admin.name, admin.surname, admin.username, admin.password FROM admin");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                giveAdminStatement = connection.prepareStatement("SELECT admin.id, admin.name, admin.surname, admin.username, admin.password FROM admin WHERE admin.username=? AND admin.password=?");
                giveAdminByIdStatement = connection.prepareStatement("SELECT admin.id, admin.name, admin.surname, admin.username, admin.password FROM admin WHERE admin.id=?");
                giveParentsStatement = connection.prepareStatement("SELECT parent.id, parent.name, parent.surname, parent.username, parent.password, parent.status, parent.phoneNumber FROM parent");
                giveParentStatement = connection.prepareStatement("SELECT parent.id, parent.name, parent.surname, parent.username, parent.password, parent.status, parent.phoneNumber FROM parent WHERE parent.username=? AND parent.password=?");
                giveParentByIdStatement = connection.prepareStatement("SELECT parent.id, parent.name, parent.surname, parent.username, parent.password, parent.status, parent.phoneNumber FROM parent WHERE parent.id=?");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    public static void removeInstance() {
        if(instance == null) return;
        try {
            instance.connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        instance = null;
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

    public boolean loginCheckIfAdmin(String username, String password) {
        ResultSet resultSet = null;
        try {
            giveAdminStatement.setString(1, username);
            giveAdminStatement.setString(2, password);
            resultSet = giveAdminStatement.executeQuery();
            return resultSet.next();
        }
        catch (SQLException e) {
            return false;
        }
        finally {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public boolean loginCheckIfParent(String username, String password) {
        ResultSet resultSet = null;
        try {
            giveParentStatement.setString(1, username);
            giveParentStatement.setString(2, password);
            resultSet = giveParentStatement.executeQuery();
            return resultSet.next();
        }
        catch (SQLException e) {
            return false;
        }
        finally {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
