package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

@Component
public class TaskLoadApplicationImpl extends SwingWorker<Void, Integer> implements TaskLoadApplication {

    private static final int NUMBER_OF_STEPS = 30;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final AppSplashScreen splashScreen;
    private final MainFrame mainFrame;

    @Autowired
    public TaskLoadApplicationImpl(AppSplashScreen splashScreen, MainFrame mainFrame) {
        this.splashScreen = splashScreen;
        this.mainFrame = mainFrame;
    }

    @Override
    protected void process(List<Integer> chunks) {
        int currentStep = chunks.getLast();

        if (currentStep == 1) {
            splashScreen.show();
        }

        splashScreen.updateProgress((int) (((double) currentStep / NUMBER_OF_STEPS) * 100) + "%", currentStep * 100 / NUMBER_OF_STEPS);
    }

    @Override
    protected Void doInBackground() throws Exception {
        for (int currentStep = 1; currentStep <= NUMBER_OF_STEPS; currentStep++) {
            publish(currentStep);

            // Illustrating long-running code.
            Thread.sleep(100);
        }

        return null;
    }

    @Override
    protected void done() {
        try {
            get();
            splashScreen.hide();
            splashScreen.dispose();
            mainFrame.show();
        } catch (InterruptedException e) {
            logger.severe(e.toString());
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            logger.severe(e.toString());
            System.exit(0);
        }
    }
}
