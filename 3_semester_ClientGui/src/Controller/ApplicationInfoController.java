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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Sebas
 */
public class ApplicationInfoController implements Initializable, IController<ScreenController> {

    private ScreenController screenController;
    
    private IClientDomain domain;

    @FXML
    private AnchorPane SignUpScreen;
    @FXML
    private Label applicationDesc;
    @FXML
    private TextField experience;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        applicationDesc.setText("The application is predicated on a personality assessment, which is based on the Big Five. This means that... ");
        
        domain = GuiFacade.getDomain();
    }

    @FXML
    private void cancel(ActionEvent event) {
        this.screenController.unloadPopupController();
    }

    @FXML
    private void proceed(ActionEvent event) {
        domain.setExperience(Integer.valueOf(experience.getText()));
        this.screenController.openPersonalityTest();
    }

    @Override
    public void setParrentController(ScreenController parentController) {
        this.screenController = parentController;
    }

    @Override
    public void unload() {
    }

}
