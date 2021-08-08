import org.sabgil.Libraries

plugins {
    `java-library`
    kotlin("jvm")
}

dependencies {
    implementation(Libraries.kotlinStdLib)
}