import org.sabgil.*

plugins {
    id("com.android.application")
    id("com.google.devtools.ksp")
    id("kotlin-android")
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

    sourceSets {
        getByName("main") {
            java.srcDir(File("build/generated/ksp/debug/kotlin"))
        }
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
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
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