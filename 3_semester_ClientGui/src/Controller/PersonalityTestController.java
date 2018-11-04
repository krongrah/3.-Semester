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
import ProjectInterfaces.IQuestion;
import ProjectInterfaces.IQuestionSet;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
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

    private IClientDomain domain;

    private IQuestionSet questionSet;

    private IQuestion currentQuestion;

    private int number = 0;
    @FXML
    private ProgressBar progress;
    @FXML
    private Button cancel;
    @FXML
    private Button next;

    private IJobPost job;
    @FXML
    private Label requiredField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        domain = GuiFacade.getDomain();

        job = screenController.getApplyingForJobPost();

        questionSet = domain.getAllQuestions();

        currentQuestion = questionSet.getQuestion(number);

        progress.setProgress(number / 100);

        requiredField.setVisible(false);
    }

    @FXML
    private void cancel(ActionEvent event) {
        screenController.unloadPopupController();
        screenController.unloadTestController();
    }

    @FXML
    private void nextQuestion(ActionEvent event) {
        if (saveAnswer() != 0) {
            requiredField.setVisible(false);
            if (number < 100) {

                currentQuestion = questionSet.getQuestion(number);

                currentQuestion.setQuestionAnswer(saveAnswer());

                resetAnswers();

                setQuestionText();

                number++;
            } else {
                domain.calculateScore(domain.getActiveUser(), questionSet);

                next.setText("Send application!");

                domain.calculateScore(domain.getActiveUser(), questionSet);

                domain.saveApplication(domain.getActiveUser(), screenController.getApplyingForJobPost(), questionSet);
            }
        } else {
            requiredField.setVisible(true);
        }

    }

    private void setQuestionText() {
        question.setText(currentQuestion.getQuestion());
    }

    private void resetAnswers() {
        disagree_large.setSelected(false);
        disagree_small.setSelected(false);
        neutral.setSelected(false);
        agree_small.setSelected(false);
        agree_large.setSelected(false);
    }

    private int saveAnswer() {
        int val = 0;
        if (disagree_large.isArmed()) {
            val = 1;
        }
        if (disagree_small.isArmed()) {
            val = 2;
        }
        if (neutral.isArmed()) {
            val = 3;
        }
        if (agree_small.isArmed()) {
            val = 4;
        }
        if (agree_large.isArmed()) {
            val = 5;
        }
        return val;
    }

    @Override
    public void setParrentController(ScreenController parentController) {
        screenController = parentController;
    }

    @Override
    public void unload() {
    }

}
