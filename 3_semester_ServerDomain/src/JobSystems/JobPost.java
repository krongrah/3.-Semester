
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
    private String companyName;
    private String companyWebsite;
    

    public JobPost(int id, String title, String description, List<IUser> applicants, String companyName, String companyWebsite) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.applicants = applicants;
        this.companyName = companyName;
        this.companyWebsite = companyWebsite;
    }
    /*
    public JobPost(ResultSet set) throws SQLException{
        this.id = set.getInt("Id");
        this.title = set.getString("Title");
        this.description = set.getString("description");
            
    }*/
       
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