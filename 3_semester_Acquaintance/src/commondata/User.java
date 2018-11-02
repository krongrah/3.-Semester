/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commondata;

import ProjectInterfaces.IUser;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User implements IUser {

    /**
     * Whether the user is a company user
     */
    private boolean isCompany;
    /**
     * Email
     */
    private String email;
    /**
     * Phone number
     */
    private Integer phonenr;
    /**
     * Address of residence
     */
    private String address;
    /**
     * Zip code for the address
     */
    private String zipcode;
    /**
     * City of residence
     */
    private String city;
    /**
     * Country of residence
     */
    private String country;
    /**
     * Region of residence
     */
    private String region;
    
    private int userId;
    
    private String username;

    /**
     * User constructor
     *
     * @param username
     * @param userId
     * @param isCompany
     * @param email : String
     * @param phonenr : String
     * @param address : String
     * @param zipcode : String
     * @param city : String
     * @param country : String
     * @param region : String
     */
    public User(String username, int userId, boolean isCompany, String email, Integer phonenr, String address, String zipcode, String city, String country, String region) {
        this.isCompany = isCompany;
        this.email = email;
        this.phonenr = phonenr;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;
        this.region = region;
        this.userId=userId;
        this.username=username;
    }
    
        public User(ResultSet user) throws SQLException { //Can't determine whether its an applicant or company 
        email = user.getString("Email");
        phonenr = user.getInt("phonenr");
        address = user.getString("address");
        zipcode = user.getString("zipcode");
        city = user.getString("city");
        country = user.getString("country");
        region = user.getString("region");
        userId = user.getInt("userid");
        isCompany=user.getBoolean("IsCompany");
        
        
    }


    /**
     * gets whether the user is a company
     */
    public boolean getIsCompany() {
        return isCompany;
    }

    /**
     * Gets the email
     *
     * @return email address : String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the phone number
     *
     * @return phonenumber : Integer
     */
    public Integer getPhonenr() {
        return phonenr;
    }

    /**
     * Gets the address of the user
     *
     * @return Address : String
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets the zipcode of the user
     *
     * @return zipcode : String
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * Gets the city of the user
     *
     * @return City : String
     */
    public String getCity() {
        return city;
    }

    /**
     * Gets the country of the user
     *
     * @return country : String
     */
    public String getCountry() {
        return country;
    }

    /**
     * Gets the region of the user
     *
     * @return region : String
     */
    public String getRegion() {
        return region;
    }


    @Override
    public int getUserId() {
      return userId;
    }

    @Override
    public String getUsername() {
       return username;
    }

}
