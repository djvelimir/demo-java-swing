package org.example;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public class TaskLoadApplication extends SwingWorker<Void, Integer> {

    private Logger logger = Logger.getLogger(this.getClass().getName());
    private final int maxSteps = 30;
    private SplashScreen splashScreen;

    public TaskLoadApplication(SplashScreen splashScreen) {
        this.splashScreen = splashScreen;
    }

    @Override
    protected void process(List<Integer> chunks) {
        int currentStep = chunks.get(chunks.size() - 1);
        splashScreen.updateProgress((int) (((double) currentStep / maxSteps) * 100) + "%", currentStep * 100 / maxSteps);
    }

    @Override
    protected Void doInBackground() throws Exception {
        try {
            for (int currentStep = 1; currentStep <= maxSteps; currentStep++) {
                publish(currentStep);

                // Illustrating long-running code.
                Thread.sleep(100);
            }
        } catch (Exception e) {
            logger.severe(e.toString());
            System.exit(0);
        }

        return null;
    }

    @Override
    protected void done() {
        try {
            get();
            splashScreen.setVisible(false);

            MainFrame frame = new MainFrame(new PasswordGeneratorImpl());
            frame.setVisible(true);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
