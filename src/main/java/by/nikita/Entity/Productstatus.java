package by.nikita.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "productstatus")
public class Productstatus {

    @Id
    private Integer idproductstatus;
    @Column
    private String productstatus;
    @OneToMany(mappedBy = "productstatus", fetch = FetchType.EAGER)
    private List<Product> listProduct = new ArrayList<>();

    public Productstatus(){
    }

    public Productstatus(Integer idproductstatus, String productstatus){
        this.idproductstatus = idproductstatus;
        this.productstatus = productstatus;
    }

    public Integer getIdproductstatus() {
        return idproductstatus;
    }

    public void setIdproductstatus(Integer idproductstatus) {
        this.idproductstatus = idproductstatus;
    }

    public String getProductstatus() {
        return productstatus;
    }

    public void setProductstatus(String productstatus) {
        this.productstatus = productstatus;
    }

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    @Override
    public String toString() {
        return "Productstatus{" +
                "idproductstatus=" + idproductstatus +
                ", productstatus='" + productstatus + '\'' +
                '}';
    }
}
