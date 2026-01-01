/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iwish.controllers;

import com.iwish.models.User;
import com.iwish.utils.UserSession;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 *
 * @author ITEi
 */
public class DashboardController {
    @FXML private Label welcomeLabel;
    @FXML private Label balanceLabel;
    
    @FXML
    public void initialize(){
        User currentUser = UserSession.getInstance().getUser();
        if(currentUser != null){
            welcomeLabel.setText("Welcome, " + currentUser.getUsername());
            balanceLabel.setText("Balance: $" + currentUser.getBalance());
        }
    }
}
