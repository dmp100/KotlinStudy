package loops

/**
 * 날짜: 2025-09-15
 * 주제: repeat 반복문
 *
 * 배운 내용:
 * - repeat(n)은 코드 블록을 정확히 n번 반복하는 가장 간단한 반복문
 * - n이 0이거나 음수면 반복문이 실행되지 않음
 * - it 키워드를 통해 현재 반복 횟수 확인 가능 (0부터 시작)
 * - 중괄호 안의 코드는 람다 표현식(이름 없는 함수)
 * - 반복문 내부에서 데이터 입력, 변수 선언, 계산 수행 가능
 * - 정확한 반복 횟수를 알고 있을 때 매우 유용함
 *
 * 어려웠던 점:
 * - it 키워드가 0부터 시작한다는 점 (1부터가 아님)
 * - 람다 표현식의 개념과 중괄호의 의미
 * - 반복문 내부와 외부 변수의 스코프 관계
 */
fun main() {

    /*************** - 기본 구조와 사용법 - ****************/
    // repeat(n) { 코드 블록 } 형태로 사용
    // n은 반복 횟수를 나타내는 정수

    repeat(3) {
        println("Hello")    // "Hello"를 3번 출력
    }
    // 출력: Hello, Hello, Hello (각각 새 줄에)

    /*************** - 특별한 경우들 - ****************/
    // n이 0이거나 음수인 경우의 동작

    repeat(0) {
        println("실행되지 않음")    // 출력되지 않음
    }

    repeat(-5) {
        println("실행되지 않음")    // 출력되지 않음
    }

    repeat(1) {
        println("한 번만 실행")     // 한 번만 출력
    }

    /*************** - it 키워드 활용 - ****************/
    // it은 현재 반복 횟수를 나타냄 (0부터 시작)
    // 몇 번째 반복인지 알고 싶을 때 사용

    println("=== 반복 횟수 출력 ===")
    repeat(5) {
        println("현재 반복: $it")    // 0, 1, 2, 3, 4 출력
    }

    // it을 활용한 실용적 예시들
    println("=== 카운트다운 ===")
    repeat(5) {
        val countdown = 5 - it      // 5, 4, 3, 2, 1
        println("카운트다운: $countdown")
    }
    println("발사!")

    println("=== 구구단 (7단) ===")
    repeat(9) {
        val num = it + 1            // it는 0부터 시작하므로 1을 더함
        println("7 × $num = ${7 * num}")
    }

    /*************** - 데이터 입력과 처리 - ****************/
    // 반복문 내부에서 데이터 읽기, 변수 선언, 계산 수행 가능
    // 첫 번째 입력값은 반복 횟수, 그 다음부터는 처리할 데이터

    println("=== 숫자 합계 계산 ===")
    println("몇 개의 숫자를 입력하시겠습니까?")
    val n = readln().toInt()        // 반복 횟수 입력받기
    var sum = 0                     // 합계를 저장할 변수

    println("$n 개의 숫자를 입력하세요:")
    repeat(n) {
        println("${it + 1}번째 숫자:")
        val next = readln().toInt()  // 각 숫자 입력받기
        sum += next                  // 합계에 더하기
        println("현재까지의 합: $sum")
    }

    println("최종 합계: $sum")

    /*************** - 람다 표현식의 특징 - ****************/
    // 중괄호 안의 코드는 람다 표현식 (이름 없는 함수)
    // 복잡한 로직도 포함 가능

    println("=== 복잡한 람다 예시 ===")
    repeat(3) {
        val isEven = it % 2 == 0
        val message = if (isEven) "짝수" else "홀수"
        println("반복 $it: $message 번째입니다")

        // 조건에 따른 다른 동작
        if (it == 0) {
            println("  → 첫 번째 반복입니다!")
        } else if (it == 2) {
            println("  → 마지막 반복입니다!")
        }
    }

    /*************** - 실용적 활용 예시 - ****************/

    // 별 패턴 출력
    println("=== 별 패턴 ===")
    repeat(5) {
        val stars = "*".repeat(it + 1)  // *, **, ***, ****, *****
        println(stars)
    }

    // 테스트 데이터 생성
    println("=== 랜덤 데이터 생성 ===")
    val testData = mutableListOf<Int>()
    repeat(5) {
        val randomNumber = (1..100).random()
        testData.add(randomNumber)
        println("${it + 1}번째 데이터: $randomNumber")
    }
    println("생성된 데이터: $testData")

    // 진행률 표시
    println("=== 작업 진행률 ===")
    repeat(10) {
        val progress = ((it + 1) * 10)  // 10%, 20%, 30%, ...
        println("작업 진행률: $progress%")
        // 실제로는 Thread.sleep() 등으로 지연을 줄 수 있음
    }
    println("작업 완료!")

    /*************** - 중첩 repeat 사용 - ****************/
    // repeat 안에 다른 repeat을 사용할 수 있음

    println("=== 구구단 전체 (2단~9단) ===")
    repeat(8) { dan ->
        val currentDan = dan + 2    // 2단부터 시작
        println("[$currentDan 단]")
        repeat(9) { num ->
            val currentNum = num + 1
            println("$currentDan × $currentNum = ${currentDan * currentNum}")
        }
        println()   // 단 구분을 위한 빈 줄
    }
}