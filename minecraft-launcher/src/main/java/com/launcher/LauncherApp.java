package com.launcher;

import com.launcher.ui.LauncherUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Главное приложение лаунчера Minecraft
 */
public class LauncherApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            LauncherUI launcherUI = new LauncherUI();
            
            Scene scene = new Scene(launcherUI.getRoot(), 900, 600);
            scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
            
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Minecraft Launcher");
            primaryStage.setResizable(false);
            primaryStage.show();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
