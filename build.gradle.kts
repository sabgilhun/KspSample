buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath(org.sabgil.GradlePlugin.androidGradlePlugin)
        classpath(org.sabgil.GradlePlugin.kotlinGradlePlugin)
        classpath(org.sabgil.GradlePlugin.kspGradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}