plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    kotlin("plugin.serialization") version "2.0.21"
    id("androidx.navigation.safeargs")
}

android {
    namespace = "com.example.midterm"
    compileSdk {
        version = release(36)
    }
    buildFeatures{
        viewBinding=true
    }
    defaultConfig {
        applicationId = "com.example.midterm"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}
dependencies {

    implementation("com.google.android.material:material:1.11.0") // Or the latest version
    // Jetpack Compose Integration
    implementation ("androidx.navigation:navigation-compose:2.9.6")

    // Views/Fragments Integration
    implementation ("androidx.navigation:navigation-fragment:2.9.6")
    implementation ("androidx.navigation:navigation-ui:2.9.6")

    // Feature module support for Fragments
    implementation ("androidx.navigation:navigation-dynamic-features-fragment:2.9.6")

    // Testing Navigation
    androidTestImplementation ("androidx.navigation:navigation-testing:2.9.6")

    // JSON serialization library, works with the Kotlin serialization plugin.
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}