package by.nikita.dao;

import by.nikita.Entity.User;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoUsersImp implements DaoUsers {
    private DBconnector connect;

    public DaoUsersImp() throws NamingException {
    }

    @Override
    public void create(String nameUser, String passwordUser, String emailUser) throws NamingException {
        Connection connection = null;
        connect = new DBconnector();
        connect.apDriver();
        try {
            connection = connect.getConnection();
            String sql = " INSERT INTO `shop`.`users` (`name`, `password`, `email`) VALUES ( ?, ?, ?); ";
            PreparedStatement ppst = null;
            try {
                ppst = connection.prepareStatement(sql);
                ppst.setString(1, nameUser);
                ppst.setString(2, passwordUser);
                ppst.setString(3, emailUser);
                ppst.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ppst.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ArrayList<String> read(int id) throws NamingException {
        Connection connection = null;
        PreparedStatement ppst = null;
        ResultSet result = null;
        connect = new DBconnector();
        connect.apDriver();
        ArrayList<String> list = new ArrayList<String>();
        try {
            connection = connect.getConnection();

            String sql = "SELECT * FROM users WHERE  idusers =?;";
            try {
                ppst = connection.prepareStatement(sql);
                ppst.setInt(1, id);
                result = ppst.executeQuery();
                result.next();

                /*System.out.println(rs.getString("idusers"));*/
                list.add(result.getString("idusers"));
                list.add(result.getString("name"));
                list.add(result.getString("password"));
                list.add(result.getString("email"));
                list.add(result.getString("idrole"));
                list.add(result.getString("idstatus"));


            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    result.close();
                    ppst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public ArrayList<String> read(String name) throws NamingException {
        Connection connection = null;
        PreparedStatement ppst = null;
        ResultSet result = null;
        connect = new DBconnector();
        connect.apDriver();
        ArrayList<String> list = new ArrayList<String>();
        String sql = "SELECT * FROM users WHERE  name =?;";

        try {
            connection = connect.getConnection();
            try {
                ppst = connection.prepareStatement(sql);
                ppst.setString(1, name);
                result = ppst.executeQuery();
                result.next();

                /*System.out.println(rs.getString("idusers"));*/
                list.add(result.getString("idusers"));
                list.add(result.getString("name"));
                list.add(result.getString("password"));
                list.add(result.getString("email"));
                list.add(result.getString("idrole"));
                list.add(result.getString("idstatus"));


            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                result.close();
                ppst.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public void updete(Object ob) {

    }

    @Override
    public void delete(Object ob) {

    }

    @Override
    public List<User> getall() throws NamingException  {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet  result = null;
        connect = new DBconnector();
        connect.apDriver();
        String sql = "SELECT idusers, name, password, email, idrole, idstatus  From users ;";
        try {
            connection = connect.getConnection();
            try {
                statement = connection.createStatement();
                result = statement.executeQuery(sql);
                while (result.next()) {
                    int idUser = result.getInt("idusers");
                    String nameUser = result.getString("name");
                    String passwordUser = result.getString("password");
                    String emailUser = result.getString("email");
                    int idRole = result.getInt("idrole");
                    int idStatus = result.getInt("idstatus");
                    User user = new User(idUser, nameUser, passwordUser, emailUser, idRole, idStatus);
                    users.add(user);
                }
            } catch (SQLException e){
                e.printStackTrace();
            } finally {
                result.close();
                statement.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return users;
    }
}
