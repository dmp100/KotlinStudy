package literalanddatatype

/**
 * 날짜: 2025-08-22
 * 주제: WorkingWithStrings
 * 
 * 배운 내용:
 * - 문자열은 문자들의 순서가 있는 집함
 * - 직접적인 인덱스 접근 가능
 * - 문자열은 비교 는 == 연산자로 가능
 * 
 * 어려웠던 점:
 * - 
 */
fun main() {

    // 문자열 (String) : 문자(Char)들의 순서가 있는 집합
    val message = "Hello World"
    // H e l l o   W o r l d
    // 0 1 2 3 4 5 6 7 8 9 10

    // 문자 접근 : 인덱스로 액세스 할 수 있는 개별 문자
    val greeting = "Hello"

    // 직접적인 인덱스 접근
    val firstChar = greeting[0]        // 'H'
    val secondChar = greeting[1]       // 'e'

    // 계산된 인덱스로 접근
    val lastChar = greeting[greeting.length - 1]  // 'o' (길이가 5이므로 마지막 인덱스는 4)

    // 코틀린에서 제공하는 다양한 함수들
    // 첫 번째와 마지막 문자에 쉽게 접근
    println(greeting.first())     // 'H' - 첫 번째 문자
    println(greeting.last())      // 'o' - 마지막 문자
    println(greeting.lastIndex)   // 4 - 마지막 인덱스 값

    // 안전한 접근 방법 (빈 문자열에서도 안전)
    println(greeting.firstOrNull())  // 'H' 또는 null (빈 문자열인 경우)
    println(greeting.lastOrNull())   // 'o' 또는 null (빈 문자열인 경우)

    // 빈 문자열
    val emptyString = ""
    println(emptyString.length == 0) //true
    println(emptyString.isEmpty()) //true

    // 문자열을 변경해야하는 경우, 재할당 필요(새롭게 생성)
    var varString = "string"
    varString = "strong" // legal
    val valString = "string"
    //valString = "strong" // error, you cannot reassign val

    // 두 문자열 비교
    val first = "first"
    val second = "second"
    var str = "first"

    println(first == str)    // true
    println(first == second) // false
    println(first != second) // true
}