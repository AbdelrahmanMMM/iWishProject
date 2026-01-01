/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iwish.controllers;

import com.iwish.models.User;
import com.iwish.network.NetworkService;
import com.iwish.utils.UserSession;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
        String username = usernameField.getText();
        String password = passwordField.getText();
        
        if (username.isEmpty()|| password.isEmpty()){
            System.out.println("Please enter credentials!");
            return;
        }
        
        try{
            NetworkService network = NetworkService.getInstance();
            
            //send command
            network.sendRequest("LOGIN");
            
            User loginData  = new User();//loginData is a user just to send data
            loginData.setUsername(username);
            loginData.setPassword(password);
            network.sendRequest(loginData);
            
            String response = (String) network.receiveResponse();
            
            if("LOGIN_SUCCESS".equals(response)){
                //receive the data
                User authenticatedUser = (User) network.receiveResponse();
                
                UserSession.getInstance().setUser(authenticatedUser);
                
                showAlert(Alert.AlertType.INFORMATION, "Sucess", "Login Successful!");
                navigateToDashboard(event);
            }else{
                showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password.");
            }
            
            
        }catch(Exception e){
            showAlert(Alert.AlertType.ERROR, "Connection Error", "Could not reach the server.");
            e.printStackTrace();
        }
    }
    
    private void navigateToDashboard(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/com/iwish/ui/dashboard.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("i-Wish - Dashboard");
        stage.show();
    }
    
    private void showAlert(Alert.AlertType alertType, String title, String message){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    @FXML
    private void goToSignup(ActionEvent event)throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/com/iwish/ui/signin.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
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
