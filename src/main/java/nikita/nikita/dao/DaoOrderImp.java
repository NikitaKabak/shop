package nikita.nikita.dao;

import nikita.nikita.Entity.Order;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoOrderImp implements DaoOrder {
    @Override
    public void create(int iduser, String data) throws NamingException {
        Connection connection = null;
        PreparedStatement ppst = null;
        DBconnector connector = new DBconnector();
        connector.apDriver();
        try {
            connection = connector.getConnection();
            String sql = "INSERT INTO `shop`.`orders` (`idusers`, `data`) VALUES ( ?, ?);";
            /*INSERT INTO `shop`.`order` (`idusers`, `data`) VALUES ( 3, '2015-02-15');*/
            try {
                ppst = connection.prepareStatement(sql);
                ppst.setInt(1, iduser);
                ppst.setString(2, data);
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
    public void delete() {
        /*    UPDATE `shop`.`order` SET `idstatusorder`='1' WHERE `idorder`='1';*/


    }

    @Override
    public void updete(Object obj) {
        /*    UPDATE `shop`.`order` SET `idstatusorder`='1' WHERE `idorder`='1';*/

    }

    @Override
    public Order getOrder(Integer iduser, String date) throws SQLException, NamingException {
        Connection connection = null;
        PreparedStatement ppst = null;
        ResultSet result = null;
        DBconnector connector = new DBconnector();
        connector.apDriver();
        Order order = null;
        ArrayList<String> list = new ArrayList<String>();
        String sql = "SELECT * FROM orders WHERE  idusers =? and data =?;";
        try {
            connection = connector.getConnection();
            try {
                ppst = connection.prepareStatement(sql);
                ppst.setInt(1,iduser);
                ppst.setString(2, date);
                result = ppst.executeQuery();
                result.next();

                Integer idorder = result.getInt("idorder");
                Integer idusers = result.getInt("idusers");
                String data = result.getString("data");
                Integer idstatusorder = result.getInt("idstatusorder");


                order = new Order();
               // order = new Order(idorder, idusers, data, idstatusorder);

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                result.close();
                ppst.close();
            }
        } catch (SQLException e) {

        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return order;
    }

    @Override
    public List<Order> getall() throws NamingException {

        List<Order> orders = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;

        DBconnector connector = new DBconnector();
        connector.apDriver();

        try {
            connection = connector.getConnection();
            String sql = "SELECT *  From order ;";
            try {
                statement = connection.createStatement();
                result = statement.executeQuery(sql);

                while (result.next()) {
                    int idorder = result.getInt("idorder");
                    String data = result.getString("data");
                    int idusers = result.getInt("idusers");
                    int idstatusorder = result.getInt("idstatusorder");
                    Order order = new Order();
                   // Order order = new Order(idorder, idusers, data, idstatusorder);
                    orders.add(order);
                }

            } catch (SQLException e) {
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
        return orders;
    }
}
