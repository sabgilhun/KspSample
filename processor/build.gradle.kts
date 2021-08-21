import org.sabgil.Libraries
import org.sabgil.Modules

plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation(project(Modules.annotation))
    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.ksp)
}