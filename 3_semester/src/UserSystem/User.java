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
    private String email;
    private Integer phonenr;
    private String address;
    private String zipcode;
    private String city;
    private String country;
    private String region;

    public User(String email, Integer phonenr, String address, String zipcode, String city, String country, String region) {
        this.email = email;
        this.phonenr = phonenr;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;
        this.region = region;
    }

    public void doTest(){
        
    }

    public String getEmail() {
        return email;
    }

    public Integer getPhonenr() {
        return phonenr;
    }

    public String getAddress() {
        return address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }
    
    
}
