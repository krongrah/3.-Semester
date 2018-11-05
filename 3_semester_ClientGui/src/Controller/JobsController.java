/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Common.IController;
import GUI.GuiFacade;
import ProjectInterfaces.IClientDomain;
import ProjectInterfaces.IJobPost;
import commondata.JobPost;
import java.net.URL;
import java.util.List;
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

    private IClientDomain domain;

    private List<IJobPost> jobs;
    @FXML
    private Label seJob_Title;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        domain = GuiFacade.getDomain();
        jobs = domain.getAllJobs();

        
        if(domain.getActiveUser() == null){
            DCWButton.setText("Log in to apply!");
            ULButton.setText("Log in to apply!");
            TMButton.setText("Log in to apply!");
            SEButton.setText("Log in to apply!");
            DoctorButton.setText("Log in to apply!");
            
            
            DCWButton.setDisable(true);
            ULButton.setDisable(true);
            TMButton.setDisable(true);
            SEButton.setDisable(true);
            DoctorButton.setDisable(true);
        }
        
        dcwJob_Title.setText(jobs.get(0).getTitle() + " by " + jobs.get(0).getCompanyName());
        dcwJob_Desc.setText(jobs.get(0).getDescription() + " for more, visit: " + jobs.get(0).getCompanyWebsite());
        
        doctorJob_Title.setText(jobs.get(1).getTitle() + " by " + jobs.get(1).getCompanyName());
        doctorJob_Desc.setText(jobs.get(1).getDescription() + " for more, visit: " + jobs.get(1).getCompanyWebsite());
        
        seJob_Title.setText(jobs.get(2).getTitle() + " by " + jobs.get(2).getCompanyName());
        seJob_Desc.setText(jobs.get(2).getDescription() + " for more, visit: " + jobs.get(2).getCompanyWebsite());
        
        tmJob_Title.setText(jobs.get(3).getTitle() + " by " + jobs.get(3).getCompanyName());
        tmJob_Desc.setText(jobs.get(3).getDescription() + " for more, visit: " + jobs.get(3).getCompanyWebsite());
        
        ulJob_Title.setText(jobs.get(4).getTitle() + " by " + jobs.get(4).getCompanyName());
        ulJob_Desc.setText(jobs.get(4).getDescription() + " for more, visit: " + jobs.get(4).getCompanyWebsite());

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
        disableApplicationButton(DCWButton);
        showApplicationInfo();
    }

    @FXML
    private void applyForULJob(ActionEvent event) {
        disableApplicationButton(ULButton);
        showApplicationInfo();
    }

    @FXML
    private void applyForTMJob(ActionEvent event) {
        disableApplicationButton(TMButton);
        showApplicationInfo();
    }

    @FXML
    private void applyForSEJob(ActionEvent event) {
        disableApplicationButton(SEButton);
        showApplicationInfo();
    }

    @FXML
    private void applyForDoctorJob(ActionEvent event) {
        disableApplicationButton(DoctorButton);
        showApplicationInfo();

    }

    public void showApplicationInfo() {
        this.screenController.openApplicationInfo();
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
