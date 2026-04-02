package org.example;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Swing application
 */
public class AppImpl implements App {
    private static final Logger logger = Logger.getLogger(AppImpl.class.getName());

    private final TaskLoadApplication taskLoadApplication;

    public AppImpl(TaskLoadApplication taskLoadApplication) {
        this.taskLoadApplication = taskLoadApplication;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "UIManager.setLookAndFeel exception", e);
        }

        PasswordGenerator passwordGenerator = new PasswordGeneratorImpl();
        AppSplashScreen splashScreen = new AppSplashScreenImpl();
        MainFrame mainFrame = new MainFrameImpl(passwordGenerator);
        TaskLoadApplication taskLoadApplication = new TaskLoadApplicationImpl(splashScreen, mainFrame);
        App app = new AppImpl(taskLoadApplication);
        app.start();
    }

    @Override
    public void start() {
        SwingUtilities.invokeLater(taskLoadApplication::execute);
    }
}
