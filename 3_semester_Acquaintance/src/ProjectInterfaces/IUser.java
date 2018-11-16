/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

/**
 *
 * @author Sebas
 */
public interface IUser {

    public int getUserId();

    public String getUsername();

    public Boolean getPersonalityTest();

    /**
     * Gets the email
     *
     * @return email address : String
     */
    public String getEmail();

    /**
     * Gets the phone number
     *
     * @return phonenumber : Integer
     */
    public Integer getPhonenr();

    /**
     * Gets the address of the user
     *
     * @return Address : String
     */
    public String getAddress();

    /**
     * Gets the zipcode of the user
     *
     * @return zipcode : String
     */
    public String getZipcode();

    /**
     * Gets the city of the user
     *
     * @return City : String
     */
    public String getCity();

    /**
     * Gets the country of the user
     *
     * @return country : String
     */
    public String getCountry();

    /**
     * Gets the region of the user
     *
     * @return region : String
     */
    public String getRegion();

    public void setExperience(int exp);
    
    public int getExperience();
    
    public void setLastJob(IJobPost jobPost);
    
    public IJobPost getLastJob();

}
