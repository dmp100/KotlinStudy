package functions

/**
 * 날짜: 2025-09-15
 * 주제: 명명된 인수 (Named Arguments)
 *
 * 배운 내용:
 * - 함수 호출 시 매개변수 이름을 지정하여 인수 전달 가능
 * - 명명된 인수로 코드 가독성 향상, 특히 매개변수가 많은 함수에서 유용
 * - 명명된 인수를 사용하면 인수 순서 변경 가능
 * - 위치 인수와 명명된 인수 혼합 사용 시 명명된 인수가 뒤에 와야 함
 * - 기본 인수와 명명된 인수를 함께 사용하여 중간 매개변수 생략 가능
 * - 기본값은 다른 매개변수나 함수를 참조할 수 있음
 *
 * 어려웠던 점:
 * - 위치 인수와 명명된 인수 혼합 시 순서 규칙
 * - Kotlin 1.4 이후 변경된 위치 인수 사용 규칙
 * - 기본값에서 다른 매개변수 참조 시 순서 제약
 * - 언제 명명된 인수를 사용하는 것이 적절한지 판단
 */
fun main() {

    /*************** - 코드 가독성 개선 - ****************/
    // 문서의 핵심 예제: 영화관 티켓 판매 계산

    println("=== 코드 가독성 개선 ===")

    fun calcEndDayAmount(startAmount: Int, ticketPrice: Int, soldTickets: Int) =
        startAmount + ticketPrice * soldTickets

    // 일반적인 호출 (가독성이 떨어짐)
    val amount1 = calcEndDayAmount(1000, 10, 500)  // 6000
    println("일반 호출: $amount1")

    // 명명된 인수 사용 (가독성 향상)
    val amount2 = calcEndDayAmount(
        startAmount = 1000,
        ticketPrice = 10,
        soldTickets = 500
    )  // 6000
    println("명명된 인수: $amount2")

    /*************** - 인수 순서 변경 - ****************/
    // 명명된 인수로 순서를 자유롭게 변경

    println("\n=== 인수 순서 변경 ===")

    val amount3 = calcEndDayAmount(
        ticketPrice = 10,
        soldTickets = 500,
        startAmount = 1000
    )  // 6000
    println("순서 변경: $amount3")

    // 다른 순서로도 가능
    val amount4 = calcEndDayAmount(
        soldTickets = 300,
        startAmount = 2000,
        ticketPrice = 15
    )
    println("다른 순서: $amount4")

    /*************** - 위치 인수와 명명된 인수 혼합 - ****************/
    // 위치 인수 다음에 명명된 인수 사용

    println("\n=== 위치 인수와 명명된 인수 혼합 ===")

    // 올바른 사용법: 위치 인수가 먼저
    val amount5 = calcEndDayAmount(1000, ticketPrice = 10, soldTickets = 500)
    println("혼합 사용: $amount5")

    // Kotlin 1.4 이후 규칙 예제
    fun testFunction(a: Int, b: Int, c: Int): String {
        return "a=$a, b=$b, c=$c"
    }

    // 올바른 호출들
    println(testFunction(a = 1, 2, 3))  // OK: 명명된 인수 후 위치 인수 (순서 유지)
    println(testFunction(1, b = 2, c = 3))  // OK: 위치 인수 후 명명된 인수

    // 잘못된 호출 예시 (주석 처리)
    // println(testFunction(b = 2, 1, 3))  // 오류: 순서가 맞지 않음
    // println(testFunction(c = 3, b = 2, 1))  // 오류: 순서가 맞지 않음

    /*************** - 기본 인수와 명명된 인수 - ****************/
    // 문서 예제: 첫 번째 매개변수에 기본값 추가

    println("\n=== 기본 인수와 명명된 인수 ===")

    fun calcEndDayAmountWithDefault(startAmount: Int = 0, ticketPrice: Int, soldTickets: Int) =
        startAmount + ticketPrice * soldTickets

    // 문제가 있는 호출 (의도와 다름)
    //val wrongAmount = calcEndDayAmountWithDefault(10, 500)  // startAmount=10, ticketPrice=500, soldTickets=?? (오류)
    // println("잘못된 호출: $wrongAmount")  // 컴파일 오류

    // 올바른 호출: 명명된 인수 사용
    val correctAmount = calcEndDayAmountWithDefault(ticketPrice = 10, soldTickets = 500)  // 5000
    println("올바른 호출: $correctAmount")

    // 다양한 조합
    val amount6 = calcEndDayAmountWithDefault(startAmount = 1000, ticketPrice = 15, soldTickets = 200)
    println("모든 인수 지정: $amount6")

    /*************** - 기본값에서 다른 매개변수 참조 - ****************/
    // 문서 예제: 매개변수를 기본값으로 사용

    println("\n=== 기본값에서 매개변수 참조 ===")

    // 올바른 예제: 이전 매개변수 참조
    fun sum2(a: Int, b: Int = a) = a + b

    println("sum2(1): ${sum2(1)}")    // 1 + 1 = 2
    println("sum2(2, 3): ${sum2(2, 3)}")  // 2 + 3 = 5

    // 잘못된 예제 (주석 처리 - 컴파일 오류)
    // fun sum2Bad(a: Int = b, b: Int) = a + b  // b가 아직 초기화되지 않음

    // 더 복잡한 예제
    fun createMessage(name: String, greeting: String = "안녕하세요", punctuation: String = "!") =
        "$greeting, $name$punctuation"

    println(createMessage("홍길동"))
    println(createMessage("김철수", greeting = "반갑습니다"))
    println(createMessage("이영희", punctuation = "?"))

    /*************** - 실용적 활용 예제 - ****************/

    println("\n=== 실용적 활용 예제 ===")

    // 복잡한 함수에서 명명된 인수의 위력
    fun configureServer(
        host: String,
        port: Int,
        protocol: String = "HTTP",
        timeout: Int = 30,
        maxConnections: Int = 100,
        enableLogging: Boolean = true,
        compressionEnabled: Boolean = false
    ) {
        println("서버 설정:")
        println("  주소: $protocol://$host:$port")
        println("  타임아웃: ${timeout}초")
        println("  최대 연결: $maxConnections")
        println("  로깅: $enableLogging")
        println("  압축: $compressionEnabled")
        println()
    }

    // 명명된 인수로 명확한 설정
    configureServer(
        host = "localhost",
        port = 8080,
        enableLogging = false,
        compressionEnabled = true
    )

    configureServer(
        host = "production.server.com",
        port = 443,
        protocol = "HTTPS",
        maxConnections = 500
    )

    // 데이터베이스 연결 함수
    fun connectToDatabase(
        database: String,
        username: String,
        password: String,
        host: String = "localhost",
        port: Int = 3306,
        charset: String = "UTF-8",
        autoCommit: Boolean = true
    ) {
        println("DB 연결: $username@$host:$port/$database")
        println("  문자셋: $charset, 자동커밋: $autoCommit")
    }

    // 필수 매개변수만 위치 인수로, 나머지는 명명된 인수로
    connectToDatabase(
        "myapp_db",
        "admin",
        "secret123",
        host = "db.company.com",
        port = 5432,
        autoCommit = false
    )

    // 이메일 발송 함수
    fun sendNotification(
        recipient: String,
        message: String,
        priority: String = "normal",
        sendImmediately: Boolean = false,
        includeAttachment: Boolean = false,
        retryOnFailure: Boolean = true
    ) {
        println("알림 발송:")
        println("  받는이: $recipient")
        println("  메시지: $message")
        println("  우선순위: $priority")
        if (sendImmediately) println("  즉시 발송")
        if (includeAttachment) println("  첨부파일 포함")
        println("  실패 시 재시도: $retryOnFailure")
        println()
    }

    // 다양한 조합으로 호출
    sendNotification("user@test.com", "시스템 점검 안내")

    sendNotification(
        recipient = "admin@company.com",
        message = "긴급 알림",
        priority = "high",
        sendImmediately = true
    )

    sendNotification(
        "team@project.com",
        "주간 보고서",
        includeAttachment = true,
        priority = "low"
    )

    // 게임 캐릭터 생성 함수
    fun createGameCharacter(
        name: String,
        characterClass: String,
        level: Int = 1,
        health: Int = 100,
        mana: Int = 50,
        strength: Int = 10,
        intelligence: Int = 10,
        agility: Int = 10
    ) {
        println("캐릭터 생성: $name ($characterClass)")
        println("  레벨: $level")
        println("  능력치 - 체력: $health, 마나: $mana")
        println("  스탯 - 힘: $strength, 지능: $intelligence, 민첩: $agility")
        println()
    }

    // 기본 전사 생성
    createGameCharacter("용감한전사", "전사")

    // 커스텀 마법사 생성
    createGameCharacter(
        name = "현명한마법사",
        characterClass = "마법사",
        level = 5,
        health = 80,
        mana = 150,
        intelligence = 20,
        agility = 15
    )

    // 일부 스탯만 조정한 도적 생성
    createGameCharacter(
        "그림자도적",
        "도적",
        agility = 25,
        strength = 15
    )

    /*************** - 언제 명명된 인수를 사용할까 - ****************/

    println("=== 명명된 인수 사용 가이드라인 ===")

    // 1. 매개변수가 많은 함수
    fun processPayment(amount: Double, currency: String, method: String,
                       installments: Int, includeInsurance: Boolean,
                       sendReceipt: Boolean, discountCode: String) {
        println("결제 처리: $amount $currency, 방법: $method")
    }

    // 명명된 인수로 명확하게
    processPayment(
        amount = 150000.0,
        currency = "KRW",
        method = "카드",
        installments = 3,
        includeInsurance = false,
        sendReceipt = true,
        discountCode = "SAVE10"
    )

    // 2. Boolean 매개변수가 있는 함수
    fun fileOperation(filename: String, backup: Boolean, overwrite: Boolean, compress: Boolean) {
        println("파일 작업: $filename (백업: $backup, 덮어쓰기: $overwrite, 압축: $compress)")
    }

    // Boolean은 특히 명명된 인수로 명확하게
    fileOperation(
        filename = "important.doc",
        backup = true,
        overwrite = false,
        compress = true
    )

    // 3. 같은 타입의 매개변수가 여러 개인 함수
    fun calculateDistance(x1: Double, y1: Double, x2: Double, y2: Double): Double {
        return kotlin.math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1))
    }

    // 좌표는 명명된 인수로 구분
    val distance = calculateDistance(
        x1 = 0.0, y1 = 0.0,
        x2 = 3.0, y2 = 4.0
    )
    println("거리: $distance")

    /*************** - 정리 - ****************/

    println("\n=== 정리 ===")
    println("1. 명명된 인수는 매개변수명 = 값 형태로 사용")
    println("2. 코드 가독성 향상, 특히 매개변수가 많은 함수에서")
    println("3. 인수 순서를 자유롭게 변경 가능")
    println("4. 위치 인수와 혼합 시 명명된 인수가 뒤에")
    println("5. 기본 인수와 함께 사용하여 중간 매개변수 생략")
    println("6. 기본값은 이전 매개변수를 참조할 수 있음")
    println("7. Boolean, 같은 타입 다중 매개변수에서 특히 유용")
}
