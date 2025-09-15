package collections

/**
 * 날짜: 2025-09-15
 * 주제: MutableSet - 변경 가능한 Set
 *
 * 배운 내용:
 * - MutableSet은 Set과 달리 요소를 추가/제거할 수 있음
 * - 중복 없음과 순서 없음은 Set과 동일
 * - mutableSetOf()로 생성, toMutableSet()으로 변환
 * - add(), addAll()로 요소 추가
 * - remove(), removeAll(), clear()로 요소 제거
 * - for 루프로 순회 가능
 * - MutableList와 달리 중복 자동 제거
 *
 * 어려웠던 점:
 * - Set vs MutableSet vs MutableList 차이점
 * - 언제 MutableSet을 사용해야 하는지 판단
 * - 중복 제거가 자동으로 되는 특성
 * - removeAll의 동작 방식
 */
fun main() {

    /*************** - Set vs MutableSet 비교 - ****************/
    // 문서의 장보기 예제

    println("=== Set의 한계점 ===")

    // 불변 Set의 문제점
    val groceries = setOf("Banana", "Strawberry")
    println("원래 장보기 목록: $groceries")

    // 새 항목 추가하려면? Set은 불가능!
    // groceries.add("Water")  // 컴파일 오류!

    println("\n=== MutableSet의 해결책 ===")

    // MutableSet으로 해결
    val mutableGroceries = mutableSetOf("Banana", "Strawberry")
    mutableGroceries.add("Water")
    println("MutableSet으로 추가: $mutableGroceries")  // [Banana, Strawberry, Water]

    /*************** - MutableSet vs MutableList 비교 - ****************/

    println("\n=== MutableSet vs MutableList 비교 ===")

    // MutableSet: 중복 자동 제거
    val setGroceries = mutableSetOf("Banana", "Banana", "Strawberry")
    println("MutableSet: $setGroceries")  // [Banana, Strawberry]

    // MutableList: 중복 허용
    val listGroceries = mutableListOf("Banana", "Banana", "Strawberry")
    println("MutableList: $listGroceries")  // [Banana, Banana, Strawberry]

    println("\n결론: MutableSet은 중복 없이 관리하고 싶을 때 사용!")

    /*************** - MutableSet 만들기 - ****************/

    println("\n=== MutableSet 만들기 ===")

    // 타입 추론으로 생성
    val students = mutableSetOf("Joe", "Elena", "Bob")
    println("학생들: $students")  // [Joe, Elena, Bob]

    // 빈 MutableSet (타입 명시 필요)
    val points = mutableSetOf<Int>()
    println("빈 Set: $points")  // []

    // Set을 MutableSet으로 변환
    val immutableStudents = setOf("Joe", "Elena", "Bob")
    val mutableStudents = immutableStudents.toMutableSet()
    mutableStudents.add("Bob")  // 이미 있어도 추가 시도 (중복 제거됨)
    println("변환된 Set: $mutableStudents")  // [Joe, Elena, Bob]

    /*************** - 요소 추가하기 - ****************/
    // 문서의 협업 단어 기록 예제

    println("\n=== 요소 추가하기 ===")

    val words = mutableSetOf<String>("Apple", "Coke")
    val friendsWords = mutableSetOf<String>("Banana", "Coke")

    println("내 단어 (초기): $words")
    println("친구 단어 (초기): $friendsWords")

    // 개별 요소 추가
    words.add("Phone")
    words.add("Controller")

    friendsWords.add("Phone")
    friendsWords.add("Pasta")
    friendsWords.add("Pizza")

    println("\n개별 추가 후:")
    println("내 단어: $words")
    println("친구 단어: $friendsWords")

    // 전체 컬렉션 추가 (중복 자동 제거)
    words.addAll(friendsWords)

    println("\n합친 후:")
    println("최종 단어 목록: $words")  // [Apple, Coke, Phone, Controller, Banana, Pasta, Pizza]

    /*************** - 요소 제거하기 - ****************/

    println("\n=== 요소 제거하기 ===")

    val shoppingList = mutableSetOf("Apple", "Water", "Banana", "Pen")
    println("원래 목록: $shoppingList")

    // 특정 요소 제거
    shoppingList.remove("Apple")
    println("사과 제거 후: $shoppingList")  // [Water, Banana, Pen]

    // 여러 요소 한번에 제거
    val uselessItems = setOf("Banana", "Pen")
    shoppingList.removeAll(uselessItems)
    println("불필요한 항목 제거 후: $shoppingList")  // [Water]

    // 모든 요소 제거
    shoppingList.clear()
    println("모두 제거 후: $shoppingList")  // []

    /*************** - 순회하기 - ****************/

    println("\n=== 순회하기 ===")

    val places = mutableSetOf("Saint-Petersburg", "Moscow", "Grodno", "Rome")

    println("방문할 도시들:")
    for (place in places) {
        println("- $place")
    }

    /*************** - 실용적 활용 예제 - ****************/

    println("\n=== 실용적 활용 예제 ===")

    // 태그 관리 시스템
    val articleTags = mutableSetOf<String>()

    println("블로그 글 태그 관리:")
    articleTags.add("Kotlin")
    articleTags.add("프로그래밍")
    articleTags.add("튜토리얼")
    articleTags.add("Kotlin")  // 중복 - 무시됨

    println("현재 태그: ${articleTags.joinToString()}")

    // 추가 태그들
    val newTags = setOf("초보자", "예제")
    articleTags.addAll(newTags)

    println("태그 추가 후: ${articleTags.joinToString()}")

    // 온라인 사용자 관리
    val onlineUsers = mutableSetOf<String>()

    fun userLogin(username: String) {
        onlineUsers.add(username)
        println("$username 로그인 - 현재 접속자: ${onlineUsers.size}명")
    }

    fun userLogout(username: String) {
        if (onlineUsers.remove(username)) {
            println("$username 로그아웃 - 현재 접속자: ${onlineUsers.size}명")
        } else {
            println("$username 은 접속 중이 아닙니다")
        }
    }

    println("\n온라인 사용자 관리:")
    userLogin("user1")
    userLogin("user2")
    userLogin("user1")  // 이미 접속 중 - 중복 제거
    userLogout("user1")
    userLogout("user3")  // 접속하지 않은 사용자

    // 권한 관리
    val userPermissions = mutableSetOf("read", "write")

    fun grantPermission(permission: String) {
        if (userPermissions.add(permission)) {
            println("권한 '$permission' 부여됨")
        } else {
            println("권한 '$permission' 이미 있음")
        }
    }

    fun revokePermission(permission: String) {
        if (userPermissions.remove(permission)) {
            println("권한 '$permission' 해제됨")
        } else {
            println("권한 '$permission' 없음")
        }
    }

    println("\n권한 관리:")
    println("현재 권한: ${userPermissions.joinToString()}")
    grantPermission("delete")
    grantPermission("read")  // 이미 있음
    revokePermission("write")
    revokePermission("admin")  // 없음
    println("최종 권한: ${userPermissions.joinToString()}")

    /*************** - 고급 사용법 - ****************/

    println("\n=== 고급 사용법 ===")

    // 집합 연산과 수정 조합
    val developers = mutableSetOf("김개발", "이코딩", "박프로그램")
    val designers = mutableSetOf("최디자인", "정UI", "한UX")
    val managers = mutableSetOf("이코딩", "박매니저")  // 이코딩은 개발자이면서 매니저

    println("팀 구성:")
    println("개발자: ${developers.joinToString()}")
    println("디자이너: ${designers.joinToString()}")
    println("매니저: ${managers.joinToString()}")

    // 전체 팀원 (합집합)
    val allTeam = mutableSetOf<String>()
    allTeam.addAll(developers)
    allTeam.addAll(designers)
    allTeam.addAll(managers)

    println("\n전체 팀원: ${allTeam.joinToString()}")
    println("총 인원: ${allTeam.size}명")

    // 프로젝트 참여자 관리
    val project1Team = mutableSetOf("김개발", "최디자인")
    val project2Team = mutableSetOf("이코딩", "정UI")

    // 신규 프로젝트에 기존 팀 합치기
    val newProjectTeam = mutableSetOf<String>()
    newProjectTeam.addAll(project1Team)
    newProjectTeam.addAll(project2Team)
    newProjectTeam.add("박매니저")  // 매니저 추가

    println("\n신규 프로젝트 팀: ${newProjectTeam.joinToString()}")

    // 조건부 수정
    val activeUsers = mutableSetOf("user1", "user2", "user3")
    val inactiveUsers = setOf("user2", "user4")

    println("\n사용자 상태 업데이트:")
    println("활성 사용자 (전): ${activeUsers.joinToString()}")

    // 비활성 사용자는 활성 목록에서 제거
    activeUsers.removeAll(inactiveUsers)
    println("활성 사용자 (후): ${activeUsers.joinToString()}")

    /*************** - 성능과 특성 이해 - ****************/

    println("\n=== 성능과 특성 이해 ===")

    // 중복 체크의 자동 수행
    val testSet = mutableSetOf<String>()

    fun addWithFeedback(item: String) {
        val wasAdded = testSet.add(item)
        if (wasAdded) {
            println("'$item' 추가 성공")
        } else {
            println("'$item' 이미 존재함 (추가되지 않음)")
        }
    }

    println("중복 체크 테스트:")
    addWithFeedback("항목1")
    addWithFeedback("항목2")
    addWithFeedback("항목1")  // 중복

    println("최종 Set: ${testSet.joinToString()}")

    // 순서 없음 확인
    val orderTest = mutableSetOf<Int>()
    orderTest.addAll(listOf(3, 1, 4, 1, 5, 9, 2, 6))

    println("\n순서 테스트:")
    println("추가 순서: [3, 1, 4, 1, 5, 9, 2, 6]")
    println("Set 결과: $orderTest")
    println("주의: Set은 순서를 보장하지 않음!")

    /*************** - Set vs MutableSet 선택 가이드 - ****************/

    println("\n=== Set vs MutableSet 선택 가이드 ===")

    println("Set을 사용하는 경우:")
    println("- 고정된 고유 값들")
    println("- 변경되지 않는 설정")
    println("- 상수성 중복 없는 목록")

    val fixedRoles = setOf("admin", "user", "guest")  // 변경 안됨

    println("\nMutableSet을 사용하는 경우:")
    println("- 동적으로 변하는 고유 값들")
    println("- 사용자 관리, 태그 관리")
    println("- 실시간 업데이트가 필요한 집합")

    val dynamicTags = mutableSetOf<String>()  // 계속 변함

    /*************** - 정리 - ****************/

    println("\n=== 정리 ===")

    println("MutableSet 핵심 특징:")
    println("1. Set의 모든 기능 + 변경 기능")
    println("2. 중복 없음 + 순서 없음")
    println("3. add(), addAll()로 추가")
    println("4. remove(), removeAll(), clear()로 제거")
    println("5. 중복 추가 시도 시 무시됨")

    println("\n언제 사용할까:")
    println("- 고유한 요소들을 동적으로 관리할 때")
    println("- 중복 제거가 자동으로 필요할 때")
    println("- 집합 연산과 수정이 모두 필요할 때")

    println("\n주의사항:")
    println("- 순서에 의존하지 말 것")
    println("- 중복 추가는 무시됨")
    println("- add() 메서드는 성공 여부를 반환")

    println("\n컬렉션 선택 기준:")
    println("- 순서 + 중복 필요 → MutableList")
    println("- 고유성 + 변경 필요 → MutableSet")
    println("- 키-값 관계 + 변경 필요 → MutableMap")
}