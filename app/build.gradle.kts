plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.google.service)
    alias(libs.plugins.github.ben.names)
}

android {
    namespace = "com.elongocrea.zmovie"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.elongocrea.zmovie"
        minSdk = 26
        targetSdk = 34
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.firebase.auth.ktx)
    implementation(libs.firebase.firestore.ktx)
    implementation(libs.firebase.messaging.ktx)
    implementation(libs.firebase.storage.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.logging.interceptor)

    implementation(libs.library)

    implementation(libs.rxandroid)
    implementation(libs.rxjava)

    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
    implementation(libs.androidx.room.rxjava2)
    implementation(libs.androidx.room.rxjava3)
    implementation(libs.androidx.room.guava)
    testImplementation(libs.androidx.room.testing)
    implementation(libs.androidx.room.paging)

    implementation(libs.androidx.swiperefreshlayout)
    implementation(libs.circleimageview)
    implementation(libs.gson)

    implementation(libs.androidx.material.icons.core)
    implementation(libs.androidx.material.icons.extended)
    implementation(libs.androidx.material3.window)
    implementation(libs.androidx.runtime.livedata)
    implementation(libs.androidx.runtime.rxjava2)

    implementation(libs.androidx.navigation.compose)

    implementation(libs.androidx.core.splashscreen)

    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)

    implementation(libs.rxjava3.rxjava)
    implementation(libs.rxjava3.rxandroid)

    implementation(libs.adapter.rxjava3)

    implementation(libs.androidx.lifecycle.reactivestreams.ktx)
    implementation(libs.androidx.lifecycle.extensions)
    annotationProcessor(libs.androidx.lifecycle.compiler)
}