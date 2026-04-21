plugins {
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
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
}
