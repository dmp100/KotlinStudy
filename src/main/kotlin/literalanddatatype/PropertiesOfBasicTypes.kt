package literalanddatatype

/**
 * 날짜: 2025-08-15
 * 주제: PropertiesOfBasicTypes
 * 
 * 배운 내용:
 * - 정수 타입의 크기 순서 : Long > Int > Short > Byte
 * 1. Byte / 8비트 (1바이트) / -128 ~ 127 / 메모리 절약이 중요한 경우
 * 2. Short / 16비트 (2바이트) / -32,768 ~ 32,767 / 중간 크기 정수
 * 3. Int / 32비트 (4바이트) / -21억 ~ 21억 / 가장 일반적인 정수
 * 4. Long/ 64비트 (8바이트) / -922경 ~ 922경 / 큰 수, 시간값, 파일크기
 *
 * 5. Float/ 32비트 (4바이트)/ 6-7자리(정밀도) / 메모리 절약, 3D 그래픽
 * 6. Double / 64비트 (8바이트) / 14-16자리 / 기본 실수 타입
 * 
 * 어려웠던 점:
 * - 
 */
fun main() {
// Byte: 8비트 (1바이트), 범위: -128 ~ 127
    var byteValue: Byte = 123
    val byteNumber: Byte = 15
    println(Byte.MIN_VALUE)  // -128
    println(Byte.MAX_VALUE)  // 127
    println(Byte.SIZE_BITS)  // 8
    println(Byte.SIZE_BYTES) // 1

// Short: 16비트 (2바이트), 범위: -32,768 ~ 32,767
    var shortValue: Short = 123
    val shortNumber: Short = 15
    println(Short.MIN_VALUE)  // -32768
    println(Short.MAX_VALUE)  // 32767
    println(Short.SIZE_BITS)  // 16
    println(Short.SIZE_BYTES) // 2

// Int: 32비트 (4바이트), 범위: -2,147,483,648 ~ 2,147,483,647
    var intValue: Int = 123
    val zero = 0              // Int (타입 추론)
    val one = 1               // Int (타입 추론)
    val oneMillion = 1_000_000 // Int (타입 추론)
    println(Int.MIN_VALUE)    // -2147483648
    println(Int.MAX_VALUE)    // 2147483647
    println(Int.SIZE_BITS)    // 32
    println(Int.SIZE_BYTES)   // 4

// Long: 64비트 (8바이트), 범위: -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
    var longValue: Long = 123L
    val twoMillion = 2_000_000L            // Long (L 접미사)
    val bigNumber = 1_000_000_000_000_000  // Long (자동 선택 - Int 범위 초과)
    val ten: Long = 10                     // Long (타입 명시)
    println(Long.MIN_VALUE)  // -9223372036854775808
    println(Long.MAX_VALUE)  // 9223372036854775807
    println(Long.SIZE_BITS)  // 64
    println(Long.SIZE_BYTES) // 8

    // Float: 32비트 (4바이트), 정밀도: 약 6-7자리
    var floatValue: Float = 12.3F
    val e = 2.71828f                    // Float (f 접미사)
    val fraction: Float = 1.51f         // Float (타입 명시)
    println(Float.MIN_VALUE)  // 1.4E-45
    println(Float.MAX_VALUE)  // 3.4028235E38
    println(Float.SIZE_BITS)  // 32
    println(Float.SIZE_BYTES) // 4

    // Double: 64비트 (8바이트), 정밀도: 약 14-16자리 (기본 실수 타입)
    var doubleValue: Double = 12.3
    val pi = 3.1415                     // Double (타입 추론)
    println(Double.MIN_VALUE) // 4.9E-324
    println(Double.MAX_VALUE) // 1.7976931348623157E308
    println(Double.SIZE_BITS) // 64
    println(Double.SIZE_BYTES) // 8

    // Char: 16비트 (2바이트), 유니코드 문자 표현
    var charValue: Char = 'A'
    val lowerCaseLetter = 'a'
    val upperCaseLetter = 'Q'
    val number = '1'
    val space = ' '
    val dollar = '$'
    println(Char.MIN_VALUE.code) // 0
    println(Char.MAX_VALUE.code) // 65535
    println(Char.SIZE_BITS)      // 16
    println(Char.SIZE_BYTES)     // 2


    // Boolean: 논리적으로 1비트, 실제로는 JVM에서 1바이트
    var booleanValue: Boolean = true
    val enabled = true
    val bugFound = false
    // Boolean에는 SIZE_BITS, SIZE_BYTES 속성이 없음


    // String: 가변 크기, 문자들의 시퀀스
    var stringValue: String = "ABC"
    val creditCardNumber = "1234 5678 9012 3456"
    val message = "Learn Kotlin instead of Java."
    println(stringValue.length) // 3 (문자 개수)
}