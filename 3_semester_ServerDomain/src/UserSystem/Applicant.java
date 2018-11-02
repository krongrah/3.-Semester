/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserSystem;

import commondata.User;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sebas
 */
public class Applicant extends User {

    /**
     * Applicants name
     */
    private String name;
    /**
     * Has taken the personality test
     */
    private Boolean personalityTest;
    /**
     * Years of experience in their given field
     */
    private int experience;

    /**
     * Applicant constructor method
     *
     * @param set
     * @param name : String
     * @param personalityTest : Boolean
     * @param experience : Integer
     * @param email : String
     * @param phonenr : String
     * @param address : String
     * @param zipcode : String
     * @param city : String
     * @param country : String
     * @param region : String
     * @param id
     * @throws java.sql.SQLException
     */
//    public Applicant(int id,String name, Boolean personalityTest, int experience, String email, Integer phonenr, String address, String zipcode, String city, String country, String region) {
//        super(email, phonenr, address, zipcode, city, country, region,id);
//        this.name = name;
//        this.personalityTest = personalityTest;
//        this.experience = experience;
//        
//    }
    
    public Applicant(ResultSet set) throws SQLException{
        super(set);
        this.name = set.getString("Name");
    }

    /**
     * Sets the years of experience the applicant has in their field
     *
     * @param experience : Integer
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }


    /**
     * Gets the name of the applicant
     *
     * @return Name : String
     */
    public String getName() {
        return name;
    }

    /**
     * Gets whether or not the personality test has been completed
     * @return personalityTest : Boolean
     */
    public Boolean getPersonalityTest() {
        return personalityTest;
    }

    /**
     * Gets the years of experience the applicant has
     * @return experience : integer
     */
    public int getExperience() {
        return experience;
    }
}
