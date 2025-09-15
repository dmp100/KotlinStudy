package collections

/**
 * 날짜: 2025-09-15
 * 주제: Set 컬렉션
 *
 * 배운 내용:
 * - Set은 중복을 허용하지 않는 불변 컬렉션
 * - 순서가 정의되지 않음 (unordered)
 * - 중복 요소 자동 제거
 * - setOf(), emptySet(), buildSet()으로 초기화
 * - contains(), indexOf(), first(), last() 등 기본 메서드
 * - +, - 연산자로 집합 연산 가능
 * - toSet()으로 다른 컬렉션을 Set으로 변환
 * - for 루프로 순회 가능
 *
 * 어려웠던 점:
 * - Set vs List의 차이점과 사용 시점
 * - 순서가 없다는 개념의 이해
 * - first(), last()가 Set에서 유용하지 않은 이유
 * - 집합 연산의 결과가 새로운 Set이라는 점
 */
fun main() {

    /*************** - Set이 왜 필요할까? - ****************/
    // 문서의 카페 방문자 예제

    println("=== MutableList의 문제점 ===")

    // MutableList 사용 시 문제점들
    val visitors = mutableListOf<String>("Vlad", "Vanya", "Liza")
    println("원래 방문자: $visitors")

    // 문제 1: 누구든 내용 변경 가능
    visitors[2] = "Nina"
    println("변경된 방문자: $visitors")  // [Vlad, Vanya, Nina]

    // 문제 2: 실수로 중복 기록 가능
    val duplicateVisitors = mutableListOf<String>("Vlad", "Vanya", "Liza", "Vanya")
    println("중복 기록: $duplicateVisitors")  // [Vlad, Vanya, Liza, Vanya]

    println("\n=== Set의 해결책 ===")

    // Set으로 해결
    val uniqueVisitors = setOf<String>("Vlad", "Vanya", "Liza", "Liza")
    println("Set 사용: $uniqueVisitors")  // [Vlad, Vanya, Liza] - 중복 자동 제거!

    println("\nSet의 장점:")
    println("- 중복 자동 제거")
    println("- 불변이므로 안전함")
    println("- 고유한 요소만 보장")

    /*************** - Set 만들기 - ****************/

    println("\n=== Set 만들기 ===")

    // 타입 명시
    val languages = setOf<String>("English", "Russian", "Italian")
    println("언어들: $languages")

    // 타입 추론 (권장)
    val languagesInferred = setOf("English", "Russian", "Italian")
    println("언어들 (추론): $languagesInferred")

    // 빈 Set
    val numbers = emptySet<Int>()
    println("빈 Set: $numbers")  // []

    // buildSet 사용
    val letters = setOf<Char>('b', 'c')

    val set = buildSet<Char> {
        add('a')
        addAll(letters)
        add('d')
    }
    println("buildSet 결과: $set")  // [a, b, c, d]

    /*************** - Set 기본 속성과 메서드 - ****************/

    println("\n=== Set 기본 속성과 메서드 ===")

    val cafeVisitors = setOf("Andrew", "Mike")

    // 크기와 빈 여부 확인
    println("오늘 카페 방문자 수: ${cafeVisitors.size}")  // 2
    println("카페가 비어있었나요? ${cafeVisitors.isEmpty()}")  // false

    // 포함 여부와 인덱스 확인
    val dailyVisitors = setOf("Paula", "Tanya", "Julia")

    println("\nTanya가 왔나요? ${dailyVisitors.contains("Tanya")}")  // true
    println("Tanya의 인덱스: ${dailyVisitors.indexOf("Tanya")}")    // 1

    // first()와 last() (Set에서는 유용하지 않음)
    val students = setOf("Bob", "Larry")
    println("\n첫 번째 학생: ${students.first()}")  // Bob
    println("마지막 학생: ${students.last()}")      // Larry
    println("주의: Set은 순서가 없으므로 first(), last()는 의미가 제한적!")

    // joinToString으로 문자열 변환
    val visitorsString = dailyVisitors.joinToString()
    println("\n방문자 목록: $visitorsString")  // Paula, Tanya, Julia

    /*************** - Set 고급 메서드 - ****************/

    println("\n=== Set 고급 메서드 ===")

    // containsAll로 부분집합 확인
    val studentsOfAGroup = setOf("Bob", "Larry", "Vlad")
    val studentsInClass = setOf("Vlad")

    println("그룹의 모든 학생이 수업에 참석했나요?")
    println("${studentsInClass.containsAll(studentsOfAGroup)}")  // false

    // 집합 연산 (+, -)
    val productsList1 = setOf("Banana", "Lime", "Strawberry")
    val productsList2 = setOf("Strawberry")

    val unionSet = productsList1 + productsList2
    println("\n합집합: $unionSet")  // [Banana, Lime, Strawberry]

    val differenceSet = productsList1 - productsList2
    println("차집합: $differenceSet")  // [Banana, Lime]

    // MutableList를 Set으로 변환
    val groceries = mutableListOf("Pen", "Pineapple", "Apple", "Super Pen", "Apple", "Pen")
    println("\n원본 리스트: $groceries")
    println("Set 변환: ${groceries.toSet()}")  // [Pen, Pineapple, Apple, Super Pen]

    /*************** - Set 순회하기 - ****************/

    println("\n=== Set 순회하기 ===")

    val partyGuests = setOf("Vlad", "Liza", "Vanya", "Nina")

    println("파티 게스트들에게 인사:")
    for (visitor in partyGuests) {
        println("안녕하세요 $visitor 님!")
    }

    /*************** - 실용적 활용 예제 - ****************/

    println("\n=== 실용적 활용 예제 ===")

    // 태그 관리 시스템
    val articleTags = setOf("코틀린", "프로그래밍", "튜토리얼", "코틀린")  // 중복 자동 제거
    println("게시글 태그: ${articleTags.joinToString(", ")}")

    // 권한 시스템
    val userPermissions = setOf("읽기", "쓰기")
    val adminPermissions = setOf("읽기", "쓰기", "삭제", "관리")

    println("\n권한 확인:")
    println("사용자 권한: ${userPermissions.joinToString()}")
    println("관리자 권한: ${adminPermissions.joinToString()}")

    // 사용자가 모든 기본 권한을 가지고 있는지 확인
    val basicPermissions = setOf("읽기", "쓰기")
    println("사용자가 기본 권한을 모두 가지고 있나: ${userPermissions.containsAll(basicPermissions)}")

    // 고유 ID 관리
    val sessionIds = setOf("user123", "user456", "user789", "user123")  // 중복 제거됨
    println("\n활성 세션 ID들: ${sessionIds.joinToString()}")
    println("활성 세션 수: ${sessionIds.size}")

    // 언어 설정
    val supportedLanguages = setOf("한국어", "영어", "일본어", "중국어")
    val userLanguage = "한국어"

    if (userLanguage in supportedLanguages) {
        println("\n지원되는 언어입니다: $userLanguage")
    } else {
        println("\n지원되지 않는 언어입니다: $userLanguage")
    }

    // 이메일 도메인 관리
    val allowedDomains = setOf("gmail.com", "company.com", "university.edu")
    val userEmail = "user@gmail.com"
    val emailDomain = userEmail.substringAfter("@")

    println("\n이메일 도메인 확인:")
    if (emailDomain in allowedDomains) {
        println("허용된 도메인입니다: $emailDomain")
    } else {
        println("허용되지 않은 도메인입니다: $emailDomain")
    }

    /*************** - Set 집합 연산 심화 - ****************/

    println("\n=== Set 집합 연산 심화 ===")

    val mathStudents = setOf("김철수", "이영희", "박민수", "최수진")
    val scienceStudents = setOf("이영희", "박민수", "정대현", "한미영")

    // 합집합 (둘 중 하나라도 수강하는 학생)
    val allStudents = mathStudents + scienceStudents
    println("수학 또는 과학 수강생: ${allStudents.joinToString()}")

    // 교집합 (두 과목 모두 수강하는 학생) - intersect 사용
    val bothSubjects = mathStudents.intersect(scienceStudents)
    println("수학과 과학 모두 수강: ${bothSubjects.joinToString()}")

    // 차집합 (수학만 수강하는 학생)
    val mathOnly = mathStudents - scienceStudents
    println("수학만 수강: ${mathOnly.joinToString()}")

    // 대칭차집합 (한 과목만 수강하는 학생) - union에서 intersect 빼기
    val onlyOneSubject = (mathStudents union scienceStudents) - (mathStudents intersect scienceStudents)
    println("한 과목만 수강: ${onlyOneSubject.joinToString()}")

    /*************** - Set vs List 비교 - ****************/

    println("\n=== Set vs List 비교 ===")

    // 같은 데이터로 비교
    val listData = listOf("사과", "바나나", "사과", "오렌지", "바나나")
    val setData = setOf("사과", "바나나", "사과", "오렌지", "바나나")

    println("List: $listData")  // 중복 포함, 순서 유지
    println("Set: $setData")    // 중복 제거, 순서 보장 안됨

    println("\nList 특징:")
    println("- 순서 보장: ${listData[0]}")
    println("- 중복 허용: 크기 ${listData.size}")
    println("- 인덱스 접근 가능")

    println("\nSet 특징:")
    println("- 중복 없음: 크기 ${setData.size}")
    println("- 고유성 보장")
    println("- 빠른 포함 여부 확인")

    /*************** - 언제 Set을 사용할까? - ****************/

    println("\n=== 언제 Set을 사용할까? ===")

    println("Set을 사용하는 경우:")
    println("- 중복을 허용하지 않아야 할 때")
    println("- 고유한 요소들만 관리할 때")
    println("- 포함 여부 확인이 주요 작업일 때")
    println("- 집합 연산이 필요할 때")

    println("\n구체적 예시:")
    println("- 사용자 ID 목록")
    println("- 태그나 키워드")
    println("- 권한 목록")
    println("- 방문자 추적")
    println("- 설정 옵션")

    // 실제 사용 사례
    val visitedPages = setOf("/home", "/about", "/contact", "/home", "/about")
    println("\n방문한 페이지 (중복 제거): ${visitedPages.joinToString()}")
    println("고유 페이지 수: ${visitedPages.size}")

    /*************** - 주의사항 - ****************/

    println("\n=== 주의사항 ===")

    val testSet = setOf("A", "B", "C")

    println("Set 사용 시 주의사항:")
    println("1. 순서에 의존하지 말 것")
    println("   - first(): ${testSet.first()} (보장되지 않음)")
    println("   - last(): ${testSet.last()} (보장되지 않음)")

    println("\n2. 중복 제거는 자동:")
    val withDuplicates = setOf(1, 1, 2, 2, 3)
    println("   - 입력: [1, 1, 2, 2, 3]")
    println("   - 결과: $withDuplicates")

    println("\n3. 불변이므로 생성 후 변경 불가:")
    // testSet.add("D")  // 컴파일 오류!
    println("   - 요소 추가/제거 불가")

    println("\n4. 빈 Set 확인:")
    val emptyTestSet = emptySet<String>()
    println("   - 빈 Set: $emptyTestSet")
    println("   - 비어있나: ${emptyTestSet.isEmpty()}")

    /*************** - 정리 - ****************/

    println("\n=== 정리 ===")

    println("Set 핵심 특징:")
    println("1. 중복 없는 고유 요소만 저장")
    println("2. 순서가 정의되지 않음")
    println("3. 불변 컬렉션")
    println("4. 빠른 포함 여부 확인")

    println("\n주요 사용법:")
    println("- 생성: setOf(요소들)")
    println("- 확인: contains(), containsAll()")
    println("- 변환: toSet()")
    println("- 연산: +, -, intersect(), union()")
    println("- 순회: for (item in set)")

    println("\n언제 사용할까:")
    println("- 고유성이 중요한 데이터")
    println("- 집합 연산이 필요한 경우")
    println("- 중복 제거가 목적인 경우")
    println("- 포함 여부 확인이 빈번한 경우")
}