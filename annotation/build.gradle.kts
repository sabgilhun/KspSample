import org.sabgil.Libraries

plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation(Libraries.kotlinStdLib)
}