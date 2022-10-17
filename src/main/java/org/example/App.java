package org.example;

import javax.swing.*;

/**
 * Swing application
 */
public class App implements IApp {

    public static void main(String[] args) {
        new App().start();
    }

    public void start() {
        SwingUtilities.invokeLater(() -> new TaskLoadApplication().execute());
    }
}
