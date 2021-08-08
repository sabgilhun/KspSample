import org.sabgil.Libraries
import org.sabgil.Modules

plugins {
    `java-library`
    kotlin("jvm")
}

dependencies {
    implementation(project(Modules.annotation))
    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.ksp)
}