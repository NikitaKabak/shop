package by.nikita.dao;

import javax.persistence.*;

@Entity
@Table(name = "test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idtest;
    @Column
    private String name;
    @Column
    private Integer qantity;

    public Test() {
    }

    public Integer getIdtest() {
        return idtest;
    }

    public void setIdtest(Integer idtest) {
        this.idtest = idtest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQantity() {
        return qantity;
    }

    public void setQantity(Integer qantity) {
        this.qantity = qantity;
    }



    @Override
    public String toString() {
        return "Test{" +
                "idtest=" + idtest +
                ", name='" + name + '\'' +
                ", qantity=" + qantity +
                '}';
    }
}
