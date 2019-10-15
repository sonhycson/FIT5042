/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.controllers;

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
@Named(value = "removeUser")
@RequestScoped
public class RemoveUser {

     @ManagedProperty(value = "#{userManagedBean}")
     UserManagedBean userManagedBean;

    private boolean showForm = true;

    //private final ArrayList<fit5042.tutex.repository.entities.Property> properties;
    private AppUser user;

    UserApplication app;

    
    public boolean isShowForm() {
        return showForm;
    }

    public void setShowForm(boolean showForm) {
        this.showForm = showForm;
    }

    public AppUser getUser() {
        return user;
    }

    /**
     * Creates a new instance of RemoveUser
     */
    public void setUser(AppUser user) {    
        this.user = user;
    }

    public RemoveUser() {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app = (UserApplication) FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "userApplication");

        app.updateUserList();

        //instantiate propertyManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        userManagedBean = (UserManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "userManagedBean");
    }
    
    public void removeUser(Long userId) {
        try {
            //remove this property from db via EJB
            userManagedBean.removeUser(userId);

            //refresh the list in PropertyApplication bean
             app.searchAll();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User has been deleted succesfully"));
        } catch (Exception ex) {

        }
        showForm = true;

    }
}
