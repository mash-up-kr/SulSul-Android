plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = AppConfig.presentationNamespace
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = AppConfig.testRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AppConfig.kotlinCompilerExt
    }
}

dependencies {

    implementation(AndroidX.coreKtx)
    implementation(AndroidX.appCompat)
    implementation(AndroidX.lifecycleRuntime)
    implementation(Google.material)

    // compose
    implementation(AndroidX.composeActivity)
    implementation(AndroidX.composeUi)
    implementation(AndroidX.composePreview)
    implementation(AndroidX.composeMaterial)

    // dagger hilt
    implementation(Google.hiltAndroid)
    kapt(Google.hiltCompiler)

    testImplementation(UnitTest.junit)
    androidTestImplementation(AndroidTest.androidJunit)
    androidTestImplementation(AndroidTest.espressoCore)

    androidTestImplementation(AndroidTest.composeJunit)
    debugImplementation(AndroidDebug.composeTooling)
    debugImplementation(AndroidDebug.composeManifest)

    implementation(project(":domain"))
}
