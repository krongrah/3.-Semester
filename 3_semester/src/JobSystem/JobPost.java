/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobSystem;

import ProjectInterfaces.IJobPost;
import ProjectInterfaces.IUser;
import UserSystem.Applicant;
import UserSystem.Company;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Naik
 */
public class JobPost implements IJobPost {
    private int id;
    private String title;
    private String description;
    private List<IUser> applicants;
    private Company company;
    private static JobsManager jobmanager;
    

    public JobPost(int id, String title, String description, List<IUser> applicants) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.applicants = applicants;
    }
    
    public JobPost(ResultSet set) throws SQLException{
        this.id = set.getInt("Id");
        this.title = set.getString("Title");
        this.description = set.getString("description");
            
    }
      /* 
    public void setApplicants(ResultSet set) throws SQLException{
        while(set.next()){
            applicants.add(new Applicant(set));
        }
            
    }
    
    public void setCompany(ResultSet set) throws SQLException{
        this.company = new Company(set);
    }
    */
    private IUser getCompanyUser(ResultSet set) throws SQLException{
        return jobmanager.getInstance().getCompanyUser(id);

       
    }
    
 
    public void addApplicant(IUser applicant){
        applicants.add(applicant);

    }
  
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<IUser> getApplicants() {
        return applicants;

    


    }
    
}