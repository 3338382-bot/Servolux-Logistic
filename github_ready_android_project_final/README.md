# BlueWebView

Минималистичный WebView на Kotlin + Material 3 (синие тона).

## Особенности
- Splash screen с androidx.core:core-splashscreen
- WebView с JavaScript, DOM storage, прогресс-баром
- Pull-to-refresh (SwipeRefreshLayout)
- Экран настроек для смены URL
- Material 3 дизайн
- minSdk 24, targetSdk 35

## Сборка APK

1. Залей проект в GitHub
2. Открой вкладку **Actions**
3. Запусти workflow **Android Release**
4. Скачай APK из **Artifacts**

## Локальная сборка

```
./gradlew assembleRelease
```

APK будет в `app/build/outputs/apk/release/`.

## Структура проекта
```
BlueWebView/
├── .github/workflows/android-release.yml
├── settings.gradle.kts
├── build.gradle.kts
├── gradle.properties
├── gradle/wrapper/gradle-wrapper.properties
└── app/
    ├── build.gradle.kts
    └── src/main/
        ├── AndroidManifest.xml
        ├── java/com/example/bluewebview/
        │   ├── MainActivity.kt
        │   └── SettingsActivity.kt
        └── res/
            ├── layout/
            ├── values/
            └── drawable/
```
