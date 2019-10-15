/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.businessInterface;

import fit5042.entities.Animal;
import fit5042.entities.Users;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.ejb.Remote;

/**
 *
 * @author jerry
 */
@Remote
public interface UserRepository {
    
    public void addUser(Users user) throws Exception;
    
    public void removeUser(Long userId) throws Exception;

    public void editUser(Users user) throws Exception;

    public Users searchUserById(Long id) throws Exception;
    
    public List<Users> searchUserByUsername(String username) throws Exception;
    
    public List<Users> searchUserByUserType(String usertype) throws Exception;
    
//    public List<Users> searchUserByDOB(Date dob) throws Exception;
    
    public List<Users> searchUserByEmail(String userEmail) throws Exception;
    
    public List<Users> searchUserByGender(String userGender) throws Exception;
    
    public List<Users> searchUserByPhoneNo(String userPhoneNo) throws Exception;

    public List<Users> getAllUsers() throws Exception;
  
    public List<Animal> getAllFavouriteAnimals() throws Exception;

    
}
