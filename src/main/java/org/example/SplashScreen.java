package org.example;

import javax.swing.*;
import java.awt.*;

public class SplashScreen {

    private JDialog dialog = new JDialog();
    private ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/splash_animation.gif"));
    private JLabel label = new JLabel(imageIcon);
    private JProgressBar progressBar = new JProgressBar();

    public SplashScreen() {
        dialog.setUndecorated(true);
        dialog.getContentPane().add(label, BorderLayout.CENTER);
        dialog.getContentPane().add(progressBar, BorderLayout.PAGE_END);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
    }

    public void show() {
        dialog.setVisible(true);
    }

    public void hide() {
        dialog.setVisible(false);
        dialog.dispose();
    }

    public void updateProgress(String progressString, int progressValue) {
        progressBar.setValue(progressValue);
        progressBar.setStringPainted(true);
        progressBar.setString(progressString);
    }
}
