package by.nikita.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idorder;

    @Column
    private String data;

    @OneToMany(mappedBy = "order")
    private List<Backet> listBacket = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "idusers")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idstatusorder")
    private Orgerstatus orgerstatus;

    public Order() {
    }

    public Order(Integer idorder, User user, String data, Orgerstatus orgerstatus) {
        this.idorder = idorder;
        this.user = user;
        this.data = data;
        this.orgerstatus = orgerstatus;
    }

    public Integer getIdorder() {
        return idorder;
    }

    public void setIdorder(Integer idorder) {
        this.idorder = idorder;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Backet> getListBacket() {

        return listBacket;
    }

    public void setListBacket(List<Backet> listBacket) {
        this.listBacket = listBacket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Orgerstatus getOrgerStatus() {
        return orgerstatus;
    }

    public void setOrgerStatus(Orgerstatus orgerStatus) {
        this.orgerstatus = orgerStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idorder=" + idorder +
                ", data='" + data + '\'' +
                '}';
    }
}
