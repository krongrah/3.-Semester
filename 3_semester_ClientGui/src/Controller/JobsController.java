/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Common.IController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Sebas
 */
public class JobsController implements Initializable, IController<ScreenController> {

    private ScreenController screenController;
    @FXML
    private Label dcwJob_Title;
    @FXML
    private Label dcwJob_Desc;
    @FXML
    private Label doctorJob_Desc;
    @FXML
    private Label doctorJob_Title;
    @FXML
    private Label seJob_Desc;
    @FXML
    private Label seJob_Tiltle;
    @FXML
    private Label tmJob_Desc;
    @FXML
    private Label tmJob_Title;
    @FXML
    private Label ulJob_Desc;
    @FXML
    private Label ulJob_Title;
    @FXML
    private AnchorPane SignUpScreen;
    @FXML
    private Button DCWButton;
    @FXML
    private Button ULButton;
    @FXML
    private Button TMButton;
    @FXML
    private Button SEButton;
    @FXML
    private Button DoctorButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @Override
    public void setParrentController(ScreenController parentController) {
        screenController = parentController;
    }

    @Override
    public void unload() {
    }

    @FXML
    private void applyForDCWJob(ActionEvent event) {
        screenController.unloadPopupController();
        screenController.openBasicPersonalityTest();
        disableApplicationButton(DCWButton);
    }

    @FXML
    private void applyForULJob(ActionEvent event) {
        screenController.unloadPopupController();
        screenController.openPersonalityTest();
        disableApplicationButton(ULButton);

    }

    @FXML
    private void applyForTMJob(ActionEvent event) {
        screenController.unloadPopupController();
        screenController.openBasicPersonalityTest();
        disableApplicationButton(TMButton);

    }

    @FXML
    private void applyForSEJob(ActionEvent event) {
        screenController.unloadPopupController();
        screenController.openBasicPersonalityTest();
        disableApplicationButton(SEButton);

    }

    @FXML
    private void applyForDoctorJob(ActionEvent event) {
        screenController.unloadPopupController();
        screenController.openBasicPersonalityTest();
        disableApplicationButton(DoctorButton);

    }

    public void disableApplicationButton(Button button) {
        button.setDisable(true);
        button.setText("Application sent");
    }

    @FXML
    private void closeJobs(MouseEvent event) {
        this.screenController.unloadPopupController();
    }

}
