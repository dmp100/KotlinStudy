package functions

/**
 * 날짜: 2025-08-19
 * 주제: InvokeFunc
 *
 * 배운 내용:
 * - argument -> [function] -> result or nothing
 * - Arguments(인수) : 함수 호출 시, 괄호 안에 전달하는 데이터
 * - Return(결과) : 함수에서 계산 결과 반환
 * - Unit : Java, C에서의 Void (반환 값 없음)
 * 어려웠던 점:
 * -
 */
fun main() {

    // -------------------- Arguments (인수) --------------------
    val text = "Hello"
    println(text)   // 문자열 인수 전달 → Hello
    println()       // 인수 없이 호출 가능 → (빈 줄 출력)

    // -------------------- Return (결과) --------------------
    val number = -10
    val nonNegNumber = Math.abs(number) // -10 → 10
    println(nonNegNumber) // 10

    // -------------------- Unit (반환 없음) --------------------
    val result = println("text") // "text" 출력
    println(result)              // kotlin.Unit 출력

    // -------------------- 직접 만든 함수 예시 --------------------
    println(add(3, 5))    // 8
    greet("Kotlin")       // Hello, Kotlin!
}

// 두 인수를 받아 결과 반환 (Int)
fun add(a: Int, b: Int): Int {
    return a + b
}

// 인수는 받지만 반환은 없음 (Unit)
fun greet(name: String) {
    println("Hello, $name!")
}
