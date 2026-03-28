# Codex Notes

## Project rules
- This app is an emulator frontend, not an emulator.
- Keep code simple and modular.
- Use Java 21, Gradle, JavaFX, JSON config.
- No database.
- No web backend.
- No unnecessary abstraction layers.
- No dependency injection framework.
- No auto updater.
- No emulator download manager.
- No scraping or cover art in v1.

## Package structure
- com.altezza
- com.altezza.model
- com.altezza.service
- com.altezza.ui
- com.altezza.util

## V1 target
- Two tabs: Play and Settings
- mGBA support first
- configure emulator path, ROM folder, save/profile folder
- select ROM and launch emulator
