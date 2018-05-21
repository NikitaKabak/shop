package by.nikita.Entity;




import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "userrole")
public class UserRole {

    @Id
    private Integer idrole;

    @Column
    private String role;

    @OneToMany(mappedBy = "userRole", fetch = FetchType.EAGER)
    private List<User> listUser = new ArrayList<>();

    public UserRole(){
    }

    public UserRole(Integer idRole,String role){
        this.idrole = idRole;
        this.role = role;
    }

    public Integer getIdRole() {
        return idrole;
    }

    public void setIdRole(Integer idRole) {
        this.idrole = idRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getListUser() {
        return listUser;
    }

    public void setListUser(List<User> listUser) {
        this.listUser = listUser;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "idRole=" + idrole +
                ", role='" + role + '\'' +
                '}';
    }
}
