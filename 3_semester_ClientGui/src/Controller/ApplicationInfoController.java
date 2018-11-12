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
import javafx.scene.control.Button;
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
    @FXML
    private Label requiredField;
    @FXML
    private Button proceedButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        applicationDesc.setText("The application is predicated on a personality assessment, which is based on the Big Five. This means that... ");

        domain = GuiFacade.getDomain();

        requiredField.setVisible(false);

        if (domain.getActiveUser().getPersonalityTest()) {
            proceedButton.setText("Apply for job!");
        }
    }

    @FXML
    private void cancel(ActionEvent event) {
        this.screenController.unloadPopupController();
    }

    @FXML
    private void proceed(ActionEvent event) {
        if (!experience.getText().isEmpty()) {
            requiredField.setVisible(false);
            domain.setExperience(Integer.valueOf(experience.getText()));
            if (domain.getActiveUser().getPersonalityTest()) {
                domain.applyForJob(domain.getActiveUser(), screenController.getApplyingForJobPost());

            } else {
                this.screenController.openPersonalityTest();
            }
        } else {
            requiredField.setVisible(true);
        }
    }

    @Override
    public void setParrentController(ScreenController parentController) {
        this.screenController = parentController;
    }

    @Override
    public void unload() {
    }

}
