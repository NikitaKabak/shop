package by.nikita.dao;

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

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url + "/" + nameDB, user, password);
    }



}
