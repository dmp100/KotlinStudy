package collections

/**
 * 날짜: 2025-09-15
 * 주제: Map 컬렉션
 *
 * 배운 내용:
 * - Map은 키-값 쌍을 저장하는 불변 컬렉션
 * - 키는 고유해야 함 (중복 불가)
 * - 키로 값을 빠르게 찾을 수 있음
 * - Pair 타입으로 키-값 쌍 표현
 * - "to" 키워드로 간편하게 Pair 생성
 * - mapOf(), emptyMap(), buildMap()으로 초기화
 * - [키] 또는 get(키)로 값 접근
 * - containsKey(), containsValue()로 포함 여부 확인
 * - for 루프로 순회 가능
 *
 * 어려웠던 점:
 * - Map vs List의 차이점과 사용 시점
 * - Pair 타입과 구조분해할당
 * - 키가 없을 때 null 반환되는 것
 * - 순회할 때 key, value 접근 방법
 */
fun main() {

    /*************** - Map이 왜 필요할까? - ****************/
    // 문서의 학생 성적 예제

    println("=== Map이 왜 필요할까? ===")

    // Map 사용 (권장)
    val students = mapOf(
        "Zhenya" to 5,
        "Vlad" to 4,
        "Nina" to 5
    )
    println("Map 사용: $students")  // {Zhenya=5, Vlad=4, Nina=5}

    // List 사용 (비효율적)
    val studentsName = mutableListOf("Zhenya", "Vlad", "Nina")
    val studentsMarks = mutableListOf(5, 4, 5)
    println("List 사용: ${studentsName[0]}=${studentsMarks[0]}, ${studentsName[1]}=${studentsMarks[1]}, ${studentsName[2]}=${studentsMarks[2]}")

    // Map의 장점: 키로 바로 접근!
    val grade1 = students["Nina"]
    println("Nina의 성적: $grade1")  // 5

    println("\nMap의 장점:")
    println("- 키로 바로 값 찾기 가능")
    println("- 두 개의 리스트 관리할 필요 없음")
    println("- 코드가 더 읽기 쉬움")

    /*************** - Pair 타입 이해하기 - ****************/

    println("\n=== Pair 타입 이해하기 ===")

    // Pair 생성과 구조분해할당
    val (name, grade) = Pair("Zhenya", 5)
    println("학생 이름: $name, 성적: $grade")

    // .first와 .second 사용 (권장하지 않음)
    val p = Pair(2, 3)
    println("첫 번째: ${p.first}, 두 번째: ${p.second}")  // 2 3

    // 구조분해할당 (권장)
    val (first, second) = p
    println("첫 번째: $first, 두 번째: $second")  // 2 3

    // "to" 키워드 사용 (간편함)
    val (studentName, studentGrade) = "Vlad" to 4
    println("학생: $studentName, 성적: $studentGrade")

    /*************** - Map 만들기 - ****************/

    println("\n=== Map 만들기 ===")

    // 타입 명시
    val staff = mapOf<String, Int>("John" to 1000)
    println("직원 급여: $staff")

    // 타입 추론 (권장)
    val staff2 = mapOf("Mike" to 1500)
    println("직원 급여2: $staff2")

    // 빈 Map
    val emptyStringToDoubleMap = emptyMap<String, Double>()
    println("빈 Map: $emptyStringToDoubleMap")

    // buildMap 사용
    val values = mapOf<String, Int>("Second" to 2, "Third" to 3)

    val map = buildMap<String, Int> {
        put("First", 1)
        putAll(values)
        put("Fourth", 4)
    }
    println("buildMap 결과: $map")  // {First=1, Second=2, Third=3, Fourth=4}

    /*************** - Map 기본 속성과 메서드 - ****************/
    // 문서의 HR 부서 예제

    println("\n=== Map 기본 속성과 메서드 ===")

    val employees = mapOf(
        "Mike" to 1500,
        "Jim" to 500,
        "Sara" to 1000
    )

    // 크기와 빈 여부 확인
    if (!employees.isEmpty()) {
        println("직원 수: ${employees.size}")
        println("Mike가 원하는 급여: ${employees["Mike"]}")
    }

    // 키 존재 여부 확인
    val isWanted = employees.containsKey("Jim")
    println("Jim이 우리 회사에 지원했나? $isWanted")

    // 값 존재 여부 확인
    val isAnyoneWilling = employees.containsValue(500)
    println("500달러에 일할 사람이 있나? $isAnyoneWilling")

    // get() vs [] 비교
    println("\n접근 방법 비교:")
    println("get() 사용: ${employees.get("Mike")}")
    println("[] 사용: ${employees["Mike"]}")  // 관용적 방법

    /*************** - Map 순회하기 - ****************/

    println("\n=== Map 순회하기 ===")

    // 방법 1: employee.key, employee.value 사용
    println("방법 1:")
    for (employee in employees) {
        println("${employee.key} ${employee.value}")
    }

    // 방법 2: 구조분해할당 사용 (권장)
    println("\n방법 2 (권장):")
    for ((k, v) in employees) {
        println("$k $v")
    }

    // 결과는 동일:
    // Mike 1500
    // Jim 500
    // Sara 1000

    /*************** - 관용적 패턴 - ****************/

    println("\n=== 관용적 패턴 ===")

    // Map 생성 - 간결한 방법
    val map1 = mapOf("a" to 1, "b" to 2, "c" to 3)
    println("간결한 Map 생성: $map1")

    // 요소 접근 - [] 사용 (권장)
    println("요소 접근:")
    println("get() 사용: ${map1.get("a")}")  // 1
    println("[] 사용: ${map1["b"]}")          // 2 (관용적)

    // 순회 - 구조분해할당 사용
    println("\n순회 (관용적 방법):")
    for ((k, v) in map1) {
        println("$k -> $v")
    }

    /*************** - 실용적 활용 예제 - ****************/

    println("\n=== 실용적 활용 예제 ===")

    // 전화번호부
    val phoneBook = mapOf(
        "엄마" to "010-1234-5678",
        "아빠" to "010-9876-5432",
        "친구" to "010-1111-2222"
    )

    println("전화번호부:")
    for ((name, phone) in phoneBook) {
        println("$name: $phone")
    }

    println("\n엄마 전화번호: ${phoneBook["엄마"]}")

    // 상품 가격표
    val priceList = mapOf(
        "사과" to 1000,
        "바나나" to 2000,
        "오렌지" to 1500
    )

    println("\n상품 가격:")
    for ((item, price) in priceList) {
        println("$item: ${price}원")
    }

    // 특정 상품 가격 확인
    val applePrice = priceList["사과"]
    println("사과 가격: ${applePrice}원")

    // 설정 정보 관리
    val config = mapOf(
        "서버주소" to "localhost",
        "포트" to "8080",
        "디버그모드" to "true"
    )

    println("\n설정 정보:")
    for ((key, value) in config) {
        println("$key = $value")
    }

    // 국가별 수도
    val capitals = mapOf(
        "한국" to "서울",
        "일본" to "도쿄",
        "중국" to "베이징",
        "미국" to "워싱턴 D.C."
    )

    println("\n국가별 수도:")
    for ((country, capital) in capitals) {
        println("$country 의 수도: $capital")
    }

    // 특정 국가 수도 찾기
    println("\n한국의 수도: ${capitals["한국"]}")

    if (capitals.containsKey("프랑스")) {
        println("프랑스의 수도: ${capitals["프랑스"]}")
    } else {
        println("프랑스 정보가 없습니다")
    }

    /*************** - null 처리와 안전한 접근 - ****************/

    println("\n=== null 처리와 안전한 접근 ===")

    val scores = mapOf(
        "철수" to 85,
        "영희" to 92,
        "민수" to 78
    )

    // 존재하지 않는 키 접근 시 null 반환
    val unknownScore = scores["홍길동"]
    println("존재하지 않는 학생: $unknownScore")  // null

    // 안전한 접근 방법들
    println("\n안전한 접근 방법:")

    // 1. containsKey로 확인 후 접근
    if (scores.containsKey("철수")) {
        println("철수 점수: ${scores["철수"]}")
    }

    // 2. null 체크
    val score = scores["영희"]
    if (score != null) {
        println("영희 점수: $score")
    }

    // 3. 엘비스 연산자 사용
    val defaultScore = scores["없는학생"] ?: 0
    println("기본값 사용: $defaultScore")

    /*************** - Map의 특징 정리 - ****************/

    println("\n=== Map의 특징 정리 ===")

    // 키는 고유해야 함
    val duplicateKeyExample = mapOf(
        "키1" to "값1",
        "키2" to "값2",
        "키1" to "새값"  // 같은 키면 마지막 값이 사용됨
    )
    println("중복 키 처리: $duplicateKeyExample")  // {키1=새값, 키2=값2}

    // 값은 중복 가능
    val duplicateValueExample = mapOf(
        "학생1" to 90,
        "학생2" to 85,
        "학생3" to 90  // 값 중복 허용
    )
    println("값 중복: $duplicateValueExample")

    // 불변성 (Map 자체는 변경 불가)
    val immutableMap = mapOf("a" to 1, "b" to 2)
    // immutableMap["c"] = 3  // 오류! 불변이므로 추가 불가
    println("불변 Map: $immutableMap")

    /*************** - 다양한 타입 Map - ****************/

    println("\n=== 다양한 타입 Map ===")

    // String to String
    val cityCountry = mapOf(
        "서울" to "한국",
        "도쿄" to "일본",
        "파리" to "프랑스"
    )

    // String to Int
    val ageMap = mapOf(
        "철수" to 25,
        "영희" to 30,
        "민수" to 22
    )

    // String to Boolean
    val statusMap = mapOf(
        "서버" to true,
        "데이터베이스" to false,
        "네트워크" to true
    )

    // Int to String
    val monthNames = mapOf(
        1 to "1월",
        2 to "2월",
        3 to "3월"
    )

    println("도시-국가: ${cityCountry["서울"]}")
    println("나이: ${ageMap["철수"]}")
    println("서버 상태: ${statusMap["서버"]}")
    println("3번째 달: ${monthNames[3]}")

    /*************** - 정리 - ****************/

    println("\n=== 정리 ===")

    println("Map 핵심 특징:")
    println("1. 키-값 쌍을 저장하는 불변 컬렉션")
    println("2. 키는 고유해야 함 (중복 불가)")
    println("3. 값은 중복 가능")
    println("4. 키로 빠른 값 검색 가능")

    println("\n주요 사용법:")
    println("- 생성: mapOf(키 to 값)")
    println("- 접근: map[키] (권장)")
    println("- 확인: containsKey(), containsValue()")
    println("- 순회: for ((k, v) in map)")

    println("\n언제 Map을 사용할까:")
    println("- 키-값 관계가 있는 데이터")
    println("- 빠른 검색이 필요할 때")
    println("- 설정 정보, 사전, 코드표 등")

    println("\n주의사항:")
    println("- 존재하지 않는 키 접근 시 null 반환")
    println("- 불변이므로 생성 후 변경 불가")
    println("- 키는 고유해야 함")
}