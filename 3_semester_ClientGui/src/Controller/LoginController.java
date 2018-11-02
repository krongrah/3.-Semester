/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Common.IController;
import GUI.GuiFacade;
import ProjectInterfaces.IClientDomain;
import ProjectInterfaces.IClientGui;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Sebas
 */
public class LoginController implements Initializable, IController<ScreenController> {

    private IClientGui gui = new GuiFacade();
    
    private IClientDomain domain;

    @FXML
    private AnchorPane LoginScreen;
    
    private ScreenController screenController;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label requiredField;
    @FXML
    private Label loginFailed;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        gui = gui.getInstance();
        GuiFacade.getDomain().connectToServer();
        
        domain = GuiFacade.getDomain();

        requiredField.setVisible(false);
        loginFailed.setVisible(false);
    }

    @FXML
    private void signIn(ActionEvent event) {
        if (username.getText().isEmpty() || password.getText().isEmpty()) {
            requiredField.setVisible(true);
        } else {
            requiredField.setVisible(false);
            if (!domain.login(username.getText(), password.getText())) {
                loginFailed.setVisible(false);
                screenController.unloadPopupController();
                screenController.updateSigInButton();
            } else {
                loginFailed.setVisible(true);
            }
        }
    }

    @FXML
    private void cancelLogin(ActionEvent event) {
        screenController.unloadPopupController();
    }

    @Override
    public void setParrentController(ScreenController parentController) {
        screenController = parentController;
    }

    @Override
    public void unload() {
    }

}
