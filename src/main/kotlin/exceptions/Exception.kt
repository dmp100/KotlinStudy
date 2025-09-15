package exceptions

/**
 * 날짜: 2025-09-15
 * 주제: 예외(Exception) 처리
 *
 * 배운 내용:
 * - 예외는 실행 시간에 발생하는 예상치 못한 오류 상황
 * - 컴파일은 성공하지만 실행 중에 프로그램이 중단됨
 * - NumberFormatException: 문자열을 숫자로 변환 실패
 * - ArithmeticException: 0으로 나누기 등 산술 오류
 * - 조건문으로 예외 상황을 미리 방지할 수 있음
 * - 입력 검증과 코너 케이스 고려가 중요함
 *
 * 어려웠던 점:
 * - 컴파일 오류와 런타임 예외의 차이점
 * - 예외가 발생했을 때의 스택 트레이스 읽는 법
 * - 어떤 상황에서 어떤 예외가 발생하는지 예측
 * - 예외 방지를 위한 적절한 검증 로직 작성
 */
fun main() {

    /*************** - 예외란 무엇인가 - ****************/
    // 예외는 프로그램 실행 중에 발생하는 예상치 못한 오류
    // 컴파일은 성공하지만 실행 시점에 프로그램을 중단시킴

    println("=== 예외의 개념 ===")
    println("예외(Exception)의 특징:")
    println("- 컴파일 시점에는 발견되지 않음")
    println("- 실행 중에 프로그램을 중단시킴")
    println("- 예상치 못한 상황에서 발생")
    println("- 적절한 검증으로 방지 가능")

    /*************** - NumberFormatException 예제 - ****************/
    // 문자열을 숫자로 변환할 때 발생하는 예외

    println("\n=== NumberFormatException 방지 ===")

    // 안전하지 않은 버전 (예외 발생 가능)
    fun unsafeReadInt(): Int {
        return readln().toInt()  // "Hi :)" 같은 입력 시 예외 발생
    }

    // 안전한 버전 (예외 방지)
    fun safeReadInt(): Int? {
        println("숫자를 입력하세요:")
        val input = readln()

        // 입력 검증: 숫자인지 확인
        return try {
            input.toInt()
        } catch (e: NumberFormatException) {
            println("오류: '$input'은 올바른 숫자가 아닙니다")
            null
        }
    }

    // 더 간단한 검증 방법
    fun validateAndReadInt(): Int? {
        println("숫자를 입력하세요:")
        val input = readln()

        // 모든 문자가 숫자인지 확인 (음수 고려)
        val isValidNumber = input.all { it.isDigit() } ||
                (input.startsWith("-") && input.drop(1).all { it.isDigit() })

        return if (isValidNumber && input.isNotEmpty() && input != "-") {
            input.toInt()
        } else {
            println("오류: '$input'은 올바른 숫자 형식이 아닙니다")
            null
        }
    }

    // 실제 사용 예시 (시뮬레이션)
    fun simulateNumberInput() {
        val testInputs = listOf("123", "abc", "-45", "12.5", "", "0")

        testInputs.forEach { input ->
            println("입력 시뮬레이션: '$input'")
            try {
                val number = input.toInt()
                println("성공: $number")
            } catch (e: NumberFormatException) {
                println("실패: NumberFormatException 발생")
            }
            println()
        }
    }

    simulateNumberInput()

    /*************** - ArithmeticException 예제 - ****************/
    // 0으로 나누기 등 산술 연산에서 발생하는 예외

    println("=== ArithmeticException 방지 ===")

    // 안전하지 않은 버전
    fun unsafeItemPrice(total: Int, amount: Int): Int {
        return total / amount  // amount가 0이면 예외 발생
    }

    // 안전한 버전 1: 조건문으로 방지
    fun safeItemPrice(total: Int, amount: Int): Int {
        if (amount == 0) {
            println("오류: 0으로 나눌 수 없습니다")
            return 0  // 또는 다른 기본값
        }
        return total / amount
    }

    // 안전한 버전 2: null 반환
    fun safeItemPriceWithNull(total: Int, amount: Int): Int? {
        return if (amount == 0) {
            println("오류: 수량이 0입니다")
            null
        } else {
            total / amount
        }
    }

    // 안전한 버전 3: 실수 계산으로 처리
    fun safeItemPriceDouble(total: Double, amount: Double): Double {
        return if (amount == 0.0) {
            println("경고: 0으로 나누기, 무한대 반환")
            Double.POSITIVE_INFINITY
        } else {
            total / amount
        }
    }

    // 테스트
    println("정상 케이스: ${safeItemPrice(100, 5)}")      // 20
    println("예외 케이스: ${safeItemPrice(100, 0)}")      // 0 (오류 메시지와 함께)

    val nullResult = safeItemPriceWithNull(100, 0)
    println("null 반환: ${nullResult ?: "계산 불가능"}")

    println("무한대 처리: ${safeItemPriceDouble(100.0, 0.0)}")

    /*************** - 다양한 예외 상황들 - ****************/
    // 일반적으로 발생할 수 있는 다른 예외들과 방지법

    println("\n=== 다양한 예외 상황 방지 ===")

    // 1. IndexOutOfBoundsException 방지
    fun safeArrayAccess(arr: Array<Int>, index: Int): Int? {
        return if (index >= 0 && index < arr.size) {
            arr[index]
        } else {
            println("오류: 인덱스 $index 가 배열 범위(0~${arr.size-1})를 벗어남")
            null
        }
    }

    val numbers = arrayOf(10, 20, 30, 40, 50)
    println("정상 접근: ${safeArrayAccess(numbers, 2)}")     // 30
    println("비정상 접근: ${safeArrayAccess(numbers, 10)}")  // null

    // 2. NullPointerException 방지
    fun safeStringLength(str: String?): Int {
        return str?.length ?: 0  // null safe 연산자 사용
    }

    println("문자열 길이: ${safeStringLength("Hello")}")    // 5
    println("null 길이: ${safeStringLength(null)}")        // 0

    // 3. ClassCastException 방지
    fun safeCasting(obj: Any): String {
        return if (obj is String) {
            "문자열: $obj"
        } else {
            "문자열이 아님: ${obj::class.simpleName}"
        }
    }

    println(safeCasting("Hello"))     // 문자열: Hello
    println(safeCasting(123))         // 문자열이 아님: Int

    /*************** - 입력 검증 패턴들 - ****************/
    // 예외를 방지하기 위한 다양한 검증 패턴

    println("\n=== 입력 검증 패턴들 ===")

    // 1. 범위 검증
    fun validateRange(value: Int, min: Int, max: Int): Boolean {
        return value in min..max
    }

    fun safeRangeOperation(value: Int): String {
        return if (validateRange(value, 1, 100)) {
            "유효한 값: $value"
        } else {
            "범위 오류: $value 는 1~100 범위를 벗어남"
        }
    }

    println(safeRangeOperation(50))   // 유효한 값
    println(safeRangeOperation(150)) // 범위 오류

    // 2. 이메일 형식 검증
    fun validateEmail(email: String): Boolean {
        return email.contains("@") &&
                email.contains(".") &&
                email.length > 5 &&
                !email.startsWith("@") &&
                !email.endsWith("@")
    }

    fun processEmail(email: String): String {
        return if (validateEmail(email)) {
            "유효한 이메일: $email"
        } else {
            "잘못된 이메일 형식: $email"
        }
    }

    println(processEmail("user@example.com"))  // 유효한 이메일
    println(processEmail("invalid-email"))     // 잘못된 형식

    // 3. 비어있지 않은 문자열 검증
    fun validateNotEmpty(str: String?): Boolean {
        return !str.isNullOrBlank()
    }

    fun processInput(input: String?): String {
        return if (validateNotEmpty(input)) {
            "처리할 입력: ${input!!.trim()}"
        } else {
            "오류: 입력이 비어있거나 null입니다"
        }
    }

    println(processInput("  Hello  "))  // 처리할 입력: Hello
    println(processInput(""))           // 오류: 비어있음
    println(processInput(null))         // 오류: null

    /*************** - 종합적인 안전한 계산기 예제 - ****************/
    // 여러 예외 상황을 고려한 계산기 함수

    println("\n=== 안전한 계산기 ===")

    fun safeCalculator(a: String, operator: String, b: String): String {
        // 1. 숫자 변환 검증
        val numA = try {
            a.toDouble()
        } catch (e: NumberFormatException) {
            return "오류: '$a'는 올바른 숫자가 아닙니다"
        }

        val numB = try {
            b.toDouble()
        } catch (e: NumberFormatException) {
            return "오류: '$b'는 올바른 숫자가 아닙니다"
        }

        // 2. 연산자 검증 및 계산
        return when (operator) {
            "+" -> "결과: ${numA + numB}"
            "-" -> "결과: ${numA - numB}"
            "*" -> "결과: ${numA * numB}"
            "/" -> {
                if (numB == 0.0) {
                    "오류: 0으로 나눌 수 없습니다"
                } else {
                    "결과: ${numA / numB}"
                }
            }
            "%" -> {
                if (numB == 0.0) {
                    "오류: 0으로 나머지 연산을 할 수 없습니다"
                } else {
                    "결과: ${numA % numB}"
                }
            }
            else -> "오류: 지원하지 않는 연산자 '$operator'"
        }
    }

    // 계산기 테스트
    val testCases = listOf(
        Triple("10", "+", "5"),      // 정상
        Triple("10", "/", "0"),      // 0으로 나누기
        Triple("abc", "+", "5"),     // 잘못된 숫자
        Triple("10", "^", "5"),      // 잘못된 연산자
        Triple("10.5", "*", "2.5")  // 실수 계산
    )

    testCases.forEach { (a, op, b) ->
        println("$a $op $b = ${safeCalculator(a, op, b)}")
    }

    /*************** - 예외 방지 체크리스트 - ****************/

    println("\n=== 예외 방지 체크리스트 ===")
    println("1. 입력값 검증:")
    println("   - null 체크")
    println("   - 빈 문자열 체크")
    println("   - 범위 체크")
    println("   - 형식 체크")

    println("2. 산술 연산:")
    println("   - 0으로 나누기 방지")
    println("   - 오버플로우 고려")
    println("   - 언더플로우 고려")

    println("3. 컬렉션 접근:")
    println("   - 인덱스 범위 체크")
    println("   - 빈 컬렉션 체크")
    println("   - null 컬렉션 체크")

    println("4. 타입 변환:")
    println("   - 안전한 캐스팅 사용")
    println("   - 변환 가능성 사전 확인")
    println("   - 기본값 준비")
}