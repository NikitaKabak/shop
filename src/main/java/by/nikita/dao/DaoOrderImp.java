package by.nikita.dao;
import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoOrderImp implements DaoOrder {
    @Override
    public void create(int iduser,String data) throws NamingException {
        Connection connection = null;
        PreparedStatement ppst = null;
        DBconnector connector = new DBconnector();
        connector.apDriver();
        try {
            connection = connector.getConnection();
            String sql = "INSERT INTO `shop`.`order` (`idusers`, `data`) VALUES ( ?, ?);";
            /*INSERT INTO `shop`.`order` (`idusers`, `data`) VALUES ( 3, '2015-02-15');*/
            try {
                ppst=connection.prepareStatement(sql);
                ppst.setInt(1,iduser);
                ppst.setString(2,data);
                ppst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ppst.close();
            }

        } catch (SQLException e ) {
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
    public Object reade(int id) {
        return null;
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
                statement=connection.createStatement();
                result = statement.executeQuery(sql);

                while (result.next()) {
                    int idorder = result.getInt("idorder");
                    String data = result.getString("data");
                    int idusers = result.getInt("idusers");
                    int idstatusorder = result.getInt("idstatusorder");
                    Order order = new Order( idorder, idusers, data, idstatusorder);
                    orders.add(order);
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
        } return orders;
    }
}
