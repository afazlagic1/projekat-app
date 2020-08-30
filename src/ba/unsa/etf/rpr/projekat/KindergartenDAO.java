package ba.unsa.etf.rpr.projekat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class KindergartenDAO {
    private static KindergartenDAO instance;
    private Connection connection;
    private PreparedStatement giveAdminsStatement, giveParentsStatement, giveAdminStatement, giveAdminByIdStatement, giveParentStatement, giveParentByIdStatement, checkIfUsernameTakenAdminStatement, checkIfUsernameTakenParentStatement, insertNewParentStatement,
    parentIdMax;

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
                checkIfUsernameTakenAdminStatement = connection.prepareStatement("SELECT admin.id, admin.name, admin.surname, admin.username, admin.password FROM admin WHERE admin.username=?");
                checkIfUsernameTakenParentStatement = connection.prepareStatement("SELECT parent.id, parent.name, parent.surname, parent.username, parent.password, parent.status, parent.phoneNumber FROM parent WHERE parent.username=?");
                giveParentsStatement = connection.prepareStatement("SELECT parent.id, parent.name, parent.surname, parent.username, parent.password, parent.status, parent.phoneNumber FROM parent");
                giveParentStatement = connection.prepareStatement("SELECT parent.id, parent.name, parent.surname, parent.username, parent.password, parent.status, parent.phoneNumber FROM parent WHERE parent.username=? AND parent.password=?");
                giveParentByIdStatement = connection.prepareStatement("SELECT parent.id, parent.name, parent.surname, parent.username, parent.password, parent.status, parent.phoneNumber FROM parent WHERE parent.id=?");
                insertNewParentStatement = connection.prepareStatement("INSERT INTO parent VALUES (?,?,?,?,?,?,?)");
                parentIdMax = connection.prepareStatement("SELECT MAX(id)+1 FROM parent");
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

    public boolean registerCheckIfUsernameTaken(String username) {
        ResultSet resultSetA = null;
        ResultSet resultSetP = null;
        try {
            checkIfUsernameTakenAdminStatement.setString(1, username);
            checkIfUsernameTakenParentStatement.setString(1, username);
            resultSetA = checkIfUsernameTakenAdminStatement.executeQuery();
            if(resultSetA.next())
                return true;
            resultSetP = checkIfUsernameTakenParentStatement.executeQuery();
            if(resultSetP.next())
                return true;
            return false;
        } catch (SQLException throwables) {
            return true;
        }
        finally {
            try {
                if(resultSetA != null)
                    resultSetA.close();
                if(resultSetP != null)
                    resultSetP.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void addNewParentDB(String name, String surname, String username, String password, String maritalStatus, String phoneNumber) {
        ResultSet resultSet = null;
        try {
            ResultSet set = parentIdMax.executeQuery();
            if(set.next())
                insertNewParentStatement.setInt(1, set.getInt(1));
            else
                insertNewParentStatement.setInt(1, 1);
            insertNewParentStatement.setString(2, name);
            insertNewParentStatement.setString(3, surname);
            insertNewParentStatement.setString(4, username);
            insertNewParentStatement.setString(5, password);
            insertNewParentStatement.setString(6, maritalStatus);
            insertNewParentStatement.setInt(7, Integer.valueOf(phoneNumber));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            insertNewParentStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
