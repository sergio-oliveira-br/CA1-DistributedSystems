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

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.swing.*;
import java.awt.event.*;
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


    /*

    //Welcome Screen
    @Override
    public synchronized void addWindowListener(WindowListener l)
    {
        super.addWindowListener(l);
        JOptionPane.showMessageDialog(null,
                "This is CA - Distributed System" +
                         "\nLecture: Mark Cudden" + "\nStudent: Sergio Oliveira",
                "Welcome to Smart Home ", JOptionPane.INFORMATION_MESSAGE );
    }

     */

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

        //As a contingency - the Smart Devices button starts disable, and it will enable after connection established
        smartDevicesButton.setEnabled(false);

        //Starts the user screen with simple msg
        appendMessage("Waiting for connection...\n---");

        //Initialize Stub
        String host = "localhost";
        int port = 8081;
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

        //Start Connection
        //SmartHomeGUIClient myClient = new SmartHomeGUIClient("localhost", 8081, "Sergio Oliveira");
        SmartHomeGUIServer myServer = new SmartHomeGUIServer(8081);



        //This will ask th user if they wanna leave, and then call the shutdown() to close and clean all connections
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                super.windowClosing(e);
                int closeAndShutdown = JOptionPane.showConfirmDialog(myGUI.this,
                        "Are you sure you want to leave?", "Shut Down Confirmation",
                        JOptionPane.YES_NO_OPTION);

                if(closeAndShutdown == JOptionPane.YES_OPTION)
                {
                    channel.shutdown();
                    myServer.stop();

                    JOptionPane.showMessageDialog(null, "\nShutting down gRPC server." +
                            "\nThis was CA1 - Distributed System" +
                            "\nby Sergio Oliveira - x23170981@student.ncirl.ie");

                }
            }
        });



        /*
            =====================================================
                Your Connection & Stop Streaming are related
                Where one starts streaming and the other stops
            =====================================================
        */

        //Start to send information to the server
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


        //Stop sending information to the server
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



        /*
            ===================================================================
                Thermostats allows the user send a requests to the server
            ===================================================================
        */

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



                myClientGUI.setYourTemp(JOptionPane.showInputDialog(myGUI.this,
                        "Enter the temperature you would like"));





            }
        });


        /*
            ===========================================================================================
                THE ORIGINAL IDEA IS FOR THE SERVER TO SEND MSG TO THE USER WITHOUT USER'S REQUEST
            ===========================================================================================
        */
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


        /*
            =================================================
                Connect & Disconnect are related,
                where one create the channel allowing
                the communication between Server and Client,
                & close e clean all connections
            ==================================================
        */

        //!IMPORTANT THERE FEW ISSUES THAT I NEED TO CLOSE SOME CONNECTIONS

        //Disconnect and clean the connection
        disconnectButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                SmartHomeGUIServer myServer = new SmartHomeGUIServer();

                appendMessage("\nThis was CA Distributed System by Sergio Oliveira");

                SmartHomeGUIClient myClient = new SmartHomeGUIClient(
                        "localhost",
                        8081,
                        "Sergio Oliveira");

                    try
                    {
                        myClient.shutdown();
                        myServer.stop();
                    }

                    catch (InterruptedException ex)
                    {
                        throw new RuntimeException(ex);
                    }

                appendMessage("---\nYou have been disconnected from the server");

                disconnectButton.setEnabled(false);
                connectButton.setEnabled(true);
                smartDevicesButton.setEnabled(false);

            }
        });

        //Start the Server
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
                smartDevicesButton.setEnabled(true);
                disconnectButton.setEnabled(true);

                yourConnectionButton.setEnabled(true);
            }
        });




        /*
            =================================================
                Smart Devices - This will open a new JFrame,
                where the user is able to send request to
                turn on/off and open/close few devices
            ==================================================
        */

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
