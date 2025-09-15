package functions

/**
 * 날짜: 2025-09-15
 * 주제: 기본 인수 (Default Arguments)
 *
 * 배운 내용:
 * - 함수 매개변수에 기본값을 설정하여 호출 시 인수 생략 가능
 * - = 연산자를 사용해 매개변수 타입 뒤에 기본값 지정
 * - 기본 인수가 있는 매개변수는 생략하거나 일반적으로 호출 가능
 * - 일반 매개변수와 기본 매개변수를 혼합하여 사용할 수 있음
 * - 인수는 왼쪽부터 순서대로 전달되므로 중간 생략 불가
 * - 기본 인수는 Kotlin의 관용적 패턴 중 하나
 *
 * 어려웠던 점:
 * - 기본값이 있는 매개변수의 순서와 호출 시 제약사항
 * - 두 번째 인수만 전달하고 첫 번째를 생략할 수 없는 이유
 * - 일반 매개변수와 기본 매개변수의 배치 순서
 * - 기본값 설정 시 적절한 값 선택 기준
 */
fun main() {

    /*************** - 기본 인수 함수 예제 - ****************/
    // 문서의 핵심 예제: printLine 함수

    println("=== 기본 인수 함수 예제 ===")

    fun printLine(line: String = "", end: String = "\n") = print("$line$end")

    // 다양한 호출 방법
    printLine("Hello, Kotlin", "!!!") // prints "Hello, Kotlin!!!"
    printLine("Kotlin") // prints "Kotlin" with an ending newline
    printLine() // prints an empty line like println()

    /* 출력:
     * Hello, Kotlin!!!Kotlin
     *
     */

    /*************** - 호출 패턴 분석 - ****************/
    // 각 호출에서 어떤 값이 사용되는지 분석

    println("\n=== 호출 패턴 분석 ===")

    fun demonstrate(first: String = "기본1", second: String = "기본2") {
        println("첫 번째: '$first', 두 번째: '$second'")
    }

    println("모든 인수 전달:")
    demonstrate("값1", "값2")

    println("첫 번째 인수만 전달:")
    demonstrate("값1")

    println("인수 없이 호출:")
    demonstrate()

    // 주의: 두 번째 인수만 전달하는 것은 불가능
    // demonstrate(second = "값2")  // 이런 방식은 나중에 named arguments에서 학습

    /*************** - 일반 매개변수와 기본 매개변수 혼합 - ****************/
    // 문서의 findMax 함수 예제

    println("\n=== 일반 매개변수와 기본 매개변수 혼합 ===")

    fun findMax(n1: Int, n2: Int, absolute: Boolean = false): Int {
        val v1: Int
        val v2: Int

        if (absolute) {
            v1 = Math.abs(n1)
            v2 = Math.abs(n2)
        } else {
            v1 = n1
            v2 = n2
        }

        return if (v1 > v2) n1 else n2
    }

    println(findMax(11, 15)) // 15
    println(findMax(11, 15, true)) // 15
    println(findMax(-4, -9)) // -4
    println(findMax(-4, -9, true)) // -9

    /*************** - 기본 인수의 활용 사례 - ****************/
    // 다양한 상황에서의 기본 인수 활용

    println("\n=== 기본 인수 활용 사례 ===")

    // 로그 출력 함수
    fun log(message: String, level: String = "INFO", timestamp: Boolean = true) {
        val timePrefix = if (timestamp) "[${System.currentTimeMillis()}] " else ""
        println("$timePrefix[$level] $message")
    }

    log("시스템 시작")
    log("오류 발생", "ERROR")
    log("디버그 정보", "DEBUG", false)

    // 파일 생성 함수
    fun createFile(name: String, extension: String = "txt", size: Int = 0) {
        println("파일 생성: $name.$extension (크기: ${size}KB)")
    }

    createFile("문서")
    createFile("이미지", "jpg", 1024)
    createFile("스크립트", "kt")

    // 계산 함수
    fun calculate(value: Double, operation: String = "square", precision: Int = 2): String {
        val result = when (operation) {
            "square" -> value * value
            "cube" -> value * value * value
            "sqrt" -> kotlin.math.sqrt(value)
            else -> value
        }
        return "%.${precision}f".format(result)
    }

    println("계산 결과: ${calculate(5.0)}")           // 기본: 제곱
    println("계산 결과: ${calculate(8.0, "cube")}")   // 세제곱
    println("계산 결과: ${calculate(16.0, "sqrt", 4)}")  // 제곱근, 소수점 4자리

    /*************** - 관용적 패턴 - ****************/
    // 문서의 관용구 예제

    println("\n=== 관용적 패턴 ===")

    // 기본적인 관용구
    fun foo(a: Int = 0, b: String = "") {
        println("a: $a, b: '$b'")
    }

    foo()
    foo(10)
    foo(5, "테스트")

    // 복잡한 함수에서의 기본 인수 활용
    fun setupConnection(
        host: String,
        port: Int = 8080,
        timeout: Int = 30,
        retries: Int = 3,
        secure: Boolean = true
    ) {
        println("연결 설정: $host:$port (timeout: ${timeout}s, retries: $retries, secure: $secure)")
    }

    setupConnection("localhost")
    setupConnection("example.com", 443)
    setupConnection("test.com", 8000, 60, 5, false)

    /*************** - 실용적 활용 예제 - ****************/

    println("\n=== 실용적 활용 예제 ===")

    // 이메일 발송 함수
    fun sendEmail(
        to: String,
        subject: String,
        body: String,
        priority: String = "normal",
        cc: String = "",
        attachment: Boolean = false
    ) {
        println("이메일 발송:")
        println("  받는이: $to")
        println("  제목: $subject")
        println("  우선순위: $priority")
        if (cc.isNotEmpty()) println("  참조: $cc")
        if (attachment) println("  첨부파일 포함")
        println("  내용: $body")
        println()
    }

    sendEmail("user@test.com", "안녕하세요", "테스트 메일입니다")
    sendEmail("boss@company.com", "긴급", "중요한 내용", "high", "team@company.com", true)

    // HTTP 요청 함수
    fun httpRequest(
        url: String,
        method: String = "GET",
        headers: Map<String, String> = emptyMap(),
        timeout: Int = 30000,
        followRedirects: Boolean = true
    ) {
        println("HTTP 요청: $method $url")
        println("  타임아웃: ${timeout}ms")
        println("  리다이렉트 따라가기: $followRedirects")
        if (headers.isNotEmpty()) {
            println("  헤더: $headers")
        }
    }

    httpRequest("https://api.example.com/users")
    httpRequest("https://api.example.com/data", "POST", mapOf("Content-Type" to "application/json"))

    // 데이터베이스 연결 함수
    fun connectDatabase(
        database: String,
        username: String = "admin",
        password: String = "",
        host: String = "localhost",
        port: Int = 3306,
        ssl: Boolean = false
    ) {
        println("DB 연결: $username@$host:$port/$database (SSL: $ssl)")
    }

    connectDatabase("myapp")
    connectDatabase("production", "produser", "secretpass", "db.company.com", 5432, true)

    // 게임 캐릭터 생성 함수
    fun createCharacter(
        name: String,
        className: String = "전사",
        level: Int = 1,
        health: Int = 100,
        mana: Int = 50
    ) {
        println("캐릭터 생성: $name")
        println("  클래스: $className (레벨 $level)")
        println("  체력: $health, 마나: $mana")
    }

    createCharacter("용사")
    createCharacter("마법사", "법사", 5, 80, 150)

    // 파일 압축 함수
    fun compressFile(
        filename: String,
        algorithm: String = "zip",
        compressionLevel: Int = 5,
        deleteOriginal: Boolean = false
    ): String {
        val compressedName = "$filename.$algorithm"
        println("파일 압축: $filename -> $compressedName")
        println("  알고리즘: $algorithm (압축률 $compressionLevel)")
        if (deleteOriginal) println("  원본 파일 삭제")
        return compressedName
    }

    compressFile("document.txt")
    compressFile("backup.sql", "gzip", 9, true)

    /*************** - 기본값 설계 팁 - ****************/

    println("\n=== 기본값 설계 팁 ===")

    // 가장 일반적인 값을 기본값으로
    fun formatCurrency(
        amount: Double,
        currency: String = "KRW",  // 한국에서는 원화가 기본
        showSymbol: Boolean = true
    ): String {
        val symbol = when (currency) {
            "KRW" -> "₩"
            "USD" -> "$"
            "EUR" -> "€"
            else -> ""
        }
        return if (showSymbol) "$symbol$amount" else "$amount $currency"
    }

    // 안전한 기본값 사용
    fun downloadFile(
        url: String,
        timeout: Int = 30,  // 적당한 기본 타임아웃
        maxRetries: Int = 3,  // 적당한 재시도 횟수
        bufferSize: Int = 8192  // 표준 버퍼 크기
    ) {
        println("파일 다운로드: $url")
        println("  설정: timeout=${timeout}s, retries=$maxRetries, buffer=${bufferSize}bytes")
    }

    println("통화 포맷:")
    println(formatCurrency(10000.0))
    println(formatCurrency(100.0, "USD"))
    println(formatCurrency(50.0, "EUR", false))

    println("\n파일 다운로드:")
    downloadFile("https://example.com/file.zip")
    downloadFile("https://slow-server.com/large.dat", 60, 5)

    /*************** - 정리 - ****************/

    println("\n=== 정리 ===")
    println("1. 기본 인수는 = 연산자로 매개변수에 기본값 지정")
    println("2. 기본값이 있는 매개변수는 호출 시 생략 가능")
    println("3. 인수는 왼쪽부터 순서대로 전달됨")
    println("4. 일반 매개변수와 기본 매개변수 혼합 가능")
    println("5. 복잡한 함수에서 특히 유용함")
    println("6. 가장 일반적이고 안전한 값을 기본값으로 설정")
}
