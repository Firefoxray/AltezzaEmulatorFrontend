package com.altezza.ui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class PlayTabView extends VBox {

    public PlayTabView() {
        setSpacing(12);
        setPadding(new Insets(16));

        Label title = new Label("Play");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);

        ComboBox<String> emulatorCombo = new ComboBox<>();
        emulatorCombo.getItems().add("mGBA");
        emulatorCombo.getSelectionModel().selectFirst();

        ComboBox<String> romCombo = new ComboBox<>();
        romCombo.setPromptText("Select ROM");

        ComboBox<String> profileCombo = new ComboBox<>();
        profileCombo.setPromptText("Select save/profile");

        Button playButton = new Button("Play");
        playButton.setDisable(true);

        form.addRow(0, new Label("Emulator:"), emulatorCombo);
        form.addRow(1, new Label("ROM:"), romCombo);
        form.addRow(2, new Label("Save/Profile:"), profileCombo);
        form.add(playButton, 1, 3);

        getChildren().addAll(title, form);
    }
}
