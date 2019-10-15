/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.mbeans;

import fit5042.businessInterface.UserRepository;
import fit5042.controllers.AppUser;
import fit5042.entities.Animal;
import fit5042.entities.Users;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author jerry
 */
@Named(value = "userManagedBean")
@SessionScoped
public class UserManagedBean implements Serializable {
    
    @EJB
    UserRepository userRepository;
    
//    RadioButton userGender;
//    String genderString = "unknown";
    /**
     * Creates a new instance of userManagedBean
     */
    public UserManagedBean() {
    }
    
    /**
     *
     * @return
     */
    public List<Users> getAllUsers() {
        try {
            List<Users> properties = userRepository.getAllUsers();
            return properties;
        } catch (Exception ex) {
            Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void addUser(Users user) {
        try {
            userRepository.addUser(user);
        } catch (Exception ex) {
            Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public void removeUser(Long userId) {
        try {
            userRepository.removeUser(userId);
        } catch (Exception ex) {
            Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//      public void getRadioChange(){
//          genderString =userGender.getText();   
//      }
       public void editUser(Users user) {
        try {

//            String s = property.getAddress().getStreetNumber();
              
//            Address address = property.getAddress();
//            address.setStreetNumber(s);
//            property.setAddress(address);
//            propertyRepository.editProperty(property);
//            if (genderString != "unknown"){
//                user.setGender(genderString);
//            }
            System.out.println(user.getUsername());
            System.out.println(user.getGender());
            userRepository.editUser(user);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User has been updated succesfully"));
        } catch (Exception ex) {
            Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
           /**
     * Search a property by Id
     */
    public Users searchUserById(Long userId) {
        try {
            return userRepository.searchUserById(userId);
        } catch (Exception ex) {
            Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
       
    public List<Users> searchUserByUsername(String username) throws Exception{
        try {
            return userRepository.searchUserByUsername(username);
        } catch (Exception ex) {
            Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    public List<Users> searchUserByUserType(String usertype) throws Exception{
        try {
            return userRepository.searchUserByUserType(usertype);
        } catch (Exception ex) {
            Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
//    public List<Users> searchUserByDOB(Date dob) throws Exception;
    
    public List<Users> searchUserByEmail(String userEmail) throws Exception{
        try {
            return userRepository.searchUserByEmail(userEmail);
        } catch (Exception ex) {
            Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    public List<Users> searchUserByGender(String userGender) throws Exception{
        try {
            return userRepository.searchUserByGender(userGender);
        } catch (Exception ex) {
            Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    public List<Users> searchUserByPhoneNo(String userPhoneNo) throws Exception{
        try {
            return userRepository.searchUserByPhoneNo(userPhoneNo);
        } catch (Exception ex) {
            Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
  
//    public List<Animal> getAllFavouriteAnimals() throws Exception{
//        
//    }


}
