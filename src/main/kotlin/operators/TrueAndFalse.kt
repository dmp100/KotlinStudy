package operators

/**
 * 날짜: 2025-08-21
 * 주제: TrueAndFalse
 * 
 * 배운 내용:
 * - 부울 : true false (C처럼 0과 1 취급 아님)
 * - .toBoolean() - 부울 값 읽기 (관대한 변환)
 * - .toBooleanStrict() : 엄격변환
 * - .toBooleanStrictOrNull() - 엄격하지만 안전한 변환
 *
 * - 논리 연산자 - 부울타입 변수와 함께 구성 : NOT, AND, OR, XOR
 * - NOT(!) - 부울 값 반전 단항 연산자
 * - AND(&&) - 모든 조건이 만족해야 하는 이항 연산자
 * - OR(||) - 하나만 만족하면 되는 이항 연산자
 * - XOR(xor) - 정확히 하나면 참이여야하는 이항 연산자
 *
 * - 계산 순서 : NOT -> XOR -> AND -> OR
 *
 * 어려웠던 점:
 * - 
 */
fun main() {

    // 부울은 true,false만 갖는 데이터 유형
    val t = true
    val f = false

    println(t)
    println(f)

    // C언어처럼 0을 거짓으로, 1을 참으로 취급하지 않음.
//    val flag: Boolean = 1 // ❌ 오류: Type mismatch
//    if (1) {              // ❌ 오류: Condition must be a boolean
//        println("true")
//    }

    // 명시적으로 변환해야만 가능함
    val flag = (1 == 1)   // ✅ true
    val flag2 = (0 != 0)  // ✅ false

    // .toBoolean() - 부울 값 읽기 (관대한 변환)
    // "true"와 비슷한 모든 것(대소문자 구분 없이)을 true로 받아들이고,
    // 그 외에는 모두 false로 처리합니다. 프로그램이 멈추지 않습니다.
    val b: Boolean = readLine().toBoolean() // 1.4ver
    val b2: Boolean = readln().toBoolean() // 1.6ver

    val result1 = "true".toBoolean()    // true
    val result2 = "True".toBoolean()    // true (대소문자 무시)
    val result3 = "TRUE".toBoolean()    // true (대소문자 무시)
    val result4 = "false".toBoolean()   // false
    val result5 = "False".toBoolean()   // false (대소문자 무시)
    val result6 = "hello".toBoolean()   // false (true가 아니면 모두 false)

    val b3: Boolean = readLine()!!.toBoolean() // Kotlin 컴파일러 버전 1.3 이하와 함께 사용

    // .toBooleanStrict() - Kotlin 1.5부터는 다른 함수를 사용하여 `String`로 변환 (엄격변환)
    // 정확히 "true" 또는 "false"라는 문자열만 받아들입니다. 대소문자도 정확해야 하고, 철자도 완전히 일치해야 합니다.

    println("true".toBooleanStrict())     // true - 정확히 "true"이므로 성공
    println("false".toBooleanStrict())    // false - 정확히 "false"이므로 성공

    // 아래 코드들은 프로그램을 중단시킵니다!
// println("True".toBooleanStrict())  // 대문자 T 때문에 오류 발생
// println("faLse".toBooleanStrict()) // 대소문자가 틀렸으므로 오류 발생
// println("yes".toBooleanStrict())   // "true"나 "false"가 아니므로 오류 발생

    // .toBooleanStrictOrNull() - 엄격하지만 안전한 변환
    // 조건에 맞지 않을 때 프로그램을 중단시키는 대신 null이라는 특별한 값을 반환

    // 논리 연산자 - 부울타입 변수와 함께 구성 : NOT, AND, OR, XOR

    // NOT(!) - 부울 값 반전 단항 연산자
    val f1 = false // f is false
    val t1 = !f1   // t is true
    println(t1)

    // AND(&&) - 모든 조건이 만족해야 하는 이항 연산자
    val hasMoney = true
    val hasTime = false
    val canTravel = hasMoney && hasTime  // false
    println(canTravel)

    // OR(||) - 하나만 만족하면 되는 이항 연산자
    val canTakeBus = true
    val canTakeSubway = false
    val canGoToSchool = canTakeBus || canTakeSubway  // true
    println(canGoToSchool)

    // XOR(xor) - 정확히 하나면 참이여야하는 이항 연산자
    val isHeads = true
    val isTails = false
    val validCoinFlip = isHeads xor isTails  // true
    println(validCoinFlip)

    // 연산자 계산 순서
    // NOT -> XOR -> AND -> OR
    val result = true || false && !true
    println(result)
    // 계산 순서: !true → false, false && false → false, true || false → true
}