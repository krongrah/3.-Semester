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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        screenController.openBasicPersonalityTest();
    }

}
