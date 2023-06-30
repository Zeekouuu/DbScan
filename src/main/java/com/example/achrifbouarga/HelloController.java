package com.example.achrifbouarga;


/*

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    TextField epsilon_text;
    @FXML
    TextField minpoints_text;
    @FXML
    TextField csv_link_text;
    @FXML
    ChoiceBox<String> distance_function_box;
    String[] functions = {"levenshtein","quantitative_euclidean","qualitative_euclidean"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        distance_function_box.getItems().addAll(functions);
    }


    @FXML
    TextArea area0;
    @FXML
    TextArea area1;
    @FXML
    TextArea area2;
    @FXML
    TextArea area3;


    public void run(ActionEvent event) throws Exception {
        double epsilon = Double.parseDouble(epsilon_text.getText());
        double minpoints = Double.parseDouble(minpoints_text.getText());
        String csv_link = csv_link_text.getText();
        String function = distance_function_box.getValue();


        String []Tabs = Affichage.afficher(csv_link,function,epsilon,minpoints);
        area0.setText(Tabs[0]);
        area1.setText(Tabs[1]);
        area2.setText(Tabs[2]);
        area3.setText(Tabs[3]);


    }
} */


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class HelloController implements Initializable {
    FileChooser fileChooser = new FileChooser();

    @FXML
    private TextArea area0;

    @FXML
    private TextArea area1;

    @FXML
    private TextArea area2;

    @FXML
    private TextArea area3;

    @FXML
    private TextArea area4;

    @FXML
    private TextField csv_link_text;

    @FXML
    ChoiceBox<String> distance_function_box;
    String[] functions = new String[]{"quantitative", "qualitative"};

    @FXML
    private TextField epsilon_text;

    @FXML
    private TextField minpoints_text;


    @FXML
    private Button importer;

    @FXML
    private Tab tab1;

    @FXML
    private Tab tab2;

    @FXML
    private Tab tab3;

    @FXML
    private Tab tab4;

    @FXML
    private Tab tab5;
    @FXML
    private TextArea textArea;
String so="";
    @FXML

    public void getLien() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        Window window = importer.getScene().getWindow(); // Replace "yourNode" with your actual node reference
        File selectedFile = fileChooser.showOpenDialog(window);
String filePath ;
        if (selectedFile != null) {
            try {
                Scanner scanner = new Scanner(selectedFile);
                while (scanner.hasNextLine()){
                   textArea.appendText(scanner.nextLine()+"\n");
                }
             filePath = selectedFile.getPath();
             so = filePath;
            System.out.println(filePath);

            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
            // File was selected, do something with it
            // ...
        } else {
            filePath="erreur";
        }
    }
    /*void getLien(MouseEvent event) {
      File file=  fileChooser.showOpenDialog(new Stage());
    } */
    @FXML
    void ajout(MouseEvent event) throws Exception {
        FileWriter fileWriter = new FileWriter(so);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(textArea.getText());
        bufferedWriter.close();

        //-------------------------------------------------------


        double epsilon = Double.parseDouble(epsilon_text.getText());
        System.out.println(epsilon);
        double minpoints = Double.parseDouble(minpoints_text.getText());
        System.out.println(minpoints);
        String csv_link = so;
        System.out.println(csv_link);
        //  String csv_link = String.valueOf(fileChooser.showOpenDialog(new Stage()));

        String function = distance_function_box.getValue();
        System.out.println(function);


        String []Tabs = Affichage.afficher(csv_link,function,epsilon,minpoints);
        area0.setText(Tabs[0]);
        area1.setText(Tabs[1]);
        area2.setText(Tabs[2]);
        area3.setText(Tabs[3]);
        area4.setText(Tabs[4]);

    }
    @FXML
    public void run(ActionEvent event) throws Exception {
        double epsilon = Double.parseDouble(epsilon_text.getText());
        System.out.println(epsilon);
        double minpoints = Double.parseDouble(minpoints_text.getText());
        System.out.println(minpoints);
        String csv_link = so;
        System.out.println(csv_link);
        //  String csv_link = String.valueOf(fileChooser.showOpenDialog(new Stage()));

        String function = distance_function_box.getValue();
        System.out.println(function);


        String []Tabs = Affichage.afficher(csv_link,function,epsilon,minpoints);
        area0.setText(Tabs[0]);
        area1.setText(Tabs[1]);
        area2.setText(Tabs[2]);
        area3.setText(Tabs[3]);
        area4.setText(Tabs[4]);



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        distance_function_box.getItems().addAll(functions);

    }
}