/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Common.IController;
import GUI.GuiFacade;
import ProjectInterfaces.IClientGui;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    
    @FXML
    private AnchorPane LoginScreen;
    private ScreenController screenController;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        gui = gui.getInstance();
        gui.getDomain().connectToServer();
    }

    @FXML
    private void signIn(ActionEvent event) {
        screenController.unloadPopupController();
        gui.getDomain().login(username.getText(), password.getText());
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
