package com.altezza.ui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SettingsTabView extends VBox {

    public SettingsTabView() {
        setSpacing(12);
        setPadding(new Insets(16));

        Label title = new Label("Settings");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);

        TextField emulatorPathField = new TextField();
        emulatorPathField.setPromptText("Path to emulator executable");

        TextField romDirectoryField = new TextField();
        romDirectoryField.setPromptText("Path to ROM directory");

        TextField profileDirectoryField = new TextField();
        profileDirectoryField.setPromptText("Path to save/profile directory");

        form.addRow(0, new Label("Emulator executable:"), emulatorPathField);
        form.addRow(1, new Label("ROM directory:"), romDirectoryField);
        form.addRow(2, new Label("Save/Profile directory:"), profileDirectoryField);

        Button saveButton = new Button("Save");
        saveButton.setDisable(true);

        HBox actions = new HBox(saveButton);

        getChildren().addAll(title, form, actions);
    }
}
