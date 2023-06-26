plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk= 33
    @Suppress("UnstableApiUsage")
    buildFeatures {
        dataBinding = true
    }

    defaultConfig {
        applicationId= "com.foxykeep.slayerlegendcalculator"
        minSdk =24
        targetSdk =33
        versionCode= 1
        versionName ="1.0"
        testInstrumentationRunner="androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary= true
    }

    buildTypes {
        release {
            isMinifyEnabled= false
            @Suppress("UnstableApiUsage")
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility= JavaVersion.VERSION_18
        targetCompatibility=JavaVersion.VERSION_18
    }
    kotlinOptions {
        jvmTarget = "18"

        // Enable Coroutines and Flow APIs
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi"
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlinx.coroutines.FlowPreview"
    }
    @Suppress("UnstableApiUsage")
    buildFeatures {
        compose=true
        dataBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.5"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    namespace = "com.foxykeep.slayerlegendcalculator"
}

androidComponents {
    onVariants(selector().withBuildType("release")) {
        // Only exclude *.version files in release mode as debug mode requires
        // these files for layout inspector to work.
        it.packaging.resources.excludes.add("META-INF/*.version")
    }
}

dependencies {
    kapt(libs.hilt.android.compiler)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.work.runtime.ktx)
    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)

    // Compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.foundation.layout)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui.viewbinding)
    implementation(libs.androidx.compose.runtime.livedata)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
}