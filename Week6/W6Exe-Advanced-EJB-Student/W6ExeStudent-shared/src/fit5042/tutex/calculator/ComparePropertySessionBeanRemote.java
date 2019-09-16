/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.calculator;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.Remote;

/**
 *
 * @author jerry
 */
@Remote
public interface ComparePropertySessionBeanRemote {
    public void addProperty(int porpertyId);
    public void removeProperty(int porpertyId);
    public int bestPerRoom();
    ComparePropertySessionBeanRemote create() throws CreateException, RemoteException;
    
}
