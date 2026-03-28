package com.altezza.ui;

import com.altezza.model.AppSettings;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

import java.util.function.Consumer;

public class MainView extends BorderPane {

    public MainView(AppSettings settings, Consumer<AppSettings> onSaveSettings) {
        TabPane tabPane = new TabPane();

        Tab playTab = new Tab("Play", new PlayTabView(settings));
        playTab.setClosable(false);

        Tab settingsTab = new Tab("Settings", new SettingsTabView(settings, onSaveSettings));
        settingsTab.setClosable(false);

        tabPane.getTabs().addAll(playTab, settingsTab);
        setCenter(tabPane);
    }
}
