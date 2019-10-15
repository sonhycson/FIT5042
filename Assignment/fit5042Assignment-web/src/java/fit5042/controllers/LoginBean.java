/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.controllers;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jerry
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {
    String username;
    String password;
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
        username = "";
        password = "";
    }
    
    public String login( )
    {
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance( ).getExternalContext( ).getRequest( );        
        try {
            request.login( username, password );
        }
        catch ( ServletException e ) {
            System.out.println("login error in login function in login bean");
            return null;
        }       
        return "http://localhost:8080/fit5042Assignment-web/admin/admin.xhtml";
    }
    
}
