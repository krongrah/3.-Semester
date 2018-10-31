/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Krongrah
 */
public interface IComm extends Remote{
    
    public IQuestionSet getQuestionSet() throws RemoteException;
    public TestObject getTest() throws RemoteException;
    
}
