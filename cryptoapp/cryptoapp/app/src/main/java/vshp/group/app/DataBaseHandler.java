package vshp.group.app;

import java.sql.*;

public class DataBaseHandler extends Config {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void signUpUser(User user){
        String insert = "INSERT INTO " + Const.USER_TABLE + "("
                + Const.USERS_SURNAME + ","
                + Const.USERS_NAME + ","
                + Const.USERS_PATRONYMIC + ","
                + Const.USERS_AGE + ","
                + Const.USERS_PHONE + ","
                + Const.USERS_EMAIL + ","
                + Const.USERS_LOGIN + ","
                + Const.USERS_PASSWORD
                + ")" + "VALUES(?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement peSt = getDbConnection().prepareStatement(insert);
            peSt.setString(2, user.getSurName());
            peSt.setString(1, user.getName());
            peSt.setString(3, user.getPatronymicName());
            peSt.setString(4, user.getAgeUser());
            peSt.setString(5, user.getPhoneUser());
            peSt.setString(6, user.getEmailUser());
            peSt.setString(7, user.getLoginUser());
            peSt.setString(8, user.getPasswordUser());

            System.out.println(insert);


            peSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUser(User user) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USERS_LOGIN + "=? AND " + Const.USERS_PASSWORD + "=?";

        try {
            PreparedStatement peSt = getDbConnection().prepareStatement(select);
            peSt.setString(1, user.getLoginUser());
            peSt.setString(2, user.getPasswordUser());

            System.out.println(peSt);

            resSet = peSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resSet;
    }
}
