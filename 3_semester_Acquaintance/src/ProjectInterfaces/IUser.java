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
    /**
     * When the user takes the personality test
     */
    public void doTest();
    
    public void setEmail(String email);

    public void setPhonenr(Integer phonenr);

    public void setAddress(String address); 

    public void setZipcode(String zipcode); 
            
    public void setCity(String city); 

    public void setCountry(String country);    

    public void setRegion(String region); 
        
    
}
