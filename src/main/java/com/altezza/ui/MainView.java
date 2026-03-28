package com.altezza.ui;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

public class MainView extends BorderPane {

    public MainView() {
        TabPane tabPane = new TabPane();

        Tab playTab = new Tab("Play", new PlayTabView());
        playTab.setClosable(false);

        Tab settingsTab = new Tab("Settings", new SettingsTabView());
        settingsTab.setClosable(false);

        tabPane.getTabs().addAll(playTab, settingsTab);
        setCenter(tabPane);
    }
}
