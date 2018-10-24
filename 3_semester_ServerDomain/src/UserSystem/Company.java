/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserSystem;

/**
 *
 * @author Sebas
 */
public class Company extends User{
    private String companyName;
    private String website;

    public Company(String companyName, String website, String email, Integer phonenr, String address, String zipcode, String city, String country, String region) {
        super(email, phonenr, address, zipcode, city, country, region);
        this.companyName = companyName;
        this.website = website;
    }

}
