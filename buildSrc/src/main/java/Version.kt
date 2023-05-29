object Dependencies {
    object Version {
        const val KOTLIN = "1.8.10"
        const val GRADLE = "7.4.0"
    }

    object AndroidX {
        private const val LIFECYCLE_VERSION = "2.6.1"
        private const val CORE_KTX_VERSION = "1.7.0"
        private const val APP_COMPAT_VERSION = "1.6.1"
        private const val MATERIAL_VERSION = "1.8.0"

        const val CORE_KTX = "androidx.core:core-ktx:$CORE_KTX_VERSION"
        const val APP_COMPAT = "androidx.appcompat:appcompat:$APP_COMPAT_VERSION"
        const val LIFECYCLE_RUNTIME =
            "androidx.lifecycle:lifecycle-runtime-ktx:$LIFECYCLE_VERSION"
        const val MATERIAL = "com.google.android.material:material:$MATERIAL_VERSION"
    }

    object Retrofit {
        private const val VERSION = "2.9.0"

        const val RETROFIT = "com.squareup.retrofit2:retrofit:$VERSION"
        const val CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:$VERSION"
    }

    object OkHttp {
        private const val VERSION = "4.10.0"

        const val OKHTTP = "com.squareup.okhttp3:okhttp:$VERSION"
        const val OKHTTP_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:$VERSION"
    }

    object Hilt {
        private const val VERSION = "2.44.2"
        private const val VIEWMODEL_VERSION = "1.0.0"

        const val HILT_ANDROID = "com.google.dagger:hilt-android:$VERSION"
        const val HILT_CORE = "com.google.dagger:hilt-core:$VERSION"
        const val HILT_COMPILER = "com.google.dagger:hilt-compiler:$VERSION"
        const val HILT_GRADLE = "com.google.dagger:hilt-android-gradle-plugin:$VERSION"
        const val HILT_VIEW_MODEL =
            "androidx.hilt:hilt-navigation-compose:$VIEWMODEL_VERSION"
    }

    object Compose {
        private const val UI_VERISON = "1.4.2"
        private const val ACTIVITY_VERSION = "1.7.1"
        private const val VIEW_MODEL_VERSION = "2.6.0"

        const val COMPOSE_ACTIVITY = "androidx.activity:activity-compose:$ACTIVITY_VERSION"
        const val COMPOSE_UI = "androidx.compose.ui:ui:$UI_VERISON"
        const val COMPOSE_PREVIEW = "androidx.compose.ui:ui-tooling-preview:$UI_VERISON"
        const val COMPOSE_MATERIAL = "androidx.compose.material:material:$UI_VERISON"

        const val COMPOSE_JUNIT = "androidx.compose.ui:ui-test-junit4:$UI_VERISON"
        const val COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling:$UI_VERISON"
        const val COMPOSE_MANITFEST = "androidx.compose.ui:ui-test-manifest:$UI_VERISON"

        const val COMPOSE_VIEW_MODEL =
            "androidx.lifecycle:lifecycle-viewmodel-compose:$VIEW_MODEL_VERSION"
    }

    object Accompanist {
        private const val VERSION = "0.30.1"

        const val ACCOMPANIST_WEBVIEW = "com.google.accompanist:accompanist-webview:$VERSION"
    }

    object Coil {
        private const val VERSION = "2.3.0"

        const val COIL_COMPOSE = "io.coil-kt:coil-compose:$VERSION"
    }

    object ViewPager {
        private const val VERSION = "1.0.0"

        const val VIEW_PAGER2 = "androidx.viewpager2:viewpager2:$VERSION"
    }

    object Coroutine {
        private const val VERSION = "1.6.4"

        const val COROUTINE_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$VERSION"
        const val COROUTINE_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$VERSION"
    }

    object Room {
        private const val VERSION = "2.4.3"

        const val ROOM_RUNTIME = "androidx.room:room-runtime:$VERSION"
        const val ROOM_KTX = "androidx.room:room-ktx:$VERSION"
        const val ROOM_COMPILER = "androidx.room:room-compiler:$VERSION"
    }

    object UnitTest {
        private const val JUNIT_VERSION = "4.13.2"

        const val JUNIT = "junit:junit:$JUNIT_VERSION"
    }

    object AndroidTest {
        private const val JUNIT_TEST_VERSION = "1.1.5"
        private const val ESPRESSO_VERSION = "3.5.1"

        const val ANDROID_JUNIT = "androidx.core:core-ktx:$JUNIT_TEST_VERSION"
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:$ESPRESSO_VERSION"
    }

    object DataStore {
        private const val DATASTORE_VERSION = "1.0.0"

        const val PREFERENCE = "androidx.datastore:datastore-preferences:$DATASTORE_VERSION"
        const val PREFERENCE_CORE =
            "androidx.datastore:datastore-preferences-core:$DATASTORE_VERSION"
    }

    object Kakao {
        private const val KAKAO_VERSION = "2.13.0"
        const val USER_SDK = "com.kakao.sdk:v2-user:$KAKAO_VERSION"
        const val TALK_SDK = "com.kakao.sdk:v2-talk:$KAKAO_VERSION"
    }
}
