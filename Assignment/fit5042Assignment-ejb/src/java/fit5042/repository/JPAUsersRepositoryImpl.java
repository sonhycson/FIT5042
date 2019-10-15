/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.repository;

import fit5042.businessInterface.UserRepository;
import fit5042.entities.Animal;
import fit5042.entities.Users;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author jerry
 */
@Stateless
public class JPAUsersRepositoryImpl implements UserRepository{
    
    @PersistenceContext (unitName = "fit5042Assignment-ejbPU")
    private EntityManager entityManager;
    @Override 
    public void addUser(Users user) throws Exception{
        List<Users> users = entityManager.createNamedQuery("Users.findAll").getResultList();
        user.setId(users.get(0).getId()+ 1);
        entityManager.persist(user);
    }
    @Override 
    public void removeUser(Long userId) throws Exception{
        Users u = searchUserById(userId);
        entityManager.remove(u);
    }
    @Override 
    public void editUser(Users user) throws Exception{
        try {
            entityManager.merge(user);
        } catch (Exception ex) {

        }
    }
    @Override 
    public Users searchUserById(Long id) throws Exception{
        Users user = entityManager.find(Users.class, id);
        return user;
    }
    @Override 
    public List<Users> searchUserByUsername(String username) throws Exception{
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Users.class);
        Root<Users> u = query.from(Users.class);
        query.select(u);
        Predicate predicate = builder.equal(u.get("username").as(String.class), username);
        query.where(predicate);
        return entityManager.createQuery(query).getResultList();
    }
    @Override 
    public List<Users> searchUserByUserType(String usertype) throws Exception{
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Users.class);
        Root<Users> u = query.from(Users.class);
        query.select(u);
        Predicate predicate = builder.equal(u.get("usertype").as(String.class), usertype);
        query.where(predicate);
        return entityManager.createQuery(query).getResultList();
    }
//    @Override 
//    public List<Users> searchUserByDOB(Date dob) throws Exception{
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        CriteriaQuery query = builder.createQuery(Users.class);
//        Root<Users> u = query.from(Users.class);
//        query.select(u);
//        Predicate predicate = builder.equal(u.get("username").as(String.class), username);
//        query.where(predicate);
//        return entityManager.createQuery(query).getResultList();
//    }
    @Override 
    public List<Users> searchUserByEmail(String userEmail) throws Exception{
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Users.class);
        Root<Users> u = query.from(Users.class);
        query.select(u);
        Predicate predicate = builder.equal(u.get("useremail").as(String.class), userEmail);
        query.where(predicate);
        return entityManager.createQuery(query).getResultList();
    }
    @Override 
    public List<Users> searchUserByGender(String userGender) throws Exception{
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Users.class);
        Root<Users> u = query.from(Users.class);
        query.select(u);
        Predicate predicate = builder.equal(u.get("usergender").as(String.class), userGender);
        query.where(predicate);
        return entityManager.createQuery(query).getResultList();
    }
    @Override 
    public List<Users> searchUserByPhoneNo(String userPhoneNo) throws Exception{
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Users.class);
        Root<Users> u = query.from(Users.class);
        query.select(u);
        Predicate predicate = builder.equal(u.get("username").as(String.class), userPhoneNo);
        query.where(predicate);
        return entityManager.createQuery(query).getResultList();
    }
    @Override 
    public List<Users> getAllUsers() throws Exception{
        return entityManager.createNamedQuery("Users.findAll").getResultList();
    }
    @Override 
    public List<Animal> getAllFavouriteAnimals() throws Exception{
        return null; 
    }
}
