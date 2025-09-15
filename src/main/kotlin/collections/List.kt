package collections

/**
 * 날짜: 2025-09-15
 * 주제: List - 순서가 있는 컬렉션
 *
 * 배운 내용:
 * - List는 변경할 수 없는(불변) 컬렉션
 * - 같은 값을 여러 번 저장할 수 있음 (중복 허용)
 * - 순서대로 저장되며 인덱스(0, 1, 2...)로 접근
 * - listOf()로 만들고, 타입은 자동으로 추론됨
 * - size, isEmpty(), contains() 같은 기본 메서드들
 * - for 반복문으로 하나씩 처리 가능
 */
fun main() {

    /*************** - List가 뭔가요? - ****************/
    // 문서 예제: 작년에 운전한 차들을 기록해보자

    println("=== List 기본 사용법 ===")

    // 차량 목록 만들기
    val cars = listOf<String>("BMW", "Honda", "Mercedes")
    println(cars) // [BMW, Honda, Mercedes]

    // 타입을 안 써도 됨 (자동으로 알아냄)
    val cars2 = listOf("BMW", "Honda", "Mercedes")
    println(cars2) // 똑같은 결과

    /*************** - 왜 List를 써야 할까? - ****************/
    // MutableList와 비교해보자

    println("\n=== 안전한 List vs 위험한 MutableList ===")

    // MutableList: 언제든 바꿀 수 있음 (위험!)
    val mutableCars = mutableListOf<String>("BMW", "Honda", "Mercedes")
    println("처음: $mutableCars")

    mutableCars[0] = "Renault"  // 첫 번째를 바꿔버림!
    println("바뀜: $mutableCars") // [Renault, Honda, Mercedes]

    // List: 바꿀 수 없음 (안전!)
    val safeCars = listOf("BMW", "Honda", "Mercedes")
    // safeCars[0] = "Renault"  // 오류! 바꿀 수 없음
    println("안전한 리스트: $safeCars") // 항상 같은 내용

    /*************** - List 만드는 방법들 - ****************/

    println("\n=== List 만드는 여러 가지 방법 ===")

    // 1. 기본 방법
    val fruits = listOf("사과", "바나나", "오렌지")
    println("과일: $fruits")

    // 2. 빈 리스트 만들기
    val emptyList = emptyList<String>()
    println("빈 리스트: $emptyList") // []

    // 3. 단계별로 만들기 (buildList)
    val names = listOf("Emma", "Kim")
    val bigList = buildList {
        add("Marta")        // 하나 추가
        addAll(names)       // 여러 개 추가
        add("Kira")         // 또 하나 추가
    }
    println("단계별로 만든 리스트: $bigList") // [Marta, Emma, Kim, Kira]

    /*************** - List의 기본 기능들 - ****************/
    // 문서의 파티 예제로 배워보자

    println("\n=== 파티 게스트 관리하기 ===")

    val partyList = listOf("Fred", "Emma", "Isabella", "James", "Olivia")
    println("파티 게스트: $partyList")

    // 크기 확인하기
    println("총 게스트 수: ${partyList.size}")

    // 비어있는지 확인하기
    println("파티가 비어있나요? ${partyList.isEmpty()}")

    // 첫 번째 사람 확인하기 (인덱스는 0부터!)
    println("첫 번째로 온 사람: ${partyList[0]}")

    // 파티 시작 판단하기
    if (!partyList.isEmpty()) {
        val size = partyList.size
        val whoIsFirst = partyList[0]
        println("파티 시작! 총 $size 명이 왔고, $whoIsFirst 이(가) 제일 먼저 왔어요!")
    }

    /*************** - 사람 찾기 기능들 - ****************/

    println("\n=== 게스트 찾기 ===")

    // Emma가 몇 번째로 왔는지 확인
    val emmaPosition = partyList.indexOf("Emma")
    println("Emma는 ${emmaPosition + 1}번째로 왔어요") // +1을 하는 이유: 인덱스는 0부터라서

    // 없는 사람을 찾으면 -1이 나옴
    println("Alice의 위치: ${partyList.indexOf("Alice")}") // -1

    // Isabella가 왔는지 확인
    println("Isabella가 왔나요? ${partyList.contains("Isabella")}") // true

    // 없는 사람 확인
    println("Charlie가 왔나요? ${partyList.contains("Charlie")}") // false

    /*************** - 모든 사람에게 인사하기 - ****************/
    // for 반복문 사용하기

    println("\n=== 모든 게스트에게 인사 ===")

    val participants = listOf("Fred", "Emma", "Isabella")

    // 기본 for 반복문
    for (participant in participants) {
        println("안녕하세요 $participant 님!")
    }

    // 번호와 함께 인사하기
    println("\n번호와 함께:")
    for (i in participants.indices) {
        println("${i + 1}번: ${participants[i]} 님 안녕하세요!")
    }

    /*************** - 실생활 예제들 - ****************/

    println("\n=== 실생활에서 List 사용하기 ===")

    // 1. 카페 메뉴 (바뀌지 않는 정보)
    val menu = listOf("아메리카노", "라떼", "카푸치노")
    println("오늘의 메뉴:")
    for (i in menu.indices) {
        println("  ${i + 1}. ${menu[i]}")
    }

    // 메뉴에 있는지 확인
    val order = "라떼"
    if (order in menu) {  // contains() 대신 in을 쓸 수 있음
        println("$order 주문 가능합니다!")
    } else {
        println("죄송합니다. $order 는 없어요.")
    }

    // 2. 시간표 (순서가 중요!)
    val schedule = listOf("국어", "수학", "과학", "체육")
    println("\n오늘 시간표:")
    for (period in schedule.indices) {
        println("${period + 1}교시: ${schedule[period]}")
    }

    // 3. 성적 기록 (같은 점수 여러 번 가능)
    val scores = listOf(85, 92, 78, 85, 90)
    println("\n시험 점수: $scores")
    println("총 시험 횟수: ${scores.size}")
    println("첫 번째 시험: ${scores[0]}점")
    println("85점을 몇 번 받았나: ${scores.count { it == 85 }}번")

    /*************** - 안전하게 접근하기 - ****************/

    println("\n=== 안전하게 List 사용하기 ===")

    val shortList = listOf("A", "B", "C")

    // 위험한 방법: 없는 인덱스에 접근하면 오류!
    // println(shortList[10])  // 오류 발생!

    // 안전한 방법 1: getOrNull 사용
    println("인덱스 1: ${shortList.getOrNull(1)}")    // B
    println("인덱스 10: ${shortList.getOrNull(10)}")  // null (오류 없음)

    // 안전한 방법 2: 범위 확인
    val index = 5
    if (index < shortList.size) {
        println("값: ${shortList[index]}")
    } else {
        println("인덱스 $index 는 너무 큽니다 (최대: ${shortList.size - 1})")
    }

    /*************** - 헷갈리기 쉬운 부분들 - ****************/

    println("\n=== 주의할 점들 ===")

    val numbers = listOf(10, 20, 30)

    println("리스트: $numbers")
    println("크기: ${numbers.size}")
    println("첫 번째 인덱스: 0")
    println("마지막 인덱스: ${numbers.size - 1}")

    // 인덱스 vs 순서 헷갈리지 말기
    println("\n인덱스와 순서:")
    println("첫 번째 값 (인덱스 0): ${numbers[0]}")
    println("두 번째 값 (인덱스 1): ${numbers[1]}")
    println("세 번째 값 (인덱스 2): ${numbers[2]}")

    // 빈 리스트 주의사항
    val empty = listOf<String>()
    println("\n빈 리스트:")
    println("크기: ${empty.size}")
    println("비어있나: ${empty.isEmpty()}")
    // println(empty[0])  // 오류! 빈 리스트는 접근할 인덱스가 없음

    /*************** - 정리하기 - ****************/

    println("\n=== 정리 ===")

    println("List는 이럴 때 사용하세요:")
    println("✓ 순서가 중요한 데이터 (시간표, 단계별 과정)")
    println("✓ 같은 값이 여러 번 나올 수 있는 데이터 (성적, 점수)")
    println("✓ 한번 만들면 바뀌지 않는 데이터 (메뉴, 상수)")

    println("\n기본 사용법:")
    println("• 만들기: listOf(\"값1\", \"값2\", \"값3\")")
    println("• 크기: list.size")
    println("• 접근: list[0], list[1], ...")
    println("• 찾기: list.indexOf(\"값\"), list.contains(\"값\")")
    println("• 순회: for (item in list) { ... }")

    println("\n기억할 점:")
    println("• 인덱스는 0부터 시작!")
    println("• 없는 인덱스 접근하면 오류!")
    println("• List는 만든 후 내용 변경 불가!")
}