package collections

/**
 * 날짜: 2025-09-15
 * 주제: For 루프와 MutableList
 *
 * 배운 내용:
 * - for 루프로 MutableList의 모든 요소를 하나씩 처리할 수 있음
 * - 요소 직접 접근: for (element in list)
 * - 인덱스로 접근: for (index in list.indices)
 * - 범위 지정 접근: for (index in 1..5)
 * - 역순 접근: downTo 사용
 * - step으로 건너뛰기 가능
 * - readln()으로 입력받아서 MutableList에 추가하기
 *
 * 어려웠던 점:
 * - indices와 범위의 차이점
 * - lastIndex 사용법
 * - until과 .. 의 차이
 * - downTo와 step 조합 사용법
 */
fun main() {

    /*************** - MutableList 기본 순회 - ****************/
    // 문서의 요일 예제

    println("=== MutableList 기본 순회 ===")

    val daysOfWeek = mutableListOf("Sun", "Mon", "Tues", "Wed", "Thur", "Fri", "Sat")

    println("요일 출력하기:")
    for (day in daysOfWeek) {
        println(day)
    }

    /* 출력:
     * Sun
     * Mon
     * Tues
     * Wed
     * Thur
     * Fri
     * Sat
     */

    /*************** - 인덱스로 순회하기 - ****************/
    // indices 속성 사용

    println("\n=== 인덱스와 함께 순회 ===")

    println("인덱스와 요일:")
    for (index in daysOfWeek.indices) {
        println("$index: ${daysOfWeek[index]}")
    }

    /* 출력:
     * 0: Sun
     * 1: Mon
     * 2: Tues
     * 3: Wed
     * 4: Thur
     * 5: Fri
     * 6: Sat
     */

    /*************** - 범위로 순회하기 - ****************/
    // 특정 구간만 처리하기

    println("\n=== 범위 지정 순회 ===")

    println("평일만 출력 (인덱스 1~5):")
    for (index in 1..5) {
        println("$index: ${daysOfWeek[index]}")
    }

    /* 출력:
     * 1: Mon
     * 2: Tues
     * 3: Wed
     * 4: Thur
     * 5: Fri
     */

    // lastIndex 사용하기
    println("\nlastIndex 사용 (토요일 제외):")
    for (index in 1 until daysOfWeek.lastIndex) {
        println("$index: ${daysOfWeek[index]}")
    }

    /* 출력:
     * 1: Mon
     * 2: Tues
     * 3: Wed
     * 4: Thur
     * 5: Fri
     */

    /*************** - 역순과 step 사용 - ****************/
    // downTo와 step으로 다양한 순회

    println("\n=== 역순과 step 사용 ===")

    println("역순으로 2씩 건너뛰며:")
    for (index in daysOfWeek.lastIndex downTo 0 step 2) {
        println("$index: ${daysOfWeek[index]}")
    }

    /* 출력:
     * 6: Sat
     * 4: Thur
     * 2: Tues
     * 0: Sun
     */

    /*************** - 입력받아서 MutableList 만들기 - ****************/
    // 문서의 숫자 입력 예제 시뮬레이션

    println("\n=== 입력받아서 리스트 만들기 ===")

    // 실제 입력 대신 시뮬레이션
    fun simulateNumberInput() {
        val inputNumbers = listOf("5", "1", "2", "3", "4", "5") // 시뮬레이션 데이터
        var inputIndex = 0

        fun mockReadln(): String = inputNumbers[inputIndex++]

        val size = mockReadln().toInt()
        val mutList: MutableList<Int> = mutableListOf()

        println("입력받을 숫자 개수: $size")

        for (i in 0 until size) {
            val number = mockReadln().toInt()
            mutList.add(number)
            println("${i + 1}번째 숫자 추가: $number")
        }

        println("완성된 리스트: $mutList")

        println("역순으로 출력:")
        for (i in mutList.lastIndex downTo 0) {
            print("${mutList[i]} ")
        }
        println() // 줄바꿈
    }

    simulateNumberInput()

    /*************** - 다양한 데이터 타입으로 연습 - ****************/

    println("\n=== 다양한 데이터 타입 순회 ===")

    // 정수 리스트
    val numbers = mutableListOf(10, 20, 30, 40, 50)
    println("숫자 리스트:")
    for (num in numbers) {
        println("숫자: $num")
    }

    // 문자 리스트
    val letters = mutableListOf('A', 'B', 'C', 'D')
    println("\n문자 리스트 (인덱스와 함께):")
    for (i in letters.indices) {
        println("${i}번째: ${letters[i]}")
    }

    // 불린 리스트
    val flags = mutableListOf(true, false, true, false)
    println("\n불린 리스트 (범위 지정: 1~2):")
    for (i in 1..2) {
        println("인덱스 $i: ${flags[i]}")
    }

    /*************** - 실용적인 예제들 - ****************/

    println("\n=== 실용적인 활용 예제 ===")

    // 쇼핑 리스트 관리
    val shoppingList = mutableListOf("우유", "빵", "계란", "치즈", "사과")

    println("쇼핑 리스트:")
    for (i in shoppingList.indices) {
        println("${i + 1}. ${shoppingList[i]}")
    }

    // 처음 3개 아이템만 확인
    println("\n급한 물건 (처음 3개):")
    for (i in 0..2) {
        println("- ${shoppingList[i]}")
    }

    // 성적 관리
    val scores = mutableListOf(85, 92, 78, 96, 88)

    println("\n성적 확인:")
    for (i in scores.indices) {
        val grade = when {
            scores[i] >= 90 -> "A"
            scores[i] >= 80 -> "B"
            scores[i] >= 70 -> "C"
            else -> "D"
        }
        println("${i + 1}회차: ${scores[i]}점 ($grade)")
    }

    // 최근 3번 성적만 확인
    println("\n최근 3번 성적:")
    for (i in (scores.size - 3) until scores.size) {
        println("${i + 1}회차: ${scores[i]}점")
    }

    /*************** - 순회하면서 MutableList 수정하기 - ****************/

    println("\n=== 순회하면서 리스트 수정 ===")

    val temperatures = mutableListOf(25, 30, 35, 40, 45)
    println("원본 온도 (섭씨): $temperatures")

    // 모든 온도를 화씨로 변경
    for (i in temperatures.indices) {
        temperatures[i] = temperatures[i] * 9 / 5 + 32  // 섭씨를 화씨로
    }
    println("변환된 온도 (화씨): $temperatures")

    // 홀수 인덱스의 값만 2배로
    val testNumbers = mutableListOf(1, 2, 3, 4, 5)
    println("\n원본: $testNumbers")

    for (i in testNumbers.indices) {
        if (i % 2 == 1) {  // 홀수 인덱스 (1, 3, 5...)
            testNumbers[i] = testNumbers[i] * 2
        }
    }
    println("홀수 인덱스 2배: $testNumbers")

    /*************** - 다양한 순회 패턴 비교 - ****************/

    println("\n=== 순회 패턴 비교 ===")

    val fruits = mutableListOf("사과", "바나나", "오렌지", "포도", "딸기")

    // 1. 요소 직접 접근 (인덱스 필요 없을 때)
    println("1. 요소 직접 접근:")
    for (fruit in fruits) {
        println("  $fruit 좋아요!")
    }

    // 2. 인덱스 접근 (번호가 필요할 때)
    println("\n2. 인덱스 접근:")
    for (i in fruits.indices) {
        println("  ${i + 1}번째: ${fruits[i]}")
    }

    // 3. 범위 지정 (일부분만 필요할 때)
    println("\n3. 범위 지정 (2~4번째):")
    for (i in 1..3) {
        println("  ${fruits[i]}")
    }

    // 4. 역순 (거꾸로 처리할 때)
    println("\n4. 역순:")
    for (i in fruits.lastIndex downTo 0) {
        println("  ${fruits[i]}")
    }

    /*************** - 주의사항과 팁 - ****************/

    println("\n=== 주의사항과 팁 ===")

    val testList = mutableListOf("A", "B", "C", "D", "E")

    println("리스트: $testList")
    println("크기: ${testList.size}")
    println("인덱스 범위: 0 ~ ${testList.lastIndex}")

    // until vs .. 차이
    println("\n범위 연산자 차이:")
    println("0..2 범위:")
    for (i in 0..2) {
        print("$i ")  // 0 1 2
    }
    println()

    println("0 until 3 범위:")
    for (i in 0 until 3) {
        print("$i ")  // 0 1 2 (같은 결과)
    }
    println()

    // step 사용법
    println("\nstep 사용 예제:")
    println("0부터 4까지 2씩 증가:")
    for (i in 0..4 step 2) {
        print("$i ")  // 0 2 4
    }
    println()

    /*************** - 정리 - ****************/

    println("\n=== 정리 ===")

    println("MutableList 순회 방법들:")
    println("1. for (item in list) - 요소에 직접 접근")
    println("2. for (i in list.indices) - 모든 인덱스 순회")
    println("3. for (i in 1..5) - 특정 범위 순회")
    println("4. for (i in list.lastIndex downTo 0) - 역순 순회")
    println("5. for (i in 0..10 step 2) - step으로 건너뛰기")

    println("\n언제 어떤 방법을 쓸까:")
    println("• 요소만 필요 → for (item in list)")
    println("• 번호나 위치 필요 → for (i in list.indices)")
    println("• 일부분만 처리 → for (i in start..end)")
    println("• 거꾸로 처리 → for (i in list.lastIndex downTo 0)")
    println("• 값 변경 필요 → 인덱스 사용 방법")

    println("\n주의할 점:")
    println("• 인덱스는 0부터 시작!")
    println("• lastIndex = size - 1")
    println("• until은 마지막 값 제외, ..은 포함")
    println("• 빈 리스트는 순회되지 않음")
}