package UserSystem;

import ProjectInterfaces.IUser;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sebas
 */
public class User implements IUser {
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
     * Zipcode for the address
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

    public User(){
        
    }
    
    /**
     * User constructor
     * @param email : String
     * @param phonenr : Integer
     * @param address : String
     * @param zipcode : String
     * @param city : String
     * @param country : String
     * @param region : String
     */
    public User(String email, Integer phonenr, String address, String zipcode, String city, String country, String region) {
        this.email = email;
        this.phonenr = phonenr;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;
        this.region = region;
    }

    public User(ResultSet user) throws SQLException { //Can't determine whether its an applicant or company 
        email = user.getString("Email");
        phonenr = user.getInt("phonenr");
        address = user.getString("address");
        zipcode = user.getString("zipcode");
        city = user.getString("city");
        country = user.getString("country");
        region = user.getString("region");
        
        
    }

    /**
     * When the user takes the personality test
     * Changes a value related to test whether or not the user has taken the test
     */
    public void doTest(){
        //todo
    }

    /**
     * Gets the email
     * @return email address : String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the phone number
     * @return phonenumber : Integer
     */
    public Integer getPhonenr() {
        return phonenr;
    }

    /**
     * Gets the address of the user
     * @return Address : String
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets the zipcode of the user
     * @return zipcode : String
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * Gets the city of the user
     * @return City : String
     */
    public String getCity() {
        return city;
    }

    /**
     * Gets the country of the user
     * @return country : String
     */
    public String getCountry() {
        return country;
    }

    /**
     * Gets the region of the user
     * @return region : String
     */
    public String getRegion() {
        return region;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setPhonenr(Integer phonenr) {
        this.phonenr = phonenr;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public void setRegion(String region) {
        this.region = region;
    }
    
    
    
}
