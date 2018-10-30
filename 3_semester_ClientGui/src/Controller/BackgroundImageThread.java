/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.stage.Screen;

/**
 *
 * @author Sebas
 */
public class BackgroundImageThread implements Runnable {

    private ArrayList<Image> images = new ArrayList();
    private ArrayList<Line> lines = new ArrayList();

    private ImageView HomeBackgroundImage;
    private boolean running = true;
    private int count = 1;

    public BackgroundImageThread(ArrayList<Image> imgs, ImageView bckg, ArrayList<Line> lines) {
        this.images = imgs;
        this.HomeBackgroundImage = bckg;
        this.lines = lines;
    }

    @Override
    public void run() {
        while (running) {
            this.HomeBackgroundImage.setImage(images.get(count % 3));
            count++;

            for (Line line : lines) {
                line.setOpacity(0.35);
            }
            lines.get(count % 3).setOpacity(0.85);

            HomeBackgroundImage.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
            HomeBackgroundImage.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());

            try {
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(BackgroundImageThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setRunning(boolean b) {
        this.running = b;
    }

}
