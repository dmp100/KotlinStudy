package literalanddatatype

/**
 * 날짜: 2025-08-22
 * 주제: CharType
 * 
 * 배운 내용:
 * - 문자는 유니코드, 즉 정수로서도 판정이다.
 * - 단, 문자열은 아님.
 * 
 * 어려웠던 점:
 * - 
 */
fun main() {

    // 문자(Char) : 딱 하나의 문자만 표현하는 데이터 타입, 최소단위
    // 문자열(String) : 문자의 모음.
    val lowerCaseLetter: Char = 'a'
    val upperCaseLetter: Char = 'Q'
    val number: Char = '1'
    val space: Char = ' '
    val dollar: Char = '$'

    // 유니코드표의 16진수 코드로도 표현 가능함.
    val ch = '\u0040'
    println(ch) // @

    // 반대로 문자와 숫자는 서로 변환 가능함
    val ch1 = 'a'
    println(ch1.code) // (아스키코드/유니코드 값)
    val num = 97
    println(num.toChar()) // a

    // Kotlin에서는 문자열로 항상 받지만,문자가 필요하다면 첫 번째 글자만 꺼내오기.
    //val ch2: Char = readln().first()

    // 문자는 Unicode이기 때문에 사칙연산이 가능.
    val ch3 = 'b'
    val ch4 = ch1 + 1 // 'c'
    val ch5 = ch3 - 2 // 'a'

    // 숫자에 기호를 추가 하면 오류 생김
    // val ch6 = 'a'
    // val ch7 = 1 + ch6 //Error

    // 두 문자를 합산할 수도 없음.
    // val charsSum = 'a' + 'b' // Error

    // ++, -- 는 "유니코드 값"을 기준으로 동작한다.
    // +=, -= 도 마찬가지로 유니코드 값에 더하거나 빼는 연산자다.
    // Char 는 결국 숫자(코드 값)이기 때문에 이런 연산이 가능하다.

    // 접두사(prefix): ++ch -> 값 증가 후 반환
    // 접미사(postfix): ch++ -> 현재값 반환 후 값 증가

    var ch6 = 'A'   // 유니코드 값: 65

    // += : 유니코드 값에 10 더하기 (65 + 10 = 75)
    ch6 += 10
    println(ch6)   // 'K' (유니코드 75번 문자)

    // ++ (접두사) : 먼저 1 증가시키고 출력
    println(++ch6) // 'L' (K → L)

    // ++ (접두사) : 다시 1 증가시키고 출력
    println(++ch6) // 'M' (L → M)

    // -- (접두사) : 1 감소시키고 출력
    println(--ch6) // 'L' (M → L)

    // 이스케이프 스퀀스

    print('\t') // makes a tab
    print('a')  // prints 'a'
    print('\n') // goes to a new line
    print('c')  // prints 'c'

    // 문자는 유니코드 값 기준으로 비교됩니다.

    println('a' < 'c')  // true
    println('x' >= 'z') // false

    println('D' == 'D') // true
    println('Q' != 'q') // true because capital and lowercase letters are not the same

    println('A' < 'a')  // true because capital Latin letters are placed before lowercase ones


    // 유용한 함수들
    val one = '1'

    val isDigit = one.isDigit()   // true
    val isLetter = one.isLetter() // false

    val capital = 'A'
    val small = 'e'

    val isLetterOrDigit = capital.isLetterOrDigit() // true

    val isUpperCase = capital.isUpperCase() // true
    val isLowerCase = capital.isLowerCase() // false

    val capitalEString = small.uppercase() // "E"
    val capitalE = small.uppercaseChar()   // 'E'
}