package br.com.belluzzibolos.lojabolosback.dto.request;

public class RequestRegister {
    private Integer id;
    private String userName;
    private String userPassword;
    private String userPermission;
    private String fullName;

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

    public String getUserPermisson() {
        return userPermission;
    }

    public void setUserPermisson(String userPermisson) {
        this.userPermission = userPermisson;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
