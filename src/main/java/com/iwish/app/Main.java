/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iwish.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ITEi
 */
public class Main extends Application{
    @Override
    public void start(Stage stage) throws Exception{
        //Points to login.fxml in the ui package
        Parent root = FXMLLoader.load(getClass().getResource("/com/iwish/ui/login.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("i-Wish - Welcome");
        stage.setScene(scene);
        stage.setResizable(false); //to keep gui clean
        stage.show();
    }
    
    public static void main(String[]args){
        launch(args);
    }
}
