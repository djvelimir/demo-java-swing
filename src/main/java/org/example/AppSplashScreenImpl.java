package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

@Component
public class AppSplashScreenImpl implements AppSplashScreen {

    private final JDialog dialog = new JDialog();
    private final ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/splash_animation.gif")));
    private final JLabel label = new JLabel(imageIcon);
    private final JProgressBar progressBar = new JProgressBar();

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
