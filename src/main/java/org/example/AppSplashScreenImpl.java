package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class AppSplashScreenImpl implements AppSplashScreen {

    private JDialog dialog = new JDialog();
    private ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/splash_animation.gif"));
    private JLabel label = new JLabel(imageIcon);
    private JProgressBar progressBar = new JProgressBar();

    @Autowired
    public AppSplashScreenImpl() {
        dialog.setUndecorated(true);
        dialog.getContentPane().add(label, BorderLayout.CENTER);
        dialog.getContentPane().add(progressBar, BorderLayout.PAGE_END);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
    }

    @Override
    public void show() {
        dialog.setVisible(true);
    }

    @Override
    public void hide() {
        dialog.setVisible(false);
    }

    @Override
    public void dispose() {
        dialog.dispose();
    }

    @Override
    public void updateProgress(String progressString, int progressValue) {
        progressBar.setValue(progressValue);
        progressBar.setStringPainted(true);
        progressBar.setString(progressString);
    }
}
