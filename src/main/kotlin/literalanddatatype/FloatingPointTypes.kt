package literalanddatatype

import java.util.*

/**
 * 날짜: 2025-09-07
 * 주제: FloatingPointTypes
 * 
 * 배운 내용:
 * - 
 * 
 * 어려웠던 점:
 * - 
 */
fun main() {

    // 실수 표현 부동 소수점 타입, Float & Double

    // 부동 소수점 타입 비교:
    // Float  - 32비트 : 유효 소수 자릿수 6~7자리,  제한적 범위
    // Double - 64비트 : 유효 소수 자릿수 14~16자리, 더 넓은 범위

    // Double 타입 선언 (소수점이 있으면 자동으로 Double로 추론)
    val one = 1.0          // Double
    val negNumber = -1.75  // Double (음수)
    val pi = 3.1415        // Double

    // Float 타입 선언 (반드시 f 접미사 필요)
    val floatValue: Float = 8.75f   // 명시적 타입 지정
    val e = 2.71828f                // f 접미사로 Float 지정

    // 산술 연산
    val number = one + 1.5        // 2.5 (Double + Double)
    val c = floatValue + negNumber         // 7.0 (Float + Double = Double로 승격)
    val squaredPi = pi * pi       // 9.86902225 (곱셈)
    val division = squaredPi / 2   // 4.934511125 (실수 나눗셈)

    // 부동 소수점 연산의 부정확성
    // - 단일 연산 오차
    println(3.3 / 3)  // 1.0999999999999999 (정확히 1.1이 아님)
    // - 누적 오차
    val num = 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1
    println(num)  // 0.9999999999999999 (정확히 1.0이 아님)

    // 표준 입력 실수 읽기
    val f = readln().toFloat()   // Float로 변환
    val d = readln().toDouble()  // Double로 변환

    // 안전하게 처리 하는 방법
    //import java.util.Locale

    val floatNum = readln().format(Locale.US).toFloat()
    println(floatNum)
}