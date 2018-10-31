/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobSystems;

import java.lang.reflect.Array;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Naik
 */
public interface IJobList extends Remote {
    public JobPost getJobPost(int id) throws RemoteException;
    public Array sortByCategory() throws RemoteException;
    
}
