package com.altezza;

import com.altezza.ui.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AltezzaApp extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new MainView(), 900, 600);

        stage.setTitle("Altezza Emulator Frontend");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
