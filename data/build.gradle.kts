plugins {
    id("com.android.library")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
    id ("org.jetbrains.kotlinx.kover")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization")
}

android {
    namespace = "com.bilalhaider.ticketmastertechtest.data"
    compileSdk = Versions.TARGET_ANDROID_SDK

    defaultConfig {
        minSdk = Versions.MIN_ANDROID_SDK
        targetSdk = Versions.TARGET_ANDROID_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    testOptions {
        unitTests.all {
            it.useJUnitPlatform()
        }
    }
}

dependencies {

    // Serialization dependencies
    api("org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.Kotlinx.SERIALIZATION}")
    api("org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.Kotlinx.SERIALIZATION}")

    // Coroutine dependencies
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlinx.COROUTINES}")

    // Hilt dependencies
    implementation("com.google.dagger:hilt-android:${Versions.Hilt.HILT}")
    kapt("com.google.dagger:hilt-android-compiler:${Versions.Hilt.HILT}")
    kapt("androidx.hilt:hilt-compiler:${Versions.Hilt.HILT_COMPILER}")

    // Room dependencies
    implementation("androidx.room:room-runtime:2.5.2")
    implementation("androidx.room:room-ktx:2.5.2")
    kapt("androidx.room:room-ktx:2.5.2")

    // Ktor dependencies
    implementation("io.ktor:ktor-client-core:${Versions.KTOR}")
    implementation("io.ktor:ktor-client-android:${Versions.KTOR}")
    implementation("io.ktor:ktor-client-content-negotiation:${Versions.KTOR}")
    implementation("io.ktor:ktor-serialization-kotlinx-json:${Versions.KTOR}")
    implementation("io.ktor:ktor-client-logging:${Versions.KTOR}")
    implementation("io.ktor:ktor-client-mock:${Versions.KTOR}")

    // Testing dependencies
    testImplementation(kotlin("test-junit"))
    testImplementation("com.google.truth:truth:1.1.3")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    testImplementation("io.ktor:ktor-client-mock:2.3.1")
    testImplementation("io.mockk:mockk:${Versions.MOCKK}")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}