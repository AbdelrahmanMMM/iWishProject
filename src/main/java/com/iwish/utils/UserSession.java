/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iwish.utils;

import com.iwish.models.User;

/**
 *
 * @author ITEi
 */
public class UserSession {
    private static UserSession instance;
    private User currentUser;
    
    private UserSession(){}
    
    public static UserSession getInstance(){
        if (instance == null){
            instance = new UserSession();
        }
        return instance;
    }
    
    public void setUser(User user){this.currentUser = user;}
    public User getUser(){return currentUser;}
    public void cleanUserSession(){currentUser = null;}
}
