#!/bin/bash

mkdir -p app/src/main/java/com/servolux/app
mkdir -p app/src/main/res/layout
mkdir -p app/src/main/res/values
mkdir -p gradle/wrapper
mkdir -p .github/workflows

echo 'rootProject.name = "Servolux"
include(":app")' > settings.gradle.kts

echo 'plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
}' > build.gradle.kts

echo 'plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.servolux.app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.servolux.app"
        minSdk = 24
        targetSdk = 34
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
}' > app/build.gradle.kts
