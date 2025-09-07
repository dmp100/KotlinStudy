package literalanddatatype

/**
 * 날짜: 2025-09-05
 * 주제: Coercion
 * 
 * 배운 내용:
 * - 
 * 
 * 어려웠던 점:
 * - 
 */
fun main() {

    // 타입 강제 변환 : 컴파일 타임에 컴파일러가 자동으로 수행하는 변환 (명시적과 다름)

    // 명시적 타입 변환 (개발자가 직접 변환)
    val a: Int = 10
    val b: Long = a.toLong()

    // 타입 강제 변환 (컴파일러가 자동 변환)
    val c: Int = 10
    val d: Long = 20L
    val result = c + d // 컴파일러가 c를 자동으로 Long으로 변환


    // Int + Float
    val x: Int = 100        // 32비트
    val y: Long = 200L      // 64비트
    val sum = x + y         // Long 타입

    // 내부적으로 일어나는 과정:
    // 1. 컴파일러가 x를 Long으로 변환: 100L
    // 2. 100L + 200L = 300L (Long 타입)

    // Float + Double
    val a2: Float = 1.5f     // 32비트 부동소수점
    val b2: Double = 2.5     // 64비트 부동소수점
    val result2 = a2 + b2      // Double 타입

    // 내부 과정:
    // 1. a2가 Double로 변환: 1.5
    // 2. 1.5 + 2.5 = 4.0 (Double 타입)

    // Byte/Short 연산결과는 INT
    // JVM이 32bit 미만 정수연산 지원을 안하기 때문
    val b1: Byte = 10
    val b3: Byte = 20
    val sum2 = b1 + b3  // Int 타입 (30)

    // JVM 레벨에서 일어나는 과정:
    // 1. b1을 Int로 확장: 10
    // 2. b3를 Int로 확장: 20
    // 3. 10 + 20 = 30 (Int 타입)

    // 실제 바이트코드 분석
    val x1: Int = 10
    val y1: Long = 20L
    val result3 = x1 + y1

    // 의사 바이트코드
//    BIPUSH 10        // Int 10을 스택에 푸시
//    I2L              // Int를 Long으로 변환
//    LCONST_1 20      // Long 20을 스택에 푸시
//    LADD             // Long 덧셈 수행
}