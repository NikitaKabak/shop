package by.nikita.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orderstatus")
public class Orgerstatus {
    @Id
    private Integer idorderstatus;
    @Column
    private String orderstatus;

    @OneToMany(mappedBy = "orgerstatus", fetch = FetchType.LAZY)
    private List<Order> listUser = new ArrayList<>();

    public Orgerstatus() {
    }

    public Orgerstatus(Integer idorderstatus, String orderstatus) {
        this.idorderstatus = idorderstatus;
        this.orderstatus = orderstatus;
    }

    public Integer getIdorderstatus() {
        return idorderstatus;
    }

    public void setIdorderstatus(Integer idorderstatus) {
        this.idorderstatus = idorderstatus;
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }

    public List<Order> getListUser() {
        return listUser;
    }

    public void setListUser(List<Order> listUser) {
        this.listUser = listUser;
    }

    @Override
    public String toString() {
        return "Orgerstatus{" +
                "idorderstatus=" + idorderstatus +
                ", orderstatus='" + orderstatus + '\'' +
                '}';
    }
}
