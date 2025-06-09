plugins {
    kotlin("jvm") version "2.1.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(22)
}

// 학습 파일별로 실행할 수 있는 task들 (application 플러그인 없이)
tasks.register<JavaExec>("runStringBasic") {
    group = "study"
    description = "Run StringBasic.kt"
    classpath = sourceSets.main.get().runtimeClasspath
    mainClass.set("literals.StringBasicKt")
}

tasks.register<JavaExec>("runMain") {
    group = "study"
    description = "Run Main.kt"
    classpath = sourceSets.main.get().runtimeClasspath
    mainClass.set("MainKt")
}

// 기본 run task (application 플러그인 대신)
tasks.register<JavaExec>("run") {
    group = "application"
    description = "Run the main class"
    classpath = sourceSets.main.get().runtimeClasspath
    mainClass.set("literals.StringBasicKt")
}