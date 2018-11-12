package commondata;

import ProjectInterfaces.IUser;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User implements IUser, Serializable {

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
     * Applicants name
     */
    private String name;
    /**
     * Has taken the personality test
     */
    private Boolean personalityTest=false;
    /**
     * Years of experience in their given field
     */
    private int experience;

    public User(ResultSet user) throws SQLException { //Can't determine whether its an applicant or company 
        while (user.next()) {
            username = user.getString("username");
            userId = user.getInt("userid");
            email = user.getString("email");
            phonenr = user.getInt("phonenr");
            address = user.getString("address");
            zipcode = user.getString("zipcode");
            city = user.getString("city");
            country = user.getString("country");
            region = user.getString("region");
            userId = user.getInt("userid");
            name = user.getString("username");
            //personalityTest=user.getBoolean("personalitytest");

        }

    }


    /**
     * Gets the email
     *
     * @return email address : String
     */
    @Override
    public String getEmail() {
        return email;
    }

    /**
     * Gets the phone number
     *
     * @return phonenumber : Integer
     */
    @Override
    public Integer getPhonenr() {
        return phonenr;
    }

    /**
     * Gets the address of the user
     *
     * @return Address : String
     */
    @Override
    public String getAddress() {
        return address;
    }

    /**
     * Gets the zipcode of the user
     *
     * @return zipcode : String
     */
    @Override
    public String getZipcode() {
        return zipcode;
    }

    /**
     * Gets the city of the user
     *
     * @return City : String
     */
    @Override
    public String getCity() {
        return city;
    }

    /**
     * Gets the country of the user
     *
     * @return country : String
     */
    @Override
    public String getCountry() {
        return country;
    }

    /**
     * Gets the region of the user
     *
     * @return region : String
     */
    @Override
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
    
        /**
     * Sets the years of experience the applicant has in their field
     *
     * @param experience : Integer
     */
    @Override
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
    @Override
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
