/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.GuiFacade;
import ProjectInterfaces.IClientDomain;
import ProjectInterfaces.IClientGui;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Screen;

/**
 * FXML Controller class
 *
 * @author Sebas
 */
public class HomeController implements Initializable {

    private IClientGui gui;

    @FXML
    private ImageView HomeBackgroundImage;
    @FXML
    private Line Image_Line1;
    @FXML
    private Line Image_Line2;
    @FXML
    private Line Image_Line3;

    private ArrayList<Image> images = new ArrayList();
    private ArrayList<Line> lines = new ArrayList();
    private AnchorPane LoginScreen;
    @FXML
    private AnchorPane SignUpScreen;
    @FXML
    private AnchorPane screen;
    @FXML
    private Button signInButton;
    @FXML
    private AnchorPane popupWindow;

    private IClientDomain clientDomain;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        gui = gui.getInstance();
        clientDomain = GuiFacade.getDomain();

        LoginScreen.setVisible(false);
        SignUpScreen.setVisible(false);

        images.add(new Image("/Images/business-man-and-woman-handshake-in-work-office-picjumbo-com-e1490198110678-1100x450.jpg"));
        images.add(new Image("/Images/handshake.jpg"));
        images.add(new Image("/Images/handshake2.jpg"));

        lines.add(Image_Line1);
        lines.add(Image_Line2);
        lines.add(Image_Line3);

        HomeBackgroundImage.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        HomeBackgroundImage.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        
        
        
        System.out.println("Was maybe logged in");
        if (clientDomain.isLoggedIn()) {
            System.out.println("Was logged in");
            //If a user already is logged in
            signInButton.setDisable(true);
            signInButton.setText(clientDomain.getActiveUser().getUsername());
        }
        
        
        
        Thread bckgswitcher = new Thread(new BackgroundImageThread(images, HomeBackgroundImage, lines));
        bckgswitcher.start();

        bckgswitcher.setDaemon(true);

    }

    public void updateSignInButton() {
        if (clientDomain.isLoggedIn()) {
            //If a user already is logged in
            signInButton.setDisable(true);
            signInButton.setText(clientDomain.getActiveUser().getUsername());
        }
    }

    @FXML
    private void openSignIn(ActionEvent event) {
        LoginScreen.setVisible(true);
        System.out.println("Signed in");

        if (clientDomain.getActiveUser() != null) {
            signInButton.setText(clientDomain.getActiveUser().getUsername());
            signInButton.setDisable(true);
        }
    }

    private void signIn(ActionEvent event) {
        LoginScreen.setVisible(false);

        if (clientDomain.getActiveUser() != null) {
            signInButton.setText(clientDomain.getActiveUser().getUsername());
            signInButton.setDisable(true);
        }
    }

    private void cancelLogin(ActionEvent event) {
        LoginScreen.setVisible(false);
    }

    private void signUp(ActionEvent event) {
        SignUpScreen.setVisible(false);
    }

    @FXML
    private void cancelSignUp(ActionEvent event) {
        SignUpScreen.setVisible(false);
    }

    @FXML
    private void openSearchForJobs(ActionEvent event) {
    }

    @FXML
    private void openSignUpScreen(ActionEvent event) {
        SignUpScreen.setVisible(true);
    }

}
