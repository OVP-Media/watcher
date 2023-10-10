import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
}

kotlin {
    group = "fr.rtransat.ovp"
    jvmToolchain(17)
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("org.springframework.boot", "spring-boot-starter")

    // KotlinX / Kotlin
    implementation("org.jetbrains.kotlin", "kotlin-reflect")

    // https://github.com/irgaly/kfswatch
    implementation("io.github.irgaly.kfswatch", "kfswatch", "_")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    // Dev
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // Test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(platform("io.kotest:kotest-bom:_"))
    testImplementation("io.kotest", "kotest-runner-junit5")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        // https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.kotlin.null-safety
        freeCompilerArgs = listOf("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
