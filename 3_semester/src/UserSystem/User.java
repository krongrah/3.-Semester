/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserSystem;

import ProjectInterfaces.IUser;

/**
 *
 * @author Sebas
 */
public class User implements IUser {

    /**
     * Username
     */
    private String username;
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

    /**
     * User constructor
     *
     * @param email : String
     * @param phonenr : String
     * @param address : String
     * @param zipcode : String
     * @param city : String
     * @param country : String
     * @param region : String
     */
    public User(boolean isCompany, String email, Integer phonenr, String address, String zipcode, String city, String country, String region) {
        this.isCompany = isCompany;
        this.email = email;
        this.phonenr = phonenr;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;
        this.region = region;
    }

    /**
     * When the user takes the personality test Changes a value related to test
     * whether or not the user has taken the test
     */
    public void doTest() {
        //todo
    }

    /**
     * gets the username of the given user
     *
     * @return Username : String
     */
    @Override
    public String getUsername() {
        return username;
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
