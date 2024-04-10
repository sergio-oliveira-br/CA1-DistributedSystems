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
        //Create the communication
        SmartHomeGUIClient myClientGUI;
        myClientGUI = new SmartHomeGUIClient( "localhost", 8081, "Sergio Oliveira");

        //WELCOME SCREEN - HOME
        setContentPane(SmartDevices);

        //Set basics configurations to the Window
        setTitle("CA1 - Smart Devices");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(600, 350);
        setLocationRelativeTo(null);
        setVisible(true);

        //Create the options:
        String [] lightStatus = {"On", "Off"};              //to myLights
        String [] locksStatus = {"Open", "Closed"};         //to myLocks

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
        //I don't need this anymore, however I need the ManagedChannel for shutdown the channel to clear and ends everything
        //LightServicesGrpc.LightServicesBlockingStub lightBlockingStub = LightServicesGrpc.newBlockingStub(channel);



        /*
                myLights - JComboBox
                =======================================
                Here is 3 buttons that allows the
                users switch on/off the lights
                =======================================
         */


        //This refers to first box - Living Room
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

                    //When the user select "ON" on JFrame Panel - ComboBox
                    if(userResponse == JOptionPane.YES_OPTION)
                    {
                        myClientGUI.controlLights(true);
                    }

                    else    //if the user press to NO on "ON".
                    {
                        livingRoomBox.setSelectedItem("Off");
                        myClientGUI.controlLights(false);
                    }
                }

                //When the user select "OFF" on JFrame Panel - ComboBox
                else
                {
                    int userResponse = JOptionPane.showConfirmDialog(null,
                            "Would you like to switch OFF? ",
                            "Server Confirmation", JOptionPane.YES_NO_OPTION);

                    if(userResponse == JOptionPane.YES_OPTION)
                    {
                        myClientGUI.controlLights(false);
                    }

                    else    //if the user press to NO on "OFF"
                    {
                        livingRoomBox.setSelectedItem("On");
                    }
                }
            }
        });

        //This refers to the second box - Kitchen
        kitchenBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String status = (String) kitchenBox.getSelectedItem();

                if(status.equals("On"))
                {
                    int userResponse = JOptionPane.showConfirmDialog(null,
                            "Would you like to switch on?",
                            "Server Confirmation", JOptionPane.YES_NO_OPTION);

                    //When the user select "ON" on JFrame Panel - ComboBox
                    if(userResponse == JOptionPane.YES_OPTION)
                    {
                        myClientGUI.controlLights(true);
                    }

                    else    //if the user press to NO on "ON".
                    {
                        kitchenBox.setSelectedItem("Off");
                        myClientGUI.controlLights(false);
                    }
                }

                //When the user select "OFF" on JFrame Panel - ComboBox
                else
                {
                    int userResponse = JOptionPane.showConfirmDialog(null,
                            "Would you like to switch OFF? ",
                            "Server Confirmation", JOptionPane.YES_NO_OPTION);

                    if(userResponse == JOptionPane.YES_OPTION)
                    {
                        myClientGUI.controlLights(false);
                    }

                    else    //if the user press to NO on "OFF"
                    {
                        kitchenBox.setSelectedItem("On");
                    }
                }
            }
        });

        //This refers to the third box - Laundry
        laundryBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String status = (String) laundryBox.getSelectedItem();

                if(status.equals("On"))
                {
                    int userResponse = JOptionPane.showConfirmDialog(null,
                            "Would you like to switch on?",
                            "Server Confirmation", JOptionPane.YES_NO_OPTION);

                    //When the user select "ON" on JFrame Panel - ComboBox
                    if(userResponse == JOptionPane.YES_OPTION)
                    {
                        myClientGUI.controlLights(true);
                    }

                    else    //if the user press to NO on "ON".
                    {
                        laundryBox.setSelectedItem("Off");
                        myClientGUI.controlLights(false);
                    }
                }

                //When the user select "OFF" on JFrame Panel - ComboBox
                else
                {
                    int userResponse = JOptionPane.showConfirmDialog(null,
                            "Would you like to switch OFF? ",
                            "Server Confirmation", JOptionPane.YES_NO_OPTION);

                    if(userResponse == JOptionPane.YES_OPTION)
                    {
                        myClientGUI.controlLights(false);
                    }

                    else    //if the user press to NO on "OFF"
                    {
                        laundryBox.setSelectedItem("On");
                    }
                }
            }
        });















        /*
                myLock - JComboBox
                =======================================
                Here is 3 buttons that allows the
                users open/close the lock
                =======================================
         */

        mainDoorBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String status = (String) mainDoorBox.getSelectedItem();

                if(status.equals("On"))
                {
                    int userResponse = JOptionPane.showConfirmDialog(null,
                            "Would you like to open the Main Door?",
                            "Server Confirmation", JOptionPane.YES_NO_OPTION);

                    //When the user select "ON" on JFrame Panel - ComboBox
                    if(userResponse == JOptionPane.YES_OPTION)
                    {
                        myClientGUI.controlLocks(true);
                    }

                    else    //if the user press to NO on "ON".
                    {
                         mainDoorBox.setSelectedItem("Off");
                         myClientGUI.controlLocks(false);
                    }
                }

                //When the user select "OFF" on JFrame Panel - ComboBox
                else
                {
                    int userResponse = JOptionPane.showConfirmDialog(null,
                            "Would you like to switch OFF? ",
                            "Server Confirmation", JOptionPane.YES_NO_OPTION);

                    if(userResponse == JOptionPane.YES_OPTION)
                    {
                        myClientGUI.controlLocks(false);
                    }

                    //if the user press to NO on "OFF"
                    else
                    {
                       mainDoorBox.setSelectedItem("On");
                    }
                }
            }
        });











    }
}
