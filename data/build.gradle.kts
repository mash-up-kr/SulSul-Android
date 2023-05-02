plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = AppConfig.dataNamespace
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
}

dependencies {

    implementation(AndroidX.coreKtx)
    implementation(AndroidX.lifecycleRuntime)
    implementation(Google.material)
    testImplementation(UnitTest.junit)
    androidTestImplementation(AndroidTest.androidJunit)
    androidTestImplementation(AndroidTest.espressoCore)

    // dagger hilt
    implementation(Google.hiltAndroid)
    kapt(Google.hiltCompiler)

    // retrofit
    implementation(Library.retrofit)
    implementation(Library.retrofitGson)

    // okHttp
    implementation(Library.okHttp)
    implementation(Library.okHttpInterceptor)

    implementation(project(":domain"))
}
