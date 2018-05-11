package by.nikita.dao;


import javax.persistence.*;

@Entity
@Table(name = "backet")
public class Backet {
    public Backet(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idbacket")
    private Integer idbacket;

    @Column (name = "idorder")
    private Integer idorder;

    @Column (name = "idproduct")
    private Integer idproduct;

    @Column (name = "qantityby")
    private Integer qantityby;

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
