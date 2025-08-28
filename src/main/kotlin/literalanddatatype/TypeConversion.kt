package literalanddatatype

import kotlin.math.sqrt

/**
 * 날짜: 2025-08-28
 * 주제: TypeConversion
 * 
 * 배운 내용:
 * - 명시적으로 직접 변환해줘야함
 * - toString()으로 모든 모든 타입 변환 가능
 * - 그외, 틀에서 벗어나는 것들은 다 오류생김 (부동소수점 -> 정수등등..)
 * 
 * 어려웠던 점:
 * - to~~가 이미 명시적으로되어잇는건데 아닌줄 알고 헷갈림
 */
fun main() {

    // 좆바랑 달리 명시적으로 변환시켜줘야함

    /* 숫자 형 간 변환 */
    val num: Int = 100                    // 1️⃣ 타입 명시 (사실 불필요)
    val bigNum: Long = num.toLong()       // 2️⃣ 타입 명시 + 명시적 변환
    val decimal: Double = num.toDouble()  // 3️⃣ 타입 명시 + 명시적 변환

//    val num1: Int = 100
//    val bigNum1: Long = num1
//    val decimal1: Double = num1
//    // Initializer type mismatch: expected 'Long', actual 'Int'.
//    // 작은수라도 명시적 변환 필수
    println(bigNum)
    println(decimal)

    // 예시
    val num2: Int = 100
    val res: Double = sqrt(num.toDouble()) // sqrt 함수는 Double을 요구
    println(res) // 10.0
    println(num) // 100 - 원본은 변경되지 않음
    // toDouble() 함수는 원본 변수를 수정하지 않고 새로운 Double 값을 생성

    /* 문자와 숫자 간 변환 */
    val n1: Int = 125
    val ch: Char = n1.toChar() // '}'
    val n2: Int = ch.code      // 125로 다시 변환 - unicode

    /* 문자열 변환 */
    val n = 8     // Int
    val d = 10.09 // Double
    val c = '@'   // Char
    val b = true  // Boolean

    val s1 = n.toString() // "8"
    val s2 = d.toString() // "10.09"
    val s3 = c.toString() // "@"
    val s4 = b.toString() // "true"
    // 모든 타입은  toString()을 통해 문자열 변환 가능

    val n3 = "8".toInt()        // 8
    val d1 = "10.09".toDouble() // 10.09
    val b1 = "true".toBoolean() // true
    // 반대로도 가능

    /* 주의점 */
    val d3: Double = 12.5
    val n4: Long = d.toLong() // 12 (소수점 이하 제거)
    // - 정밀도 손실 (부동소수점 -> 정수 변환 시)

    val bigNum5: Long = 100_000_000_000_000
    val n5: Int = bigNum.toInt() // 276447232 - 오버플로우 발생!
    // 큰 타입에서 작은 타입으로 변환할 때 값이 범위를 벗어나면 예상치 못한 결과가 발생

    /* Short와 Byte 변환의 특별한 주의사항 */

    val floatNumber = 10f
    val doubleNumber = 1.0

    // 권장되지 않는 방식
    //val shortNumber1 = floatNumber.toShort()

    // 올바른 방식
    val shortNumber = floatNumber.toInt().toShort()
    val byteNumber = doubleNumber.toInt().toByte()

    //Kotlin 1.4부터 Float이나 Double을 직접 Short나 Byte로 변환하는 것은 권장되지 않습니다.
    //대신 먼저 Int로 변환한 후 목표 타입으로 변환해야 합니다


}