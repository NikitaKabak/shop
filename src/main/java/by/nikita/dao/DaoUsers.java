package by.nikita.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoUsers implements DaoInterface {
     private DBconnector connect;
     private Connection connection;

    public DaoUsers(){
        connect = new DBconnector();
        connect.apDriver();
        try {
            connection = connect.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void closeconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public Object create() {
        return null;
    }

    @Override
    public ArrayList<String> read(int id) {
        ArrayList<String> list = new ArrayList<String>();

        String sql ="SELECT * FROM users WHERE  idusers =?;";
        PreparedStatement ppst = null;
        try {
            ppst = connection.prepareStatement(sql);
            ppst.setInt(1,id);
            ResultSet rs = ppst.executeQuery();
            rs.next();

            System.out.println(rs.getString("idusers"));
            list.add( rs.getString("idusers"));
            list.add(rs.getString("name"));
            list.add(rs.getString("password"));
            list.add(rs.getString("email"));
            list.add(rs.getString("idrole"));
            list.add(rs.getString("idstatus"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeconnect();
       return list;
    }

    @Override
    public void updete(Object ob) {

    }

    @Override
    public void delete(Object ob) {

    }

    @Override
    public List getall() throws Exception {
        return null;
    }
}
