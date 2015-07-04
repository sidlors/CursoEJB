package com.example;

import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class SecurityBean {

    @Inject
    private Principal principal;
    private String userName;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPrincipalName() {
        //If not logged in this returns "<anonymous>" on WLS
        //If not logged in this returns "ANONYMOUS" on GF
        return principal.getName();
    }
    
    // Methods like this are useful when you need to see if someone is in any one of several roles
    public boolean isAdmin() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        return externalContext.isUserInRole("admin");
    }

    public String login() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        try {
            request.login(userName, password);
        } catch (ServletException ex) {
            Logger.getLogger(SecurityBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String logout() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        try {
            request.logout();
        } catch (ServletException ex) {
            Logger.getLogger(SecurityBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}