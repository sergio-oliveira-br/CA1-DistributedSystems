/*
Continuous Assessment (CA)
Type: Project

Distributed Systems - NCI
HDip in Computing - HDCSDEV_INT

Due Date: 19th April 2024
Lecturer: Mark Cudden

Student:
    Sergio Vinicio da Silva Oliveira
    x23170981@student.ncirl.ie

GitHub:
https://github.com/sergio-oliveira-br/CA1-DistributedSystems
*/


package com.CA;



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
    private JButton stopStreamingButton;


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


        //This makes the button unable until the user start streaming by the button your connection
        stopStreamingButton.setEnabled(false);


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


                //Disable the start connection button once clicked
                yourConnectionButton.setEnabled(false);

                //Enables the button
                stopStreamingButton.setEnabled(true);





            }
        });




        stopStreamingButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Start Connection
                SmartHomeGUIClient myClient = new SmartHomeGUIClient("localhost", 8081, "Sergio Oliveira");
                SmartHomeGUIClient.setStreaming(false);

                try {
                    myClient.shutdown();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

                stopStreamingButton.setEnabled(false);
                yourConnectionButton.setEnabled(true);

            }





                /*
                myClient.sendUnaryRequest("Sergio Oliveira");

                //Send unary request
                String stub = "Sergio Oliveira";

                Thread streamThread = new Thread(() -> myClient.streamClientInformation(stub));

                streamThread.start();



                try {
                    myClient.shutdown();


                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                    //Thread.currentThread().interrupt();
                }

                 */

            //}
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
                //SmartHomeGUIServer myServer1 = new SmartHomeGUIServer(8081);


                //SmartHomeGUIServer myServerChannel = new SmartHomeGUIServer(server, 8081);


                appendMessage("\nThis was CA Distributed System by Sergio Oliveira");

                SmartHomeGUIClient myClient = new SmartHomeGUIClient(
                        "localhost",
                        8081,
                        "Sergio Oliveira");


                    try
                    {
                        JOptionPane.showMessageDialog(null, "before stop and shutdown");

                        myClient.shutdown();
                        myServer.stop();
                        //myServer1.stop();

                        JOptionPane.showMessageDialog(null, "AFTER stop and shutdown");
                    }

                    catch (InterruptedException ex)
                    {
                        throw new RuntimeException(ex);
                    }



                appendMessage("You was disconnected");


                disconnectButton.setEnabled(false);
                connectButton.setEnabled(true);



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














        smartDevicesButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //This make the reference to new JFrame
                SmartDevicesGUI myDevicesGUI = new SmartDevicesGUI();

                myDevicesGUI.setVisible(true);

            }
        });
    }
}
