package by.nikita.dao;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idorder;
    @Column
    private Integer idusers;
    @Column
    private Integer idstatusorder;
    @Column
    private String data;

    public Order() {
    }

    public Order(Integer idorder, Integer idusers, String data, Integer idstatusorder) {
        this.idorder = idorder;
        this.idusers = idusers;
        this.data = data;
        this.idstatusorder = idstatusorder;
    }

    public Integer getIdorder() {
        return idorder;
    }

    public void setIdorder(Integer idorder) {
        this.idorder = idorder;
    }

    public Integer getIdusers() {
        return idusers;
    }

    public void setIdusers(Integer idusers) {
        this.idusers = idusers;
    }

    public Integer getIdstatusorder() {
        return idstatusorder;
    }

    public void setIdstatusorder(Integer idstatusorder) {
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
