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
public class Applicant extends User {
    private String name;
    private Boolean personalityTest;
    private int experience;

    public Applicant(String name, Boolean personalityTest, int experience, String email, Integer phonenr, String address, String zipcode, String city, String country, String region) {
        super(email, phonenr, address, zipcode, city, country, region);
        this.name = name;
        this.personalityTest = personalityTest;
        this.experience = experience;
    }
    
    public void setExperience(int experience){
        this.experience = experience;
    }
    
    public void applyForJob(){
        
    }

    public String getName() {
        return name;
    }

    public Boolean getPersonalityTest() {
        return personalityTest;
    }

    public int getExperience() {
        return experience;
    }
}
