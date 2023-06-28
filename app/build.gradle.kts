plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
    id ("org.jetbrains.kotlinx.kover")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization")
}

android {
    namespace = "com.bilalhaider.ticketmastertechtest"
    compileSdk = Versions.TARGET_ANDROID_SDK

    defaultConfig {
        applicationId = "com.bilalhaider.ticketmastertechtest"
        minSdk = Versions.MIN_ANDROID_SDK
        targetSdk = Versions.TARGET_ANDROID_SDK
        versionCode = 1
        versionName = "1.0"

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

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }

    testOptions {
        unitTests.all {
            it.useJUnitPlatform()
        }
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))

    // Androidx appcompat and core dependencies
    implementation("androidx.appcompat:appcompat:${Versions.Androidx.APP_COMPAT}")
    implementation("androidx.core:core-ktx:${Versions.Androidx.CORE_KTX}")

    // Compose
    implementation("androidx.activity:activity-compose:${Versions.Androidx.ACTIVITY_COMPOSE}")
    implementation("androidx.compose.ui:ui:${Versions.Compose.COMPOSE}")
    implementation("androidx.compose.ui:ui-tooling:${Versions.Compose.COMPOSE}")
    implementation("androidx.compose.foundation:foundation:${Versions.Compose.COMPOSE}")
    implementation("androidx.compose.material3:material3:${Versions.MATERIAL}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Compose.VIEWMODEL_COMPOSE}")
    implementation("androidx.paging:paging-compose:${Versions.Compose.PAGING_COMPOSE}")
    implementation("io.coil-kt:coil-compose:${Versions.COIL}")

    // Lifecycle dependencies
    implementation("androidx.lifecycle:lifecycle-process:${Versions.Androidx.LIFECYCLE}")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Androidx.LIFECYCLE}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Androidx.LIFECYCLE}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Androidx.LIFECYCLE}")

    // Hilt dependencies
    implementation("com.google.dagger:hilt-android:${Versions.Hilt.HILT}")
    kapt("com.google.dagger:hilt-android-compiler:${Versions.Hilt.HILT}")
    kapt("androidx.hilt:hilt-compiler:${Versions.Hilt.HILT_COMPILER}")

    // Coroutine dependencies
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlinx.COROUTINES}")

    // Testing dependencies
    testImplementation(kotlin("test-junit"))
    testImplementation("com.google.truth:truth:1.1.3")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    testImplementation("io.ktor:ktor-client-mock:2.3.1")
    testImplementation("io.mockk:mockk:${Versions.MOCKK}")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")

    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    androidTestImplementation("io.mockk:mockk-android:${Versions.MOCKK}")
    androidTestImplementation("io.mockk:mockk-agent:${Versions.MOCKK}")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
}