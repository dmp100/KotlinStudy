package collections

/**
 * 날짜: 2025-09-15
 * 주제: 컬렉션 소개 (Introduction to Collections)
 *
 * 배운 내용:
 * - 컬렉션은 여러 객체를 저장하고 구성하는 컨테이너
 * - 가변(mutable)과 불변(immutable) 컬렉션의 차이점
 * - List: 순서가 있고 중복 허용, 인덱스로 접근
 * - Set: 고유한 요소들, 순서 정의되지 않음, 중복 불허
 * - Map: 키-값 쌍 저장, 키는 고유하지만 값은 중복 가능
 * - 모든 컬렉션의 공통 속성과 메서드들
 * - in 키워드가 contains()보다 관용적
 *
 * 어려웠던 점:
 * - 가변성과 불변성의 실제 차이점과 용도
 * - List, Set, Map의 특성과 적절한 사용 시점
 * - 제네릭 컬렉션의 개념
 * - 공통 메서드들의 정확한 동작 방식
 */
fun main() {

    /*************** - 컬렉션이란 무엇인가 - ****************/
    // 컬렉션의 기본 개념과 연산들

    println("=== 컬렉션이란 무엇인가 ===")

    // 컬렉션이 지원하는 기본 연산들:
    // - retrieving an element (요소 조회)
    // - removing an element (요소 제거)
    // - changing or replacing an element (요소 변경/교체)
    // - adding a new element (새 요소 추가)

    println("컬렉션이 지원하는 연산:")
    println("1. 요소 조회")
    println("2. 요소 제거 (가변 컬렉션만)")
    println("3. 요소 변경/교체 (가변 컬렉션만)")
    println("4. 새 요소 추가 (가변 컬렉션만)")

    /*************** - 가변성(Mutability) - ****************/
    // 문서의 핵심 개념: 불변 vs 가변 컬렉션

    println("\n=== 가변성 (Mutability) ===")

    // 불변 컬렉션 예제
    val immutableList = listOf("사과", "바나나", "오렌지")
    println("불변 리스트: $immutableList")
    println("크기: ${immutableList.size}")
    println("첫 번째 요소: ${immutableList[0]}")
    // immutableList.add("포도")  // 컴파일 오류 - 불변이므로 추가 불가

    // 가변 컬렉션 예제
    val mutableList = mutableListOf("사과", "바나나", "오렌지")
    println("\n가변 리스트 (초기): $mutableList")
    mutableList.add("포도")
    println("요소 추가 후: $mutableList")
    mutableList.remove("바나나")
    println("요소 제거 후: $mutableList")
    mutableList[0] = "딸기"
    println("요소 변경 후: $mutableList")

    /*************** - Kotlin의 컬렉션 타입들 - ****************/
    // List, Set, Map의 특성과 차이점

    println("\n=== Kotlin의 컬렉션 타입들 ===")

    // List: 순서 있음, 중복 허용, 인덱스 접근
    println("=== List ===")
    val studentRatings = listOf(85, 92, 78, 85, 90)  // 중복 허용
    println("학생 평점 이력: $studentRatings")
    println("첫 번째 평점: ${studentRatings[0]}")
    println("세 번째 평점: ${studentRatings[2]}")
    println("85점이 몇 번 나왔나: ${studentRatings.count { it == 85 }}")

    // Set: 고유한 요소, 순서 정의되지 않음, 중복 불허
    println("\n=== Set ===")
    val favoriteRestaurants = setOf("한식당", "중식당", "일식당", "한식당")  // 중복 자동 제거
    println("좋아하는 식당들: $favoriteRestaurants")
    println("크기: ${favoriteRestaurants.size}")  // 3 (중복 제거됨)

    val partyInvitees = mutableSetOf<String>()
    partyInvitees.add("김철수")
    partyInvitees.add("이영희")
    partyInvitees.add("김철수")  // 중복 추가 시도
    println("파티 초대 명단: $partyInvitees")  // 김철수는 하나만

    // Map: 키-값 쌍, 키는 고유, 값은 중복 가능
    println("\n=== Map ===")
    val jobTitles = mapOf(
        "김철수" to "개발자",
        "이영희" to "디자이너",
        "박민수" to "개발자",  // 값 중복 허용
        "최수진" to "매니저"
    )
    println("직책 정보: $jobTitles")
    println("김철수의 직책: ${jobTitles["김철수"]}")
    println("존재하지 않는 키: ${jobTitles["홍길동"]}")  // null

    val mutableJobTitles = mutableMapOf("김철수" to "개발자")
    mutableJobTitles["이영희"] = "디자이너"
    mutableJobTitles["김철수"] = "시니어 개발자"  // 키 중복 시 값 덮어쓰기
    println("변경된 직책: $mutableJobTitles")

    /*************** - 공통 속성과 메서드 - ****************/
    // 모든 컬렉션에서 사용 가능한 공통 기능들

    println("\n=== 공통 속성과 메서드 ===")

    val numbers = listOf(1, 2, 3, 4, 5, 3)
    val fruits = setOf("apple", "banana", "orange")
    val colors = mapOf("red" to "빨강", "blue" to "파랑", "green" to "초록")

    // size - 컬렉션 크기
    println("numbers 크기: ${numbers.size}")
    println("fruits 크기: ${fruits.size}")
    println("colors 크기: ${colors.size}")

    // contains(element) - 요소 포함 여부
    println("\ncontains 테스트:")
    println("numbers에 3 포함: ${numbers.contains(3)}")
    println("fruits에 apple 포함: ${fruits.contains("apple")}")
    println("colors에 red 키 포함: ${colors.containsKey("red")}")

    // containsAll(elements) - 모든 요소 포함 여부
    println("\ncontainsAll 테스트:")
    println("numbers에 [1, 3, 5] 모두 포함: ${numbers.containsAll(listOf(1, 3, 5))}")
    println("fruits에 [apple, orange] 모두 포함: ${fruits.containsAll(listOf("apple", "orange"))}")

    // isEmpty() - 빈 컬렉션 여부
    val emptyList = listOf<String>()
    println("\n빈 컬렉션 테스트:")
    println("numbers가 비어있나: ${numbers.isEmpty()}")
    println("emptyList가 비어있나: ${emptyList.isEmpty()}")

    // joinToString() - 문자열로 변환
    println("\njoinToString 테스트:")
    println("numbers: ${numbers.joinToString()}")
    println("fruits: ${fruits.joinToString(" | ")}")
    println("colors keys: ${colors.keys.joinToString(", ")}")

    // indexOf(element) - 첫 번째 인덱스 (List만)
    println("\nindexOf 테스트:")
    println("numbers에서 3의 첫 인덱스: ${numbers.indexOf(3)}")
    println("numbers에서 10의 인덱스: ${numbers.indexOf(10)}")  // -1

    /*************** - 가변 컬렉션 전용 메서드 - ****************/
    // 가변 컬렉션에서만 사용 가능한 메서드들

    println("\n=== 가변 컬렉션 전용 메서드 ===")

    val mutableNumbers = mutableListOf(1, 2, 3, 4, 5, 3)
    val mutableFruits = mutableSetOf("apple", "banana", "orange")

    println("초기 상태:")
    println("mutableNumbers: $mutableNumbers")
    println("mutableFruits: $mutableFruits")

    // remove(element) - 첫 번째 발생 요소 제거
    mutableNumbers.remove(3)  // 첫 번째 3만 제거
    mutableFruits.remove("banana")
    println("\nremove 후:")
    println("mutableNumbers: $mutableNumbers")
    println("mutableFruits: $mutableFruits")

    // removeAll(elements) - 지정된 모든 요소 제거
    mutableNumbers.removeAll(listOf(1, 5))
    println("\nremoveAll 후:")
    println("mutableNumbers: $mutableNumbers")

    // clear() - 모든 요소 제거
    val testList = mutableListOf("a", "b", "c")
    println("\nclear 전: $testList")
    testList.clear()
    println("clear 후: $testList")

    /*************** - 관용구: in 키워드 - ****************/
    // 문서의 관용구 예제

    println("\n=== 관용구: in 키워드 ===")

    val collection = listOf("apple", "banana", "orange")
    val elem = "apple"

    // 권장 방법: in 키워드
    println("in 키워드 사용: ${elem in collection}")

    // 일반적인 방법: contains() 메서드
    println("contains() 사용: ${collection.contains(elem)}")

    // 실제 활용 예제
    val validColors = setOf("red", "green", "blue", "yellow")
    val userInput = "red"

    if (userInput in validColors) {
        println("유효한 색상입니다: $userInput")
    } else {
        println("지원하지 않는 색상입니다: $userInput")
    }

    /*************** - 실용적 활용 예제 - ****************/

    println("\n=== 실용적 활용 예제 ===")

    // 도서 관리 시스템
    val bookPages = listOf("표지", "목차", "1장", "2장", "3장", "찾아보기")  // 불변 - 페이지는 변하지 않음
    println("책 구조: ${bookPages.joinToString(" → ")}")

    // 쇼핑 카트
    val shoppingCart = mutableListOf<String>()  // 가변 - 상품 추가/제거 가능
    shoppingCart.addAll(listOf("우유", "빵", "계란"))
    shoppingCart.add("치즈")
    shoppingCart.remove("빵")
    println("쇼핑 카트: $shoppingCart")

    // 사용자 권한 관리
    val adminPermissions = setOf("읽기", "쓰기", "삭제", "관리")  // 중복 불허
    val userPermissions = setOf("읽기", "쓰기")

    fun checkPermission(action: String, userPerms: Set<String>): Boolean {
        return action in userPerms
    }

    println("사용자가 삭제 가능: ${checkPermission("삭제", userPermissions)}")
    println("사용자가 읽기 가능: ${checkPermission("읽기", userPermissions)}")

    // 설정 관리
    val appSettings = mutableMapOf(
        "theme" to "dark",
        "language" to "ko",
        "notifications" to "true"
    )

    fun updateSetting(key: String, value: String) {
        appSettings[key] = value
        println("설정 업데이트: $key = $value")
    }

    updateSetting("theme", "light")
    println("현재 설정: $appSettings")

    // 데이터 분석
    val scores = listOf(85, 92, 78, 96, 88, 91, 83)
    println("\n성적 분석:")
    println("전체 점수: $scores")
    println("평균: ${scores.average()}")
    println("최고점: ${scores.maxOrNull()}")
    println("90점 이상: ${scores.filter { it >= 90 }}")
    println("점수 분포: ${scores.groupBy {
        when (it) {
            in 90..100 -> "A"
            in 80..89 -> "B"
            in 70..79 -> "C"
            else -> "F"
        }
    }}")

    /*************** - 컬렉션 타입 선택 가이드 - ****************/

    println("\n=== 컬렉션 타입 선택 가이드 ===")

    println("List를 사용하는 경우:")
    println("- 순서가 중요한 경우")
    println("- 중복 요소가 필요한 경우")
    println("- 인덱스로 접근해야 하는 경우")
    println("예: 학생 성적 이력, 주문 목록, 단계별 진행 과정")

    println("\nSet을 사용하는 경우:")
    println("- 중복을 허용하지 않는 경우")
    println("- 순서가 중요하지 않은 경우")
    println("- 포함 여부 검사가 주요 연산인 경우")
    println("예: 태그 목록, 권한 집합, 고유 ID 집합")

    println("\nMap을 사용하는 경우:")
    println("- 키-값 연관 관계를 저장해야 하는 경우")
    println("- 빠른 키 기반 조회가 필요한 경우")
    println("예: 사용자 정보, 설정값, 캐시 데이터")

    println("\n가변 vs 불변 선택:")
    println("불변: 데이터가 변하지 않아야 하는 경우 (설정, 상수 등)")
    println("가변: 데이터가 동적으로 변해야 하는 경우 (카트, 목록 등)")

    /*************** - 정리 - ****************/

    println("\n=== 정리 ===")
    println("1. 컬렉션은 여러 객체를 저장하는 컨테이너")
    println("2. 불변 vs 가변: 요소 변경 가능 여부")
    println("3. List: 순서O, 중복O, 인덱스 접근")
    println("4. Set: 순서X, 중복X, 고유 요소")
    println("5. Map: 키-값 쌍, 키는 고유")
    println("6. 공통 메서드: size, contains, isEmpty, joinToString")
    println("7. 가변 전용: clear, remove, removeAll")
    println("8. in 키워드가 contains()보다 권장됨")
}
