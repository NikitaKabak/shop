package nikita.nikita.dao;



import nikita.nikita.Entity.Product;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoCatalogImp implements DaoCatalog {
    private DBconnector dBconnector;
    private Connection connection;

    public DaoCatalogImp() throws NamingException {
        dBconnector = new DBconnector();
        dBconnector.apDriver();
        try {
            connection = dBconnector.getConnection();
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
    public void create() {

    }

    @Override
    public Product read(int id) {
        Product product = null;
        String sql = "SELECT * From product WHERE idproduct =? ;";
        /*String sql = "SELECT idproduct, nameproduct, idcategory, idstatusproduct, quantity, price From product WHERE id =? ;";*/
        PreparedStatement ppst = null;

        try {
            ppst = connection.prepareStatement(sql);
            ppst.setInt(1,id);
            ResultSet rs = ppst.executeQuery();
            rs.next();
            int idproduct = rs.getInt("idproduct");
            String nameproduct = rs.getString("nameproduct");
            int idcategory = rs.getInt("idcategory");
            int idstatusproduct = rs.getInt("idstatusproduct");
            int quantity = rs.getInt("quantity");
            int price = rs.getInt("price");
            product = new Product(idproduct, nameproduct, idcategory, idstatusproduct, quantity, price);
            ppst.close();
            rs.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void updete(Object ob) {

    }

    @Override
    public void delete(Object ob) {

    }

    @Override
    public List<Product> getall() throws Exception {
        List<Product> catalog = new ArrayList<>();
        String sql = "SELECT idproduct, nameproduct, idcategory, idstatusproduct, quantity, price From product ;";
        Statement st = null;
        st = connection.createStatement();
        ResultSet resultSet = st.executeQuery(sql);
        while (resultSet.next()){
            int idproduct = resultSet.getInt("idproduct");
            String nameproduct = resultSet.getString("nameproduct");
            int idcategory = resultSet.getInt("idcategory");
            int idstatusproduct = resultSet.getInt("idstatusproduct");
            int quantity = resultSet.getInt("quantity");
            int price = resultSet.getInt("price");
            Product product = new Product(idproduct, nameproduct, idcategory, idstatusproduct, quantity, price);
            catalog.add(product);
        }
        st.close();
        resultSet.close();
        connection.close();
        return catalog;
    }
}
