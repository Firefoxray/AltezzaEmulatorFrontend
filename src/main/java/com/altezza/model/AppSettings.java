package com.altezza.model;

public class AppSettings {

    private String emulatorPath;
    private String romDirectory;
    private String saveDirectory;

    public AppSettings() {
        this("", "", "");
    }

    public AppSettings(String emulatorPath, String romDirectory, String saveDirectory) {
        this.emulatorPath = emulatorPath;
        this.romDirectory = romDirectory;
        this.saveDirectory = saveDirectory;
    }

    public String getEmulatorPath() {
        return emulatorPath;
    }

    public void setEmulatorPath(String emulatorPath) {
        this.emulatorPath = emulatorPath;
    }

    public String getRomDirectory() {
        return romDirectory;
    }

    public void setRomDirectory(String romDirectory) {
        this.romDirectory = romDirectory;
    }

    public String getSaveDirectory() {
        return saveDirectory;
    }

    public void setSaveDirectory(String saveDirectory) {
        this.saveDirectory = saveDirectory;
    }
}
