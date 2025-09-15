package exceptions

/**
 * 날짜: 2025-09-15
 * 주제: try-catch 문 상세 - 다중 예외 처리와 정보 획득
 *
 * 배운 내용:
 * - try-catch는 예외 처리 메커니즘의 핵심
 * - catch 블록은 지정된 예외 타입과 모든 하위 타입을 처리
 * - 예외 발생 시 try 블록의 나머지 코드는 실행되지 않음
 * - e.message로 예외에 대한 상세 정보 획득 가능
 * - 여러 catch 블록으로 다양한 예외 타입을 각각 처리
 * - 구체적인 예외 타입을 일반적인 타입보다 먼저 배치해야 함
 *
 * 어려웠던 점:
 * - catch 블록의 순서가 중요한 이유 (상속 관계)
 * - try 블록 내 변수의 스코프 제한
 * - 적절한 예외 처리 위치 결정
 * - 구체적 예외 vs 일반적 예외 선택 기준
 */
fun main() {

    /*************** - 기본 try-catch 템플릿 - ****************/
    // try { 예외 발생 가능 코드 }
    // catch (e: 예외타입) { 예외 처리 코드 }

    println("=== 기본 try-catch 구조 ===")

    try {
        // 예외가 발생할 수 있는 코드
        println("예외 발생 가능한 코드 실행")
    } catch (e: Exception) {
        // 예외 처리 코드
        println("예외 처리")
    }

    /*************** - 실행 흐름 상세 분석 - ****************/
    // 문서의 핵심 예제: 실행 순서 확인

    println("\n=== 실행 흐름 분석 ===")

    println("Before the try-catch block") // 출력됨
    try {
        println("Inside the try block before an exception") // 출력됨
        println(2 / 0) // ArithmeticException 발생
        println("Inside the try block after the exception") // 출력되지 않음
    } catch (e: ArithmeticException) {
        println("Division by zero!") // 출력됨
    }
    println("After the try-catch block") // 출력됨

    /*************** - catch 블록의 예외 타입 범위 - ****************/
    // 지정된 타입과 모든 하위 타입을 처리

    println("\n=== catch 블록의 예외 타입 범위 ===")

    // ArithmeticException으로 구체적 처리
    try {
        val result = 10 / 0
    } catch (e: ArithmeticException) {
        println("ArithmeticException 처리: ${e.message}")
    }

    // Exception으로 더 넓은 범위 처리 (ArithmeticException도 포함)
    try {
        val result = 15 / 0
    } catch (e: Exception) {
        println("Exception으로 처리: ${e.message}")
        println("실제 예외 타입: ${e::class.simpleName}")
    }

    // RuntimeException으로 중간 범위 처리
    try {
        val result = 20 / 0
    } catch (e: RuntimeException) {
        println("RuntimeException으로 처리: ${e.message}")
        println("실제 예외 타입: ${e::class.simpleName}")
    }

    /*************** - 부적절한 예외 타입 사용 - ****************/
    // NumberFormatException으로는 ArithmeticException을 잡을 수 없음

    println("\n=== 부적절한 예외 타입 ===")

    try {
        try {
            val result = 25 / 0  // ArithmeticException 발생
        } catch (e: NumberFormatException) {
            // 이 catch는 ArithmeticException을 처리할 수 없음
            println("NumberFormatException 처리 (실행되지 않음)")
        }
    } catch (e: ArithmeticException) {
        println("외부에서 ArithmeticException 처리: ${e.message}")
    }

    /*************** - 예외 정보 획득 - ****************/
    // e.message를 통한 상세 정보 확인

    println("\n=== 예외 정보 획득 ===")

    // 문서의 예제
    try {
        val d = (2 / 0).toDouble()
    } catch (e: Exception) {
        println("예외 메시지: ${e.message}")  // "/ by zero" 출력
    }

    // 다양한 예외의 메시지 확인
    try {
        "abc".toInt()
    } catch (e: Exception) {
        println("NumberFormatException 메시지: ${e.message}")
    }

    try {
        val str = "Hello"
        str[10]
    } catch (e: Exception) {
        println("StringIndexOutOfBoundsException 메시지: ${e.message}")
    }

    /*************** - 단일 핸들러로 모든 예외 처리 - ****************/
    // Exception으로 모든 예외를 한 번에 처리

    println("\n=== 단일 핸들러 사용 ===")

    fun demonstrateSingleHandler(testCase: String) {
        try {
            when (testCase) {
                "arithmetic" -> println(10 / 0)
                "number" -> println("abc".toInt())
                "index" -> println("test"[10])
                else -> println("정상 실행")
            }
        } catch (e: Exception) {
            println("모든 예외를 한 번에 처리: ${e::class.simpleName}")
        }
    }

    demonstrateSingleHandler("arithmetic")
    demonstrateSingleHandler("number")
    demonstrateSingleHandler("index")

    /*************** - 다중 catch 블록 - ****************/
    // 여러 예외 타입을 각각 다르게 처리

    println("\n=== 다중 catch 블록 ===")

    fun demonstrateMultipleCatch(operation: String) {
        try {
            when (operation) {
                "divide" -> {
                    println("나누기 연산 수행")
                    println(100 / 0)
                }
                "convert" -> {
                    println("문자열 변환 수행")
                    println("invalid".toInt())
                }
                "access" -> {
                    println("문자열 접근 수행")
                    println("test"[100])
                }
            }
        } catch (e: ArithmeticException) {
            println("산술 오류 처리: 0으로 나눌 수 없습니다")
        } catch (e: NumberFormatException) {
            println("변환 오류 처리: 올바른 숫자 형식이 아닙니다")
        } catch (e: StringIndexOutOfBoundsException) {
            println("인덱스 오류 처리: 문자열 범위를 벗어났습니다")
        } catch (e: Exception) {
            println("기타 오류 처리: ${e::class.simpleName}")
        }
    }

    demonstrateMultipleCatch("divide")
    demonstrateMultipleCatch("convert")
    demonstrateMultipleCatch("access")

    /*************** - catch 블록 순서의 중요성 - ****************/
    // 구체적인 예외를 일반적인 예외보다 먼저 배치

    println("\n=== catch 블록 순서 ===")

    // 올바른 순서: 구체적 -> 일반적
    fun correctCatchOrder() {
        try {
            println("잘못된 문자열 변환".toInt())
        } catch (e: NumberFormatException) {      // 구체적 예외 먼저
            println("NumberFormatException 처리")
        } catch (e: RuntimeException) {           // 중간 수준
            println("RuntimeException 처리")
        } catch (e: Exception) {                  // 가장 일반적 예외 마지막
            println("Exception 처리")
        }
    }

    correctCatchOrder()

    /* 잘못된 순서 예시 (컴파일 오류 발생)
    try {
        // some code
    } catch (e: Exception) {              // 너무 일반적인 예외가 먼저
        // 이 블록이 모든 예외를 잡아버림
    } catch (e: NumberFormatException) {  // 도달할 수 없는 코드 (컴파일 오류)
        // 이 블록은 절대 실행되지 않음
    }
    */

    /*************** - try 블록 변수 스코프 - ****************/
    // try 블록 내 변수는 블록 외부에서 접근 불가

    println("\n=== 변수 스코프 문제 ===")

    // 올바른 방법: 변수를 try 블록 외부에서 선언
    var result: Int? = null
    try {
        result = "123".toInt()
    } catch (e: NumberFormatException) {
        println("변환 실패")
    }
    println("결과: $result")  // try 블록 외부에서 접근 가능

    /* 잘못된 예시 (컴파일 오류)
    try {
        val localVar = "123".toInt()
    } catch (e: NumberFormatException) {
        println("변환 실패")
    }
    println(localVar)  // 컴파일 오류: localVar에 접근 불가
    */

    /*************** - 예외 처리 위치 결정 - ****************/
    // 적절한 정보를 가진 곳에서 예외 처리

    println("\n=== 적절한 예외 처리 위치 ===")

    // 낮은 수준: 기술적 예외 정보만 있음
    fun readNumber(input: String): Int {
        return try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw NumberFormatException("숫자 변환 실패: '$input'")
        }
    }

    // 높은 수준: 비즈니스 로직 정보를 가지고 있음
    fun processUserAge(ageInput: String): String {
        return try {
            val age = readNumber(ageInput)
            when {
                age < 0 -> "나이는 음수가 될 수 없습니다"
                age > 150 -> "현실적이지 않은 나이입니다"
                else -> "등록된 나이: $age 세"
            }
        } catch (e: NumberFormatException) {
            "올바른 나이를 숫자로 입력해주세요"
        }
    }

    println(processUserAge("25"))   // 정상
    println(processUserAge("abc"))  // 예외 처리
    println(processUserAge("-5"))   // 비즈니스 로직 검증

    /*************** - 구체적 예외 vs 일반적 예외 - ****************/
    // 적절한 예외 타입 선택의 중요성

    println("\n=== 구체적 예외 vs 일반적 예외 ===")

    // 구체적 예외 던지기 (권장)
    fun validatePositiveNumber(value: Int) {
        if (value < 0) {
            throw IllegalArgumentException("값은 0 이상이어야 합니다: $value")
        }
    }

    // 일반적 예외 던지기 (비권장)
    fun validatePositiveNumberBad(value: Int) {
        if (value < 0) {
            throw Exception("뭔가 잘못됨")  // 정보가 부족함
        }
    }

    // 구체적 예외 처리
    try {
        validatePositiveNumber(-5)
    } catch (e: IllegalArgumentException) {
        println("구체적 예외 처리: ${e.message}")
    }

    // 일반적 예외 처리
    try {
        validatePositiveNumberBad(-10)
    } catch (e: Exception) {
        println("일반적 예외 처리: ${e.message} (정보 부족)")
    }

    /*************** - 실용적인 예외 처리 패턴 - ****************/
    // 실제 개발에서 자주 사용하는 패턴

    println("\n=== 실용적인 예외 처리 패턴 ===")

    fun safeParseInt(input: String): Int? {
        return try {
            input.toInt()
        } catch (e: NumberFormatException) {
            null  // 실패 시 null 반환
        }
    }

    fun parseIntWithDefault(input: String, default: Int): Int {
        return try {
            input.toInt()
        } catch (e: NumberFormatException) {
            default  // 실패 시 기본값 반환
        }
    }

    fun parseIntWithLogging(input: String): Int? {
        return try {
            input.toInt()
        } catch (e: NumberFormatException) {
            println("경고: '$input'은 올바른 숫자가 아닙니다")
            null
        }
    }

    println("null 반환: ${safeParseInt("abc")}")
    println("기본값 반환: ${parseIntWithDefault("xyz", 0)}")
    println("로그 포함: ${parseIntWithLogging("123")}")
    parseIntWithLogging("invalid")

    /*************** - 정리 - ****************/

    println("\n=== 정리 ===")
    println("1. try-catch는 예외 처리의 핵심 메커니즘")
    println("2. catch 블록은 지정된 타입과 하위 타입 모두 처리")
    println("3. 예외 발생 시 try 블록의 나머지 코드는 실행되지 않음")
    println("4. e.message로 예외 상세 정보 확인")
    println("5. 다중 catch로 예외별 다른 처리 가능")
    println("6. catch 순서: 구체적 예외 -> 일반적 예외")
    println("7. try 블록 변수는 블록 외부에서 접근 불가")
    println("8. 충분한 정보를 가진 곳에서 예외 처리")
    println("9. 구체적인 예외 타입 사용 권장")
}
