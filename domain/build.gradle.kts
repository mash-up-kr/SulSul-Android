plugins {
    id("kotlin")
    id("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(Dependencies.Hilt.HILT_CORE)
    kapt(Dependencies.Hilt.HILT_COMPILER)

    // coroutine
    implementation(Dependencies.Coroutine.COROUTINE_CORE)
}
