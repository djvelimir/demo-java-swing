package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Swing application
 */
@Component
public class AppImpl implements App {
    private static final Logger logger = Logger.getLogger(AppImpl.class.getName());

    private final TaskLoadApplication taskLoadApplication;

    @Autowired
    public AppImpl(TaskLoadApplication taskLoadApplication) {
        this.taskLoadApplication = taskLoadApplication;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "UIManager.setLookAndFeel exception", e);
        }

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringMainConfig.class);
        App app = context.getBean(App.class);
        app.start();
    }

    @Override
    public void start() {
        SwingUtilities.invokeLater(taskLoadApplication::execute);
    }
}
