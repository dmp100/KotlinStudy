package collections

/**
 * 날짜: 2025-09-15
 * 주제: MutableList - 변경 가능한 리스트
 *
 * 배운 내용:
 * - MutableList는 List와 달리 요소를 추가/제거/변경할 수 있음
 * - List의 모든 기능 + 변경 기능 추가 (add, remove, clear 등)
 * - 순서 유지하고 중복 허용 (List와 동일)
 * - toMutableList()와 toList()로 서로 변환 가능
 * - add(), set(), addAll(), removeAt(), remove(), clear() 메서드
 * - for 루프로 순회 가능
 *
 * 어려웠던 점:
 * - List vs MutableList 언제 사용할지 판단
 * - 효율성 측면에서 재할당 vs add() 차이
 * - 변경 가능성이 주는 위험성과 장점의 균형
 */
fun main() {

    /*************** - List vs MutableList 비교 - ****************/
    // 문서의 여행지 예제

    println("=== List의 한계점 ===")

    // 불변 List의 문제점
    val places = listOf<String>("Paris", "Moscow", "Tokyo")
    println("원래 여행지: $places")

    // 새 장소 추가하려면? 재할당 필요 (비효율적)
    var placesVar = listOf<String>("Paris", "Moscow", "Tokyo")
    placesVar += "Saint-Petersburg" // 느리고 비효율적
    println("재할당으로 추가: $placesVar")

    println("\n=== MutableList의 해결책 ===")

    // MutableList로 해결
    val mutablePlaces = mutableListOf<String>("Paris", "Moscow", "Tokyo")
    mutablePlaces.add("Saint-Petersburg")
    println("MutableList로 추가: $mutablePlaces")

    /*************** - 주요 차이점 정리 - ****************/

    println("\n=== List vs MutableList 차이점 ===")

    println("List (불변):")
    println("  - 읽기만 가능")
    println("  - 안전하지만 융통성 없음")
    println("  - 요소 추가/제거 불가")

    println("\nMutableList (가변):")
    println("  - 읽기 + 쓰기 가능")
    println("  - 융통성 있지만 주의 필요")
    println("  - add, remove, clear 등 사용 가능")

    /*************** - MutableList 초기화 - ****************/

    println("\n=== MutableList 만들기 ===")

    // 타입 추론으로 생성
    val cars = mutableListOf("Ford", "Toyota", "Audi", "Mazda", "Tesla")
    println("자동차: $cars")

    // 빈 MutableList (타입 명시 필요)
    val emptyCars = mutableListOf<String>()
    println("빈 리스트: $emptyCars")

    // List를 MutableList로 변환
    val carsList = listOf("Ford", "Toyota")
    val carsFromList = carsList.toMutableList()
    carsFromList.add("Tesla")
    println("변환된 리스트: $carsFromList")

    // MutableList를 List로 변환
    val backToList = carsFromList.toList()
    println("다시 List로: $backToList")

    /*************** - 요소 추가와 변경 - ****************/
    // 문서의 장보기 예제

    println("\n=== 요소 추가와 변경 ===")

    val products = listOf("Milk", "Cheese", "Coke")
    println("원래 장보기 목록: $products")

    // MutableList로 변환해서 수정
    val finalList = products.toMutableList()

    // 요소 추가
    finalList.add("Chips")
    println("칩 추가: $finalList")

    // 요소 변경 (두 가지 방법)
    finalList[0] = "Water"  // 간단한 방법
    // finalList.set(0, "Water")  // 정식 메서드
    println("우유를 물로 변경: $finalList")

    // 여러 요소 한번에 추가 (addAll)
    val products2 = mutableListOf("Milk", "Cheese", "Coke")
    val dadsProducts = listOf("Banana", "Watermelon", "Apple")

    products2.addAll(dadsProducts)
    println("\n아빠 목록 추가: $products2")

    /*************** - 요소 제거 - ****************/

    println("\n=== 요소 제거하기 ===")

    val groceries = mutableListOf("Milk", "Cheese", "Coke")
    println("원래 목록: $groceries")

    // 인덱스로 제거
    groceries.removeAt(0)  // 첫 번째 제거
    println("첫 번째 제거: $groceries")

    // 값으로 제거
    groceries.remove("Coke")  // "Coke" 제거
    println("콜라 제거: $groceries")

    // 모든 요소 제거
    groceries.clear()
    println("모두 제거: $groceries")

    /*************** - for 루프로 순회 - ****************/

    println("\n=== MutableList 순회하기 ===")

    val shoppingList = mutableListOf("Cheese", "Milk", "Coke")

    println("장보기 목록:")
    for (product in shoppingList) {
        println("- $product")
    }

    /*************** - 실용적 활용 예제 - ****************/

    println("\n=== 실용적 활용 예제 ===")

    // 할 일 목록 관리
    val todoList = mutableListOf<String>()

    println("할 일 추가:")
    todoList.add("숙제하기")
    todoList.add("운동하기")
    todoList.add("책읽기")

    for (i in todoList.indices) {
        println("${i + 1}. ${todoList[i]}")
    }

    // 할 일 완료 처리
    println("\n숙제 완료!")
    todoList.removeAt(0)  // 첫 번째 할 일 제거

    println("남은 할 일:")
    for (i in todoList.indices) {
        println("${i + 1}. ${todoList[i]}")
    }

    // 친구 목록 관리
    val friends = mutableListOf("철수", "영희")
    println("\n친구 목록: $friends")

    // 새 친구 추가
    friends.add("민수")
    friends.add("수진")
    println("친구 추가 후: $friends")

    // 친구 이름 수정
    friends[1] = "영희님"  // 더 정중하게
    println("이름 수정 후: $friends")

    // 성적 관리 시스템
    val scores = mutableListOf<Int>()

    // 시험 점수 추가
    scores.addAll(listOf(85, 92, 78))
    println("\n성적 기록: $scores")

    // 추가 시험 점수
    scores.add(96)
    scores.add(88)
    println("추가 시험 후: $scores")

    // 잘못 입력된 점수 수정
    scores[2] = 80  // 78을 80으로 수정
    println("점수 수정 후: $scores")

    // 평균 계산
    val average = scores.average()
    println("평균 점수: ${"%.1f".format(average)}")

    /*************** - 변경하면서 순회하기 - ****************/

    println("\n=== 순회하면서 수정하기 ===")

    val numbers = mutableListOf(1, 2, 3, 4, 5)
    println("원본: $numbers")

    // 모든 숫자를 2배로
    for (i in numbers.indices) {
        numbers[i] = numbers[i] * 2
    }
    println("2배 후: $numbers")

    // 문자열 리스트 대문자 변환
    val words = mutableListOf("hello", "world", "kotlin")
    println("\n원본 단어: $words")

    for (i in words.indices) {
        words[i] = words[i].uppercase()
    }
    println("대문자 변환: $words")

    /*************** - MutableList 안전하게 사용하기 - ****************/

    println("\n=== 안전한 사용법 ===")

    val safeList = mutableListOf("A", "B", "C")

    // 안전한 제거 (인덱스 확인)
    fun safeRemoveAt(list: MutableList<String>, index: Int): Boolean {
        return if (index in 0 until list.size) {
            list.removeAt(index)
            println("인덱스 $index 제거 성공")
            true
        } else {
            println("인덱스 $index 는 범위를 벗어남 (0~${list.size - 1})")
            false
        }
    }

    println("리스트: $safeList")
    safeRemoveAt(safeList, 1)    // 성공
    safeRemoveAt(safeList, 10)   // 실패
    println("최종 리스트: $safeList")

    // 안전한 변경
    fun safeSet(list: MutableList<String>, index: Int, value: String): Boolean {
        return if (index in 0 until list.size) {
            list[index] = value
            println("인덱스 $index 를 '$value'로 변경")
            true
        } else {
            println("인덱스 $index 는 범위를 벗어남")
            false
        }
    }

    safeSet(safeList, 0, "X")    // 성공
    safeSet(safeList, 5, "Y")    // 실패
    println("최종 리스트: $safeList")

    /*************** - List vs MutableList 언제 사용할까 - ****************/

    println("\n=== 언제 무엇을 사용할까 ===")

    println("List를 사용하는 경우:")
    println("  ✓ 데이터가 변하지 않아야 할 때")
    println("  ✓ 안전성이 중요할 때")
    println("  ✓ 여러 곳에서 공유하는 데이터")
    println("  예: 설정값, 상수, 메뉴 항목")

    val menuItems = listOf("아메리카노", "라떼", "카푸치노")  // 변하지 않음

    println("\nMutableList를 사용하는 경우:")
    println("  ✓ 데이터가 자주 변해야 할 때")
    println("  ✓ 사용자 입력을 받을 때")
    println("  ✓ 동적으로 관리해야 할 때")
    println("  예: 장바구니, 할 일 목록, 검색 결과")

    val shoppingCart = mutableListOf<String>()  // 계속 변함
    shoppingCart.add("우유")
    shoppingCart.add("빵")

    /*************** - 성능 고려사항 - ****************/

    println("\n=== 성능 비교 ===")

    // 비효율적: List 재할당
    var inefficientList = listOf("A")
    println("비효율적 방법:")
    for (i in 1..3) {
        inefficientList = inefficientList + "Item$i"  // 매번 새 리스트 생성
        println("  추가 후: $inefficientList")
    }

    // 효율적: MutableList 사용
    val efficientList = mutableListOf("A")
    println("\n효율적 방법:")
    for (i in 1..3) {
        efficientList.add("Item$i")  // 기존 리스트에 추가
        println("  추가 후: $efficientList")
    }

    println("\n결론: 자주 변경된다면 MutableList가 훨씬 빠름!")

    /*************** - 정리 - ****************/

    println("\n=== 정리 ===")

    println("MutableList 주요 특징:")
    println("1. List의 모든 기능 + 변경 기능")
    println("2. add() - 요소 추가")
    println("3. set() 또는 [index] = value - 요소 변경")
    println("4. remove(), removeAt() - 요소 제거")
    println("5. clear() - 모든 요소 제거")
    println("6. addAll() - 여러 요소 한번에 추가")

    println("\n주의사항:")
    println("• 인덱스 범위 확인하기")
    println("• 순회 중 크기 변경 주의")
    println("• 필요할 때만 사용하기")

    println("\n기본 원칙:")
    println("• 변경이 필요하면 MutableList")
    println("• 안전성이 중요하면 List")
    println("• 확실하지 않으면 List부터 시작")
}