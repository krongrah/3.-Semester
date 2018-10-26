/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Sebas
 */
public class TheJobGUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("/FXML/PersonalityTest.fxml"));

        Parent root = FXMLLoader.load(getClass().getResource("/FXML/MainScreen.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);

        stage.setWidth(1280);
        stage.setHeight(768);

        stage.setMaximized(true);

        stage.setTitle("TheJob - The best people for the best jobs");
        stage.getIcons().add(new Image("/Images/logo-light.png"));

        stage.show();
    }

    public void launchGui(String[] args) {
        launch(args);
    }

}
