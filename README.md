# TravelApp (Android)

Prosta aplikacja podróżnicza na Androida (Jetpack Compose), która wyświetla listę przykładowych kierunków podróży i podstawowe informacje:

- miasto i kraj,
- najlepszy sezon,
- orientacyjny poziom budżetu.

## Jak sprawdzić, czy aplikacja działa?

### Opcja A (najszybsza): podgląd w Android Studio (Compose Preview)

1. Otwórz projekt w Android Studio.
2. Przejdź do pliku `app/src/main/java/com/example/travelapp/MainActivity.kt`.
3. Znajdź funkcję `TravelPlannerPreview` i kliknij **Split** albo **Design**.
4. Jeśli podgląd renderuje ekran z tytułem *„Twoja aplikacja podróżnicza”* i listą kart (Lizbona, Reykjavik, Kioto, Tbilisi), UI działa poprawnie.

### Opcja B: uruchomienie na emulatorze/telefonie

1. W Android Studio wejdź w **Tools > Device Manager** i utwórz emulator (np. Pixel + API 34).
2. Kliknij **Run 'app'**.
3. Po uruchomieniu powinna pojawić się aplikacja z listą destynacji.

## Oczekiwany rezultat działania

Po starcie aplikacja pokazuje:

- pasek górny: **„Twoja aplikacja podróżnicza”**,
- 4 karty z danymi o kierunkach podróży,
- na każdej karcie: nazwa miasta i kraju, sezon, budżet.

## Weryfikacja z terminala (opcjonalnie)

Jeśli masz poprawnie skonfigurowane środowisko Android SDK/Gradle lokalnie:

```bash
./gradlew assembleDebug
```

Następnie APK znajdziesz zwykle w:

`app/build/outputs/apk/debug/app-debug.apk`

## Struktura

- `app/src/main/java/com/example/travelapp/MainActivity.kt` – ekran główny, UI Compose i podgląd.
- `app/src/main/AndroidManifest.xml` – konfiguracja aplikacji i aktywności startowej.
- `app/build.gradle.kts` – konfiguracja modułu Android.
