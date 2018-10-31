/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobSystems;

import java.util.List;
import UserSystem.Applicant;
import java.rmi.server.UnicastRemoteObject;


/**
 *The JobPost is the class that holds information about a certain job.
 * @author Naik
 */
class JobPost extends UnicastRemoteObject implements IJobPost {
    private int id;
    private String title;
    private String description;
    private List<Applicant> Applicants;
       
    
    @Override
    public void addApplicant(Applicant a){
    }
    
    @Override
    public Applicant getSortedList(){
        return null;
        
    }
    
    public int getID(){
        return 0;
        
    }
}
