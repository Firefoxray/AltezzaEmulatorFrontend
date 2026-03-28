package com.altezza.service;

import com.altezza.model.AppSettings;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfigService {

    private static final Pattern JSON_STRING_FIELD =
            Pattern.compile("\"([a-zA-Z]+)\"\\s*:\\s*\"((?:\\\\.|[^\\\"])*)\"");

    private final Path configFilePath;

    public ConfigService() {
        this(Path.of(System.getProperty("user.home"), ".altezza", "settings.json"));
    }

    public ConfigService(Path configFilePath) {
        this.configFilePath = configFilePath;
    }

    public AppSettings load() throws IOException {
        if (Files.notExists(configFilePath)) {
            AppSettings defaults = new AppSettings();
            save(defaults);
            return defaults;
        }

        String json = Files.readString(configFilePath, StandardCharsets.UTF_8);
        return fromJson(json);
    }

    public void save(AppSettings settings) throws IOException {
        Path parent = configFilePath.getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }
        Files.writeString(configFilePath, toJson(settings), StandardCharsets.UTF_8);
    }

    public Path getConfigFilePath() {
        return configFilePath;
    }

    private AppSettings fromJson(String json) {
        AppSettings settings = new AppSettings();
        Matcher matcher = JSON_STRING_FIELD.matcher(json);

        while (matcher.find()) {
            String key = matcher.group(1);
            String value = unescape(matcher.group(2));
            switch (key) {
                case "emulatorPath" -> settings.setEmulatorPath(value);
                case "romDirectory" -> settings.setRomDirectory(value);
                case "saveDirectory" -> settings.setSaveDirectory(value);
                default -> {
                    // Ignore unknown keys to keep parsing resilient.
                }
            }
        }

        return settings;
    }

    private String toJson(AppSettings settings) {
        return """
                {
                  \"emulatorPath\": \"%s\",
                  \"romDirectory\": \"%s\",
                  \"saveDirectory\": \"%s\"
                }
                """.formatted(
                escape(settings.getEmulatorPath()),
                escape(settings.getRomDirectory()),
                escape(settings.getSaveDirectory())
        );
    }

    private String escape(String value) {
        String safeValue = value == null ? "" : value;
        return safeValue
                .replace("\\", "\\\\")
                .replace("\"", "\\\"");
    }

    private String unescape(String value) {
        return value
                .replace("\\\"", "\"")
                .replace("\\\\", "\\");
    }
}
