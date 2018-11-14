/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Common.IController;
import GUI.GuiFacade;
import ProjectInterfaces.IClientDomain;
import ProjectInterfaces.IQuestionSet;
import commondata.QuestionSet;
import java.net.URL;
import java.util.List;
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

    private IQuestionSet questions;

    private IClientDomain domain;

    private ScreenController screenController;
    @FXML
    private Label header;
    
    private List<Integer> list;
    
    private int rank;
    
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
        questions = domain.getAllQuestions();
        list = domain.getPersonalityAssessment(domain.getActiveUser());
        // TODO Implement ranking. Problem: get jobpost.
        rank = domain.getRanking(domain.getActiveUser().getLastJob(), domain.getActiveUser());
        
        header.setText("Thank you for applying! You currently ranked nr. " + rank +", out of all applicants");
        
        //todo:
        oScore = list.get(0) + list.get(1);
        cScore = list.get(2) + list.get(3);
        eScore = list.get(4) + list.get(5);
        aScore = list.get(6) + list.get(7);
        nScore = list.get(8) + list.get(9);
        
        setResults();
    }
    
    private void setResults(){
        this.openness.setProgress(oScore/100.0);
        this.op_percent.setText(String.valueOf(oScore));
        
        this.conscientiousness.setProgress(cScore/100.0);
        this.con_percent.setText(String.valueOf(cScore));
        
        this.extraversion.setProgress(eScore/100.0);
        this.ext_percent.setText(String.valueOf(eScore));
        
        this.agreeableness.setProgress(aScore/100.0);
        this.agr_percent.setText(String.valueOf(aScore));
        
        this.neuroticism.setProgress(nScore/100.0);
        this.neu_percent.setText(String.valueOf(nScore));
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
