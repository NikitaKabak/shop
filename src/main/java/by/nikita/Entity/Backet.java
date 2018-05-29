package by.nikita.Entity;




import by.nikita.Entity.Order;
import by.nikita.Entity.Product;

import javax.persistence.*;


@Entity
@Table(name = "backet")
public class Backet {
    public Backet(){

    }

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
  /* @GeneratedValue(strategy = GenerationType.TABLE, generator = "student_gen")
   @TableGenerator(name = "student_gen", initialValue = 10, allocationSize = 50)*/
   @Column(name = "idbacket",nullable = false)
    private Integer idbacket;

    /*@Column (name = "idord")
    private Integer idorders;*/

   /* @Column(name = "idproduct")
    private Integer idproduct;*/

    @Column(name = "qantityby")
    private Integer qantityby;

    @ManyToOne
    @JoinColumn (name = "idord")
    private Order order;

    @ManyToOne
    @JoinColumn (name = "idproduct")
    private Product product;



    public Integer getIdbacket() {
        return idbacket;
    }

    public void setIdbacket(Integer idbacket) {
        this.idbacket = idbacket;
    }

  /*  public Integer getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(Integer idproduct) {
        this.idproduct = idproduct;
    }*/

    public Integer getQantityby() {
        return qantityby;
    }

    public void setQantityby(Integer qantityby) {
        this.qantityby = qantityby;
    }

   /* public Integer getIdorders() {
        return idorders;
    }

    public void setIdorders(Integer idorders) {
        this.idorders = idorders;
    }*/

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Backet{" +
                "idbacket=" + idbacket +
              //  ", idorder=" + idorders +
              //  ", idproduct=" + idproduct +
                ", qantityby=" + qantityby +
                '}';
    }
}
