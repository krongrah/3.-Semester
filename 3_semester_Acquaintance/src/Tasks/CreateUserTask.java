/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;

/**
 *
 * @author ahmadhamid
 */
public class CreateUserTask extends Task {
    private String fullName;
    private String mail;
    private String address;
    private String country;
    private String city;
    private String zipCode;
    private String gender;
    private String userName;
    private String password;

    public CreateUserTask(String fullName, String mail, String address, String country, String city, String zipCode, String gender, String userName, String password) {
        super(TaskTypes.CREATEUSER);
        this.fullName = fullName;
        this.mail = mail;
        this.address = address;
        this.country = country;
        this.city = city;
        this.zipCode = zipCode;
        this.gender = gender;
        this.userName = userName;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getMail() {
        return mail;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getGender() {
        return gender;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    
    
    
    
}
