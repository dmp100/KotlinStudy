package exceptions

/**
 * 날짜: 2025-09-15
 * 주제: 예외 타입과 계층 구조
 *
 * 배운 내용:
 * - 예외들은 subtype-supertype 관계의 계층 구조를 가짐
 * - Throwable이 최상위 타입이고 Error와 Exception으로 나뉨
 * - RuntimeException은 실행 중 발생하는 예외의 상위 타입
 * - ArithmeticException: 잘못된 산술 연산 (0으로 나누기 등)
 * - NumberFormatException: 문자열을 숫자로 변환 실패
 * - IndexOutOfBoundsException: 존재하지 않는 인덱스 접근
 *
 * 어려웠던 점:
 * - subtype과 supertype의 개념과 상속 관계
 * - Error와 Exception의 차이점
 * - RuntimeException이 특별한 이유
 * - 예외 계층 구조에서 각 타입의 위치와 역할
 */
fun main() {

    /*************** - Subtype과 Supertype 개념 - ****************/
    // 커피와 차는 음료의 subtype, 음료는 이들의 supertype
    // subtype: 다른 타입(supertype)의 특성을 상속받는 타입
    // supertype: 하위 타입들의 공통 특성과 행동 규칙을 정의하는 타입

    println("=== Subtype과 Supertype 개념 ===")
    println("예시: 음료(supertype) <- 커피, 차(subtype)")
    println("- 모든 음료는 색깔을 가짐")
    println("- 하지만 커피와 차는 각각 다른 색깔")
    println("- subtype은 supertype의 특성을 상속하지만 고유한 특성도 가짐")

    /*************** - 예외 계층 구조 개요 - ****************/
    // Throwable (최상위)
    //  ├── Error (심각한 시스템 오류)
    //  └── Exception (애플리케이션에서 처리 가능한 예외)
    //       └── RuntimeException (실행 중 발생하는 예외)

    println("\n=== 예외 계층 구조 ===")
    println("Throwable (최상위)")
    println("├── Error (처리하지 말아야 할 심각한 오류)")
    println("└── Exception (애플리케이션에서 처리할 예외)")
    println("    └── RuntimeException (실행 중 발생하는 예외)")
    println("        ├── ArithmeticException")
    println("        ├── NumberFormatException")
    println("        └── IndexOutOfBoundsException")

    /*************** - RuntimeException의 특징 - ****************/
    // RuntimeException: 프로그램 실행 중에 발생할 수 있는 예외
    // 주로 코드의 검증 부족으로 인해 발생
    // 프로그래밍으로 방지 가능

    println("\n=== RuntimeException의 특징 ===")
    println("- 프로그램 정상 실행 중에 발생 가능")
    println("- 코드 검증 부족이 원인")
    println("- 프로그래밍으로 방지 가능")
    println("- Exception의 subtype")

    /*************** - ArithmeticException 예제 - ****************/
    // 잘못된 산술 연산 시 발생하는 예외

    println("\n=== ArithmeticException 예제 ===")

    // 문서의 예제: 0으로 나누기
    fun demonstrateArithmeticException() {
        try {
            val example = 2 / 0  // ArithmeticException 발생
            println("결과: $example")
        } catch (e: ArithmeticException) {
            println("ArithmeticException 발생: ${e.message}")
            println("원인: 0으로 나누기는 허용되지 않음")
        }
    }

    demonstrateArithmeticException()

    // 다른 ArithmeticException 예제들
    println("기타 ArithmeticException 상황들:")

    fun testOtherArithmeticCases() {
        // 정수 오버플로우는 Kotlin에서 예외가 발생하지 않음 (래핑됨)
        val maxInt = Int.MAX_VALUE
        println("Int.MAX_VALUE: $maxInt")
        println("Int.MAX_VALUE + 1: ${maxInt + 1}") // 오버플로우되어 음수가 됨

        // 실제 ArithmeticException은 주로 나누기 관련
        try {
            val modulo = 10 % 0  // 나머지 연산도 0으로 하면 예외
        } catch (e: ArithmeticException) {
            println("나머지 연산에서도 ArithmeticException: ${e.message}")
        }
    }

    testOtherArithmeticCases()

    /*************** - NumberFormatException 예제 - ****************/
    // 숫자가 아닌 문자열을 숫자로 변환하려 할 때 발생

    println("\n=== NumberFormatException 예제 ===")

    // 문서의 예제
    fun demonstrateNumberFormatException() {
        try {
            val string = "It's not a number"
            val number = string.toInt()  // NumberFormatException 발생
            println("변환 결과: $number")
        } catch (e: NumberFormatException) {
            println("NumberFormatException 발생: ${e.message}")
            println("원인: 숫자가 아닌 문자열을 Int로 변환 시도")
        }
    }

    demonstrateNumberFormatException()

    // 다양한 NumberFormatException 케이스
    println("다양한 NumberFormatException 케이스:")

    val testCases = listOf(
        "abc",          // 일반 문자열
        "12.5",         // 소수점 (Int 변환 시)
        "",             // 빈 문자열
        " 123 ",        // 공백 포함
        "123abc",       // 숫자+문자 조합
        "∞"             // 특수 문자
    )

    testCases.forEach { testCase ->
        try {
            val result = testCase.toInt()
            println("'$testCase' -> $result (성공)")
        } catch (e: NumberFormatException) {
            println("'$testCase' -> NumberFormatException")
        }
    }

    /*************** - IndexOutOfBoundsException 예제 - ****************/
    // 존재하지 않는 인덱스에 접근할 때 발생

    println("\n=== IndexOutOfBoundsException 예제 ===")

    // 문서의 예제: StringIndexOutOfBoundsException
    fun demonstrateStringIndexOutOfBounds() {
        try {
            val sequence = "string"
            println("문자열: '$sequence' (길이: ${sequence.length})")
            println("10번 인덱스 접근 시도...")
            println(sequence[10])  // StringIndexOutOfBoundsException 발생
        } catch (e: StringIndexOutOfBoundsException) {
            println("StringIndexOutOfBoundsException 발생: ${e.message}")
            println("원인: 문자열 길이를 초과한 인덱스 접근")
        }
    }

    demonstrateStringIndexOutOfBounds()

    // 다른 IndexOutOfBoundsException 예제들
    println("다른 IndexOutOfBoundsException 예제들:")

    // 배열에서의 IndexOutOfBoundsException
    fun demonstrateArrayIndexOutOfBounds() {
        try {
            val numbers = arrayOf(1, 2, 3, 4, 5)
            println("배열: ${numbers.contentToString()} (크기: ${numbers.size})")
            println("10번 인덱스 접근 시도...")
            println(numbers[10])  // ArrayIndexOutOfBoundsException 발생
        } catch (e: ArrayIndexOutOfBoundsException) {
            println("ArrayIndexOutOfBoundsException 발생: ${e.message}")
        }
    }

    demonstrateArrayIndexOutOfBounds()

    // 리스트에서의 IndexOutOfBoundsException
    fun demonstrateListIndexOutOfBounds() {
        try {
            val items = listOf("apple", "banana", "orange")
            println("리스트: $items (크기: ${items.size})")
            println("5번 인덱스 접근 시도...")
            println(items[5])  // IndexOutOfBoundsException 발생
        } catch (e: IndexOutOfBoundsException) {
            println("IndexOutOfBoundsException 발생: ${e.message}")
        }
    }

    demonstrateListIndexOutOfBounds()

    /*************** - 예외 계층의 실제 확인 - ****************/
    // 예외 타입들 간의 상속 관계 확인

    println("\n=== 예외 타입 계층 확인 ===")

    fun checkExceptionHierarchy() {
        try {
            throw ArithmeticException("테스트 예외")
        } catch (e: RuntimeException) {
            println("ArithmeticException은 RuntimeException의 subtype")
            println("실제 타입: ${e::class.simpleName}")
            println("상위 타입으로 catch 가능: RuntimeException")
        }

        try {
            throw NumberFormatException("테스트 예외")
        } catch (e: Exception) {
            println("NumberFormatException은 Exception의 subtype")
            println("실제 타입: ${e::class.simpleName}")
            println("상위 타입으로 catch 가능: Exception")
        }

        try {
            throw StringIndexOutOfBoundsException("테스트 예외")
        } catch (e: IndexOutOfBoundsException) {
            println("StringIndexOutOfBoundsException은 IndexOutOfBoundsException의 subtype")
            println("실제 타입: ${e::class.simpleName}")
            println("상위 타입으로 catch 가능: IndexOutOfBoundsException")
        }
    }

    checkExceptionHierarchy()

    /*************** - 모든 예외의 공통 특성 - ****************/
    // Throwable에서 상속받은 공통 메서드들

    println("\n=== 모든 예외의 공통 특성 (Throwable 상속) ===")

    fun demonstrateCommonExceptionFeatures() {
        try {
            val result = 10 / 0
        } catch (e: ArithmeticException) {
            println("예외 메시지: ${e.message}")
            println("예외 타입: ${e::class.simpleName}")
            println("예외 문자열 표현: $e")

            // 스택 트레이스 정보도 Throwable에서 제공
            println("스택 트레이스 첫 번째 요소: ${e.stackTrace.firstOrNull()}")
        }
    }

    demonstrateCommonExceptionFeatures()

    /*************** - 정리 - ****************/

    println("\n=== 정리 ===")
    println("1. 예외는 Throwable을 최상위로 하는 계층 구조")
    println("2. Exception은 애플리케이션에서 처리할 수 있는 예외")
    println("3. RuntimeException은 실행 중 발생하는 예외들의 상위 타입")
    println("4. 주요 RuntimeException 타입들:")
    println("   - ArithmeticException: 잘못된 산술 연산")
    println("   - NumberFormatException: 숫자 변환 실패")
    println("   - IndexOutOfBoundsException: 인덱스 범위 초과")
    println("5. subtype 예외는 supertype으로 catch 가능")
}