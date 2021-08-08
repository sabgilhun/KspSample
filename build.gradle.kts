buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(org.sabgil.GradlePlugin.androidGradlePlugin)
        classpath(org.sabgil.GradlePlugin.kotlinGradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
    }
}