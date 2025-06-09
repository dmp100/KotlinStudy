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
        val dayOfWeek = try {
            today.dayOfWeek.getDisplayName(
                TextStyle.FULL,
                Locale.KOREAN
            )
        } catch (e: Exception) {
            today.dayOfWeek.name
        }

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

        // 3. daily-log.md 업데이트
        val dailyLog = File("daily-log.md")
        val existingContent = if (dailyLog.exists()) dailyLog.readText() else ""

        // 오늘 날짜가 이미 있는지 확인
        val todayHeader = "## 📅 $today"
        val newEntry = if (!existingContent.contains(todayHeader)) {
            """
$todayHeader ($dayOfWeek)
### 오늘 한 일
- [`$packageName/$fileName.kt`](./src/main/kotlin/$packageName/$fileName.kt) $fileName 학습 시작

### 배운 내용
- 

### 느낀 점
- 

---

$existingContent
            """.trimIndent()
        } else {
            // 오늘 날짜가 있으면 파일만 추가
            existingContent.replace(
                "### 오늘 한 일",
                "### 오늘 한 일\n- [`$packageName/$fileName.kt`](./src/main/kotlin/$packageName/$fileName.kt) $fileName 학습 시작"
            )
        }

        dailyLog.writeText(newEntry)

        // 4. Git 자동 커밋
        try {
            val gitAdd = ProcessBuilder("git", "add", ".").directory(project.projectDir).start()
            gitAdd.waitFor()

            val commitMsg = "📚 $today: $fileName 학습 시작\n\n- 새 파일: $packageName/$fileName.kt\n- daily-log 업데이트"
            val gitCommit = ProcessBuilder("git", "commit", "-m", commitMsg).directory(project.projectDir).start()
            gitCommit.waitFor()

            println("✅ Git 커밋 완료!")

        } catch (e: Exception) {
            println("⚠️ Git 커밋 실패: ${e.message}")
        }

        // 5. 결과 출력
        println("\n🚀 파일 생성 완료!")
        println("📁 파일 위치: ${ktFile.absolutePath}")
        println("🔧 실행 명령어: ./gradlew runNew -PfileName=$fileName -PpackageName=$packageName")
        println("📝 daily-log.md 업데이트됨")
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