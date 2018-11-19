/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Common.IController;
import GUI.GuiFacade;
import ProjectInterfaces.IClientDomain;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Sebas
 */
public class SignUpController implements Initializable, IController<ScreenController> {

    @FXML
    private AnchorPane SignUpScreen;
    private ScreenController screenController;
    @FXML
    private TextField fullName;
    @FXML
    private TextField mail;
    @FXML
    private TextField address;
    @FXML
    private MenuButton country;
    @FXML
    private TextField city;
    @FXML
    private TextField zipCode;
    @FXML
    private MenuButton gender;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    
    private IClientDomain domain;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        domain = GuiFacade.getDomain();
    }

    @FXML
    private void cancelSignUp(ActionEvent event) {
        screenController.unloadPopupController();
    }


    @Override
    public void setParrentController(ScreenController parentController) {
        screenController = parentController;
    }

    @Override
    public void unload() {
    }

    @FXML
    private void openPersonalityTest(ActionEvent event) {
        screenController.unloadPopupController();
        System.out.println(fullName.getText());
        System.out.println(mail.getText());
        System.out.println(address.getText());
        System.out.println(country.getText());
        System.out.println(city.getText());
        System.out.println(zipCode.getText());
        System.out.println(gender.getText());
        System.out.println(userName.getText());
        System.out.println(password.getText());
        domain.setUser(fullName.getText(), mail.getText(), address.getText(), country.getText(), city.getText(), zipCode.getText(), gender.getText(), userName.getText(), password.getText());
        //screenController.openBasicPersonalityTest();
    }

}
