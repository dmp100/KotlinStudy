package literals

/**
 * 날짜: 2025-06-10
 * 주제: 문자열 리터럴 기초
 *
 * 배운 내용:
 * - 기본 문자열 선언과 사용법
 * - 이스케이프 문자 사용
 */
fun main() {
    // 기본 문자열 리터럴
    val greeting = "Hello, Kotlin!"
    println(greeting)

    // 이스케이프 문자
    val multiLine = "첫 번째 줄\n두 번째 줄"
    println(multiLine)

    // 탭 문자
    val withTab = "이름:\tKotlin"
    println(withTab)

    // 따옴표 포함
    val quote = "그는 \"안녕하세요\"라고 말했다"
    println(quote)
}