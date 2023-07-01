package android.template.gradle.convention.plugins.common

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion

fun CommonExtension<*, *, *, *>.configureAndroid() {
    compileSdk = 33

    defaultConfig.minSdk = 21

    buildFeatures {
        aidl = false
        buildConfig = false
        renderScript = false
        shaders = false
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}