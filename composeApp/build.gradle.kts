import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_17)
                }
            }
        }
    }
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    sourceSets {
        
        androidMain.dependencies {
            // Android - Compose
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)

            // Koin - Inject dependency
            implementation(libs.koin.android)

            // Ktor - Http Request
            implementation(libs.ktor.client.android)
            implementation(libs.ktor.client.okhttp)

            // Splash Screen
            implementation(libs.androidx.core.splashscreen)
        }
        commonMain.dependencies {
            // Android - Compose
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)

            // Navigation
            implementation(libs.compose.navigation)

            // Coil
            implementation(libs.landscapist.coil3)

            // Koin - Inject dependency
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)

            // Ktor - Http Request
            implementation(libs.bundles.ktor)

            //Paging3
            implementation(libs.paging.compose.common)
            implementation(libs.paging.common)
        }

        iosMain.dependencies {
            // Ktor - Http Request
            implementation(libs.ktor.client.darwin)
        }
    }
}

android {
    namespace = "com.challenge.kotlinpop"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.challenge.kotlinpop"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/**"
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            merges += "META-INF/LICENSE.md"
            merges += "META-INF/LICENSE-notice.md"
        }
    }
    buildTypes {
        getByName("release") {
            applicationIdSuffix = ".prod"
            versionNameSuffix = ".prod"
            isMinifyEnabled =  true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"api.github.com\"")
        }
        getByName("debug") {
            applicationIdSuffix = ".dev"
            versionNameSuffix = ".dev"
            isMinifyEnabled = false
            isDebuggable = true
            buildConfigField("String", "BASE_URL", "\"api.github.com\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    tasks.withType<KotlinJvmCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
            freeCompilerArgs.add("-opt-in=kotlin.RequiresOptIn")
        }
    }

    buildFeatures {
        buildConfig = true
        compose = true
    }
    dependencies {
        debugImplementation(compose.uiTooling)
    }
}