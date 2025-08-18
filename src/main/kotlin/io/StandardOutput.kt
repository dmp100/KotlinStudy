package io

/**
 * 날짜: 2025-08-19
 * 주제: Standard output
 *
 * 배운 내용:
 * - println - 문자열을 화면에 표시 한 후 줄바꿈
 * - println() - 공백 출력
 * - print - 모든 문자열을 한줄에 출력
 * - [ 숫자, 문자, 문자열 출력가능 ]
 * - $ 연산자 : 문자열 템플에서 변수, 표현식의 값을 문자열에 직접 삽입
 * - ${ 표현 식 } : 복잡 표현식, 개체 속성에 액세스해야하는 경우.
 * -
 * - $변수명: 변수값으로 치환
 * - $ 단독: 뒤에 유효한 변수명이 없으면 일반 문자로 처리
 * - \$: 이스케이프 문자로 달러 기호를 일반 문자로 처리
 * - 연속된 $: 각각 독립적으로 해석
 *
 * 어려웠던 점:
 * - $ 사용법이 어려웠다.
 */
fun main() {
    println("I")
    println("know")
    println("Kotlin")
    println("well.")
    // print line - 문자열을 화면에 표시 한 후 줄바꿈

    println()
    // prints an empty line

    print("I ")
    print("know ")
    print("Kotlin ")
    print("well.")
    // print - 모든 문자열을 한줄에 출력

    print(108)   // prints a number
    print('c')   // prints a character
    print("Q")   // prints a string
    println('3') // prints a character that represents a digit

    print(22)
    print('E')
    print(8)
    println('1')
    // 문자열, 숫자, 문자도 출력 가능.

    val name = "Alice"
    println("Hello, $name!")
    // $ 연산자 : 문자열 템플에서 변수, 표현식의 값을 문자열에 직접 삽입
    // Output: Hello, Alice!

    val a = 5
    val b = 10
    println("Sum of $a and $b is ${a + b}")
    // ${ 표현 식 } : Output: Sum of 5 and 10 is 15

    val a1 = 20

    // There is a dot after $, not variable, so no problem here
    println("The price is $a$.")
    // Output:  The price is 20$.

    // The second $ insert the variable and the first a common symbol here
    println("The price is $$a.")
    // Output: The price is $20.

    // \$ means that you take $ and don't mind about special interpretation
    println("The price is \$a.")
    // Output: The price is $a.

    //Another example with \$
    println("The price is \$$a.")
}