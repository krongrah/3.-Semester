/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobSystems;
import UserSystem.Applicant;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Naik
 */
public interface IJobPost extends Remote {
    
    
    public void addApplicant(Applicant a) throws RemoteException;
    
    public Applicant getSortedList() throws RemoteException;
}
