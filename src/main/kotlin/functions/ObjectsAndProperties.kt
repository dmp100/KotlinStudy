package functions

/**
 * 날짜: 2025-09-15
 * 주제: 객체와 속성 (Objects and their Properties)
 *
 * 배운 내용:
 * - Kotlin에서 모든 변수는 객체를 가리킴 (정수, 문자열 등 모두 객체)
 * - 객체는 상태(state)와 행동(behavior)을 가짐
 * - 속성(property)으로 객체의 상태에 접근 (예: msg.length)
 * - 멤버 함수(member function)로 객체의 행동 실행 (예: msg.repeat())
 * - 변수 할당 시 객체 자체가 아닌 참조(reference)가 복사됨
 * - 객체는 가변(mutable) 또는 불변(immutable)으로 구분됨
 * - 기본 타입들(Int, String 등)은 불변 객체
 *
 * 어려웠던 점:
 * - 참조에 의한 복사와 값 복사의 차이점
 * - 가변성과 불변성의 개념과 실제 동작
 * - == 와 === 연산자의 차이점
 * - 변수 재할당 시 새 객체 생성 과정
 */
fun main() {

    /*************** - 객체의 상태와 행동 - ****************/
    // 문서의 핵심 예제: String 객체의 속성과 메서드

    println("=== 객체의 상태와 행동 ===")

    val msg = "Hi"

    // 상태 접근: 속성(property)
    println("메시지: '$msg'")
    println("길이: ${msg.length}") // 2

    // 행동 실행: 멤버 함수(member function)
    println("반복: ${msg.repeat(3)}") // "HiHiHi"

    // 다른 String 속성과 메서드들
    val message = "Hello, Kotlin!"
    println("\n문자열 객체의 다양한 속성과 메서드:")
    println("원본: '$message'")
    println("길이: ${message.length}")
    println("대문자: ${message.uppercase()}")
    println("소문자: ${message.lowercase()}")
    println("첫 번째 문자: ${message.first()}")
    println("마지막 문자: ${message.last()}")
    println("부분 문자열: ${message.substring(0, 5)}")

    /*************** - 참조에 의한 복사 - ****************/
    // 문서의 은행 계좌 비유 예제

    println("\n=== 참조에 의한 복사 ===")

    val msg1 = "Hi"
    val msg2 = msg1

    println("msg1: '$msg1'")
    println("msg2: '$msg2'")
    println("같은 객체를 가리키는가? ${msg1 === msg2}") // true

    // 시각적 설명
    println("\n참조 관계:")
    println("msg1 ──┐")
    println("       ├─── \"Hi\" 객체")
    println("msg2 ──┘")

    /*************** - 불변 객체의 특성 - ****************/
    // 문서의 Int 예제

    println("\n=== 불변 객체의 특성 (Int) ===")

    var a: Int = 100
    val anotherA: Int = a

    println("초기 상태:")
    println("a = $a, anotherA = $anotherA")
    println("값이 같은가? ${a == anotherA}")      // true
    println("같은 객체인가? ${a === anotherA}")    // true

    a = 200  // a에 새로운 객체 할당

    println("\na = 200 할당 후:")
    println("a = $a, anotherA = $anotherA")
    println("값이 같은가? ${a == anotherA}")      // false
    println("같은 객체인가? ${a === anotherA}")    // false

    // 문서의 Double 예제
    println("\n=== 불변 객체의 특성 (Double) ===")

    var d1: Double = 1.5
    val d2 = d1

    println("초기 상태:")
    println("d1 = $d1, d2 = $d2")
    println("같은 객체인가? ${d1 === d2}") // true

    d1 += 1            // d1 is 2.5 now

    println("d1 += 1 연산 후:")
    println("d1 = $d1, d2 = $d2")
    println("같은 객체인가? ${d1 === d2}") // false

    /*************** - 다양한 기본 타입 객체들 - ****************/
    // 모든 기본 타입이 객체임을 보여주는 예제

    println("\n=== 다양한 기본 타입 객체들 ===")

    // String 객체
    val text = "Kotlin"
    println("String 객체:")
    println("  값: '$text'")
    println("  길이: ${text.length}")
    println("  빈 문자열인가? ${text.isEmpty()}")

    // Int 객체
    val number = 42
    println("\nInt 객체:")
    println("  값: $number")
    println("  문자열로: ${number.toString()}")
    println("  절댓값: ${(-number).let { kotlin.math.abs(it) }}")

    // Boolean 객체
    val flag = true
    println("\nBoolean 객체:")
    println("  값: $flag")
    println("  문자열로: ${flag.toString()}")
    println("  NOT 연산: ${!flag}")

    // Double 객체
    val pi = 3.14159
    println("\nDouble 객체:")
    println("  값: $pi")
    println("  반올림: ${pi.toInt()}")
    println("  무한대인가? ${pi.isFinite()}")

    /*************** - 객체 참조 실험 - ****************/
    // 참조와 값의 차이를 명확히 보여주는 실험

    println("\n=== 객체 참조 실험 ===")

    // 실험 1: 문자열 참조
    val original = "Hello"
    val copy1 = original
    val copy2 = "Hello"  // 새로 생성? 아니면 기존 객체?

    println("문자열 참조 실험:")
    println("original === copy1: ${original === copy1}")  // true
    println("original === copy2: ${original === copy2}")  // true (문자열 풀링)

    // 실험 2: 숫자 참조
    val num1 = 100
    val num2 = num1
    val num3 = 100

    println("\n숫자 참조 실험:")
    println("num1 === num2: ${num1 === num2}")  // true
    println("num1 === num3: ${num1 === num3}")  // true (작은 정수 캐싱)

    // 실험 3: 큰 숫자
    val big1 = 1000
    val big2 = 1000

    println("큰 숫자 참조 실험:")
    println("big1 === big2: ${big1 === big2}")  // true (Kotlin/JVM 최적화)

    /*************** - 불변성의 안전성 - ****************/
    // 불변 객체를 안전하게 복사할 수 있음을 보여주는 예제

    println("\n=== 불변성의 안전성 ===")

    fun processString(input: String): String {
        // input을 안전하게 사용할 수 있음 (불변이므로)
        println("처리 중인 문자열: '$input'")
        return input.uppercase()
    }

    val myString = "important data"
    val processed = processString(myString)

    println("원본: '$myString'")
    println("처리 결과: '$processed'")
    println("원본이 변경되었나? ${myString == "important data"}")  // true

    // 숫자도 마찬가지
    fun calculateSquare(num: Int): Int {
        println("제곱 계산 중: $num")
        return num * num
    }

    val myNumber = 5
    val squared = calculateSquare(myNumber)

    println("\n원본 숫자: $myNumber")
    println("제곱 결과: $squared")
    println("원본이 변경되었나? ${myNumber == 5}")  // true

    /*************** - 실용적 활용 예제 - ****************/

    println("\n=== 실용적 활용 예제 ===")

    // 문자열 객체 활용
    fun analyzeText(text: String) {
        println("텍스트 분석: '$text'")
        println("  글자 수: ${text.length}")
        println("  단어 수: ${text.split(" ").size}")
        println("  첫 글자: ${if (text.isNotEmpty()) text.first() else "없음"}")
        println("  마지막 글자: ${if (text.isNotEmpty()) text.last() else "없음"}")
        println("  대문자 포함: ${text.any { it.isUpperCase() }}")
        println("  숫자 포함: ${text.any { it.isDigit() }}")
    }

    analyzeText("Hello World 123!")

    // 숫자 객체 활용
    fun analyzeNumber(num: Int) {
        println("\n숫자 분석: $num")
        println("  문자열 길이: ${num.toString().length}")
        println("  짝수인가: ${num % 2 == 0}")
        println("  양수인가: ${num > 0}")
        println("  자릿수 합: ${num.toString().map { it.digitToInt() }.sum()}")
    }

    analyzeNumber(12345)

    // 불변 객체 체인 활용
    fun processData(input: String): String {
        return input
            .trim()                    // 공백 제거
            .lowercase()               // 소문자 변환
            .replace(" ", "_")         // 공백을 언더스코어로
            .filter { it.isLetterOrDigit() || it == '_' }  // 특수문자 제거
    }

    val userInput = "  Hello World! @#$ "
    val cleaned = processData(userInput)

    println("\n데이터 처리:")
    println("입력: '$userInput'")
    println("처리 결과: '$cleaned'")
    println("원본 보존: '$userInput'")

    /*************** - 메모리와 성능 고려사항 - ****************/

    println("\n=== 메모리와 성능 고려사항 ===")

    // 문자열 연결 시 새 객체 생성
    var result = ""
    val words = listOf("Kotlin", "is", "awesome")

    println("문자열 연결 과정:")
    for (word in words) {
        val oldResult = result
        result += "$word "
        println("'$oldResult' + '$word ' = '$result' (새 객체 생성)")
    }

    // 더 효율적인 방법
    val efficientResult = words.joinToString(" ")
    println("효율적인 방법: '$efficientResult'")

    // 불변 객체의 장점
    println("\n불변 객체의 장점:")
    println("1. 스레드 안전성 - 동시 접근 시 안전")
    println("2. 예측 가능성 - 값이 변하지 않음")
    println("3. 해시코드 안정성 - Map의 키로 안전하게 사용")
    println("4. 디버깅 용이성 - 상태 변경 추적 불필요")

    /*************** - 정리 - ****************/

    println("\n=== 정리 ===")
    println("1. Kotlin의 모든 변수는 객체를 가리키는 참조")
    println("2. 객체는 상태(속성)와 행동(메서드)을 가짐")
    println("3. 변수 할당 시 참조가 복사됨 (객체 자체 복사 아님)")
    println("4. 기본 타입(Int, String 등)은 불변 객체")
    println("5. 불변 객체는 안전하게 공유 가능")
    println("6. 변수 재할당 시 새로운 객체 참조")
    println("7. == 는 값 비교, === 는 참조 비교")
}
