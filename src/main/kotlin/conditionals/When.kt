package conditionals

/**
 * 날짜: 2025-09-14
 * 주제: when 표현식
 *
 * 배운 내용:
 * - when은 변수 값에 따라 다른 동작을 수행하는 강력한 표현식
 * - if-else-if 체인보다 가독성이 좋고 복잡한 조건 처리에 적합
 * - 여러 값을 쉼표로 구분하여 하나의 분기에서 처리 가능
 * - 표현식으로 사용할 때는 모든 분기가 값을 반환하고 else 분기 필수
 * - 단순 값 매칭뿐만 아니라 범위, 조건식, 계산 결과 비교 가능
 * - 인수 없는 when으로 복잡한 불린 조건들을 깔끔하게 처리
 *
 * 어려웠던 점:
 * - 문장형과 표현식형 when의 차이점과 사용 시점
 * - 복잡한 블록에서 마지막 표현식이 반환값이 되는 개념
 * - 인수 없는 when에서 조건들의 우선순위 이해
 */
fun main() {

    /*************** - 기본 사용법 (문장형) - ****************/
    // 변수의 값에 따라 서로 다른 동작 수행
    // else 분기는 선택사항

    val (var1, op, var2) = readln().split(" ")
    val a = var1.toInt()
    val b = var2.toInt()

    when (op) {
        "+" -> println(a + b)           // 덧셈
        "-" -> println(a - b)           // 뺄셈
        "*" -> println(a * b)           // 곱셈
        else -> println("Unknown operator")  // 기타
    }

    /*************** - 여러 값을 하나의 분기에서 처리 - ****************/
    // 쉼표로 구분하여 여러 값을 하나의 분기에서 처리
    // 마지막 쉼표(trailing comma)도 허용됨

    when (op) {
        "+", "plus" -> println(a + b)
        "-", "minus", -> println(a - b)    // 마지막 쉼표 허용
        "*", "times" -> println(a * b)
        else -> println("Unknown operator")
    }

    /*************** - 복잡한 블록 사용 - ****************/
    // 여러 문장이 포함된 복잡한 블록도 분기로 사용 가능

    when (op) {
        "+", "plus" -> {
            val sum = a + b
            println("계산 중...")
            println("결과: $sum")
        }
        "-", "minus" -> {
            val diff = a - b
            println("뺄셈 수행")
            println("결과: $diff")
        }
        else -> println("Unknown operator")
    }

    /*************** - 표현식으로서의 when - ****************/
    // when을 표현식으로 사용하여 결과값 반환
    // 표현식으로 사용할 때는 모든 분기가 값을 반환해야 하고 else 분기 필수

    val result = when (op) {
        "+" -> a + b        // 값 반환
        "-" -> a - b        // 값 반환
        "*" -> a * b        // 값 반환
        else -> 0           // 기본값 반환 (필수)
    }
    println("계산 결과: $result")

    // 변수에 저장하지 않고 바로 사용
    println(when(op) {
        "+" -> a + b
        "-" -> a - b
        "*" -> a * b
        else -> "Unknown result"
    })

    // 복잡한 블록에서는 마지막 표현식이 반환값
    val complexResult = when (op) {
        "+" -> {
            println("덧셈 수행 중...")
            val sum = a + b
            sum  // 이 값이 반환됨
        }
        else -> 0
    }

    /*************** - 조건과 범위 사용 - ****************/
    // 단순한 값 매칭뿐만 아니라 복잡한 조건 처리 가능

    val c = 10

    // 계산 결과 비교
    println(when (c) {
        a + b -> "$c equals $a plus $b"
        a - b -> "$c equals $a minus $b"
        a * b -> "$c equals $a times $b"
        else -> "We do not know how to calculate $c"
    })

    // 범위 사용 - in 키워드로 범위 확인
    val n = 15
    when (n) {
        0 -> println("n is zero")
        in 1..10 -> println("n is between 1 and 10 (inclusive)")
        in 25..30 -> println("n is between 25 and 30 (inclusive)")
        else -> println("n is outside a range")
    }

    // 여러 범위를 결합
    when (n) {
        in 1..10, in 20..30 -> println("n belongs to allowed ranges")
        else -> println("n is outside allowed ranges")
    }

    /*************** - 인수 없는 when - ****************/
    // when을 인수 없이 사용하면 각 분기가 불린 표현식
    // 첫 번째로 true가 되는 조건이 실행됨

    when {
        n == 0 -> println("n is zero")
        n in 100..200 -> println("n is between 100 and 200")
        n > 300 -> println("n is greater than 300")
        n < 0 -> println("n is negative")
        n % 2 == 0 -> println("n is even")
        else -> println("n is odd and positive")
    }

    /*************** - 실용적 예시 - ****************/

    // 학점 계산 시스템
    val score = 85
    val grade = when (score) {
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        in 60..69 -> "D"
        else -> "F"
    }
    println("성적: $grade")

    // 요일 분류
    val dayOfWeek = 3
    val dayType = when (dayOfWeek) {
        1, 7 -> "주말"           // 일요일, 토요일
        in 2..6 -> "평일"        // 월~금
        else -> "잘못된 요일"
    }
    println("오늘은 $dayType 입니다")

    // 복잡한 조건 처리
    val temperature = 22
    val weather = when {
        temperature < 0 -> "매우 추움"
        temperature in 0..15 -> "추움"
        temperature in 16..25 -> "적당함"
        temperature in 26..30 -> "따뜻함"
        temperature > 30 -> "더움"
        else -> "알 수 없음"
    }
    println("날씨: $weather")
}
