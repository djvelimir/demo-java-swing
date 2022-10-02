package org.example;

import java.awt.*;

/**
 * Swing application
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            }
        });
    }
}
