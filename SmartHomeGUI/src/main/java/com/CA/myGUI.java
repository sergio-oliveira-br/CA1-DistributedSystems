package com.CA;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class myGUI extends JFrame
{
    private JPanel WelcomeScreen;
    private JButton connectButton;
    private JButton disconnectButton;
    private JButton smartDevicesButton;
    private JButton smartThermostatsButton;
    private JButton yourConnectionButton;
    private JTextArea systemInformation;
    private JButton button1;


    //Method: used to display all msg on JTextArea
    public void appendMessage(String message)
    {
        systemInformation.append(message + "\n");
    }



    public myGUI()
    {

        //This make the reference to JTextArea
        SmartHomeGUIClient myClientGUI = new SmartHomeGUIClient(this);

        //WELCOME SCREEN - HOME
        setContentPane(WelcomeScreen);

        //Set the Main Window
        setTitle("CA1 - SmartHome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);
        setVisible(true);


        //Text Area: where the system will print few information
        systemInformation.setEditable(false); //the user is not allow to edit


        //Call SmartHomePing the method
        yourConnectionButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Start Connection
                SmartHomeGUIClient myClient = new SmartHomeGUIClient("localhost", 8081, "Sergio Oliveira");
                myClient.sendUnaryRequest("Sergio Oliveira");

                //Send unary request
                String stub = "Sergio Oliveira";

                // Start streaming client information
                Thread streamThread = new Thread(() -> myClient.streamClientInformation(stub));
                streamThread.start();

                // Disable the start connection button once clicked
                yourConnectionButton.setEnabled(false);

            }
        });







        //This set the room temp
        smartThermostatsButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Instance the object
                //SmartHomeGUIClient mySmartThermostats = new SmartHomeGUIClient();
                //JOptionPane.showInputDialog(myGUI.this, "Enter the temperature",
                       // "Smart Thermostats", JOptionPane.INFORMATION_MESSAGE);

                //SmartHomeGUIClient myClient = new SmartHomeGUIClient();

                myClientGUI.setYourTemp(JOptionPane.showInputDialog(myGUI.this, "Please enter the Temp"));
            }
        });






        //Just a test to ask the server the weather forecast
        button1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //SmartHomeGUIClient myClient = new SmartHomeGUIClient();
                myClientGUI.getForecast();
            }
        });





        //Disconnect and clean the connection
        disconnectButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                SmartHomeGUIServer myServer = new SmartHomeGUIServer();


                appendMessage("This was CA Distributed System by Sergio Oliveira");

                SmartHomeGUIClient myClient = new SmartHomeGUIClient(
                        "localhost",
                        8081,
                        "Sergio Oliveira");


                SmartHomeGUIServer myS = new SmartHomeGUIServer(8081);


                myS.stop();
                    try
                    {
                        myClient.shutdown();
                        myServer.stop();
                    }

                    catch (InterruptedException ex)
                    {
                        throw new RuntimeException(ex);
                    }

                appendMessage("You was disconnected");
                disconnectButton.setEnabled(false);
                connectButton.setEnabled(true);

                appendMessage("here before");

                appendMessage("here after");








            }
        });






        connectButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                SmartHomeGUIServer myServer = new SmartHomeGUIServer(8081);
                try
                {
                    appendMessage("Connecting client to server...");
                    myServer.start();


                    appendMessage("Successful Connection");
                }

                catch (IOException ex)
                {
                    throw new RuntimeException(ex);
                }

                connectButton.setEnabled(false); //once connected the button will be unavailable.
            }
        });
    }
}
