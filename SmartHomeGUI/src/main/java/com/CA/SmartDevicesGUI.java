package com.CA;

import com.CA.gRPC.LightRequest;
import com.CA.gRPC.LightServicesGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SmartDevicesGUI extends JFrame
{
    //Instance Variables
    private JPanel SmartDevices;


    //Instance Variables: Refers to myLocks
    private JComboBox<String> mainDoorBox;
    private JComboBox<String> frontGateBox;
    private JComboBox<String> backDoorBox;





    //Instance Variables: Refers to myLocks
    private JComboBox<String> kitchenBox;
    private JComboBox<String> laundryBox;
    private JComboBox<String> livingRoomBox;




    private JButton button1;






    public SmartDevicesGUI()
    {
        SmartHomeGUIClient myClientGUI = new SmartHomeGUIClient( "localhost",
                8081,
                "Sergio Oliveira");


        //WELCOME SCREEN - HOME
        setContentPane(SmartDevices);

        //Set the Main Window
        setTitle("CA1 - Smart Devices");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(600, 350);
        setLocationRelativeTo(null);
        setVisible(true);

        //Create the option:
        String [] lightStatus = {"On", "Off"};           //to myLights
        String [] locksStatus = {"Open", "Closed"};     //to myLocks

        //Add the option into myLights components
        livingRoomBox.setModel(new DefaultComboBoxModel<>(lightStatus));
        kitchenBox.setModel(new DefaultComboBoxModel<>(lightStatus));
        laundryBox.setModel(new DefaultComboBoxModel<>(lightStatus));

        //Add te option into myLock components
        mainDoorBox.setModel(new DefaultComboBoxModel<>(locksStatus));
        backDoorBox.setModel(new DefaultComboBoxModel<>(locksStatus));
        frontGateBox.setModel(new DefaultComboBoxModel<>(locksStatus));



        //Initialize Stub
        String host = "localhost";
        int port = 8081;
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        LightServicesGrpc.LightServicesBlockingStub lightBlockingStub = LightServicesGrpc.newBlockingStub(channel);




        livingRoomBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String status = (String) livingRoomBox.getSelectedItem();

                if(status.equals("On"))
                {
                    int userResponse = JOptionPane.showConfirmDialog(null,
                            "Would you like to switch on?",
                            "Server Confirmation", JOptionPane.YES_NO_OPTION);

                    //THIS IS FOR ON
                    if(userResponse == JOptionPane.YES_OPTION)
                    {




                        myClientGUI.controlLights(true);






                        //myClientGUI.controlLights(true);

                        System.out.println("This is a test - IS ON");

                        //I need to get response from the server


                    }
                    else
                    {
                        livingRoomBox.setSelectedItem("Off"); //this IS not working
                        //myClientGUI.controlLights(false);

                    }
                }

                // THIS IS FOR OFF
                else
                {
                    int userResponse = JOptionPane.showConfirmDialog(null,
                            "Would you like to switch OFF? ",
                            "Server Confirmation", JOptionPane.YES_NO_OPTION);

                    if(userResponse == JOptionPane.YES_OPTION)
                    {
                        //here I call my method asking the server to switch off
                        //myClientGUI.controlLights(false);
                        lightBlockingStub.controlLights(LightRequest.newBuilder()
                                .setLightOn(false)
                                .build());



                        //myClientGUI.controlLights(false);

                        System.out.println("This is a test - !!!IS OFF!!");
                    }
                    else
                    {
                        livingRoomBox.setSelectedItem("On");
                    }
                }
            }
        });





    }
}
