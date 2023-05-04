buildscript {
    dependencies {
        classpath(Dependencies.Hilt.HILT_GRADLE)
    }
} // Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version Dependencies.Version.GRADLE apply false
    id("com.android.library") version Dependencies.Version.GRADLE apply false
    id("org.jetbrains.kotlin.android") version Dependencies.Version.KOTLIN apply false
}
