package org.example;

public interface AppSplashScreen {
    void show();

    void hide();

    void dispose();

    void updateProgress(String progressString, int progressValue);
}
