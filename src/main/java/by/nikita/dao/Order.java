package by.nikita.dao;

public class Order {
    private int idorder, idusers, idstatusorder;
    private String data;

    public  Order(){}

    public Order(int idorder, int idusers, String data, int idstatusorder) {
        this.idorder = idorder;
        this.idusers = idusers;
        this.data = data;
        this.idstatusorder = idstatusorder;
    }

    public int getIdorder() {
        return idorder;
    }

    public void setIdorder(int idorder) {
        this.idorder = idorder;
    }

    public int getIdusers() {
        return idusers;
    }

    public void setIdusers(int idusers) {
        this.idusers = idusers;
    }

    public int getIdstatusorder() {
        return idstatusorder;
    }

    public void setIdstatusorder(int idstatusorder) {
        this.idstatusorder = idstatusorder;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idorder=" + idorder +
                ", idusers=" + idusers +
                ", idstatusorder=" + idstatusorder +
                ", data='" + data + '\'' +
                '}';
    }
}
