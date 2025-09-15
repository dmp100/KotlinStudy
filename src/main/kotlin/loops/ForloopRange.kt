package loops

/**
 * 날짜: 2025-09-15
 * 주제: for 반복문과 범위 반복
 *
 * 배운 내용:
 * - for 루프는 범위, 배열, 컬렉션의 각 요소를 순회하는 반복문
 * - 범위(1..4), 문자열, 문자 범위를 반복할 수 있음
 * - downTo 키워드로 역순 반복, until로 상한 제외, step으로 간격 설정
 * - 중첩 for 루프로 다차원 구조 처리 가능
 * - 팩토리얼, 구구단 등 수학적 계산에 활용
 * - 다양한 범위 문법이 코드 가독성을 크게 향상시킴
 *
 * 어려웠던 점:
 * - downTo와 일반 범위(..)의 문법 차이점
 * - until과 닫힌 범위의 차이 (상한 포함/제외)
 * - step을 사용할 때의 시작점과 끝점 계산
 * - 중첩 루프에서 변수명 구분과 스코프 관리
 */
fun main() {

    /*************** - 기본 for 루프 구조 - ****************/
    // for (element in source) { 루프 본문 }
    // source의 각 요소에 대해 루프 본문이 실행됨

    println("=== 기본 정수 범위 반복 ===")
    for (i in 1..4) {
        println("숫자: $i")
    }
    // 출력: 1, 2, 3, 4 (각각 새 줄에)

    /*************** - 문자 범위 반복 - ****************/
    // 단일 문자 범위는 가능하지만 문자열 범위("da".."dd")는 불가능

    println("=== 문자 범위 반복 ===")
    for (ch in 'a'..'e') {
        println("문자: $ch")
    }
    // 출력: a, b, c, d, e

    println("=== 대문자 범위 ===")
    for (ch in 'A'..'D') {
        print("$ch ")  // A B C D
    }
    println()

    /*************** - 문자열 반복 - ****************/
    // 문자열의 각 문자를 하나씩 순회

    println("=== 문자열 순회 ===")
    val str = "Kotlin"
    for (ch in str) {
        println("글자: $ch")
    }
    // 출력: K, o, t, l, i, n (각각 새 줄에)

    /*************** - 역순 반복 (downTo) - ****************/
    // downTo 키워드를 사용하여 큰 수에서 작은 수로 반복
    // 주의: 4..1이 아니라 4 downTo 1을 사용해야 함

    println("=== 역순 반복 ===")
    for (i in 5 downTo 1) {
        println("카운트다운: $i")
    }
    println("발사!")

    /*************** - 상한 제외 (until) - ****************/
    // until 키워드로 상한값을 제외한 범위 반복
    // 1 until 4 = 1, 2, 3 (4 제외)

    println("=== until 사용 (상한 제외) ===")
    for (i in 1 until 5) {
        println("$i (5 제외)")
    }
    // 출력: 1, 2, 3, 4 (5는 제외)

    // until과 닫힌 범위 비교
    println("=== 비교: until vs 닫힌 범위 ===")
    print("1 until 4: ")
    for (i in 1 until 4) print("$i ")  // 1 2 3
    println()

    print("1..3: ")
    for (i in 1..3) print("$i ")       // 1 2 3 (같은 결과)
    println()

    /*************** - 간격 설정 (step) - ****************/
    // step 키워드로 반복 간격 설정 (기본값은 1)

    println("=== step을 이용한 간격 설정 ===")
    println("홀수만 출력 (1부터 10까지, step 2):")
    for (i in 1..10 step 2) {
        print("$i ")  // 1 3 5 7 9
    }
    println()

    println("짝수만 출력 (2부터 10까지, step 2):")
    for (i in 2..10 step 2) {
        print("$i ")  // 2 4 6 8 10
    }
    println()

    // 역순 + step 조합
    println("=== 역순 + step 조합 ===")
    for (i in 10 downTo 1 step 3) {
        print("$i ")  // 10 7 4 1
    }
    println()

    /*************** - 실용적 예시: 팩토리얼 계산 - ****************/
    // n! = 1 × 2 × 3 × ... × n

    println("=== 팩토리얼 계산 ===")
    println("팩토리얼을 계산할 숫자를 입력하세요:")
    val n = readln().toInt()
    var factorial = 1  // 팩토리얼 시작값 (0! = 1, 1! = 1)

    for (i in 2..n) {  // 2부터 n까지 곱하기
        factorial *= i
        println("$i 까지 곱한 결과: $factorial")
    }

    println("$n! = $factorial")

    /*************** - 중첩 for 루프 - ****************/
    // 루프 안에 다른 루프를 넣어 다차원 구조 처리

    println("=== 구구단 (2단~4단) ===")
    for (dan in 2..4) {
        println("[$dan 단]")
        for (num in 1..9) {
            println("$dan × $num = ${dan * num}")
        }
        println()  // 단 구분을 위한 빈 줄
    }

    /*************** - 복잡한 중첩 루프 예시: 짝수 곱셈표 - ****************/
    // 2부터 10까지 짝수들의 곱셈표 생성

    println("=== 짝수 곱셈표 ===")
    print("    ")  // 헤더 공간
    for (j in 2..10 step 2) {
        print("$j\t")  // 열 헤더
    }
    println()

    for (i in 2..10 step 2) {
        print("$i |\t")  // 행 헤더
        for (j in 2..10 step 2) {
            print("${i * j}\t")  // 곱셈 결과
        }
        println()
    }

    /*************** - 다양한 범위 문법 정리 - ****************/
    // Kotlin의 다양한 범위 표현법들

    println("=== 범위 문법 정리 ===")

    // 닫힌 범위 (양 끝 포함)
    print("1..5: ")
    for (i in 1..5) print("$i ")
    println(" (닫힌 범위)")

    // 반열린 범위 (상한 제외)
    print("1 until 5: ")
    for (i in 1 until 5) print("$i ")
    println(" (상한 제외)")

    // 간격 지정
    print("1..10 step 3: ")
    for (i in 1..10 step 3) print("$i ")
    println(" (간격 3)")

    // 역순
    print("5 downTo 1: ")
    for (i in 5 downTo 1) print("$i ")
    println(" (역순)")

    // 역순 + 간격
    print("10 downTo 1 step 2: ")
    for (i in 10 downTo 1 step 2) print("$i ")
    println(" (역순 + 간격 2)")

    /*************** - 실전 응용 예시 - ****************/

    // 피라미드 패턴 출력
    println("=== 별 피라미드 ===")
    for (i in 1..5) {
        // 공백 출력
        for (space in 1..(5-i)) {
            print(" ")
        }
        // 별 출력
        for (star in 1..(2*i-1)) {
            print("*")
        }
        println()
    }

    // 소수 찾기 (2부터 20까지)
    println("=== 소수 찾기 (2~20) ===")
    for (num in 2..20) {
        var isPrime = true
        for (divisor in 2 until num) {
            if (num % divisor == 0) {
                isPrime = false
                break  // 약수를 찾으면 더 이상 확인할 필요 없음
            }
        }
        if (isPrime) {
            print("$num ")
        }
    }
    println()
}