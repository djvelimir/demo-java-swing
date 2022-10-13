package org.example;

import javax.swing.*;

/**
 * Swing application
 */
public class App {

    public static void main(String[] args) {
        new App().start();
    }

    public void start() {
        SwingUtilities.invokeLater(() -> {
            final SplashScreen s = new SplashScreen();
            s.setVisible(true);

            new TaskLoadApplication(s).execute();
        });
    }
}
