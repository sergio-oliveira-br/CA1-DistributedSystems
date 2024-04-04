package com.CA;

import com.CA.gRPC.BidirectionalRequest;
import com.CA.gRPC.BidirectionalStreamingServiceGrpc;
import com.CA.gRPC.WeatherForecastResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class myGUI extends JFrame
{
    private JPanel WelcomeScreen;
    private JButton connectButton;
    private JButton disconnectButton;
    private JButton smartDevicesButton;
    private JButton smartThermostatsButton;
    private JButton yourConnectionButton;


    //Create to help the condition of the button connect to the server
     boolean userConnected = false;
     int status = 0; //0 disconnected; 1 connected

    public myGUI()
    {
        //WELCOME SCREEN - HOME
        setContentPane(WelcomeScreen);

        //Set the window
        setTitle("CA1 - SmartHome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);
        setLocationRelativeTo(null);
        setVisible(true);



        connectButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(myGUI.this, "Connecting to the server through gRPC....");

            }
        });








        //Call SmartHomePing the method
        yourConnectionButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Start Connection
                SmartHomeGUIClient client = new SmartHomeGUIClient("localhost", 8081, "Sergio Oliveira");
                client.sendUnaryRequest("Sergio Oliveira");

                //Send unary request
                String stub = "Sergio Oliveira - Client Side";

                // Start streaming client information
                Thread streamThread = new Thread(() -> client.streamClientInformation(stub));
                streamThread.start();

                //Call the second frame - YOUR CONNECTION SCREEN for shutdown the connection
                YourConnection connectionScreen = new YourConnection(client);
                connectionScreen.setVisible(true);

            }
        });








        smartThermostatsButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Instance the object
                //SmartHomeGUIClient mySmartThermostats = new SmartHomeGUIClient();

                JOptionPane.showInputDialog(myGUI.this, "Enter the temperature", "Smart Thermostats", JOptionPane.INFORMATION_MESSAGE);

            }
        });
    }
}
