package exceptions

/**
 * 날짜: 2025-09-15
 * 주제: 예외 처리와 직접 예외 발생시키기
 *
 * 배운 내용:
 * - 조건문을 사용해 예외를 미리 방지할 수 있음
 * - throw 키워드로 직접 예외를 발생시킬 수 있음
 * - 예외를 던질 때는 Exception 객체를 생성해서 사용
 * - 예외를 던지는 함수의 반환 타입은 Nothing
 * - 예외 객체는 변수에 저장할 수 있고, throw할 때만 실제 예외 발생
 * - 예외 방지 vs 예외 발생의 적절한 선택이 중요함
 *
 * 어려웠던 점:
 * - 언제 예외를 방지하고 언제 직접 던져야 하는지 판단
 * - Nothing 타입의 개념과 의미
 * - 예외 객체 생성과 throw의 차이점
 * - 에지 케이스 식별과 적절한 처리 방법
 */
fun main() {

    /*************** - 문제가 있는 함수 예제 - ****************/
    // 문서의 예제: 돈과 상품 가격으로 지출 금액 계산

    println("=== 문제가 있는 함수 ===")

    // 원본 함수 (예외 발생 가능)
    fun calculateSpentMoney(total: Int, itemPrice: Int): Int {
        val amountToBuy = total / itemPrice  // itemPrice가 0이면 예외 발생
        return amountToBuy * itemPrice
    }

    // 정상 케이스 테스트
    println("정상 케이스: 37달러로 2달러 햄버거 구매")
    val normalResult = calculateSpentMoney(37, 2)
    println("지출 금액: ${normalResult}달러")

    // 문제 케이스: 무료 상품 (0으로 나누기)
    println("\n문제 케이스: 37달러로 0달러(무료) 사탕 구매")
    try {
        val freeResult = calculateSpentMoney(37, 0)
        println("지출 금액: ${freeResult}달러")
    } catch (e: ArithmeticException) {
        println("ArithmeticException 발생: ${e.message}")
        println("원인: 무료 상품(가격 0)으로 인한 0으로 나누기")
    }

    /*************** - 조건문으로 예외 방지 - ****************/
    // 특별한 경우를 미리 체크해서 예외 방지

    println("\n=== 조건문으로 예외 방지 ===")

    // 개선된 함수 (무료 상품 케이스 처리)
    fun safeCalculateSpentMoney(total: Int, itemPrice: Int): Int {
        if (itemPrice == 0) {
            return 0  // 무료 상품이면 지출 금액은 0
        }
        val amountToBuy = total / itemPrice
        return amountToBuy * itemPrice
    }

    // 테스트
    println("개선된 함수로 무료 상품 케이스 처리:")
    val safeResult = safeCalculateSpentMoney(37, 0)
    println("무료 사탕 지출 금액: ${safeResult}달러")

    println("정상 케이스도 확인:")
    val safeNormalResult = safeCalculateSpentMoney(37, 2)
    println("햄버거 지출 금액: ${safeNormalResult}달러")

    /*************** - 예외를 직접 던지기 (throw) - ****************/
    // 부적절한 입력에 대해 직접 예외 발생

    println("\n=== throw 키워드로 예외 발생 ===")

    // 완전히 개선된 함수 (모든 에지 케이스 처리)
    fun robustCalculateSpentMoney(total: Int, itemPrice: Int): Int {
        // 음수 총액 체크
        if (total < 0) {
            throw Exception("Total can't be negative")
        }

        // 음수 가격 체크
        if (itemPrice < 0) {
            throw Exception("Item price can't be negative")
        }

        // 무료 상품 처리
        if (itemPrice == 0) {
            return 0
        }

        val amountToBuy = total / itemPrice
        return amountToBuy * itemPrice
    }

    // 정상 케이스
    println("정상 케이스 테스트:")
    val robustResult = robustCalculateSpentMoney(37, 2)
    println("결과: ${robustResult}달러")

    // 음수 총액 테스트
    println("\n음수 총액 테스트:")
    try {
        val negativeTotal = robustCalculateSpentMoney(-10, 4)
        println("결과: ${negativeTotal}달러")
    } catch (e: Exception) {
        println("Exception 발생: ${e.message}")
    }

    // 음수 가격 테스트
    println("\n음수 가격 테스트:")
    try {
        val negativePrice = robustCalculateSpentMoney(50, -5)
        println("결과: ${negativePrice}달러")
    } catch (e: Exception) {
        println("Exception 발생: ${e.message}")
    }

    // 무료 상품 테스트
    println("\n무료 상품 테스트:")
    val freeItemResult = robustCalculateSpentMoney(50, 0)
    println("결과: ${freeItemResult}달러 (예외 발생하지 않음)")

    /*************** - 예외 객체와 변수 - ****************/
    // 예외 객체를 변수에 저장하고 나중에 throw

    println("\n=== 예외 객체와 변수 ===")

    // 예외 객체를 변수에 저장
    val countError = Exception("Number is too big")
    println("예외 객체 생성됨: $countError")
    println("하지만 아직 프로그램이 중단되지 않음")

    // 나중에 throw
    fun demonstrateStoredException(shouldThrow: Boolean) {
        if (shouldThrow) {
            throw countError  // 여기서 실제로 예외 발생
        } else {
            println("예외를 던지지 않고 정상 실행")
        }
    }

    demonstrateStoredException(false)  // 정상 실행

    try {
        demonstrateStoredException(true)   // 예외 발생
    } catch (e: Exception) {
        println("저장된 예외 발생: ${e.message}")
    }

    /*************** - Nothing 타입 - ****************/
    // 예외를 던지는 함수의 반환 타입은 Nothing

    println("\n=== Nothing 타입 ===")

    // Nothing을 반환하는 함수
    fun makeAnException(): Nothing {
        throw Exception("I'm an exception!")
    }

    // Nothing 타입 설명
    println("Nothing 타입의 특징:")
    println("- 실제로 값을 반환하지 않음")
    println("- 함수가 정상적으로 끝나지 않음을 나타냄")
    println("- 항상 예외를 던지거나 무한 루프인 함수에 사용")

    try {
        makeAnException()  // 항상 예외 발생
    } catch (e: Exception) {
        println("Nothing 타입 함수에서 예외 발생: ${e.message}")
    }

    /*************** - 에지 케이스 식별과 처리 전략 - ****************/
    // 언제 예외를 방지하고 언제 던져야 하는지

    println("\n=== 에지 케이스 처리 전략 ===")

    fun analyzeStrategy(value: Int, strategy: String): String {
        return when (strategy) {
            "prevent" -> {
                // 예외 방지 전략: 합리적인 기본값 반환
                if (value < 0) {
                    "음수를 0으로 처리: 0"
                } else {
                    "정상값: $value"
                }
            }
            "throw" -> {
                // 예외 발생 전략: 부적절한 입력 거부
                if (value < 0) {
                    throw Exception("음수는 허용되지 않음: $value")
                } else {
                    "정상값: $value"
                }
            }
            else -> "알 수 없는 전략"
        }
    }

    println("예외 방지 전략:")
    println("값 10: ${analyzeStrategy(10, "prevent")}")
    println("값 -5: ${analyzeStrategy(-5, "prevent")}")

    println("\n예외 발생 전략:")
    println("값 10: ${analyzeStrategy(10, "throw")}")
    try {
        println("값 -5: ${analyzeStrategy(-5, "throw")}")
    } catch (e: Exception) {
        println("예외 발생: ${e.message}")
    }

    /*************** - 실제 활용 예제 - ****************/
    // 나이 검증 함수로 두 전략 비교

    println("\n=== 실제 활용: 나이 검증 ===")

    // 방지 전략: 부적절한 나이를 조정
    fun validateAgePrevent(age: Int): Int {
        return when {
            age < 0 -> 0        // 음수를 0으로 조정
            age > 150 -> 150    // 너무 큰 값을 150으로 조정
            else -> age
        }
    }

    // 예외 발생 전략: 부적절한 나이 거부
    fun validateAgeThrow(age: Int): Int {
        if (age < 0) {
            throw Exception("나이는 음수일 수 없습니다: $age")
        }
        if (age > 150) {
            throw Exception("나이가 비현실적입니다: $age")
        }
        return age
    }

    val testAges = listOf(25, -5, 200, 0, 150)

    println("방지 전략 결과:")
    testAges.forEach { age ->
        val result = validateAgePrevent(age)
        println("입력 $age -> 결과 $result")
    }

    println("\n예외 발생 전략 결과:")
    testAges.forEach { age ->
        try {
            val result = validateAgeThrow(age)
            println("입력 $age -> 결과 $result")
        } catch (e: Exception) {
            println("입력 $age -> 예외: ${e.message}")
        }
    }

    /*************** - 정리 - ****************/

    println("\n=== 정리 ===")
    println("1. 조건문으로 예외를 미리 방지할 수 있음")
    println("2. throw 키워드로 직접 예외를 발생시킬 수 있음")
    println("3. 예외 객체는 Exception(\"메시지\") 형태로 생성")
    println("4. 예외를 던지는 함수의 반환 타입은 Nothing")
    println("5. 전략 선택:")
    println("   - 합리적인 기본값이 있으면 -> 예외 방지")
    println("   - 부적절한 입력을 거부해야 하면 -> 예외 발생")
}
