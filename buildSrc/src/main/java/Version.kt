object Version {
    const val kotlin = "1.8.10"
    const val gradle = "7.4.0"

    const val lifeCycle = "2.6.1"
    const val coreKtx = "1.7.0"
    const val appCompat = "1.6.1"
    const val material = "1.8.0"

    const val junit = "4.13.2"
    const val junitTest = "1.1.5"
    const val espressoCore = "3.5.1"

    const val composeUi = "1.4.2"
    const val composeActivity = "1.7.1"

    const val hilt = "2.44.2"

    const val retrofit = "2.9.0"
    const val okHttp = "4.10.0"

    const val room = "2.4.3"

    const val coroutine = "1.6.4"
    const val viewPager2 = "1.0.0"

    const val coil = "2.3.0"

    const val timber = "5.0.1"
}

object Kotlin {
    const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutine}"
    const val coroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutine}"
}

object AndroidX {
    const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"

    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifeCycle}"
    const val viewPager2 = "androidx.viewpager2:viewpager2:${Version.viewPager2}"

    const val roomRuntime = "androidx.room:room-runtime:${Version.room}"
    const val roomKtx = "androidx.room:room-ktx:${Version.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Version.room}"

    const val composeActivity = "androidx.activity:activity-compose:${Version.composeActivity}"
    const val composeUi = "androidx.compose.ui:ui:${Version.composeUi}"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview:${Version.composeUi}"
    const val composeMaterial = "androidx.compose.material:material:${Version.composeUi}"
}

object Google {
    const val material = "com.google.android.material:material:${Version.material}"
    const val hiltAndroid = "com.google.dagger:hilt-android:${Version.hilt}"
    const val hiltCore = "com.google.dagger:hilt-core:${Version.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Version.hilt}"
    const val hiltGradle = "com.google.dagger:hilt-android-gradle-plugin:${Version.hilt}"
}

object Library {
    const val coilCompose = "io.coil-kt:coil-compose:${Version.coil}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"

    const val okHttp = "com.squareup.okhttp3:okhttp:${Version.okHttp}"
    const val okHttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Version.okHttp}"

    const val timber = "com.jakewharton.timber:timber:${Version.timber}"
}

object UnitTest {
    const val junit = "junit:junit:${Version.junit}"
}

object AndroidTest {
    const val androidJunit = "androidx.core:core-ktx:${Version.junitTest}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Version.espressoCore}"

    const val composeJunit = "androidx.compose.ui:ui-test-junit4:${Version.composeUi}"
}

object AndroidDebug {
    const val composeTooling = "androidx.compose.ui:ui-tooling:${Version.composeUi}"
    const val composeManifest = "androidx.compose.ui:ui-test-manifest:${Version.composeUi}"
}
