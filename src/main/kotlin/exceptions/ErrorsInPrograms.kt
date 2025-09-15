package exceptions

/**
 * 날짜: 2025-09-15
 * 주제: 프로그램의 오류 유형
 *
 * 배운 내용:
 * - 프로그램 오류는 컴파일 타임 오류와 런타임 오류로 구분됨
 * - 컴파일 타임 오류: 문법 오류, 오타, 잘못된 메서드 호출 등
 * - 런타임 오류: 논리 오류와 처리되지 않은 예외로 구분
 * - IDE의 정적 코드 분석기로 컴파일 오류를 미리 발견 가능
 * - 런타임 오류는 디버깅, 자동 테스트, 코드 리뷰로 방지
 * - 컴파일 성공이 버그 없음을 보장하지는 않음
 *
 * 어려웠던 점:
 * - 논리 오류와 예외의 차이점 구분
 * - 런타임 오류 발견이 컴파일 오류보다 어려운 이유
 * - 정적 코드 분석기의 역할과 한계
 * - 다양한 오류 방지 전략들의 적용 시점
 */
fun main() {

    /*************** - 컴파일 타임 오류 예시 - ****************/
    // 컴파일 시점에 발견되는 오류들 (실제로는 주석 처리)

    println("=== 컴파일 타임 오류의 종류 ===")

    // 1. 문법 오류 (Syntax Error) 예시들
    /*
    // 잘못된 함수명
    fun main(args: Aray<String>) {  // Array가 아닌 Aray (오타)
        printn("Hello!")            // println이 아닌 printn (오타)
    }

    // 괄호/중괄호 누락
    fun badFunction() {
        println("Hello"  // 닫는 괄호 누락
    // 닫는 중괄호 누락

    // 잘못된 키워드 사용
    funk main() {        // fun이 아닌 funk
        println("Test")
    }

    // 잘못된 패키지 import
    import kotlin.randon.Random  // random이 아닌 randon
    */

    println("컴파일 타임 오류:")
    println("- 문법 오류: 오타, 괄호 누락, 잘못된 키워드")
    println("- 존재하지 않는 메서드 호출")
    println("- 잘못된 패키지 이름")
    println("- IDE가 컴파일 전에 미리 감지 가능")

    /*************** - 올바른 컴파일 가능한 코드 - ****************/
    // 컴파일 오류를 수정한 올바른 코드

    println("\n=== 올바른 코드 (컴파일 성공) ===")

    fun correctFunction() {
        println("이 함수는 올바르게 컴파일됩니다")
    }

    correctFunction()

    /*************** - 런타임 오류: 논리 오류 - ****************/
    // 컴파일은 되지만 잘못된 결과를 만드는 논리 오류

    println("\n=== 논리 오류 예시 ===")

    // 예시 1: 잘못된 계산 로직
    fun calculateAverage(a: Int, b: Int, c: Int): Double {
        // 논리 오류: 합계를 2로 나누고 있음 (3으로 나누어야 함)
        return (a + b + c) / 2.0  // 버그!
    }

    val wrongAverage = calculateAverage(10, 20, 30)
    println("잘못된 평균 계산: $wrongAverage")  // 30.0 (실제로는 20.0이어야 함)

    // 올바른 계산
    fun calculateCorrectAverage(a: Int, b: Int, c: Int): Double {
        return (a + b + c) / 3.0  // 수정됨
    }

    val correctAverage = calculateCorrectAverage(10, 20, 30)
    println("올바른 평균 계산: $correctAverage")  // 20.0

    // 예시 2: 잘못된 조건문
    fun checkGrade(score: Int): String {
        return when {
            score >= 90 -> "A"
            score >= 80 -> "B"
            score >= 70 -> "C"
            score >= 60 -> "D"
            else -> "F"
        }
    }

    // 논리적으로는 맞지만, 요구사항과 다를 수 있음
    println("85점의 학점: ${checkGrade(85)}")

    /*************** - 런타임 오류: 처리되지 않은 예외 - ****************/
    // 실행 중에 발생할 수 있는 예외 상황들

    println("\n=== 처리되지 않은 예외 예시 ===")

    // 예시 1: 0으로 나누기 (실제로는 안전하게 처리)
    fun safeDivision(a: Int, b: Int): String {
        return if (b != 0) {
            "결과: ${a / b}"
        } else {
            "오류: 0으로 나눌 수 없습니다"
        }
    }

    println(safeDivision(10, 2))   // 정상
    println(safeDivision(10, 0))   // 예외 방지

    // 예시 2: 배열 인덱스 초과 (안전하게 처리)
    val numbers = arrayOf(1, 2, 3, 4, 5)

    fun safeArrayAccess(array: Array<Int>, index: Int): String {
        return if (index >= 0 && index < array.size) {
            "값: ${array[index]}"
        } else {
            "오류: 인덱스 $index 는 유효하지 않습니다 (배열 크기: ${array.size})"
        }
    }

    println(safeArrayAccess(numbers, 2))   // 정상
    println(safeArrayAccess(numbers, 10))  // 예외 방지

    // 예시 3: 문자열을 숫자로 변환 시 오류 (안전 처리)
    fun safeStringToInt(str: String): String {
        return try {
            val number = str.toInt()
            "변환 성공: $number"
        } catch (e: NumberFormatException) {
            "변환 실패: '$str'는 숫자가 아닙니다"
        }
    }

    println(safeStringToInt("123"))    // 정상
    println(safeStringToInt("abc"))    // 예외 처리

    /*************** - 오류 방지 전략들 - ****************/

    println("\n=== 오류 방지 전략 시연 ===")

    // 1. 방어적 프로그래밍
    fun defensiveProgramming(input: String?): String {
        // null 체크
        if (input == null) {
            return "입력이 null입니다"
        }

        // 빈 문자열 체크
        if (input.isEmpty()) {
            return "입력이 비어있습니다"
        }

        // 길이 체크
        if (input.length > 100) {
            return "입력이 너무 깁니다 (최대 100자)"
        }

        return "유효한 입력: $input"
    }

    println(defensiveProgramming("Hello"))
    println(defensiveProgramming(null))
    println(defensiveProgramming(""))

    // 2. 입력 검증
    fun validateEmail(email: String): Boolean {
        return email.contains("@") && email.contains(".")
    }

    fun processEmail(email: String): String {
        return if (validateEmail(email)) {
            "이메일 처리 완료: $email"
        } else {
            "유효하지 않은 이메일 형식: $email"
        }
    }

    println(processEmail("user@example.com"))
    println(processEmail("invalid-email"))

    /*************** - 디버깅 도구 시연 - ****************/

    println("\n=== 디버깅 기법 예시 ===")

    // 로그를 통한 디버깅
    fun debuggableFunction(x: Int, y: Int): Int {
        println("[DEBUG] 함수 시작: x=$x, y=$y")

        val result = x * y + 10
        println("[DEBUG] 계산 결과: $result")

        println("[DEBUG] 함수 종료")
        return result
    }

    val debugResult = debuggableFunction(5, 3)
    println("최종 결과: $debugResult")

    // 단언문(assertion) 스타일 검사
    fun assertStyle(value: Int): String {
        require(value >= 0) { "값은 0 이상이어야 합니다: $value" }
        require(value <= 100) { "값은 100 이하여야 합니다: $value" }

        return "유효한 값: $value"
    }

    try {
        println(assertStyle(50))   // 정상
        println(assertStyle(-1))   // 예외 발생
    } catch (e: IllegalArgumentException) {
        println("검증 실패: ${e.message}")
    }

    /*************** - 테스트 가능한 코드 작성 - ****************/

    println("\n=== 테스트 가능한 코드 예시 ===")

    // 순수 함수 (side-effect 없음)
    fun pureFunction(a: Int, b: Int): Int {
        return a + b  // 항상 같은 입력에 같은 출력
    }

    // 간단한 테스트 시뮬레이션
    fun testPureFunction() {
        val testCases = listOf(
            Triple(1, 2, 3),
            Triple(0, 0, 0),
            Triple(-1, 1, 0),
            Triple(10, -5, 5)
        )

        var passedTests = 0
        testCases.forEach { (a, b, expected) ->
            val actual = pureFunction(a, b)
            if (actual == expected) {
                println("✓ 테스트 통과: $a + $b = $actual")
                passedTests++
            } else {
                println("✗ 테스트 실패: $a + $b = $actual (예상: $expected)")
            }
        }

        println("테스트 결과: $passedTests/${testCases.size} 통과")
    }

    testPureFunction()

    /*************** - 코드 리뷰 체크리스트 - ****************/

    println("\n=== 코드 리뷰 포인트 ===")

    // 리뷰할 만한 코드 예시
    fun reviewableFunction(items: List<String>, filter: String): List<String> {
        // 1. null 안전성 확인
        val safeItems = items ?: emptyList()

        // 2. 빈 컬렉션 처리
        if (safeItems.isEmpty()) {
            println("빈 리스트가 전달되었습니다")
            return emptyList()
        }

        // 3. 명확한 변수명 사용
        val filteredItems = safeItems.filter { item ->
            item.contains(filter, ignoreCase = true)
        }

        // 4. 결과 로깅
        println("필터링 결과: ${filteredItems.size}개 항목 발견")

        return filteredItems
    }

    val sampleItems = listOf("Apple", "Banana", "Orange", "Grape")
    val result = reviewableFunction(sampleItems, "ap")
    println("필터된 항목들: $result")

    println("\n코드 리뷰 체크 포인트:")
    println("- 변수명이 명확한가?")
    println("- 예외 상황이 처리되었는가?")
    println("- 함수가 단일 책임을 가지는가?")
    println("- 테스트하기 쉬운 구조인가?")
}
