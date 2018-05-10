package by.nikita.dao;


import javax.persistence.*;

@Entity
@Table(name = "backet")
public class Backet {
    public Backet(){

    }

    @Id
    @Column (name = "idbacket")
    Integer idbacket;

    @Column (name = "idorder")
    Integer idorder;

    @Column (name = "idproduct")
    Integer idproduct;

    @Column (name = "qantityby")
    Integer qantityby;

    public Integer getIdbacket() {
        return idbacket;
    }

    public void setIdbacket(Integer idbacket) {
        this.idbacket = idbacket;
    }

    public Integer getIdorder() {
        return idorder;
    }

    public void setIdorder(Integer idorder) {
        this.idorder = idorder;
    }

    public Integer getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(Integer idproduct) {
        this.idproduct = idproduct;
    }

    public Integer getQantityby() {
        return qantityby;
    }

    public void setQantityby(Integer qantityby) {
        this.qantityby = qantityby;
    }

    @Override
    public String toString() {
        return "Backet{" +
                "idbacket=" + idbacket +
                ", idorder=" + idorder +
                ", idproduct=" + idproduct +
                ", qantityby=" + qantityby +
                '}';
    }
}
