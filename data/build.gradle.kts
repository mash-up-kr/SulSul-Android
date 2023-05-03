plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = AppConfig.DATA_NAME_SPACE
    compileSdk = AppConfig.COMPILE_SDK

    defaultConfig {
        minSdk = AppConfig.MIN_SDK

        testInstrumentationRunner = AppConfig.TEST_RUNNER
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
}

dependencies {

    implementation(Dependencies.AndroidX.CORE_KTX)
    implementation(Dependencies.AndroidX.LIFECYCLE_RUNTIME)
    implementation(Dependencies.AndroidX.MATERIAL)
    testImplementation(Dependencies.UnitTest.JUNIT)
    androidTestImplementation(Dependencies.AndroidTest.ANDROID_JUNIT)
    androidTestImplementation(Dependencies.AndroidTest.ESPRESSO_CORE)

    // dagger hilt
    implementation(Dependencies.Hilt.HILT_ANDROID)
    kapt(Dependencies.Hilt.HILT_COMPILER)

    // retrofit
    implementation(Dependencies.Retrofit.RETROFIT)
    implementation(Dependencies.Retrofit.CONVERTER_GSON)

    // okHttp
    implementation(Dependencies.OkHttp.OKHTTP)
    implementation(Dependencies.OkHttp.OKHTTP_INTERCEPTOR)

    implementation(project(":domain"))
}
