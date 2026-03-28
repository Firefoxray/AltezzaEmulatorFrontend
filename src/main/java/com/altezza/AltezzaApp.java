package com.altezza;

import com.altezza.model.AppSettings;
import com.altezza.service.ConfigService;
import com.altezza.ui.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AltezzaApp extends Application {

    @Override
    public void start(Stage stage) {
        ConfigService configService = new ConfigService();
        AppSettings settings = loadSettings(configService);

        Scene scene = new Scene(new MainView(settings, updatedSettings -> saveSettings(configService, updatedSettings)), 900, 600);

        stage.setTitle("Altezza Emulator Frontend");
        stage.setScene(scene);
        stage.show();
    }

    private AppSettings loadSettings(ConfigService configService) {
        try {
            return configService.load();
        } catch (IOException exception) {
            System.err.println("Failed to load settings from " + configService.getConfigFilePath() + ": " + exception.getMessage());
            return new AppSettings();
        }
    }

    private void saveSettings(ConfigService configService, AppSettings settings) {
        try {
            configService.save(settings);
        } catch (IOException exception) {
            System.err.println("Failed to save settings to " + configService.getConfigFilePath() + ": " + exception.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
