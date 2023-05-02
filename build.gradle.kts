buildscript {
    dependencies {
        classpath(Google.hiltGradle)
    }
} // Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version Version.gradle apply false
    id("com.android.library") version Version.gradle apply false
    id("org.jetbrains.kotlin.android") version Version.kotlin apply false
}
