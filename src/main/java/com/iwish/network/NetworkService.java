/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iwish.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author ITEi
 */
public class NetworkService {
    private static NetworkService instance;
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    
    private NetworkService(){
        try{
            //Connect to server (localhost) for now
            socket  = new Socket("localhost", 5005);
            
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            
            System.out.println("Connected to i-Wish Server");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
    //Singlton pattern so all screens use the same connection
    public static NetworkService getInstance(){
        if (instance == null){
            instance = new NetworkService();
        }
        return instance;
    }
    
    public void sendRequest(Object obj) throws IOException{
        out.writeObject(obj);
        out.flush();
    }
    
    public Object receiveResponse() throws IOException, ClassNotFoundException{
        return in.readObject();
    }
}
