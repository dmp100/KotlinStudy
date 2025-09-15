package functions

/**
 * 날짜: 2025-09-15
 * 주제: 함수 선언 기초
 *
 * 배운 내용:
 * - 함수는 코드를 재사용 가능한 블록으로 구성하는 기본 단위
 * - fun 키워드로 함수를 선언하고 매개변수와 반환 타입을 지정
 * - 매개변수는 함수 내부에서만 접근 가능
 * - 반환 타입을 생략하거나 Unit 타입으로 지정 가능
 * - 단일 표현식 함수로 간결하게 작성할 수 있음
 * - 반환 타입은 자동으로 추론 가능
 * - return 문 이후의 코드는 실행되지 않음 (unreachable code)
 *
 * 어려웠던 점:
 * - 매개변수와 인수의 차이점
 * - Unit 타입의 개념과 사용 시점
 * - 단일 표현식 함수의 문법과 활용
 * - 함수 내부 변수의 스코프 이해
 */
fun main() {

    /*************** - 기본 문법 구조 - ****************/
    // fun functionName(p1: Type1, p2: Type2, ...): ReturnType { body }

    println("=== 기본 함수 문법 ===")

    // 문서의 기본 예제: 두 정수의 합
    fun sum(a: Int, b: Int): Int {
        val result = a + b
        return result
    }

    val result1 = sum(2, 5)
    println(result1) // 7

    val result2 = sum(result1, 4)
    println(result2) // 11

    /*************** - 다양한 매개변수 패턴 - ****************/
    // 문서의 예제들: 매개변수 개수에 따른 함수들

    println("\n=== 다양한 매개변수 패턴 ===")

    /**
     * The function returns its argument
     */
    fun identity(a: Int): Int {
        return a
    }

    /**
     * The function returns the sum of two Ints
     */
    fun sum2(a: Int, b: Int): Int {
        return a + b
    }

    /**
     * The function just returns 3
     */
    fun get3(): Int {
        return 3
    }

    fun add3(a: Int): Int {
        return identity(a) + get3()
    }

    println(identity(1000)) // 1000
    println(sum2(200, 300))  // 500
    println(get3())         // 3
    println(add3(5))        // 8

    /*************** - 반환 타입 처리 - ****************/
    // 아무것도 반환하지 않는 함수들

    println("\n=== 반환 타입 처리 ===")

    /**
     * The function prints the values of a and b
     */
    fun printAB(a: Int, b: Int) {
        println(a)
        println(b)
    }

    /**
     * The function prints the sum of a and b
     */
    fun printSum(a: Int, b: Int): Unit {
        println(a + b)
    }

    printAB(10, 20)
    printSum(15, 25)

    /*************** - 함수 본문 예제들 - ****************/
    // 문서의 함수 본문 예제들

    println("\n=== 함수 본문 예제들 ===")

    // 마지막 자릿수 추출 (변수 사용)
    fun extractLastDigit(number: Int): Int {
        val lastDigit = number % 10
        return lastDigit
    }

    // 마지막 자릿수 추출 (간소화)
    fun extractLastDigitSimple(number: Int): Int {
        return number % 10
    }

    // 양수 판별
    fun isPositive(number: Int): Boolean {
        return number > 0
    }

    // 도달 불가능한 코드 예제
    /**
     * It returns "hello"
     */
    fun getGreeting(): String {
        return "hello"   // Ends the function
        // println("hello") // Will not be executed (unreachable code)
    }

    println("마지막 자릿수: ${extractLastDigit(12345)}")
    println("마지막 자릿수 (간소화): ${extractLastDigitSimple(67890)}")
    println("양수 판별: ${isPositive(10)}")
    println("양수 판별: ${isPositive(-5)}")
    println("인사말: ${getGreeting()}")

    /*************** - 단일 표현식 함수 - ****************/
    // 중괄호 없이 간결하게 작성하는 방법

    println("\n=== 단일 표현식 함수 ===")

    // 반환 타입 명시
    fun sumExpression(a: Int, b: Int): Int = a + b
    fun sayHello(): Unit = println("Hello")
    fun isPositiveExpression(number: Int): Boolean = number > 0

    // 반환 타입 추론
    fun sumInferred(a: Int, b: Int) = a + b // Int
    fun sayHelloInferred() = println("Hello") // Unit
    fun isPositiveInferred(number: Int) = number > 0 // Boolean

    println("단일 표현식 합: ${sumExpression(3, 7)}")
    sayHello()
    println("단일 표현식 양수 판별: ${isPositiveExpression(8)}")

    println("타입 추론 합: ${sumInferred(4, 6)}")
    sayHelloInferred()
    println("타입 추론 양수 판별: ${isPositiveInferred(-3)}")

    /*************** - 실용적 활용 예제 - ****************/

    println("\n=== 실용적 활용 예제 ===")

    // 온도 변환 함수들
    fun celsiusToFahrenheit(celsius: Double): Double {
        return celsius * 9.0 / 5.0 + 32.0
    }

    fun fahrenheitToCelsius(fahrenheit: Double) = (fahrenheit - 32.0) * 5.0 / 9.0

    // 문자열 검증 함수들
    fun isValidEmail(email: String): Boolean {
        return email.contains("@") && email.contains(".")
    }

    fun formatName(firstName: String, lastName: String) = "$firstName $lastName"

    // 수학 함수들
    fun calculateArea(width: Double, height: Double) = width * height

    fun isEven(number: Int): Boolean = number % 2 == 0

    fun max(a: Int, b: Int) = if (a > b) a else b

    // 테스트
    println("섭씨 25도 = 화씨 ${celsiusToFahrenheit(25.0)}도")
    println("화씨 77도 = 섭씨 ${fahrenheitToCelsius(77.0)}도")

    println("이메일 검증: ${isValidEmail("test@example.com")}")
    println("이메일 검증: ${isValidEmail("invalid-email")}")

    println("이름 포맷: ${formatName("김", "철수")}")

    println("넓이 계산: ${calculateArea(5.0, 3.0)}")

    println("짝수 판별: ${isEven(4)}")
    println("짝수 판별: ${isEven(7)}")

    println("최댓값: ${max(10, 15)}")

    // 함수 조합 사용
    fun processTemperature(celsius: Double): String {
        val fahrenheit = celsiusToFahrenheit(celsius)
        return "섭씨 $celsius 도는 화씨 $fahrenheit 도입니다"
    }

    println(processTemperature(30.0))

    // 복잡한 검증 함수
    fun validateUser(name: String, age: Int, email: String): Boolean {
        val nameValid = name.isNotEmpty()
        val ageValid = age in 1..120
        val emailValid = isValidEmail(email)

        return nameValid && ageValid && emailValid
    }

    println("사용자 검증: ${validateUser("홍길동", 25, "hong@test.com")}")
    println("사용자 검증: ${validateUser("", 25, "hong@test.com")}")

    /*************** - 정리 - ****************/

    println("\n=== 정리 ===")
    println("1. 함수는 fun 키워드로 선언")
    println("2. 매개변수는 (name: Type) 형태로 작성")
    println("3. 반환 타입은 : ReturnType으로 지정 (생략 가능)")
    println("4. Unit 타입은 반환값이 없음을 의미")
    println("5. 단일 표현식 함수는 = 기호로 간결하게 작성")
    println("6. 반환 타입은 자동 추론 가능")
    println("7. return 이후의 코드는 실행되지 않음")
    println("8. 함수는 코드 재사용성과 가독성을 향상시킴")
}
