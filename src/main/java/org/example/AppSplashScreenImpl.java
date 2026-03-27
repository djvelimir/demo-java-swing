package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

@Component
public class AppSplashScreenImpl implements AppSplashScreen {
    private final JWindow window;
    private final JProgressBar progressBar;

    @Autowired
    public AppSplashScreenImpl() {
        JLabel label = new JLabel();
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/splash_animation.gif")));
        label.setIcon(imageIcon);
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);

        window = new JWindow();
        window.getContentPane().add(label, BorderLayout.CENTER);
        window.getContentPane().add(progressBar, BorderLayout.PAGE_END);
    }

    @Override
    public void show() {
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    @Override
    public void hide() {
        window.setVisible(false);
    }

    @Override
    public void dispose() {
        window.dispose();
    }

    @Override
    public void updateProgress(String progressString, int progressValue) {
        progressBar.setValue(progressValue);
        progressBar.setString(progressString);
    }
}
