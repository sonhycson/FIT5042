package fit5042.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import fit5042.entities.Users;
import fit5042.mbeans.UserManagedBean;
import java.util.ArrayList;
import javax.el.ELContext;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

/**
 *
 * @author jerry
 */
@Named(value = "userApplication")
@ApplicationScoped
public class UserApplication {
    
    @ManagedProperty(value = "#{userManagedBean}")
    UserManagedBean userManagedBean;
    
    private ArrayList<Users> users;

    private boolean showForm = true;
    /**
     * Creates a new instance of UserApplication
     */   
    public UserApplication() throws Exception {
        users = new ArrayList<>();
        //instantiate propertyManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        userManagedBean = (UserManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "userManagedBean");
        //get properties from db 
        updateUserList();
    }

    public ArrayList<Users> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Users> users) {
        this.users = users;
    }
    
    public void updateUserList() {
       if (users != null && users.size() > 0){}
       else
       {
           users.clear();
           for (fit5042.entities.Users user : userManagedBean.getAllUsers())
           {
               users.add(user);
           }
           setUsers(users);
       }
    }
     
    public void searchUserById(Long userId) {
        users.clear();
        users.add(userManagedBean.searchUserById(userId));
    }
    
     public void searchAll()
    {
        users.clear();
        
        for (fit5042.entities.Users user: userManagedBean.getAllUsers())
        {
            users.add(user);
        }
        
        setUsers(users);
    }
    
}
