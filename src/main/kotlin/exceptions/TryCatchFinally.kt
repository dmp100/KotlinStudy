package exceptions

/**
 * 날짜: 2025-09-15
 * 주제: try-catch-finally 문과 try 표현식
 *
 * 배운 내용:
 * - finally 블록은 예외 발생 여부와 관계없이 항상 실행됨
 * - try-catch-finally의 실행 순서와 각 블록의 역할
 * - catch나 finally 블록 중 하나는 생략 가능하지만 둘 다 생략할 수는 없음
 * - try를 표현식으로 사용하여 값을 반환할 수 있음
 * - try 표현식의 반환값은 try 또는 catch 블록의 마지막 표현식
 * - finally 블록은 반환값에 영향을 주지 않음
 * - try 표현식은 Kotlin의 관용적 패턴
 *
 * 어려웠던 점:
 * - finally 블록이 항상 실행되는 정확한 의미와 시점
 * - try 표현식에서 finally 블록이 반환값에 영향을 주지 않는 이유
 * - 블록 생략 규칙과 최소 요구사항
 * - 표현식 스타일 vs 문장 스타일의 적절한 선택
 */
fun main() {

    /*************** - finally 블록 기본 개념 - ****************/
    // finally 블록은 예외 발생 여부와 관계없이 항상 실행

    println("=== finally 블록 기본 구조 ===")

    try {
        println("try 블록 실행")
        // 예외가 발생할 수 있는 코드
    } catch (e: Exception) {
        println("catch 블록 실행")
        // 예외 처리 코드
    } finally {
        println("finally 블록 실행")
        // 항상 실행되는 코드
    }

    /*************** - 실행 순서 분석 (예외 발생 시) - ****************/
    // 문서의 핵심 예제: 예외가 발생하는 경우

    println("\n=== 예외 발생 시 실행 순서 ===")

    try {
        println("Inside the try block")
        println(2 / 0) // ArithmeticException 발생
    } catch (e: Exception) {
        println("Inside the catch block")
    } finally {
        println("Inside the finally block")
    }
    println("After the try-catch-finally block")

    /* 출력 결과:
     * Inside the try block
     * Inside the catch block
     * Inside the finally block
     * After the try-catch-finally block
     */

    /*************** - 실행 순서 분석 (정상 실행 시) - ****************/
    // 예외가 발생하지 않는 경우의 실행 순서

    println("\n=== 정상 실행 시 실행 순서 ===")

    try {
        println("Inside the try block (정상)")
        println("정상 계산: ${10 / 2}")  // 예외 발생하지 않음
    } catch (e: Exception) {
        println("Inside the catch block (실행되지 않음)")
    } finally {
        println("Inside the finally block (항상 실행)")
    }
    println("After the try-catch-finally block")

    /* 출력 결과:
     * Inside the try block (정상)
     * 정상 계산: 5
     * Inside the finally block (항상 실행)
     * After the try-catch-finally block
     */

    /*************** - finally의 필요성 - ****************/
    // 예외 발생 시 일반 코드는 실행되지 않지만 finally는 실행됨

    println("\n=== finally의 필요성 ===")

    fun demonstrateFinallyNecessity() {
        try {
            println("예외 발생 전")
            val result = 0 / 0  // ArithmeticException 발생
            println("이 줄은 실행되지 않음")
        } finally {
            println("End of the try block")  // 실행됨
        }
        println("End of the program")  // 실행되지 않음 (예외로 인해)
    }

    try {
        demonstrateFinallyNecessity()
    } catch (e: ArithmeticException) {
        println("함수 외부에서 예외 처리")
    }

    /*************** - finally와 일반 코드의 차이 - ****************/
    // finally 블록 vs try-catch 이후 코드의 실행 차이

    println("\n=== finally vs 일반 코드 비교 ===")

    fun withFinally() {
        println("== withFinally 함수 ==")
        try {
            throw RuntimeException("테스트 예외")
        } catch (e: RuntimeException) {
            println("예외 처리됨")
        } finally {
            println("finally: 항상 실행됨")
        }
        println("함수 끝: 정상적으로 실행됨")
    }

    fun withoutFinally() {
        println("== withoutFinally 함수 ==")
        try {
            throw RuntimeException("테스트 예외")
            println("이후 코드: 실행되지 않음")
        } catch (e: RuntimeException) {
            println("예외 처리됨")
            throw RuntimeException("다시 예외 발생")  // 새로운 예외 발생
        }
        println("함수 끝: 실행되지 않음")  // 새로운 예외로 인해 실행 안됨
    }

    withFinally()

    try {
        withoutFinally()
    } catch (e: RuntimeException) {
        println("외부에서 재발생 예외 처리")
    }

    /*************** - catch 블록에서 예외 발생 시 finally - ****************/
    // catch 블록에서 예외가 발생해도 finally는 실행됨

    println("\n=== catch 블록 예외 시 finally 실행 ===")

    try {
        try {
            println("원본 예외 발생")
            throw NumberFormatException("원본 예외")
        } catch (e: NumberFormatException) {
            println("catch 블록에서 처리 중")
            throw RuntimeException("catch에서 새 예외")  // catch에서 또 예외 발생
        } finally {
            println("finally: catch에서 예외 발생해도 실행됨")
        }
    } catch (e: RuntimeException) {
        println("외부에서 catch 블록의 예외 처리: ${e.message}")
    }

    /*************** - 블록 생략 패턴 - ****************/
    // catch 또는 finally 중 하나는 생략 가능

    println("\n=== 블록 생략 패턴 ===")

    // 패턴 1: try-finally (catch 생략)
    println("1. try-finally 패턴:")
    try {
        println("try 블록 실행")
        println("정상 처리: ${20 / 4}")
    } finally {
        println("finally 블록 실행")
    }

    // 패턴 2: try-catch (finally 생략) - 이미 많이 사용
    println("\n2. try-catch 패턴:")
    try {
        println("abc".toInt())
    } catch (e: NumberFormatException) {
        println("catch 블록 실행: ${e.message}")
    }

    // 패턴 3: try-catch-finally (모든 블록 사용)
    println("\n3. 모든 블록 사용:")
    try {
        println("모든 블록 테스트")
    } catch (e: Exception) {
        println("catch 블록")
    } finally {
        println("finally 블록")
    }

    /* 불가능한 패턴: try만 단독 사용
    try {
        println("이것은 컴파일 오류")
    }
    // 컴파일 오류: catch나 finally 중 최소 하나는 있어야 함
    */

    /*************** - try 표현식 기본 - ****************/
    // try를 표현식으로 사용하여 값 반환

    println("\n=== try 표현식 기본 ===")

    // 문서의 기본 예제
    val number: Int = try {
        "abc".toInt()
    } catch (e: NumberFormatException) {
        0
    }
    println("try 표현식 결과: $number")  // 0

    // 성공 케이스
    val validNumber: Int = try {
        "123".toInt()
    } catch (e: NumberFormatException) {
        -1
    }
    println("성공 케이스 결과: $validNumber")  // 123

    /*************** - finally가 반환값에 미치지 않는 영향 - ****************/
    // finally 블록은 try 표현식의 반환값에 영향을 주지 않음

    println("\n=== finally와 반환값 ===")

    val numberWithFinally: Int = try {
        "2a".toInt()
    } catch (e: NumberFormatException) {
        0
    } finally {
        println("Inside the finally block")
    }
    println("finally 포함 결과: $numberWithFinally")

    /* 출력:
     * Inside the finally block
     * finally 포함 결과: 0
     */

    // finally에서 값을 반환해도 try 표현식 결과에는 영향 없음
    val testFinally = try {
        42
    } catch (e: Exception) {
        -1
    } finally {
        println("finally에서 다른 값 처리")
        100  // 이 값은 반환되지 않음
    }
    println("testFinally 결과: $testFinally")  // 42 (finally의 100이 아님)

    /*************** - 예외 재던지기 패턴 - ****************/
    // 예외를 변환해서 다시 던지는 패턴

    println("\n=== 예외 재던지기 패턴 ===")

    fun countSomething(): Int {
        return 10 / 0  // ArithmeticException 발생
    }

    fun test() {
        val result = try {
            countSomething()
        } catch (e: ArithmeticException) {
            throw IllegalStateException("계산 중 오류 발생", e)  // 다른 예외로 변환
        }

        println("결과 처리: $result")  // 이 줄은 실행되지 않음
    }

    try {
        test()
    } catch (e: IllegalStateException) {
        println("변환된 예외 처리: ${e.message}")
        println("원인: ${e.cause?.message}")
    }

    /*************** - 관용적 패턴 비교 - ****************/
    // 표현식 스타일 vs 문장 스타일 비교

    println("\n=== 관용적 패턴 비교 ===")

    // 권장 방법: try 표현식 사용
    val string1 = "abc"
    val number1 = try {
        string1.toInt()
    } catch (e: NumberFormatException) {
        -1
    }
    println("표현식 스타일 결과: $number1")

    // 비권장 방법: var 변수 사용
    val string2 = "abc"
    var number2 = 0  // var 사용 (피하는 것이 좋음)
    try {
        number2 = string2.toInt()
    } catch (e: NumberFormatException) {
        number2 = -1
    }
    println("문장 스타일 결과: $number2")

    /*************** - 복잡한 try 표현식 패턴 - ****************/
    // 실용적인 try 표현식 활용

    println("\n=== 복잡한 try 표현식 활용 ===")

    // 파일 처리 시뮬레이션
    fun readFileContent(filename: String): String {
        return try {
            when (filename) {
                "valid.txt" -> "파일 내용"
                "empty.txt" -> ""
                else -> throw Exception("파일을 찾을 수 없음")
            }
        } catch (e: Exception) {
            "기본 내용"
        } finally {
            println("파일 처리 완료: $filename")
        }
    }

    val content1 = readFileContent("valid.txt")
    val content2 = readFileContent("missing.txt")
    println("읽은 내용1: '$content1'")
    println("읽은 내용2: '$content2'")

    // 설정값 파싱
    fun parseConfig(configStr: String): Map<String, Any> {
        val timeout = try {
            configStr.substringAfter("timeout=")
                .substringBefore(",")
                .toInt()
        } catch (e: Exception) {
            30  // 기본 타임아웃
        }

        val debug = try {
            configStr.contains("debug=true")
        } catch (e: Exception) {
            false
        }

        return mapOf("timeout" to timeout, "debug" to debug)
    }

    val config1 = parseConfig("timeout=60,debug=true")
    val config2 = parseConfig("invalid_config")
    println("설정1: $config1")
    println("설정2: $config2")

    /*************** - 실용적 활용 예제 - ****************/
    // 실제 개발에서 자주 사용하는 패턴들

    println("\n=== 실용적 활용 예제 ===")

    // 안전한 타입 변환
    fun safeConvert(value: String): Pair<Int?, String> {
        val number = try {
            value.toInt()
        } catch (e: NumberFormatException) {
            null
        }

        val message = if (number != null) "변환 성공" else "변환 실패"
        return Pair(number, message)
    }

    // 여러 작업 중 일부 실패 허용
    fun processMultipleInputs(inputs: List<String>): List<Int> {
        return inputs.mapNotNull { input ->
            try {
                input.toInt()
            } catch (e: NumberFormatException) {
                println("'$input' 변환 실패, 건너뜀")
                null
            }
        }
    }

    val conversion1 = safeConvert("123")
    val conversion2 = safeConvert("abc")
    println("변환 결과1: $conversion1")
    println("변환 결과2: $conversion2")

    val inputs = listOf("1", "abc", "3", "def", "5")
    val processed = processMultipleInputs(inputs)
    println("처리된 숫자들: $processed")

    /*************** - 리소스 관리 패턴 - ****************/
    // finally를 사용한 리소스 정리

    println("\n=== 리소스 관리 패턴 ===")

    class MockResource(val name: String) {
        fun open() = println("$name 리소스 열기")
        fun process() = println("$name 리소스 처리")
        fun close() = println("$name 리소스 닫기")
    }

    fun processResource(shouldFail: Boolean) {
        val resource = MockResource("데이터베이스")

        try {
            resource.open()
            resource.process()

            if (shouldFail) {
                throw RuntimeException("처리 중 오류 발생")
            }

            println("리소스 처리 완료")
        } catch (e: RuntimeException) {
            println("오류 처리: ${e.message}")
        } finally {
            resource.close()  // 예외 발생 여부와 관계없이 리소스 정리
        }
    }

    println("정상 케이스:")
    processResource(false)

    println("\n예외 케이스:")
    processResource(true)

    /*************** - 정리 - ****************/

    println("\n=== 정리 ===")
    println("1. finally 블록은 예외 발생 여부와 관계없이 항상 실행")
    println("2. 실행 순서: try -> catch -> finally -> 이후 코드")
    println("3. catch 또는 finally 중 최소 하나는 있어야 함")
    println("4. try를 표현식으로 사용하여 값 반환 가능")
    println("5. try 표현식의 반환값은 try 또는 catch 블록의 마지막 표현식")
    println("6. finally 블록은 반환값에 영향을 주지 않음")
    println("7. try 표현식은 Kotlin의 관용적 패턴")
    println("8. 리소스 정리는 finally 블록에서 수행")
}
