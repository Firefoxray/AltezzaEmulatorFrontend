package com.altezza.ui;

import com.altezza.model.AppSettings;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.function.Consumer;

public class SettingsTabView extends VBox {

    private final TextField emulatorPathField = new TextField();
    private final TextField romDirectoryField = new TextField();
    private final TextField saveDirectoryField = new TextField();

    public SettingsTabView(AppSettings settings, Consumer<AppSettings> onSave) {
        setSpacing(12);
        setPadding(new Insets(16));

        Label title = new Label("Settings");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);

        emulatorPathField.setPromptText("Path to emulator executable");
        romDirectoryField.setPromptText("Path to ROM directory");
        saveDirectoryField.setPromptText("Path to save/profile directory");

        form.addRow(0, new Label("Emulator executable:"), emulatorPathField);
        form.addRow(1, new Label("ROM directory:"), romDirectoryField);
        form.addRow(2, new Label("Save/Profile directory:"), saveDirectoryField);

        Button saveButton = new Button("Save");
        saveButton.setOnAction(event -> {
            settings.setEmulatorPath(emulatorPathField.getText());
            settings.setRomDirectory(romDirectoryField.getText());
            settings.setSaveDirectory(saveDirectoryField.getText());
            onSave.accept(settings);
        });

        loadSettingsIntoFields(settings);

        HBox actions = new HBox(saveButton);
        getChildren().addAll(title, form, actions);
    }

    private void loadSettingsIntoFields(AppSettings settings) {
        emulatorPathField.setText(settings.getEmulatorPath());
        romDirectoryField.setText(settings.getRomDirectory());
        saveDirectoryField.setText(settings.getSaveDirectory());
    }
}
