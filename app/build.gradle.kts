plugins {
    id("com.android.application")
}

android {
    namespace = "com.taohuo.hsyz"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.taohuo.hsyz"
        minSdk = 27
        targetSdk = 36
        versionCode = 1
        versionName = "2.6"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.7.1")
    implementation("com.google.android.material:material:1.14.0")
    implementation("androidx.activity:activity:1.13.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.2")
    implementation("androidx.gridlayout:gridlayout:1.1.0")
    // 网络请求：Retrofit + Gson（自动 JSON 序列化，减少手写代码）
    implementation("com.squareup.retrofit2:retrofit:3.0.0")
    implementation("com.squareup.retrofit2:converter-gson:3.0.0")
    // 图片加载：Glide（商品封面等网络图片）
    //noinspection NewerVersionAvailable
    implementation("com.github.bumptech.glide:glide:4.16.0")
    // Ably 实时通信：买卖家在线聊天（频道即聊天室，与网页端 ably-js 互通）
    implementation("io.ably:ably-android:1.8.0")
    // JSON 持久化：本地会话与聊天记录存储
    implementation("com.google.code.gson:gson:2.14.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.3.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.7.0")
}