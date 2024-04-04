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
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(myGUI.this,"Connecting...");
            }
        });
        disconnectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(myGUI.this,"Disconnecting...");


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

                String stub = "Sergio Oliveira";

                client.sendUnaryRequest(stub); // Send unary request

                // Start streaming client information
                Thread streamThread = new Thread(() -> client.streamClientInformation(stub));
                streamThread.start();



                /*

                //Call the second frame - YOUR CONNECTION SCREEN
                JPanel connectionScreen = new JPanel();
                connectionScreen.add(new YourConnection());
                getContentPane().add(connectionScreen);

                 */

            }
        });
    }
}
