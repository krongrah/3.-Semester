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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Sebas
 */
public class PersonalityTestController implements Initializable, IController<ScreenController> {

    @FXML
    private ToggleGroup AgreementValues;
    private ScreenController screenController;
    @FXML
    private RadioButton disagree_large;
    @FXML
    private RadioButton disagree_small;
    @FXML
    private RadioButton neutral;
    @FXML
    private RadioButton agree_small;
    @FXML
    private RadioButton agree_large;
    @FXML
    private Label question;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void cancel(ActionEvent event) {
        screenController.unloadPopupController();
    }

    @FXML
    private void nextQuestion(ActionEvent event) {
    }

    @Override
    public void setParrentController(ScreenController parentController) {
        screenController = parentController;
    }

    @Override
    public void unload() {
    }

}
