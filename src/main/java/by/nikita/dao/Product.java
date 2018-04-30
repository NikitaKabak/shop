package by.nikita.dao;

public class Product {
    private int idproduct;
    private String nameproduct;
    private int idcategory;
    private int idstatusproduct;
    private int quantity;
    private int price;

    public Product(){}

    public  Product(int idproduct,String nameproduct,int idcategory,int idstatusproduct,int quantity,int price){
        this.idproduct = idproduct;
        this.nameproduct = nameproduct;
        this.idcategory = idcategory;
        this.idstatusproduct = idstatusproduct;
        this.quantity = quantity;
        this.price = price;
    }

    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public String getNameproduct() {
        return nameproduct;
    }

    public void setNameproduct(String nameproduct) {
        this.nameproduct = nameproduct;
    }

    public int getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
    }

    public int getIdstatusproduct() {
        return idstatusproduct;
    }

    public void setIdstatusproduct(int idstatusproduct) {
        this.idstatusproduct = idstatusproduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idproduct=" + idproduct +
                ", nameproduct='" + nameproduct + '\'' +
                ", idcategory=" + idcategory +
                ", idstatusproduct=" + idstatusproduct +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
