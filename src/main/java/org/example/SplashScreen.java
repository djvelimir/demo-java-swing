package org.example;

import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JDialog {

    private ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/splash_animation.gif"));
    private JLabel label = new JLabel(imageIcon);
    private JProgressBar progressBar = new JProgressBar();

    public SplashScreen() {
        super();
        setUndecorated(true);
        getContentPane().add(label, BorderLayout.CENTER);
        getContentPane().add(progressBar, BorderLayout.PAGE_END);
        pack();
        setLocationRelativeTo(null);
    }

    public void updateProgress(String progressString, int progressValue) {
        progressBar.setValue(progressValue);
        progressBar.setStringPainted(true);
        progressBar.setString(progressString);
    }
}
