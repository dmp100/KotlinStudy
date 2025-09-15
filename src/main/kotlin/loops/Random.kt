package loops

import kotlin.random.Random

/**
 * 날짜: 2025-09-15
 * 주제: Random - 난수 생성
 *
 * 배운 내용:
 * - kotlin.random.Random을 사용한 다양한 타입의 난수 생성
 * - nextInt(), nextLong(), nextFloat(), nextDouble() 함수들
 * - 사용자 정의 범위로 난수 범위 제한 가능
 * - 의사난수(pseudorandom)의 개념과 시드(seed) 사용
 * - 동일한 시드는 동일한 난수 시퀀스를 생성함
 * - Random.Default vs 사용자 정의 시드 생성기의 차이점
 *
 * 어려웠던 점:
 * - 의사난수와 진정한 난수의 개념적 차이
 * - 시드의 역할과 예측 가능성의 관계
 * - nextFloat()에는 범위 지정 기능이 없다는 점
 * - 포함(inclusive)과 제외(exclusive) 범위의 구분
 */
fun main() {

    // import kotlin.random.Random

            /*************** - 기본 난수 생성 타입들 - ****************/
            // 각 데이터 타입별 기본 범위의 난수 생성

            println("=== 기본 타입별 난수 생성 ===")

    // 정수형 난수 (Int.MIN_VALUE ~ Int.MAX_VALUE)
    println("정수 난수: ${Random.nextInt()}")

    // 긴 정수형 난수 (Long.MIN_VALUE ~ Long.MAX_VALUE)
    println("Long 난수: ${Random.nextLong()}")

    // 실수형 난수 (0.0 이상 1.0 미만)
    println("Float 난수: ${Random.nextFloat()}")

    // 배정밀도 실수형 난수 (0.0 이상 1.0 미만)
    println("Double 난수: ${Random.nextDouble()}")

    // 같은 함수를 다시 호출해도 다른 값 생성
    println("Double 난수 (재호출): ${Random.nextDouble()}")

    /*************** - 사용자 정의 범위 난수 - ****************/
    // 특정 범위 내에서만 난수 생성하기

    println("\n=== 사용자 정의 범위 난수 ===")

    // 0 이상 100 미만의 정수
    println("0~99 정수: ${Random.nextInt(100)}")

    // 1 이상 100 미만의 정수 (1~99)
    println("1~99 정수: ${Random.nextInt(1, 100)}")

    // 0 이상 100 미만의 Long
    println("0~99 Long: ${Random.nextLong(100)}")

    // 1 이상 100 미만의 Long
    println("1~99 Long: ${Random.nextLong(1, 100)}")

    // 0.0 이상 5.0 미만의 Double
    println("0.0~4.999... Double: ${Random.nextDouble(5.0)}")

    // 1.0 이상 5.0 미만의 Double
    println("1.0~4.999... Double: ${Random.nextDouble(1.0, 5.0)}")

    /*************** - 범위 설정 규칙과 주의사항 - ****************/
    // 포함(inclusive)과 제외(exclusive) 범위 이해하기

    println("\n=== 범위 규칙 확인 ===")

    // 여러 번 생성해서 범위 확인
    println("주사위 굴리기 (1~6):")
    repeat(10) {
        val dice = Random.nextInt(1, 7)  // 1 이상 7 미만 = 1~6
        print("$dice ")
    }
    println()

    // nextFloat는 범위 지정 불가능 (nextDouble 사용 권장)
    println("Float는 범위 지정 불가능, Double 사용:")
    repeat(5) {
        val customDouble = Random.nextDouble(10.0, 20.0)
        println("10.0~19.999... 범위: $customDouble")
    }

    /*************** - 시드를 사용한 예측 가능한 난수 - ****************/
    // 동일한 시드는 동일한 시퀀스를 생성함

    println("\n=== 시드 기반 난수 생성 ===")

    // 시드 42를 사용한 생성기
    val randomGenerator42 = Random(42)
    println("시드 42로 생성한 6개 숫자:")
    repeat(6) {
        print("${randomGenerator42.nextInt(100)} ")
    }
    println()

    // 같은 시드로 다시 생성 (동일한 결과)
    val anotherGenerator42 = Random(42)
    println("같은 시드 42로 다시 생성:")
    repeat(6) {
        print("${anotherGenerator42.nextInt(100)} ")
    }
    println()

    // 다른 시드 사용
    val randomGenerator123 = Random(123)
    println("시드 123으로 생성:")
    repeat(6) {
        print("${randomGenerator123.nextInt(100)} ")
    }
    println()

    /*************** - Default vs 사용자 정의 생성기 - ****************/
    // Random.Default는 매번 다른 시퀀스 생성

    println("\n=== Default vs 사용자 정의 생성기 ===")

    // Default 생성기 (예측 불가능)
    val defaultGenerator = Random.Default
    println("Default 생성기 (예측 불가능):")
    repeat(5) {
        print("${defaultGenerator.nextInt(100)} ")
    }
    println()

    // 시스템 시간 기반 시드 (매번 다름)
    val timeBasedGenerator = Random(System.currentTimeMillis())
    println("시간 기반 시드 생성기:")
    repeat(5) {
        print("${timeBasedGenerator.nextInt(100)} ")
    }
    println()

    /*************** - 실용적 활용 예시 - ****************/

    // 간단한 비밀번호 생성
    println("\n=== 랜덤 비밀번호 생성 ===")
    val characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
    val passwordLength = 8
    val password = buildString {
        repeat(passwordLength) {
            val randomIndex = Random.nextInt(characters.length)
            append(characters[randomIndex])
        }
    }
    println("생성된 비밀번호: $password")

    // 랜덤 색상 RGB 값 생성
    println("\n=== 랜덤 RGB 색상 ===")
    repeat(3) {
        val red = Random.nextInt(256)    // 0~255
        val green = Random.nextInt(256)
        val blue = Random.nextInt(256)
        println("RGB($red, $green, $blue)")
    }

    // 가중치가 있는 랜덤 선택 시뮬레이션
    println("\n=== 확률 시뮬레이션 (동전 던지기) ===")
    var heads = 0
    var tails = 0
    val trials = 1000

    repeat(trials) {
        if (Random.nextBoolean()) {  // 50% 확률
            heads++
        } else {
            tails++
        }
    }

    println("$trials 번 동전 던지기 결과:")
    println("앞면: $heads 번 (${heads * 100.0 / trials}%)")
    println("뒷면: $tails 번 (${tails * 100.0 / trials}%)")

    /*************** - 게임에서의 활용 - ****************/

    // 숫자 맞추기 게임
    println("\n=== 숫자 맞추기 게임 ===")
    val targetNumber = Random.nextInt(1, 11)  // 1~10
    println("1부터 10 사이의 숫자를 맞춰보세요!")

    var attempts = 0
    var gameOver = false

    while (!gameOver && attempts < 3) {
        print("시도 ${attempts + 1}: ")
        val guess = readln().toInt()
        attempts++

        when {
            guess == targetNumber -> {
                println("정답입니다! $attempts 번 만에 맞췄습니다!")
                gameOver = true
            }
            guess < targetNumber -> println("더 큰 수입니다!")
            else -> println("더 작은 수입니다!")
        }
    }

    if (!gameOver) {
        println("아쉽습니다! 정답은 $targetNumber 였습니다.")
    }

    /*************** - 테스트용 예측 가능한 데이터 - ****************/
    // 테스트 코드에서 일관된 결과를 위한 시드 사용

    println("\n=== 테스트용 예측 가능한 데이터 ===")

    fun generateTestData(seed: Long, count: Int): List<Int> {
        val generator = Random(seed)
        return List(count) { generator.nextInt(1, 101) }
    }

    // 항상 같은 테스트 데이터 생성
    val testData1 = generateTestData(999, 5)
    val testData2 = generateTestData(999, 5)

    println("첫 번째 테스트 데이터: $testData1")
    println("두 번째 테스트 데이터: $testData2")
    println("두 데이터가 같은가? ${testData1 == testData2}")

    /*************** - Boolean과 다양한 확률 - ****************/

    println("\n=== Boolean과 확률 조정 ===")

    // 기본 50% 확률
    println("동전 던지기 (50% 확률):")
    repeat(10) {
        val result = if (Random.nextBoolean()) "앞면" else "뒷면"
        print("$result ")
    }
    println()

    // 사용자 정의 확률 (30% 확률로 true)
    println("30% 확률 이벤트:")
    repeat(10) {
        val result = Random.nextDouble() < 0.3
        print("${if (result) "발생" else "미발생"} ")
    }
    println()
}
