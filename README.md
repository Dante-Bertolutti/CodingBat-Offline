# CodingBat Offline

An offline desktop application inspired by [CodingBat.com](https://codingbat.com) for practicing Java coding interview problems without an internet connection. Perfect for road trips, flights, or anywhere you want to sharpen your coding skills.

## Download & Run (No Java Required)

1. Go to the [Releases](https://github.com/Dante-Bertolutti/CodingBat-Offline/releases/latest) page
2. Download `CodingBat-Offline-Windows.zip`
3. Extract the zip to any folder
4. Double-click `CodingBat-Offline.exe`

That's it — the exe bundles its own Java runtime so no install is needed.

## Build From Source

Requires **JDK 21+** installed.

```bash
git clone https://github.com/Dante-Bertolutti/CodingBat-Offline.git
cd CodingBat-Offline
```

**Run directly:**
```bash
./gradlew run
```

**Build the standalone exe:**
```bash
./gradlew packageExe
```
The exe will be at `build/package/CodingBat-Offline/CodingBat-Offline.exe`

## Features

- **80+ coding problems** across 10 categories (Warmup 1-2, String 1-2, Array 1-2, Logic 1-2, Recursion 1-2)
- **Built-in code editor** with Java syntax highlighting (keywords, strings, numbers, comments)
- **Instant feedback** — compiles and runs your solution in-app against test cases
- **Java docs tab** — quick reference for strings, arrays, recursion, operators, and more with code examples
- **Dark theme** — MDB-inspired orange and black color scheme
- **Fully offline** — no internet connection needed

## Tech Stack

- **Java 21** + **JavaFX** for the desktop UI
- **RichTextFX** for syntax-highlighted code editing
- **Gradle** build system with wrapper included
- **jpackage** to bundle everything into a native Windows exe

## License

MIT
