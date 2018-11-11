/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Common.IController;
import GUI.GuiFacade;
import ProjectInterfaces.IClientDomain;
import commondata.QuestionSet;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Sebas
 */
public class ResultController implements Initializable, IController<ScreenController>{

    @FXML
    private AnchorPane SignUpScreen;
    @FXML
    private ProgressBar openness;
    @FXML
    private Label op_percent;
    @FXML
    private ProgressBar conscientiousness;
    @FXML
    private Label con_percent;
    @FXML
    private ProgressBar extraversion;
    @FXML
    private ProgressBar agreeableness;
    @FXML
    private ProgressBar neuroticism;
    @FXML
    private Label ext_percent;
    @FXML
    private Label agr_percent;
    @FXML
    private Label neu_percent;

    private QuestionSet questions;

    private IClientDomain domain;

    private ScreenController screenController;
    @FXML
    private Label header;
    
    private int rank = 0;
    
    private int oScore;
    private int cScore;
    private int eScore;
    private int aScore;
    private int nScore;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        domain = GuiFacade.getDomain();
        header.setText("Thank you for applying! You currently ranked nr. " + rank +", out of all applicants");
        
        //todo:
        //oScore = ...
        //cScore = ...
        //eScore = ...
        //aScore = ...
        //nScore = ...
        
        setResults();
    }
    
    private void setResults(){
        this.openness.setProgress(oScore/100.0);
        this.op_percent.setText(String.valueOf(oScore));
        
        this.conscientiousness.setProgress(oScore/100.0);
        this.con_percent.setText(String.valueOf(oScore));
        
        this.extraversion.setProgress(oScore/100.0);
        this.ext_percent.setText(String.valueOf(oScore));
        
        this.agreeableness.setProgress(oScore/100.0);
        this.agr_percent.setText(String.valueOf(oScore));
        
        this.neuroticism.setProgress(oScore/100.0);
        this.neu_percent.setText(String.valueOf(oScore));
    }

    @FXML
    private void closeResults(ActionEvent event) {
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
