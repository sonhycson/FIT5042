/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.controllers;

import fit5042.entities.Users;
import fit5042.mbeans.UserManagedBean;
import javax.el.ELContext;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

/**
 *
 * @author jerry
 */
@Named(value = "registerUser")
@RequestScoped
public class RegisterUser {

    /**
     * Creates a new instance of registerUser
     */
    
    @ManagedProperty(value = "#{userManagedBean}")
    UserManagedBean userManagedBean;

    private boolean showForm = true;

    private Users user;

    UserApplication app;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public boolean isShowForm() {
        return showForm;
    }

    public RegisterUser() {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app = (UserApplication) FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "userApplication");

        //instantiate propertyManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        userManagedBean = (UserManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "userManagedBean");
    }

    public void addUser(Users localUser) {
        //this is the local property, not the entity
        try {
            //add this property to db via EJB
            userManagedBean.addUser(localUser);

            //refresh the list in PropertyApplication bean
             app.searchAll();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User has been added succesfully"));
        } catch (Exception ex) {

        }
        showForm = true;
    }
    
}
