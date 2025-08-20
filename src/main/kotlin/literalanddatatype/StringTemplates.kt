package literalanddatatype

/**
 * 날짜: 2025-08-20
 * 주제: StringTemplates
 * 
 * 배운 내용:
 * - 문자열 템플릿을 쓰면 더 직관적으로 쓸 수 있음
 * - 문자열로만 쓰기
 * - $, ${language.length}
 * 
 * 어려웠던 점:
 * - 
 */
fun main() {

    val city = "Paris"
    val temp = "24"

    println("The temperature in " + city + " is " + temp + " degrees Celsius.")
    // 보다 더 편하게 쓰기
    println("The temperature in $city is $temp degrees Celsius.")

    val value = "55"
    val currency = "dollars"
    val price = "$value $currency" // "55 dollars"
    // 문자열 출력하기 싫으면 이렇게

    val language = "Kotlin"
    println("$language has ${language.length} letters in the name")
    // 임의의 표현식 결과를 문자열로 넣어버리기.

    println("Have a nice $language!")        // nice code
    println("Have a nice " + language + "!") // bad practice
    // 관용구 - 명확하고 읽기 쉬운 코드를 위한 템플릿
    // https://kotlinlang.org/docs/idioms.html

}