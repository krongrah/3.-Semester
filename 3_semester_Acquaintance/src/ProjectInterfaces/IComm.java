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
    
    //todo add methods calls going to the server
    public IQuestionSet getQuestionSet() throws RemoteException;
    public IUser login(String username, String hashedPwd)throws RemoteException;
    
    
}
