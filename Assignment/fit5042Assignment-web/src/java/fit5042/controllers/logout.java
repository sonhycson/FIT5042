/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.controllers;

import java.util.Collections;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jerry
 */
@Named(value = "logout")
@RequestScoped
public class logout {
    
    public logout() {
    }
    
    public String logoutMethod() {
    
        
        try {
              ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//              FacesContext context = FacesContext.getCurrentInstance();
//              context.getExternalContext().invalidateSession();
              HttpSession session = (HttpSession) ec.getSession(false);
              HttpServletResponse httpResponse = (HttpServletResponse) ec.getResponse();
              httpResponse.setHeader("Cache-Control", "private,no-store,no-cache");
              session.invalidate();
              System.out.print("logout successfully");
              ec.redirect("http://localhost:8080/fit5042Assignment-web/index.xhtml");
        } catch (Exception e) {
              System.out.print("Error when logging out");
        }
//        if (ec.getRequestCookieMap().get("opentoken") != null) {
//            System.out.println("fit5042.controllers.logout.logout() error");
//            ec.addResponseCookie("opentoken", null, Collections.<String, Object>singletonMap("maxAge", 0));
//    }


        return "http://localhost:8080/fit5042Assignment-web/index.xhtml?faces-redirect=true";
    }
    
    
}
