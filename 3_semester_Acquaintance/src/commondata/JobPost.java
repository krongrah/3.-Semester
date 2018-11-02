/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commondata;

import ProjectInterfaces.IJobPost;
import ProjectInterfaces.IUser;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Krongrah
 */
public class JobPost implements IJobPost{

    private int id;
    private String title;
    private String description;
    private List<IUser> applicants;
    private String companyName;
    private String companyWebsite;
    

    public JobPost(int id, String title, String description, List<IUser> applicants) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.applicants = applicants;
    }
    
    public JobPost(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
    
//    public JobPost(ResultSet set) throws SQLException{
//        this.id = set.getInt("Id");
//        this.title = set.getString("Title");
//        this.description = set.getString("description");
//            
//    }
    
    public JobPost(int id, String title, String description, String companyName, String companyWebsite, List<IUser> applicants) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.applicants = applicants;
        this.companyName = companyName;
        this.companyWebsite = companyWebsite;
        this.applicants = applicants;
    }


    
 
    @Override
    public void addApplicant(IUser applicant){
        applicants.add(applicant);

    }
  
    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getCompanyName() {
        return companyName;
    }

    @Override
    public String getCompanyWebsite() {
        return companyWebsite;
    }
    
}
