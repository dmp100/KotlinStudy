package conditionals

/**
 * 날짜: 2025-09-14
 * 주제: Kotlin 조건식 - if와 when 표현식
 *
 * 배운 내용:
 * - Kotlin의 if는 표현식으로 값을 반환할 수 있음
 * - 표현식으로 사용할 때는 반드시 else 분기가 필요함
 * - when 표현식은 복잡한 조건 처리에 더 적합함
 * - 문장형과 표현식형을 상황에 맞게 선택할 수 있음
 *
 * 어려웠던 점:
 * - 표현식과 문장의 차이점 이해
 * - when 표현식에서 범위와 조건식 사용법
 */
fun main() {
    /**************** - 문장형 if (Statement Style) - **********************/
    // 전통적인 방식: 조건에 따라 동작만 수행하고 값을 반환하지 않음
    // else 분기가 없어도 컴파일 가능

    val score = 85

    if (score >= 90) {
        println("A")
    } else if (score >= 80) {
        println("B")
    } else {
        println("더 노력")
    }

    /*************** - 표현식형 if (Expression Style) - *****************/
    // Kotlin의 특별한 기능: if가 값을 반환하여 변수에 저장 가능
    // 표현식으로 사용할 때는 반드시 else 분기가 필요함
    // 각 블록의 마지막 표현식이 해당 블록의 반환값이 됨

    val message = if (score >= 90) {
        "A학점입니다"    // 이 문자열이 반환됨
    } else if (score >= 80) {
        "B학점입니다"    // 이 문자열이 반환됨
    } else {
        "더 노력하세요"   // 이 문자열이 반환됨
    }
    println(message)

    /*************** - 간단한 표현식 (Simple Expression) - ****************/
    // 한 줄로 표현 가능한 경우 중괄호 생략 가능
    // Java의 삼항 연산자와 같은 역할: (조건) ? 참값 : 거짓값

    val a = 0
    val b = 1
    val max = if (a > b) a else b    // a와 b 중 더 큰 값을 max에 저장

    /*************** - 직접 사용 (Direct Use) - *********************/
    // 변수에 저장하지 않고 함수의 인자로 직접 전달 가능
    // 복잡한 조건도 바로 사용할 수 있어 코드가 간결해짐

    println(if (a == b) {
        "a equal b"
    } else if (a > b) {
        "a is greater than b"
    } else {
        "a is less than b"
    })

    /*************** - when 표현식 (When Expression) - ******************/
    // 여러 조건을 처리할 때 if-else-if보다 더 깔끔하고 읽기 쉬움
    // 값 매칭뿐만 아니라 범위, 조건식도 처리 가능

    val number = 4

    // 기본적인 값 매칭 사용법
    val message1 = when (number) {
        1 -> "One"           // number가 1이면 "One" 반환
        2 -> "Two"           // number가 2이면 "Two" 반환
        3 -> "Three"         // number가 3이면 "Three" 반환
        4 -> "Four"          // number가 4이면 "Four" 반환
        else -> "Number is greater than four"  // 위 조건에 해당하지 않으면 이 값 반환
    }

    // 고급 사용법: 범위와 조건식 활용
    when {
        number < 0 -> println("Negative number")           // 음수 체크
        number in 1..10 -> println("Number between 1 and 10")  // 범위 체크 (1부터 10까지)
        number % 2 == 0 -> println("Even number")          // 짝수 체크
        else -> println("Odd number greater than 10")      // 나머지 경우
    }
}