/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Common.IController;
import ProjectInterfaces.IJobPost;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Screen;

/**
 *
 * @author Sebas
 */
public class ScreenController implements Initializable, IController<ScreenController> {

    private IController<ScreenController> screenController;
    @FXML
    private ImageView HomeBackgroundImage;
    @FXML
    private AnchorPane screen;
    @FXML
    private Line Image_Line1;
    @FXML
    private Line Image_Line2;
    @FXML
    private Line Image_Line3;
    @FXML
    private AnchorPane popupWindow;

    /**
     * Reference to main controller
     */
    private ScreenController mainController;

    private ArrayList<Image> images = new ArrayList();
    private ArrayList<Line> lines = new ArrayList();
    
    private IJobPost applyingForJob;
    @FXML
    private AnchorPane testWindow;

    public void initialize(URL url, ResourceBundle rb) {

        images.add(new Image("/Images/business-man-and-woman-handshake-in-work-office-picjumbo-com-e1490198110678-1100x450.jpg"));
        images.add(new Image("/Images/handshake.jpg"));
        images.add(new Image("/Images/handshake2.jpg"));

        lines.add(Image_Line1);
        lines.add(Image_Line2);
        lines.add(Image_Line3);

        //HomeBackgroundImage.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        //HomeBackgroundImage.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        Thread bckgswitcher = new Thread(new BackgroundImageThread(images, HomeBackgroundImage, lines));
        bckgswitcher.start();
        bckgswitcher.isDaemon();

        loadController("FXML/HomeDesc.fxml");

        popupWindow.setVisible(false);
        testWindow.setVisible(false);
    }

    /**
     * Unload the current screen controller
     */
    private void unloadController() {
        if (screenController != null) {
            screenController.unload();
        }
    }

    /**
     * Loads a new screen controller
     *
     * @param url the URL for the .fxml document
     */
    private void loadController(String url) {
        try {
            unloadController();
            screen.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(url));
            Node node = loader.load();
            screenController = loader.getController();
            screenController.setParrentController(this);

            AnchorPane.setTopAnchor(node, 0.0);
            AnchorPane.setRightAnchor(node, 0.0);
            AnchorPane.setLeftAnchor(node, 0.0);
            AnchorPane.setBottomAnchor(node, 0.0);

            screen.getChildren().add(node);
        } catch (IOException ex) {
            Logger.getLogger(ScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadPopupController(String url) {
        try {
            unloadController();
            popupWindow.setVisible(true);
            popupWindow.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(url));
            Node node = loader.load();
            screenController = loader.getController();
            screenController.setParrentController(this);

            AnchorPane.setTopAnchor(node, 0.0);
            AnchorPane.setRightAnchor(node, 0.0);
            AnchorPane.setLeftAnchor(node, 0.0);
            AnchorPane.setBottomAnchor(node, 0.0);

            popupWindow.getChildren().add(node);
        } catch (IOException ex) {
            Logger.getLogger(ScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadApplicationController(String url) {
        try {
            unloadController();
            testWindow.setVisible(true);
            testWindow.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(url));
            Node node = loader.load();
            screenController = loader.getController();
            screenController.setParrentController(this);

            AnchorPane.setTopAnchor(node, 0.0);
            AnchorPane.setRightAnchor(node, 0.0);
            AnchorPane.setLeftAnchor(node, 0.0);
            AnchorPane.setBottomAnchor(node, 0.0);

            testWindow.getChildren().add(node);
        } catch (IOException ex) {
            Logger.getLogger(ScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void unloadPopupController() {
        popupWindow.setVisible(false);
    }

    public void unloadTestController() {
        testWindow.setVisible(false);
    }

    @FXML
    private void openSignIn(ActionEvent event) {
        loadPopupController("FXML/Login.fxml");
    }

    @FXML
    private void openSearchForJobs(ActionEvent event) {
    }

    @FXML
    private void openSignUpScreen(ActionEvent event) {
        loadPopupController("FXML/SignUp.fxml");
    }

    private void cancelSignUp(ActionEvent event) {
        unloadPopupController();
    }

    public void openBasicPersonalityTest() {
        loadPopupController("FXML/PersonalityTest.fxml");
    }

    public void openPersonalityTest() {
        loadPopupController("FXML/PersonalityTest.fxml");
    }
    
    public void openApplicationInfo(){
        unload();
        loadPopupController("FXML/ApplicationInfo.fxml");
    }

    private void signIn(ActionEvent event) {
        unloadPopupController();
        loadController("FXML/HomeController.fxml");
    }

    private void cancelLogin(ActionEvent event) {
        System.out.println("Cancelling");
        unloadPopupController();
    }

    @FXML
    private void openHomeScreen(MouseEvent event) {
        unload();
        loadController("FXML/HomeDesc.fxml");
    }

    @Override
    public void setParrentController(ScreenController parentController) {
        mainController = parentController;
    }

    @Override
    public void unload() {
        unloadController();
    }
    
    public void setApplyingForJob(IJobPost job){
        this.applyingForJob = job;
    }
    
    public IJobPost getApplyingForJobPost(){
        return this.applyingForJob;
    }

    @FXML
    private void openAllJobs(MouseEvent event) {
        unload();
        loadPopupController("FXML/Jobs.fxml");
    }

}
