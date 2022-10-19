package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * Swing application
 */
@Component
public class AppImpl implements App {

    private final TaskLoadApplication taskLoadApplication;

    @Autowired
    public AppImpl(TaskLoadApplication taskLoadApplication) {
        this.taskLoadApplication = taskLoadApplication;
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringMainConfig.class);
        App app = context.getBean(App.class);
        app.start();
    }

    @Override
    public void start() {
        SwingUtilities.invokeLater(() -> taskLoadApplication.execute());
    }
}
