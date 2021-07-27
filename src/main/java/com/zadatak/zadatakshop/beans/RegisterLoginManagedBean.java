
package com.zadatak.zadatakshop.beans;

import com.zadatak.zadatakshop.entity.Privilege;
import com.zadatak.zadatakshop.entity.User;
import com.zadatak.zadatakshop.entity.facade.PrivilegeFacadeLocal;
import com.zadatak.zadatakshop.entity.facade.UserFacadeLocal;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "registerLoginManagedBean")
@SessionScoped
public class RegisterLoginManagedBean implements Serializable{
    private String username;
    private String password;
    private String name;
    private String surname;
    
    @Inject
    UserFacadeLocal userFacadeLocal;
    @Inject
    PrivilegeFacadeLocal privilegeFacadeLocal;
    
    public String login(){
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return "";
        }
        User user = userFacadeLocal.login(username, password);
        if (user == null) {
            return "";
        }else{
            Privilege privilege = user.getPrivilegeId();
            if ("READ".equals(privilege.getName())) {
                return "read";
            }else{
                return "write";
            }
        }
    }
    public String register(){
        boolean userCreated = userFacadeLocal.register(username, password, name, surname);
        if (userCreated) {
            return "index";
        }
        return "register";
    }
   
    public RegisterLoginManagedBean() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}

