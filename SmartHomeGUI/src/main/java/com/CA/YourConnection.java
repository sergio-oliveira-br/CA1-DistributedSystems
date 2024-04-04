package com.CA;

import com.CA.gRPC.StreamingClientServiceGrpc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class YourConnection extends JFrame
{

    private JPanel YourConnection;
    private JButton cancelButton;
    private JLabel streamMsg;
    private JLabel hostInfo;
    private JLabel portInfo;
    private JLabel stubInfo;

    public YourConnection()
    {
        //WELCOME SCREEN - HOME
        setContentPane(YourConnection);

        //Set the window
        setTitle("Your Connection");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
        setLocationRelativeTo(null);
        setVisible(true);


        cancelButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //SmartHomeGUIClient client = new SmartHomeGUIClient("localhost", 8081, "Sergio Oliveira");
                //client.sendUnaryRequest("Sergio Oliveira");

                SmartHomeGUIClient mySmartHome = new SmartHomeGUIClient();

                try
                {
                    mySmartHome.shutdown();
                }

                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
