/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Naik
 */
public interface IJobPost{
    
    public void addApplicant(IUser applicant);
    
<<<<<<< HEAD
    public int getId();
=======
    public void setApplicants(ResultSet set) throws SQLException;
    
    public void setCompany(ResultSet set) throws SQLException;
    
    public int getId();
    
>>>>>>> master
    
}
