/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commondata;

import ProjectInterfaces.IJobPost;
import ProjectInterfaces.IUser;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Krongrah
 */
public class JobPost implements IJobPost, Serializable {

    private int id;
    private String title;
    private String description;
    //private List<IUser> applicants;
    private String companyName;
    private String companyWebsite;

    public JobPost(ResultSet set) throws SQLException {
        this.id = set.getInt("id");
        this.title = set.getString("title");
        this.description = set.getString("description");
        this.companyName = set.getString("companyname");
        this.companyWebsite = set.getString("website");

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
