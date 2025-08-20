package literalanddatatype

/**
 * 날짜: 2025-08-15
 * 주제: Data Type
 * 
 * 배운 내용:
 * - val/var 변수명 = 값 (자동 타입 추론)
 * - val/var 변수명 : 유형 = 값 (유형지정)
 *
 * - 변수 선언후,
 * 
 * 어려웠던 점:
 * - 변수 선언후에는 반드시 유형지정해줘야함
 * - Const에는 웬만해선 안씀
 */
fun main() {
    val text = "Hello" // 타입추론 방식
    val n = 1

    val text1 : String = "Hello1" // 유형지정 (대문자시작)
    val n1 : Int = 11

//    val greeing // 변수 선언후, 초기화 형태는 타입추론 작동 X
//    geeting = "hello"

    val greeting : String
    greeting = "hello"

//    val n: Int ="abc" // Type mismatch: inferred type is String but Int was expected
//    var age = 30 // the type is inferred as Int
//    age = "31 years old" // Type mismatch
}