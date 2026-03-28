package com.altezza.service;

import com.altezza.model.AppSettings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class RomScanService {

    public List<String> scanRomNames(AppSettings settings) {
        if (settings == null) {
            return List.of();
        }

        String romDirectory = settings.getRomDirectory();
        if (romDirectory == null || romDirectory.isBlank()) {
            return List.of();
        }

        Path romPath;
        try {
            romPath = Path.of(romDirectory);
        } catch (RuntimeException ex) {
            return List.of();
        }

        if (!Files.isDirectory(romPath)) {
            return List.of();
        }

        List<String> romNames = new ArrayList<>();
        try (var files = Files.list(romPath)) {
            files.filter(Files::isRegularFile)
                    .filter(this::isSupportedRom)
                    .map(path -> path.getFileName().toString())
                    .sorted(Comparator.naturalOrder())
                    .forEach(romNames::add);
        } catch (IOException ex) {
            return List.of();
        }

        return romNames;
    }

    private boolean isSupportedRom(Path path) {
        String fileName = path.getFileName().toString().toLowerCase(Locale.ROOT);
        return fileName.endsWith(".gba")
                || fileName.endsWith(".gb")
                || fileName.endsWith(".gbc");
    }
}
