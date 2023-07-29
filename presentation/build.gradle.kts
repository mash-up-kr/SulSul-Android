import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = AppConfig.PRESENTATION_NAME_SPACE
    compileSdk = AppConfig.COMPILE_SDK

    defaultConfig {
        minSdk = AppConfig.MIN_SDK

        testInstrumentationRunner = AppConfig.TEST_RUNNER
        consumerProguardFiles("consumer-rules.pro")
        manifestPlaceholders["KAKAO_KEY"] =
            gradleLocalProperties(rootDir).getProperty("kakao_native_key")
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
        kotlinCompilerExtensionVersion = AppConfig.KOTLIN_COMPILER_EXT
    }
}

dependencies {

    implementation(Dependencies.AndroidX.CORE_KTX)
    implementation(Dependencies.AndroidX.APP_COMPAT)
    implementation(Dependencies.AndroidX.LIFECYCLE_RUNTIME)
    implementation(Dependencies.AndroidX.MATERIAL)

    // compose
    implementation(Dependencies.Compose.COMPOSE_ACTIVITY)
    implementation(Dependencies.Compose.COMPOSE_UI)
    implementation(Dependencies.Compose.COMPOSE_UI_UTIL)
    implementation(Dependencies.Compose.COMPOSE_PREVIEW)
    implementation(Dependencies.Compose.COMPOSE_MATERIAL)
    implementation(Dependencies.Compose.COMPOSE_LIFECYCLE_RUNTIME)
    implementation(Dependencies.Accompanist.ACCOMPANIST_WEBVIEW)
    implementation(Dependencies.Accompanist.ACCOMPANIST_SYSTEM_UI_CONTROLLER)

    // dagger hilt
    implementation(Dependencies.Hilt.HILT_ANDROID)
    kapt(Dependencies.Hilt.HILT_COMPILER)

    testImplementation(Dependencies.UnitTest.JUNIT)
    androidTestImplementation(Dependencies.AndroidTest.ANDROID_JUNIT)
    androidTestImplementation(Dependencies.AndroidTest.ESPRESSO_CORE)

    androidTestImplementation(Dependencies.Compose.COMPOSE_JUNIT)
    debugImplementation(Dependencies.Compose.COMPOSE_TOOLING)
    debugImplementation(Dependencies.Compose.COMPOSE_MANITFEST)

    // kakao sdk
    implementation(Dependencies.Kakao.USER_SDK) // 카카오 로그인
    implementation(Dependencies.Kakao.TALK_SDK) // 친구, 메시지(카카오톡)

    // compose coil
    implementation(Dependencies.Coil.COIL_COMPOSE)

    implementation(project(":domain"))
}
