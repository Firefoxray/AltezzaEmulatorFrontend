# AltezzaEmulatorFrontend

AltezzaEmulatorFrontend is a Java desktop launcher/front-end for emulators.

## Local development

This repository intentionally does **not** commit `gradle-wrapper.jar` to avoid binary-file PR tooling limitations in this environment.

Use a locally installed Gradle to (re)generate wrapper files when needed:

```bash
gradle wrapper
```

## JavaFX runtime error in IntelliJ

If you run `com.altezza.AltezzaApp.main()` directly with a plain **Application** run config, you may see:

`Error: JavaFX runtime components are missing, and are required to run this application`

Why this happens:

- Since JDK 11+, JavaFX is no longer bundled with the JDK.
- This project gets JavaFX from Gradle via the `org.openjfx.javafxplugin`.
- A plain IDE run configuration may launch only the JDK (without the JavaFX module path), so `launch(args)` cannot find JavaFX runtime modules.

Use one of these fixes:

1. Run through Gradle (recommended):

   ```bash
   gradle run
   ```

   Or in IntelliJ, run the Gradle `application -> run` task.

2. If you must use an IntelliJ Application config, add JavaFX to VM options/module-path manually (or delegate runs to Gradle in IntelliJ settings).
