package com.CA;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YourConnection extends JFrame
{

    private JPanel YourConnection;
    private JButton disconnectButton;


    public YourConnection(SmartHomeGUIClient smartHomeClient)
    {

        //WELCOME SCREEN - HOME
        setContentPane(YourConnection);

        //Set the window
        setTitle("Your Connection");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
        setLocationRelativeTo(null);
        setVisible(true);

        disconnectButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //NEED TO CLOSE THE CONNECTION USING THE METHOD SHUTDOWN
            }
        });
    }
}
