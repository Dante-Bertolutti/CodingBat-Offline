# CodingBat Offline

An offline desktop application inspired by [CodingBat.com](https://codingbat.com) for practicing Java coding interview problems without an internet connection.

## About

CodingBat Offline packages CodingBat-style coding challenges into a standalone `.exe` desktop app with a modern UI. Perfect for road trips, flights, or anywhere you want to sharpen your coding skills offline.

## Tech Stack

- **Language:** Java 21
- **UI Framework:** JavaFX (modern, styled desktop GUI)
- **Build Tool:** Gradle
- **Packaging:** jpackage (bundles JRE + app into a native `.exe`)
- **Styling:** CSS (JavaFX supports CSS theming for a modern look)

## Features (Planned)

- Offline Java coding challenges (Warmup, String, Array, Logic, Recursion, etc.)
- Built-in code editor with syntax highlighting
- Instant feedback — compile and run solutions in-app
- Progress tracking across sessions
- Clean, modern dark-themed UI

## Building

```bash
./gradlew build
./gradlew jpackage   # produces a native .exe installer
```

## License

MIT
