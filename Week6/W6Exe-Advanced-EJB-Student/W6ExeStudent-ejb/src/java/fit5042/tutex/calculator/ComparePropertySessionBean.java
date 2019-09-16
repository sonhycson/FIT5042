/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.calculator;

import fit5042.tutex.repository.entities.Property;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.CreateException;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jerry
 */
@Stateful
public class ComparePropertySessionBean implements ComparePropertySessionBeanRemote{
    @PersistenceContext(unitName = "W6ExeStudent-ejbPU")
    private EntityManager entityManager;
    ArrayList<Integer> list;
    
    @Override
    public void addProperty(int propertyId){
        list.add(propertyId);
    }
    
    @Override
    public void removeProperty(int propertyId){
        list.remove(new Integer(propertyId));
    }

    
    @Override
    public int bestPerRoom(){
        Integer bestID=0;
        Property property;
        int numberOfRooms;
        double price;
        double bestPerRoom=100000000.00;
        for(Integer propertyID : list)
        {
            property = entityManager.find(Property.class, propertyID);
            numberOfRooms = property.getNumberOfBedrooms();
            price = property.getPrice();
            if(price/numberOfRooms<bestPerRoom)
            {
                bestPerRoom = price/numberOfRooms;
                bestID = property.getPropertyId();
            }
        }
        return bestID;
        
    }
    
    @PostConstruct
    public void init() {
        list=new ArrayList<>();
    }

    public ComparePropertySessionBeanRemote create() throws CreateException, RemoteException {
        return null;
    }

    public void ejbCreate() throws CreateException {
    }
    
}
