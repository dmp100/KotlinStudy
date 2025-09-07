package literalanddatatype

/**
 * 날짜: 2025-09-07
 * 주제: IntegerInAction
 *
 * 배운 내용:
 * - Kotlin의 주요 정수 타입: Int(32비트), Long(64비트)와 각각의 범위
 * - Long 타입 선언 3가지 방법: 큰 값 자동 승격, 명시적 타입 지정, L 접미사
 * - 표준 입력에서 정수 읽기: readln().toInt(), readln().toLong()
 * - 부호 없는 정수 타입(UByte, UShort, UInt, ULong)과 u/U 접미사 사용법
 * - 데이터 타입 오버플로우: 최댓값 초과 시 최솟값으로 순환하는 현상
 * - 타입 변환 시 데이터 손실 위험성 (Long → Int 변환)
 *
 * 어려웠던 점:
 * - 오버플로우가 발생해도 컴파일러가 경고하지 않아 예측하기 어려움
 * - 부호 없는 타입의 실제 활용 시나리오 이해하기
 */
fun main() {

    // 코틀린에서는 정수타입 Int와 Long을 제일 많이씀
    // Int,32bit,-2,147,483,648 ~ 2,147,483,647
    // Long,64bit,-9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807

    // Long 타입 선언 방법
    // 1. 값이 Int 범위를 초과하는 경우 (자동으로 Long)
    val longNumber1 = 1_000_000_000_000_000

    // 2. 명시적 타입 지정
    val longNumber2: Long = 1_000_000

    // 3. L 접미사 사용
    val longNumber3 = 1000L

    val result = longNumber1 + longNumber2 - longNumber3
    println(result) // 1000000000999000

    // 표준 입력에서 Int 읽기
    val a = readln().toInt()
    val b = readln().toInt()

    val sum = a + b
    println(sum)

    // 표준 입력에서 Long 읽기
    val readLong = readln().toLong()
    val readLong2 = readln().toLong()

    val sumLongs = readLong + readLong2
    println(sumLongs)

    // 6. 부호 없는 정수 타입 (Unsigned Types)
    // Kotlin은 음수가 아닌 값(0 이상)만 저장할 수 있는 부호 없는 정수 타입을 제공

    // 부호 없는 정수 타입 종류와 범위:
    // UByte  - 8비트  : 0 ~ 255
    // UShort - 16비트 : 0 ~ 65,535
    // UInt   - 32비트 : 0 ~ 4,294,967,295
    // ULong  - 64비트 : 0 ~ 18,446,744,073,709,551,615

    // 부호 없는 정수 선언 방법
    val uByte: UByte = 5u        // u 또는 U 접미사 사용
    val uShort: UShort = 10U
    val uInt: UInt = 100u
    val uLong: ULong = 1000UL    // ULong은 uL 또는 UL 접미사

    // 타입 추론 (타입 명시하지 않는 경우)
    val smallSize = 100u                // UInt (기본값)
    val bigSize = 5_000_000_000u        // ULong (UInt 범위 초과로 자동 승격)
    val forcedLong = 10uL               // ULong (uL 접미사로 강제 지정)

    // 부호 없는 타입의 특징
    // - 음수 값 저장 불가 (컴파일 오류)
    // - 동일한 비트 수에서 더 큰 양수 표현 가능
    // - 주로 바이트 데이터, 메모리 주소, 파일 크기 등에 사용

    // 데이터 타입 오버플로우
    // Int의 경우
    var d: Int = 2147483647  // Int의 최댓값
    d += 1
    println(d)  // -2147483648 (최솟값으로 순환)

    // Long to Int 변환시, 데이터 손실
    val c: Long = 1_000_000_000_000_000
    println(c.toInt())  // -1530494976 (예측 불가능한 결과)

    // 8. 오버플로우 주의사항

    // 데이터 타입 오버플로우는 프로그래머 오류
    // 오버플로우 발생 시 프로그램 동작이 예측 불가능
    // 컴파일러가 오버플로우를 경고하지 않음
}