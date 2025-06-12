package literalanddatatype

/**
 * 날짜: 2025-06-10
 * 주제: Basic Literals (기본 리터럴)
 *
 * 배운 내용:
 * > 리터럴(Literals) : 코드에서 직접 표현되는 고정된 값
 * >> 기본 타입 : 정수, 문자, 문자열
 *
 * > 정수 리터럴 (Integer Literals)
 * >> 기본 형태 : `0`, `1`, `2`, `10`, `11`, `100`
 * >> 가독성을 위한 밑줄 사용 : `1_000_000` (백만)
 * >> 밑줄 여러 개 사용 가능 : `1__000_000`, `1_2_3`
 * >> *주의* 숫자 시작/끝에는 밑줄 불가 : `_10`, `100_` (오류)
 *
 * > 문자 리터럴 (Character Literals) - 2byte(16bit)
 * >> 작은따옴표 사용 : `'A'`, `'B'`, `'x'`, `'0'`, `'1'`
 * >> 단일 문자만 가능, 여러 문자 불가 : `'abc'` (오류)
 * >> 숫자 문자와 숫자 구분 필수 : `'9'`(문자) vs `9`(숫자)
 * >> 저장 방식 : Stack 메모리에 유니코드 값으로 저장
 *
 * > 문자열 리터럴 (String Literals) - 최소 40+byte
 * >> 큰따옴표 사용 : `"text"`, `"Hello World"`, `"123456"`
 * >> 개별 문자들의 시퀀스, 여러 문자 포함 가능
 * >> 문자와 구분 : `'A'`(문자) vs `"A"`(문자열)
 * >> 저장 방식 : Heap 메모리에 String 객체로 저장
 *
 * > 메모리 효율성
 * >> 정수 : 4byte, Stack 메모리, 직접 값 저장
 * >> 문자 : 2byte, Stack 메모리, 유니코드 값 저장
 * >> 문자열 : 40+byte, Heap 메모리, 객체로 저장
 * >> 단일 문자 저장 시 : `'A'`(2byte) vs `"A"`(40+byte) → 약 20배 차이
 *
 * 어려웠던 점:
 * - 문자열 메모리 저장 구조 (Stack의 참조 + Heap의 객체)
 * - 문자('1')와 숫자(1)의 내부 저장 방식 차이 (유니코드 49 vs 정수 1)
 * - 메모리 효율성을 고려한 적절한 리터럴 타입 선택
 */
fun main() {

    // Integer Literals - 4byte(32bit), Stack에 직접 값 저장
    val int = 42 // Stack에 42 값이 직접 저장
    val intUnder = 1_000_000 // 컴파일 시 밑줄 제거됨, 1000000으로 저장

    // 오류 예시 - 밑줄을 숫자 시작/끝에 사용 불가
    // val intError1 = _10    // 컴파일 오류
    // val intError2 = 100_   // 컴파일 오류

    // Character Literals - 2byte(16bit), Stack에 유니코드 값 저장
    val char = 'A'      // Stack에 유니코드 65 저장
    val charNum = '1'   // 숫자가 아닌 문자, 유니코드 49 저장
    val korean = '가'   // Stack에 유니코드 44032 저장

    // String Literals - 40+byte, Heap에 String 객체로 저장
    val string = "Hello World"     // Heap에 String 객체 생성
    val stringSpec = "H-E_LLo_W@ld" // 특수문자, 밑줄 포함 가능

    // 메모리 효율성 비교 예시
    val singleChar = 'H'    // 2byte (효율적)
    val singleString = "H"  // 40+byte (비효율적)
    val numString = "1"     // 문자열 "1", 내부에 유니코드 49 저장

    // 출력으로 확인
    println("정수: $int")
    println("밑줄 정수: $intUnder")
    println("문자: $char, 유니코드: ${char.code}")
    println("문자 숫자: $charNum, 유니코드: ${charNum.code}")
    println("한글 문자: $korean, 유니코드: ${korean.code}")
    println("문자열: $string")
    println("특수문자 문자열: $stringSpec")
    println("단일 문자: $singleChar vs 단일 문자열: $singleString")
    println("숫자 문자열: $numString, 첫 문자 유니코드: ${numString[0].code}")
}
