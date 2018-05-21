package by.nikita.Entity;




import by.nikita.Entity.UserRole;

import javax.persistence.*;
import java.io.Serializable;


@Entity
/*@OneToOne
    BIDIRECTIONAL(mappedBy, UNIDIRECTIONAL without  mappedBy)*/
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;
    @Column
    private String nameUser;
    @Column
    private String passwordUser;
    @Column
    private String emailUser;

    @Column(name = "idrole")
    private Integer idRole;

    @Column(name = "idstatus")
    private Integer idStatus;

    @ManyToOne
    @JoinColumn(name = "idrole", insertable = false, updatable = false)
    private UserRole userRole;

    @ManyToOne
    @JoinColumn(name = "idstatus", insertable = false, updatable = false)
    private Userstatus userStatus;


   /* @JoinColumn (name = "idrole")
    private UserRole userRole;
*/
    public User() {
    }


    public User(Integer idUser, String nameUser, String passwordUser, String emailUser, Integer idRole, Integer idStatus) {
        this.nameUser = nameUser;
        this.passwordUser = passwordUser;
        this.emailUser = emailUser;
        this.idUser = idUser;
        this.idRole = idRole;
        this.idStatus = idStatus;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }


    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Userstatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Userstatus userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "nameUser='" + nameUser + '\'' +
                ", passwordUser='" + passwordUser + '\'' +
                ", emailUser='" + emailUser + '\'' +
                ", idUser=" + idUser +
                ", idRole=" + idRole +
                ", idStatus=" + idStatus +
                '}';
    }
}
