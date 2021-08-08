package org.sabgil


const val kotlinVersion = "1.5.21"

object GradlePlugin {
    private object Version {
        const val androidGradlePlugin = "4.2.2"
    }

    const val androidGradlePlugin =
        "com.android.tools.build:gradle:${Version.androidGradlePlugin}"

    const val kotlinGradlePlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
}

object AndroidSdk {
    const val min = 23
    const val compile = 30
    const val target = 30
    const val buildToolVersion = "30.0.3"
}

object Version {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Modules {
    const val app = ":app"
    const val annotation = ":annotation"
    const val processor = ":processor"
}

object Libraries {
    private object Versions {
        const val appcompat = "1.3.1"
        const val ktx = "1.6.0"
        const val constraintLayout = "2.1.0"
        const val material = "1.4.0"
        const val ksp = "1.5.21-1.0.0-beta06"
    }

    const val kotlinStdLib =
        "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
    const val appCompat =
        "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val ktxCore =
        "androidx.core:core-ktx:${Versions.ktx}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val materialComponents =
        "com.google.android.material:material:${Versions.material}"
    const val ksp =
        "com.google.devtools.ksp:symbol-processing-api:${Versions.ksp}"
}

object TestLibraries {
    private object Versions {
        const val junit4 = "4.13.2"
        const val androidJunit = "1.1.3"
        const val espresso = "3.4.0"
    }

    const val junit4 = "junit:junit:${Versions.junit4}"
    const val androidJunit = "androidx.test.ext:junit:${Versions.androidJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}
