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
                + Const.USERS_PASSWORD + ","
                + ")"
                + "VALUES(?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement peSt = getDbConnection().prepareStatement(insert);
            peSt.setString(1, user.getLoginUser());
            peSt.setString(2, user.getPasswordUser());
            peSt.setString(3, user.getAgeUser());

            peSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

//    public ResultSet getUser (User user){
//        ResultSet rsSet = null;
//
//        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE "
//                + Const.USERS_NICKNAME + "=? AND "+ Const.USERS_PASSWORD + "=?";
//
//        try {
//            PreparedStatement peSt = getDbConnection().prepareStatement(select);
//            peSt.setString(1, user.getLoginUser());
//            peSt.setString(2, user.getPasswordUser());
//
//            rsSet = peSt.executeQuery();
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        return rsSet;
//    }
}
