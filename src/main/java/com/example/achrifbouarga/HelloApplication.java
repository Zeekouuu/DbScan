package com.example.achrifbouarga;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {


   // public static void main(String[] args) { launch(args); }


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //  stage.setFullScreen(true);
        stage.setTitle("M2I_DATAMINING_Dr.MAZROUI");
        Image icon = new Image(getClass().getResourceAsStream("logo.png"));
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

  
    public static void main(String[] args) {
        launch();}
}