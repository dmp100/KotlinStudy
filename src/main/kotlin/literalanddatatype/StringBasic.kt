package literalanddatatype

/**
 * 날짜: 2025-08-20
 * 주제: StringBasic
 * 
 * 배운 내용:
 * - .length 프로퍼티 접근 : 길이 알려주기
 * - 문자열끼리 더할 수 있다
 * - 코틀린은 첫번째 변수 타입에따라 어떻게 계산할지 결정한다.
 * - repeat()함수 : 문자열을 두번 이상 반복해야할때 루프유지
 * 어려웠던 점:
 * - 10 + 'a' 유니코드로 계산해서 더해지는게 되는줄 알았으나, 안됌.
 */
fun main() {

    val lang = "Kotlin"
    println(lang.length)
    // 6

    val empty = ""
    println(empty.length)
    // 0

    val str1 = "ab"
    val str2 = "cde"
    val result = str1 + str2
    // "abcde" - 두개의 문자열 연결

    val one = "1"
    val two = "2"
    val twelve = one + two
    println(one)    // 1, no changes
    println(two)    // 2, no changes
    println(twelve) // 12
    // "12" - 두개의 문자열 연결 -> 새로운 문자열 생성

    val firstName = "John"
    val lastName = "Smith"
    val fullName = firstName + " " + lastName
    println(fullName)
    // 동일한 표현식에서 여러 문자열 연결 가능

    val stringPlusBoolean = "abc" + 10 + true
    println(stringPlusBoolean)
    // abc10true - 첫 번째가 문자열이면 모든것들은 문자열로 변환

    val stringAndNumbers = "abc" + 11 + 22
    println(stringAndNumbers)
    // abc1122

    //val errorString = 10 + "abc"
    // an error here! - Kotlin은 정수로 계산을 하려고함, 불가능

    val UniCodePlusResult = 10 + 'a'.code  // 'a'.code는 Char를 Int로 변환
    println(UniCodePlusResult)
    // 107 - 유니코드로 합칠려면 이런식으로도 가능

    print("Hello".repeat(4))
    // HelloHelloHelloHello - repeat()함수 : 문자열을 두번 이상 반복해야할때 루프유지

    val largeString = """
    This is the house that Jack built.
      
    This is the malt that lay in the house that Jack built.
       
    This is the rat that ate the malt
    That lay in the house that Jack built.
       
    This is the cat
    That killed the rat that ate the malt
    That lay in the house that Jack built.
""".trimIndent() // removes the first and the last lines and trims indents
    print(largeString)
    // 원시 문자열로 장문 출력

    val unevenString = """
        123
         456
          789""".trimIndent()
    print(unevenString)
    println()

    val rawString = """123
         456
          789
""".trimIndent()
    print(rawString )

}