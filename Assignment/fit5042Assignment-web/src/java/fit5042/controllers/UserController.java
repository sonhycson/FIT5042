/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.controllers;

import javax.inject.Named;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jerry
 */
@Named(value = "userController")
@RequestScoped
public class UserController implements Serializable {
    private int userId;
    private fit5042.entities.Users user;
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public UserController() {
        // Assign property identifier via GET param 
        //this propertyID is the index, don't confuse with the Property Id

        userId = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("userId"));
        System.out.println(userId);
        // Assign property based on the id provided 
        user = getUser();
    }

    public fit5042.entities.Users getUser() {
        if (user == null) {
            // Get application context bean PropertyApplication 
            ELContext context
                    = FacesContext.getCurrentInstance().getELContext();
            UserApplication app
                    = (UserApplication) FacesContext.getCurrentInstance()
                            .getApplication()
                            .getELResolver()
                            .getValue(context, null, "userApplication");
            // -1 to propertyId since we +1 in JSF (to always have positive property id!) 
//            int userIntId = userId.intValue();
            return app.getUsers().get(--userId); //this propertyId is the index, don't confuse with the Property Id
        }
        return user;
    }
}
