/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commondata;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sebas
 */
public class Applicant extends User implements Serializable{

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
     * Gender of the applicant
     */
    private String gender;

    /**
     * Applicant constructor method
     *
     * @param username
     * @param userId
     * @param name : String
     * @param personalityTest : Boolean
     * @param gender
     * @param experience : Integer
     * @param email : String
     * @param phonenr : String
     * @param address : String
     * @param zipcode : String
     * @param city : String
     * @param country : String
     * @param region : String
     */
    public Applicant(String username, int userId, String name, Boolean personalityTest, String gender, int experience, String email, Integer phonenr, String address, String zipcode, String city, String country, String region) {
        super(username, userId, false, email, phonenr, address, zipcode, city, country, region);
        this.name = name;
        this.personalityTest = personalityTest;
        this.gender = gender;
        this.experience = experience;
    }
    
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
     * Gets the gender of the user
     * @return gender : String
     */
    public String getGender(){
        return gender;
    }
    
    /**
     * Gets the years of experience the applicant has
     * @return experience : integer
     */
    public int getExperience() {
        return experience;
    }
}
