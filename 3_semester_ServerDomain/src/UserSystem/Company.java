/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserSystem;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sebas
 */
public class Company extends User{
    /**
     * A given company's name
     */
    private String companyName;
    /**
     * The website of the company
     */
    private String website;

    /**
     * Company constructor
     * @param companyName : String
     * @param website : String
     * @param email : String
     * @param phonenr : Integer
     * @param address : String
     * @param zipcode : String
     * @param city : String
     * @param country : String
     * @param region  : String
     * @param id
     */
    public Company(String companyName, String website, String email, Integer phonenr, String address, String zipcode, String city, String country, String region, int id) {
        super(email, phonenr, address, zipcode, city, country, region, id);
        this.companyName = companyName;
        this.website = website;
    }
    
    public Company(ResultSet set) throws SQLException{
        this.companyName = set.getString("CompanyName");
        this.website = set.getString("Website");
        
    }

}
