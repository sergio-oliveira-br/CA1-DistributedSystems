package com.CA;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                String stub = "Sergio Oliveira - Client Side";

                // Start streaming client information
                Thread streamThread = new Thread(() -> myClient.streamClientInformation(stub));
                streamThread.start();

                //I DO NOT IT SO FAR
                //Call the second frame - YOUR CONNECTION SCREEN for shutdown the connection
                //YourConnection connectionScreen = new YourConnection(client);
                //connectionScreen.setVisible(true);

            }
        });








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

















    }
}
