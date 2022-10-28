package br.com.belluzzibolos.lojabolosback.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TB_USER")
public class LoginModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_PASSWORD")
    private String userPassword;

    @Column(name = "USER_CREATED_DATA")
    private Date dateCreated;

    @Column(name = "USER_FULLNAME")
    private String fullName;

    @Column(name = "USER_PERMISSION")
    private String userPermission;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserPermission() {
        return userPermission;
    }

    public void setUserPermission(String userPermission) {
        this.userPermission = userPermission;
    }

    public LoginModel() {
    }

    public LoginModel(Integer id, String userName, String userPassword, Date dateCreated, String fullName, String userPermission) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.dateCreated = dateCreated;
        this.fullName = fullName;
        this.userPermission = userPermission;
    }
}
