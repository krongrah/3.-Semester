
package JobSystems;

import ProjectInterfaces.IJobPost;
import ProjectInterfaces.IUser;
import java.util.List;
import UserSystem.Applicant;
import UserSystem.Company;
import java.sql.ResultSet;
import java.sql.SQLException;


class JobPost implements IJobPost {
    
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
       
    @Override
    public void setApplicants(ResultSet set) throws SQLException{
        while(set.next()){
            applicants.add(new Applicant(set));
        }
            
    }
    
    @Override
    public void setCompany(ResultSet set) throws SQLException{
        this.company = new Company(set);
    }
    
    private IUser getCompanyUser(ResultSet set) throws SQLException{
        return jobmanager.getInstance().getCompanyUser(id); 
    }
    
    @Override
    public void addApplicant(IUser applicant){
        applicants.add(applicant);

    }
  
    @Override
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