package by.nikita.dao;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public Object create() {
        return null;
    }

    @Override
    public ArrayList<String> read(int id) {
        return null;
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
