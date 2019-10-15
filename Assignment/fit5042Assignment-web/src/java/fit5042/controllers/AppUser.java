/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.controllers;

import fit5042.entities.Favouriteanimal;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jerry
 */
@Named(value = "appUser")
@RequestScoped
public class AppUser implements Serializable{
    private Long id;
    private String username;
    private String password;
    private String usertype;
    private Date dob;
    private String email;
    private String gender;
    private String phoneno;
    private Collection<Favouriteanimal> favouriteanimalCollection;
    
    public String getCurrentUsername(){
        String username = "";
        try {
              ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//              FacesContext context = FacesContext.getCurrentInstance();
//              context.getExternalContext().invalidateSession();
              HttpSession session = (HttpSession) ec.getSession(false);
              username = ec.getUserPrincipal().getName();
//              HttpServletResponse httpResponse = (HttpServletResponse) ec.getResponse();
//              HttpServletRequest httpRequest = (HttpServletRequest) ec.getRequest();
//              username = httpRequest.getRemoteUser();
        } catch (Exception e) {
              System.out.print("Error when getting username");
        }
        return username;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public Collection<Favouriteanimal> getFavouriteanimalCollection() {
        return favouriteanimalCollection;
    }

    public void setFavouriteanimalCollection(Collection<Favouriteanimal> favouriteanimalCollection) {
        this.favouriteanimalCollection = favouriteanimalCollection;
    }
    /**
     * Creates a new instance of RegisterUser
     */
    public AppUser() {
    }
    
}
