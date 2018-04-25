package by.nikita.dao;

public class User {
    private String nameUser;
    private String passwordUser;
    private String emailUser;
    private int idUser;
    private int idRole;
    private int idStatus;

    public User(){}


    public User(int idUser, String nameUser, String passwordUser, String emailUser, int idRole, int idStatus) {
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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
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
