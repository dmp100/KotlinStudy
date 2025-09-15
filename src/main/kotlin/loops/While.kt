package loops

import java.util.*

/**
 * 날짜: 2025-09-15
 * 주제: while과 do...while 반복문
 *
 * 배운 내용:
 * - while 루프는 조건을 먼저 검사한 후 실행하는 전조건 루프
 * - do...while 루프는 먼저 실행한 후 조건을 검사하는 후조건 루프
 * - while은 조건이 거짓이면 한 번도 실행되지 않을 수 있음
 * - do...while은 최소 한 번은 반드시 실행됨
 * - 무한 루프 작성 가능 (while(true), do...while(true))
 * - Scanner의 hasNext() 함수로 입력 데이터 존재 여부 확인
 *
 * 어려웠던 점:
 * - while과 do...while의 실행 순서 차이점 이해
 * - 루프 변수의 초기화와 증감 위치의 중요성
 * - Scanner 사용법과 입력 종료 조건 처리
 * - 무한 루프의 위험성과 적절한 사용법
 */
fun main() {

    /*************** - while 루프 기본 구조 - ****************/
    // while (조건) { 루프 본문 }
    // 조건을 먼저 검사하고, 참이면 본문 실행 (전조건 루프)

    println("=== 기본 while 루프 ===")
    var i = 0
    while (i < 5) {
        println("i의 값: $i")
        i++  // 반드시 조건 변수를 변경해야 무한 루프 방지
    }
    println("루프 완료")

    /*************** - while 루프의 특징 - ****************/
    // 조건이 처음부터 거짓이면 한 번도 실행되지 않음

    println("=== 조건이 거짓인 경우 ===")
    var j = 10
    while (j < 5) {
        println("이 코드는 실행되지 않음")  // 10 < 5가 false이므로 실행 안됨
        j++
    }
    println("while 루프를 건너뜀")

    /*************** - 문자 처리 while 루프 - ****************/
    // 문자도 Unicode 값으로 비교하여 반복 가능

    println("=== 문자 반복 (A~Z) ===")
    var letter = 'A'
    while (letter <= 'Z') {
        print("$letter ")  // A B C D ... Z
        letter++  // 다음 문자로 증가 (Unicode 값 기준)
    }
    println()

    println("=== 소문자 반복 (a~e) ===")
    var smallLetter = 'a'
    while (smallLetter <= 'e') {
        print("$smallLetter ")
        smallLetter++
    }
    println()

    /*************** - 입력 처리 while 루프 - ****************/
    // Scanner의 hasNext() 함수를 사용한 동적 입력 처리

    // import java.util.*

            println("=== 동적 입력 처리 ===")
    println("단어들을 입력하세요 (Ctrl+D로 종료):")
    val scanner = Scanner(System.`in`)
    var wordCount = 0

    while (scanner.hasNext()) {
        val word = scanner.next()
        wordCount++
        println("${wordCount}번째 단어: $word")
    }
    println("총 $wordCount 개의 단어를 입력했습니다")

    /*************** - do...while 루프 기본 구조 - ****************/
    // do { 루프 본문 } while (조건)
    // 본문을 먼저 실행한 후 조건 검사 (후조건 루프)
    // 최소 한 번은 반드시 실행됨

    println("=== 기본 do...while 루프 ===")
    var k = 0
    do {
        println("k의 값: $k")
        k++
    } while (k < 3)
    println("do...while 완료")

    /*************** - do...while의 특징 - ****************/
    // 조건이 처음부터 거짓이어도 최소 한 번은 실행됨

    println("=== 조건이 거짓인 do...while ===")
    var m = 10
    do {
        println("m의 값: $m (조건이 거짓이어도 한 번 실행됨)")
        m++
    } while (m < 5)  // 10 < 5는 false이지만 위 코드는 한 번 실행됨

    /*************** - while vs do...while 비교 - ****************/
    // 같은 조건에서 두 루프의 동작 차이 비교

    println("=== while vs do...while 비교 ===")

    // while 루프 테스트
    println("while 루프 (조건: false):")
    var whileTest = 5
    while (whileTest < 5) {
        println("while: 실행되지 않음")
    }
    println("while: 조건이 거짓이므로 실행 안됨")

    // do...while 루프 테스트
    println("do...while 루프 (조건: false):")
    var doWhileTest = 5
    do {
        println("do...while: 한 번은 실행됨")
    } while (doWhileTest < 5)

    /*************** - 실용적 예시: 사용자 입력 검증 - ****************/
    // do...while의 대표적 사용 사례: 올바른 입력을 받을 때까지 반복

    println("=== 입력 검증 (1~10 사이 숫자) ===")
    var number: Int
    do {
        print("1부터 10 사이의 숫자를 입력하세요: ")
        number = readln().toInt()
        if (number !in 1..10) {
            println("잘못된 입력입니다. 다시 시도하세요.")
        }
    } while (number !in 1..10)
    println("올바른 입력: $number")

    /*************** - 카운터 기반 반복 예시 - ****************/
    // while을 사용한 다양한 카운팅 패턴

    println("=== 카운트다운 (while) ===")
    var countdown = 5
    while (countdown > 0) {
        println("카운트다운: $countdown")
        countdown--
    }
    println("발사!")

    println("=== 짝수만 출력 (while) ===")
    var even = 2
    while (even <= 10) {
        print("$even ")
        even += 2  // 2씩 증가
    }
    println()

    /*************** - 문자열 처리 예시 - ****************/
    // 문자열의 각 문자를 하나씩 처리

    println("=== 문자열 역순 출력 ===")
    val text = "Kotlin"
    var index = text.length - 1
    while (index >= 0) {
        print(text[index])
        index--
    }
    println()

    /*************** - 누적 계산 예시 - ****************/
    // while을 사용한 수학적 계산

    println("=== 1부터 100까지의 합 ===")
    var sum = 0
    var num = 1
    while (num <= 100) {
        sum += num
        num++
    }
    println("1부터 100까지의 합: $sum")

    println("=== 팩토리얼 계산 (while 버전) ===")
    val n = 5
    var factorial = 1
    var factor = 1
    while (factor <= n) {
        factorial *= factor
        println("$factor! = $factorial")
        factor++
    }

    /*************** - 무한 루프와 제어 - ****************/
    // break를 사용한 무한 루프 제어

    println("=== 제어된 무한 루프 ===")
    var counter = 0
    while (true) {  // 무한 루프
        counter++
        println("무한 루프 실행 횟수: $counter")
        if (counter >= 3) {
            println("3번 실행 후 종료")
            break  // 루프 탈출
        }
    }

    /*************** - 중첩 while 루프 - ****************/
    // while 루프 안에 다른 while 루프

    println("=== 중첩 while 루프 (구구단 일부) ===")
    var dan = 2
    while (dan <= 4) {
        println("[$dan 단]")
        var gop = 1
        while (gop <= 5) {
            println("$dan × $gop = ${dan * gop}")
            gop++
        }
        println()
        dan++
    }

    /*************** - 실전 응용: 숫자 맞추기 게임 - ****************/
    // do...while을 활용한 간단한 게임

    println("=== 숫자 맞추기 게임 ===")
    val targetNumber = (1..10).random()
    var guess: Int
    var attempts = 0

    do {
        print("1부터 10 사이의 숫자를 맞춰보세요: ")
        guess = readln().toInt()
        attempts++

        when {
            guess < targetNumber -> println("더 큰 숫자입니다!")
            guess > targetNumber -> println("더 작은 숫자입니다!")
            else -> {
                println("정답입니다! $attempts 번 만에 맞췄습니다!")
                break
            }
        }
    } while (true)
}
