package by.nikita.Entity;

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
    private Integer idusers;
    @Column
    private Integer idstatusorder;
    @Column
    private String data;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<Backet> listBacket = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "idusers", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "idstatusorder", insertable = false, updatable = false)
    private Orgerstatus orgerStatus;

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
        return orgerStatus;
    }

    public void setOrgerStatus(Orgerstatus orgerStatus) {
        this.orgerStatus = orgerStatus;
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
