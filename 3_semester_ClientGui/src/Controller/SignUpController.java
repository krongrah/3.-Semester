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
import javafx.scene.control.MenuItem;
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
    @FXML
    private TextField region;
    @FXML
    private TextField phonenr;
    @FXML
    private MenuItem male;
    @FXML
    private MenuItem female;
    @FXML
    private MenuItem denmark;
    @FXML
    private MenuItem sweden;

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
        domain.setUser(fullName.getText(), mail.getText(), phonenr.getText(), address.getText(), country.getText(), region.getText(), city.getText(), zipCode.getText(), gender.getText(), userName.getText(), password.getText());
        //screenController.openBasicPersonalityTest();
    }

    @FXML
    private void countryMenuButton(ActionEvent event) {
        //country.setText(country.getText());
    }

    @FXML
    private void genderMenuButton(ActionEvent event) {
        //gender.setText(gender.getText());
    }

    @FXML
    private void genderMaleAction(ActionEvent event) {
        gender.setText(male.getText());
    }

    @FXML
    private void genderFemaleAction(ActionEvent event) {
        gender.setText(female.getText());
    }

    @FXML
    private void countryDenmarkAction(ActionEvent event) {
        country.setText(denmark.getText());
    }

    @FXML
    private void countrySwedenAction(ActionEvent event) {
        country.setText(sweden.getText());
    }

}
