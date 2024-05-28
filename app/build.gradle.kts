import java.util.Properties
import java.io.FileInputStream


plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.mynewsblog"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mynewsblog"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"


     val properties= Properties()
     val localProperties= rootProject.file("local.properties")

        if (localProperties.exists()){
            FileInputStream(localProperties).use { fis->properties.load(fis)
            }
        }

        else{
            throw GradleException("local.properties file not found.Please create it and add it your API Keys")
        }

        buildConfigField("String","API_KEY",properties.getProperty("apiKey"))
        buildConfigField("String","NEWS_URL",properties.getProperty("newsUrl"))
        buildConfigField("String","LOGIN_AUTH_URK",properties.getProperty("loginUrl"))


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures{
        viewBinding=true
        buildConfig=true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

     // nav graph
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    // retrofit
    implementation (libs.retrofit)
    implementation (libs.converter.gson)

    //Hilt
    implementation (libs.hilt.android.v242)
    kapt (libs.hilt.android.testing)
    kapt (libs.hilt.compiler.v242)


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

kapt {
    correctErrorTypes = true
}

