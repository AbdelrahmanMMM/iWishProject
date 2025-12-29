/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iwish.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author ITEi
 */
public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    
    @FXML
    private void handleLogin(ActionEvent event){
        String user = usernameField.getText();
        String pass = passwordField.getText();
        
        if (user.isEmpty()|| pass.isEmpty()){
            System.out.println("Please enter credentials!");
            return;
        }
        
        //This is where we will call NetworkService!
        //.......................................
        System.out.println("Attempting to login user: "+user);
    }
    
    @FXML
    private void goToRegistration(ActionEvent event) throws IOException{
        // logic to switch to signin.fxml
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/com/iwish/ui/signin.fxml"));
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            stage.setScene(new Scene(root));
            stage.show();
        }catch(IOException e){
            System.err.println("Error: Could not find signin.fxml");
            e.printStackTrace();
        }
    }
}
