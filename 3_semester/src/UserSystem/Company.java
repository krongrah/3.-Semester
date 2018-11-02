/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserSystem;

import commondata.User;

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
     * @param username
     * @param userId
     * @param companyName
     * @param website
     * @param email
     * @param phonenr
     * @param address
     * @param zipcode
     * @param city
     * @param country
     * @param region 
     */
    public Company(String username, int userId, String companyName, String website, String email, Integer phonenr, String address, String zipcode, String city, String country, String region) {
        super(username, userId, true, email, phonenr, address, zipcode, city, country, region);
        this.companyName = companyName;
        this.website = website;
    }
    
    public String getCompanyName(){
        return companyName;
    }
    
    public String getWebsite(){
        return website;
    }

}
