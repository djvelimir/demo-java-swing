package org.example;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public class TaskLoadApplication extends SwingWorker<Void, Integer> {

    private static final int NUMBER_OF_STEPS = 30;
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private SplashScreen splashScreen = new SplashScreen();

    @Override
    protected void process(List<Integer> chunks) {
        int currentStep = chunks.get(chunks.size() - 1);

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

            MainFrame frame = new MainFrame(new PasswordGeneratorImpl());
            frame.show();
        } catch (InterruptedException e) {
            logger.severe(e.toString());
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            logger.severe(e.toString());
            System.exit(0);
        }
    }
}
