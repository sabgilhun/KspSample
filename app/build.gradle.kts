import org.sabgil.AndroidSdk
import org.sabgil.Libraries
import org.sabgil.TestLibraries
import org.sabgil.Version
import org.sabgil.Modules

plugins {
    id("com.android.application")
    id("com.google.devtools.ksp") version "1.5.21-1.0.0-beta06"
    kotlin("android")
}

android {
    compileSdkVersion(AndroidSdk.compile)
    buildToolsVersion(AndroidSdk.buildToolVersion)

    defaultConfig {
        applicationId("org.sabgil.kspsample")
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode(Version.versionCode)
        versionName(Version.versionName)
        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
    }

    buildTypes {
        getByName("release") {
            minifyEnabled(false)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(Modules.annotation))
    ksp(project(Modules.processor))

    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.appCompat)
    implementation(Libraries.ktxCore)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.materialComponents)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.androidJunit)
    androidTestImplementation(TestLibraries.espresso)
}