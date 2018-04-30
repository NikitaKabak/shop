package by.nikita.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnector {

    private String url = "jdbc:mysql://localhost:3306";
    private String nameDB = "shop";
    private String user = "root";
    private String password = "root";
    private String driver = "com.mysql.jdbc.Driver";

    // как правильно обьеденить  эти 2 метота в  1 или  разделить их?

    public void apDriver() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    /*public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url + "/" + nameDB, user, password);
    }*/

    public static Connection getConnection() throws SQLException, NamingException {
        Context ctx = new InitialContext();
        DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/shop");
        return  dataSource.getConnection();

    }





}
