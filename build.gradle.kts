import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

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

// 학습 파일별로 실행할 수 있는 task들
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

// 기본 run task
tasks.register<JavaExec>("run") {
    group = "application"
    description = "Run the main class"
    classpath = sourceSets.main.get().runtimeClasspath
    mainClass.set("literals.StringBasicKt")
}

// 완전 자동화 task
tasks.register("newStudy") {
    doLast {
        // 1. 사용자 입력 받기
        print("파일명 입력 (예: StringTemplate): ")
        val fileName = readLine() ?: "Practice"

        print("어떤 패키지? (예: literals): ")
        val packageName = readLine() ?: "literals"

        val today = LocalDate.now()

        // 2. 코틀린 파일 생성
        val packageDir = File("src/main/kotlin/$packageName")
        packageDir.mkdirs()

        val ktFile = File(packageDir, "$fileName.kt")
        ktFile.writeText("""
package $packageName

/**
 * 날짜: $today
 * 주제: $fileName
 * 
 * 배운 내용:
 * - 
 * 
 * 어려웠던 점:
 * - 
 */
fun main() {
    // TODO: 코드 작성
    println("$fileName 학습 시작!")
}
        """.trimIndent())

        // 3. 패키지별 README.md 생성/업데이트
        val packageReadme = File(packageDir, "README.md")

        if (!packageReadme.exists()) {
            // 새로운 README 생성
            val packageTitle = packageName.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
            }
            packageReadme.writeText("""
# $packageTitle 학습

1. [$fileName](./$fileName.kt) - 

""".trimIndent())
            println("📄 새로운 패키지 README 생성: ${packageReadme.name}")
        } else {
            // 기존 README에 항목 추가
            val existingContent = packageReadme.readText()

            // 마지막 번호 찾기
            val numberRegex = """^(\d+)\.""".toRegex(RegexOption.MULTILINE)
            val lastNumber = numberRegex.findAll(existingContent)
                .mapNotNull { it.groupValues[1].toIntOrNull() }
                .maxOrNull() ?: 0

            val newNumber = lastNumber + 1
            val newEntry = "$newNumber. [$fileName](./$fileName.kt) - \n"

            packageReadme.appendText(newEntry)
            println("📄 패키지 README 업데이트: 항목 $newNumber 추가")
        }

        // 4. 결과 출력
        println("\n🚀 파일 생성 완료!")
        println("📁 파일 위치: ${ktFile.absolutePath}")
        println("🔧 실행 명령어: ./gradlew runNew -PfileName=$fileName -PpackageName=$packageName")
        println("📄 패키지 README: ${packageReadme.absolutePath}")

        // 5. 메인 README 추가용 링크 안내
        println("\n📋 메인 README에 추가할 링크:")
        println("### X.[$packageName](./src/main/kotlin/$packageName/)")
        println("설명 작성 후 수동으로 추가하세요.")
    }
}

// 새로 만든 파일 바로 실행하는 task
tasks.register<JavaExec>("runNew") {
    group = "study"
    description = "Run newly created file"
    classpath = sourceSets.main.get().runtimeClasspath

    // 프로퍼티로 파일명과 패키지명 받기
    val fileName = project.findProperty("fileName")?.toString() ?: "StringBasic"
    val packageName = project.findProperty("packageName")?.toString() ?: "literals"

    mainClass.set("$packageName.${fileName}Kt")
}