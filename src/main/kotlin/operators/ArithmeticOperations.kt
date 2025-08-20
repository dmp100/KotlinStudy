package operators

/**
 * 날짜: 2025-08-20
 * 주제: ArithmeticOperations
 * 
 * 배운 내용:
 * - 
 * 
 * 어려웠던 점:
 * - 
 */
fun main() {

    // 산술연산자
    // 계산 방법 - BODMAS (Brackets, Order, Division, Multiplication, Addition, Subtraction)
    // 괄호 -> 단항 -> 곱셈,나눗셈,나머지 -> 덧셈,뺄셈

    println(13 + 25) // prints 38
    println(20 + 70) // prints 90
    // 덧셈 +

    println(70 - 30) // prints 40
    println(30 - 70) // prints -40
    // 빼기 -

    println(21 * 3)  // prints 63
    println(20 * 10) // prints 200
    // 곱셉 *

    println(8 / 3)  // prints 2
    println(41 / 5) // prints 8
    // 나누기 /

    println(10 % 3) // prints 1 because 10 divided by 3 leaves a remainder of 1
    println(12 % 4) // prints 0 because 12 divided by 4 leaves no remainder
    // 나머지 %

    // 복잡한 계산 - BODMAS
    println(1 + 3 * 4 - 2) // prints 11

    println((1 + 3) * (4 - 2)) // prints 8
    // 실행순서 지정위해 괄호 사용

    println(54 % 10) // it prints 4
    println((54 / 10) % 10) // it prints 5

    // 단항 연산자
    // 더하기 연산자는 값만 제공합니다. 선택 연산자이므로 실제로는 생략합니다.
    println(+5) // prints 5
    println(+(-5)) // prints -5

    println(-8)  // prints -8
    println(-(100 + 4)) // prints -104
}