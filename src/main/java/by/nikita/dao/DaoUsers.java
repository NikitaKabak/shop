package by.nikita.dao;

import java.sql.*;
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
    public List<User> getall() throws Exception {
        List<User> users = new ArrayList<>();

        String sql ="SELECT idusers, name, password, email, idrole, idstatus  From users ;";
        Statement st = null;
        st = connection.createStatement();
        ResultSet resultSet = st.executeQuery(sql);
        while (resultSet.next()){
            int idUser = resultSet.getInt("idusers");
            System.out.println(idUser);
            String nameUser = resultSet.getString("name");
            System.out.println(nameUser);
            String passwordUser = resultSet.getString("password");
            System.out.println(passwordUser);
            String emailUser = resultSet.getString("email");
            System.out.println(emailUser);
            int idRole = resultSet.getInt("idrole");
            System.out.println(idRole);
            int idStatus = resultSet.getInt("idstatus");
            System.out.println(idStatus);
            User user = new User(idUser, nameUser, passwordUser, emailUser, idRole, idStatus);
            users.add(user);
        }
        st.close();
        resultSet.close();
        connection.close();
        return users;
    }
}
