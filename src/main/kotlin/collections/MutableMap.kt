package collections

/**
 * 날짜: 2025-09-15
 * 주제: MutableMap - 변경 가능한 Map
 *
 * 배운 내용:
 * - MutableMap은 Map과 달리 키-값 쌍을 추가/제거/변경할 수 있음
 * - Map의 모든 기능 + 변경 기능 추가
 * - mutableMapOf()로 생성, toMutableMap()으로 변환
 * - put(), [키] = 값, putAll(), putIfAbsent()로 추가
 * - remove(), clear()로 제거
 * - +=, -= 연산자도 사용 가능
 * - 기존 키에 새 값 할당하면 덮어쓰기됨
 *
 * 어려웠던 점:
 * - Map vs MutableMap 언제 사용할지 판단
 * - put() vs [키] = 값의 차이점
 * - 키 중복 시 덮어쓰기 동작
 * - += 연산자의 다양한 사용법
 */
fun main() {

    /*************** - Map vs MutableMap 비교 - ****************/
    // 문서의 직원 급여 예제

    println("=== Map의 한계점 ===")

    // 불변 Map의 문제점
    val staff = mapOf(
        "John" to 500,
        "Mike" to 1000,
        "Lara" to 1300
    )
    println("원래 직원 목록: $staff")

    // 새 직원 추가하려면? 재할당 필요 (비효율적)
    var staffVar = mapOf(
        "John" to 500,
        "Mike" to 1000,
        "Lara" to 1300
    )
    staffVar += "Jane" to 700  // 재할당 (느림)
    println("재할당으로 추가: $staffVar")

    println("\n=== MutableMap의 해결책 ===")

    // MutableMap으로 해결
    val mutableStaff = mutableMapOf(
        "John" to 500,
        "Mike" to 1000,
        "Lara" to 1300
    )

    mutableStaff["Nika"] = 999  // 바로 추가!
    println("MutableMap으로 추가: $mutableStaff")

    /*************** - MutableMap 만들기 - ****************/

    println("\n=== MutableMap 만들기 ===")

    // 타입 명시
    val students = mutableMapOf<String, Int>("Nika" to 19, "Mike" to 23)
    println("학생 나이: $students")

    // 타입 추론 (권장)
    val carsPerYear = mutableMapOf(1999 to 30000, 2021 to 202111)
    println("연도별 자동차: $carsPerYear")

    // Map을 MutableMap으로 변환
    val mapCarsPerYear = mapOf(1999 to 30000, 2021 to 202111)
    val convertedCars = mapCarsPerYear.toMutableMap()
    convertedCars[2020] = 2020
    println("변환된 Map: $convertedCars")

    /*************** - 요소 추가하기 - ****************/

    println("\n=== 요소 추가하기 ===")

    // 빈 MutableMap부터 시작
    val groupOfStudents = mutableMapOf<String, Int>()

    // 세 가지 추가 방법
    groupOfStudents.put("John", 4)          // put 메서드
    groupOfStudents["Mike"] = 5             // 인덱스 방식 (권장)
    groupOfStudents["Anastasia"] = 10

    println("학생 그룹: $groupOfStudents")

    // 다른 Map 전체 추가
    val studentsFromOregon = mapOf("Alexa" to 7)
    groupOfStudents.putAll(studentsFromOregon)

    println("오레곤 학생 추가 후: $groupOfStudents")

    // 기존 키에 새 값 할당 (덮어쓰기)
    val groceries = mutableMapOf<String, Int>()
    groceries["Potato"] = 5
    println("첫 번째 할당: $groceries")  // {Potato=5}

    groceries["Potato"] = 10  // 덮어쓰기!
    println("덮어쓰기 후: $groceries")   // {Potato=10}

    // += 연산자 사용
    val shoppingList = mutableMapOf<String, Int>()
    shoppingList += mapOf("Potato" to 5)    // Map 추가
    shoppingList += "Sprite" to 1           // 단일 항목 추가

    println("+= 연산자 사용: $shoppingList")

    /*************** - 요소 제거하기 - ****************/

    println("\n=== 요소 제거하기 ===")

    val inventory = mutableMapOf(
        "Potato" to 10,
        "Coke" to 5,
        "Chips" to 7
    )

    println("원래 재고: $inventory")

    // 특정 키 제거
    inventory.remove("Potato")
    println("감자 제거 후: $inventory")  // {Coke=5, Chips=7}

    // 모든 요소 제거
    inventory.clear()
    println("모두 제거 후: $inventory")  // {}

    // -= 연산자 사용
    val cars = mutableMapOf<String, Double>()
    cars["Ford"] = 100.500
    cars["Kia"] = 500.15

    println("자동차 목록: $cars")        // {Ford=100.5, Kia=500.15}

    cars -= "Kia"  // -= 연산자로 제거
    println("Kia 제거 후: $cars")       // {Ford=100.5}

    /*************** - 실용적 활용 예제 - ****************/

    println("\n=== 실용적 활용 예제 ===")

    // 장바구니 관리
    val cart = mutableMapOf<String, Int>()

    println("장바구니에 상품 추가:")
    cart["사과"] = 3
    cart["바나나"] = 5
    cart["우유"] = 2

    for ((item, quantity) in cart) {
        println("$item: ${quantity}개")
    }

    // 수량 변경
    cart["사과"] = 5  // 3개에서 5개로 변경
    println("\n사과 수량 변경 후:")
    println("사과: ${cart["사과"]}개")

    // 상품 제거
    cart.remove("바나나")
    println("\n바나나 제거 후: $cart")

    // 점수 관리 시스템
    val gameScores = mutableMapOf<String, Int>()

    println("\n게임 점수 관리:")
    gameScores["플레이어1"] = 100
    gameScores["플레이어2"] = 85
    gameScores["플레이어3"] = 120

    // 점수 업데이트
    gameScores["플레이어1"] = gameScores["플레이어1"]!! + 50  // 보너스 점수

    println("점수 업데이트:")
    for ((player, score) in gameScores) {
        println("$player: ${score}점")
    }

    // 설정 관리
    val appSettings = mutableMapOf<String, String>()

    println("\n앱 설정 관리:")
    appSettings["테마"] = "다크"
    appSettings["언어"] = "한국어"
    appSettings["알림"] = "켜짐"

    // 설정 변경
    fun changeSetting(key: String, value: String) {
        appSettings[key] = value
        println("설정 변경: $key = $value")
    }

    changeSetting("테마", "라이트")
    changeSetting("알림", "꺼짐")

    println("현재 설정:")
    for ((setting, value) in appSettings) {
        println("$setting: $value")
    }

    /*************** - 고급 사용법 - ****************/

    println("\n=== 고급 사용법 ===")

    // putIfAbsent 사용
    val userProfiles = mutableMapOf<String, String>()

    userProfiles["홍길동"] = "관리자"
    userProfiles.putIfAbsent("홍길동", "사용자")  // 이미 있으므로 변경되지 않음
    userProfiles.putIfAbsent("김철수", "사용자")  // 없으므로 추가됨

    println("사용자 프로필:")
    for ((name, role) in userProfiles) {
        println("$name: $role")
    }

    // 안전한 업데이트
    val counters = mutableMapOf<String, Int>()

    fun incrementCounter(key: String) {
        counters[key] = (counters[key] ?: 0) + 1
    }

    incrementCounter("방문자")
    incrementCounter("방문자")
    incrementCounter("클릭")

    println("\n카운터 값:")
    for ((event, count) in counters) {
        println("$event: ${count}회")
    }

    // 조건부 제거
    val inventory2 = mutableMapOf(
        "사과" to 0,
        "바나나" to 5,
        "오렌지" to 0,
        "포도" to 3
    )

    println("\n재고 정리 전: $inventory2")

    // 재고가 0인 항목 제거
    val itemsToRemove = inventory2.filter { it.value == 0 }.keys
    itemsToRemove.forEach { inventory2.remove(it) }

    println("재고 정리 후: $inventory2")

    /*************** - 성능과 안전성 고려사항 - ****************/

    println("\n=== 성능과 안전성 고려사항 ===")

    // 큰 Map 처리
    val largeMap = mutableMapOf<String, Int>()

    // 대량 데이터 추가
    for (i in 1..5) {
        largeMap["항목$i"] = i * 10
    }

    println("대량 데이터: $largeMap")

    // 안전한 접근과 수정
    fun safeUpdate(map: MutableMap<String, Int>, key: String, newValue: Int): Boolean {
        return if (map.containsKey(key)) {
            map[key] = newValue
            true
        } else {
            false
        }
    }

    val updateSuccess = safeUpdate(largeMap, "항목3", 99)
    println("업데이트 성공: $updateSuccess")
    println("업데이트 후: ${largeMap["항목3"]}")

    // null 값 처리
    val nullableMap = mutableMapOf<String, String?>()
    nullableMap["존재함"] = "값"
    nullableMap["존재하지만null"] = null

    println("\nnull 처리:")
    println("존재함: ${nullableMap["존재함"]}")
    println("존재하지만null: ${nullableMap["존재하지만null"]}")
    println("없음: ${nullableMap["없음"]}")

    /*************** - Map vs MutableMap 선택 가이드 - ****************/

    println("\n=== Map vs MutableMap 선택 가이드 ===")

    println("Map을 사용하는 경우:")
    println("- 데이터가 변하지 않아야 할 때")
    println("- 설정값, 상수, 코드표")
    println("- 여러 곳에서 공유하는 데이터")
    println("- 안전성이 중요할 때")

    val constants = mapOf(
        "PI" to 3.14159,
        "E" to 2.71828
    )  // 수학 상수는 변하지 않음

    println("\nMutableMap을 사용하는 경우:")
    println("- 데이터가 자주 변해야 할 때")
    println("- 사용자 입력을 받을 때")
    println("- 동적으로 관리해야 할 때")
    println("- 캐시, 세션, 임시 데이터")

    val cache = mutableMapOf<String, String>()  // 캐시는 계속 변함
    cache["user1"] = "데이터1"
    cache["user2"] = "데이터2"

    /*************** - 정리 - ****************/

    println("\n=== 정리 ===")

    println("MutableMap 주요 특징:")
    println("1. Map의 모든 기능 + 변경 기능")
    println("2. put() 또는 [키] = 값으로 추가")
    println("3. putAll()로 여러 항목 한번에 추가")
    println("4. remove()로 특정 키 제거")
    println("5. clear()로 모든 요소 제거")
    println("6. +=, -= 연산자 지원")

    println("\n주요 메서드:")
    println("- 추가: [키] = 값, put(), putAll()")
    println("- 제거: remove(), clear()")
    println("- 확인: containsKey(), containsValue()")
    println("- 접근: [키], get()")

    println("\n주의사항:")
    println("- 기존 키에 새 값 할당하면 덮어쓰기")
    println("- 존재하지 않는 키 접근 시 null 반환")
    println("- 동시 접근 시 동기화 필요할 수 있음")

    println("\n기본 원칙:")
    println("- 변경이 필요하면 MutableMap")
    println("- 안전성이 중요하면 Map")
    println("- 확실하지 않으면 Map부터 시작")
}