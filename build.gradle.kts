plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.5.7"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "io.github.douglas-dreer"
version = "0.0.1-SNAPSHOT"
description = "auth-boot-producer"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // --- Spring Boot ---
    implementation("org.springframework.boot:spring-boot-starter-web") // Starter web básico
    implementation("org.springframework.boot:spring-boot-starter-amqp") // Para falar com o RabbitMQ
    implementation("org.springframework.boot:spring-boot-starter-actuator") // Para monitorar a saúde do app
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin") // Suporte top pra Kotlin e JSON

    // --- Kotlin ---
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // --- Google API (O "Trauma" do OAuth2) ---
    // Cliente principal da API do Google
    implementation("com.google.api-client:google-api-client:2.2.0")
    // Cliente específico para o GMAIL
    implementation("com.google.apis:google-api-services-gmail:v1-rev20220404-2.0.0")
    // Cliente OAuth2 para autenticação
    implementation("com.google.oauth-client:google-oauth-client-jetty:1.34.1")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")


    // --- Testes ---
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.amqp:spring-rabbit-test")
    runtimeOnly("com.h2database:h2")
}


kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
