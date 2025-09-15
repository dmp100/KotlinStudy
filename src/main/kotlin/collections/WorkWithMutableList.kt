package collections

/**
 * 날짜: 2025-09-15
 * 주제: MutableList 활용법
 *
 * 배운 내용:
 * - joinToString()으로 리스트를 문자열로 출력
 * - + 연산자로 리스트 연결
 * - ==, != 연산자로 리스트 비교
 * - val/var과 상관없이 요소 내용 변경 가능
 * - add, remove, clear 등으로 리스트 내용 변경
 * - += 연산자로 요소나 리스트 추가
 * - toMutableList()로 리스트 복사
 * - isEmpty(), subList(), indexOf() 등 유용한 함수들
 * - minOrNull(), maxOrNull(), sum(), sorted() 등 분석 함수들
 *
 * 어려웠던 점:
 * - val로 선언해도 내용 변경이 가능한 이유
 * - 리스트 연결과 추가의 차이점
 * - subList의 범위 (to는 포함되지 않음)
 * - sorted()와 sortedDescending()의 동작 방식
 */
fun main() {

    /*************** - 리스트 출력하기 - ****************/
    // joinToString() 함수 사용법

    println("=== 리스트 출력하기 ===")

    val southernCross = mutableListOf("Acrux", "Gacrux", "Imai", "Mimosa")

    // 기본 출력 (쉼표로 구분)
    println(southernCross.joinToString())  // Acrux, Gacrux, Imai, Mimosa

    // 다른 구분자 사용
    println(southernCross.joinToString(" -> "))  // Acrux -> Gacrux -> Imai -> Mimosa

    // 다양한 구분자 예제
    println(southernCross.joinToString(" | "))   // Acrux | Gacrux | Imai | Mimosa
    println(southernCross.joinToString(", ", "[", "]"))  // [Acrux, Gacrux, Imai, Mimosa]

    /*************** - 여러 리스트 다루기 - ****************/

    println("\n=== 여러 리스트 다루기 ===")

    // 리스트 연결하기
    val stars1 = mutableListOf("Ginan", "Mu Crucis")
    val newList = southernCross + stars1
    println("연결된 리스트: ${newList.joinToString()}")  // Acrux, Gacrux, Imai, Mimosa, Ginan, Mu Crucis

    // 리스트 비교하기
    val firstList = mutableListOf("result", "is", "true")
    val secondList = mutableListOf("result", "is", "true")
    val thirdList = mutableListOf("result")

    println("\n리스트 비교:")
    println("첫 번째와 두 번째 같나? ${firstList == secondList}")  // true
    println("첫 번째와 세 번째 같나? ${firstList == thirdList}")   // false
    println("두 번째와 세 번째 다른가? ${secondList != thirdList}")  // true

    /*************** - val vs var과 내용 변경 - ****************/

    println("\n=== val/var과 내용 변경 ===")

    // val로 선언해도 내용 변경 가능!
    val valList = mutableListOf("Acrux", "Gacrux", "Imai", "Mimosa")
    var varList = mutableListOf("Ginan", "Mu Crucis")

    println("변경 전:")
    println("val 리스트: $valList")
    println("var 리스트: $varList")

    // 둘 다 내용 변경 가능
    valList[1] = "star"
    varList[1] = "star"

    println("\n변경 후:")
    println("val 리스트: ${valList[1]}")  // star
    println("var 리스트: ${varList[1]}")  // star

    println("\n설명: val은 변수 재할당을 막지만, 리스트 내용 변경은 허용!")

    /*************** - 리스트 내용 변경하기 - ****************/

    println("\n=== 리스트 내용 변경하기 ===")

    val stars = mutableListOf("Acrux", "Gacrux", "Imai", "Mimosa")
    val planets = mutableListOf("Ginan", "Mu Crucis")
    val names = mutableListOf("Jack", "John", "Katie")
    val food = mutableListOf("Bread", "Cheese", "Meat")
    val fruits = mutableListOf("Apple", "Banana", "Grape", "Mango")

    println("변경 전:")
    println("별들: ${stars.joinToString()}")
    println("행성들: ${planets.joinToString()}")
    println("이름들: ${names.joinToString()}")
    println("음식들: ${food.joinToString()}")

    // 요소 제거
    stars.removeAt(0)        // 첫 번째 제거
    stars.remove("Mimosa")   // "Mimosa" 제거

    // 요소 추가
    planets.add("New star")           // 끝에 추가
    planets.add(0, "First star")      // 첫 번째 위치에 추가

    // 모든 요소 제거
    names.clear()

    // 다른 리스트 전체 추가
    food.addAll(fruits)

    println("\n변경 후:")
    println("별들: ${stars.joinToString()}")     // Gacrux, Imai
    println("행성들: ${planets.joinToString()}") // First star, Ginan, Mu Crucis, New star
    println("이름들: $names")                    // []
    println("음식들: ${food.joinToString()}")    // Bread, Cheese, Meat, Apple, Banana, Grape, Mango

    /*************** - += 연산자 사용하기 - ****************/

    println("\n=== += 연산자 사용하기 ===")

    val vowels = mutableListOf('a', 'o', 'i', 'e', 'u')
    val intList1 = mutableListOf(1, 2, 3, 4, 5)
    val intList2 = mutableListOf(5, 4, 3, 2, 1)

    println("추가 전:")
    println("모음들: $vowels")
    println("숫자1: $intList1")

    // 단일 요소 추가
    vowels += 'y'

    // 전체 리스트 추가
    intList1 += intList2

    println("\n추가 후:")
    println("모음들: $vowels")   // [a, o, i, e, u, y]
    println("숫자1: $intList1")  // [1, 2, 3, 4, 5, 5, 4, 3, 2, 1]

    /*************** - 리스트 복사하기 - ****************/

    println("\n=== 리스트 복사하기 ===")

    val originalList = mutableListOf(1, 2, 3, 4, 5)

    // 방법 1: toMutableList() 사용 (권장)
    val copyList1 = originalList.toMutableList()

    // 방법 2: 수동으로 복사
    val copyList2 = mutableListOf<Int>()
    copyList2.addAll(originalList)

    println("원본: $originalList")
    println("복사본1: $copyList1")
    println("복사본2: $copyList2")

    // 복사본 변경해도 원본에 영향 없음
    copyList1[0] = 999
    println("\n복사본1 변경 후:")
    println("원본: $originalList")      // [1, 2, 3, 4, 5] (변경되지 않음)
    println("복사본1: $copyList1")      // [999, 2, 3, 4, 5]

    /*************** - 유용한 함수들 - ****************/

    println("\n=== 유용한 함수들 ===")

    val numbers = mutableListOf(1, 2, 3, 4, 5)
    val vowelsChar = mutableListOf('e', 'a', 'y', 'i', 'u', 'o')

    // 빈 리스트 확인
    println("numbers가 비어있나? ${numbers.isEmpty()}")        // false
    println("numbers가 비어있지 않나? ${numbers.isNotEmpty()}")  // true

    // 부분 리스트 만들기 (subList)
    var sublist = mutableListOf<Int>()
    if (numbers.isNotEmpty() && numbers.size >= 4) {
        sublist = numbers.subList(1, 4)  // 인덱스 1부터 3까지 (4는 포함안됨)
    }
    println("부분 리스트 (1~3): $sublist")  // [2, 3, 4]

    // 요소 위치 찾기
    if (5 in numbers) {
        println("5의 위치: ${numbers.indexOf(5)}")  // 4
    }
    println("7의 위치: ${numbers.indexOf(7)}")      // -1 (없음)

    // 최솟값, 최댓값, 합계
    println("\n숫자 분석:")
    println("최솟값: ${numbers.minOrNull()}")  // 1
    println("최댓값: ${numbers.maxOrNull()}")  // 5
    println("합계: ${numbers.sum()}")          // 15

    // 정렬
    println("\n정렬:")
    println("모음 오름차순: ${vowelsChar.sorted()}")           // [a, e, i, o, u, y]
    println("모음 내림차순: ${vowelsChar.sortedDescending()}")  // [y, u, o, i, e, a]

    /*************** - 실용적 활용 예제 - ****************/

    println("\n=== 실용적 활용 예제 ===")

    // 학생 성적 관리
    val studentScores = mutableListOf(85, 92, 78, 96, 88, 74, 91)

    println("전체 성적: ${studentScores.joinToString()}")
    println("학생 수: ${studentScores.size}")
    println("평균: ${"%.1f".format(studentScores.sum().toDouble() / studentScores.size)}")
    println("최고점: ${studentScores.maxOrNull()}")
    println("최저점: ${studentScores.minOrNull()}")

    // 합격자만 뽑기 (80점 이상)
    val passedScores = studentScores.filter { it >= 80 }.toMutableList()
    println("합격 점수들: ${passedScores.joinToString()}")

    // 성적 순으로 정렬
    val sortedScores = studentScores.sortedDescending()
    println("성적 순위: ${sortedScores.joinToString(" > ")}")

    // 장보기 목록 관리
    val groceryList = mutableListOf("우유", "빵", "계란")
    val extraItems = mutableListOf("사과", "바나나")

    println("\n장보기 목록:")
    println("기본 목록: ${groceryList.joinToString(" | ")}")

    // 추가 항목들 넣기
    groceryList += "치즈"
    groceryList.addAll(extraItems)

    println("완성된 목록: ${groceryList.joinToString(" | ")}")

    // 구매 완료 처리
    groceryList.remove("우유")
    groceryList.removeAt(0)  // 첫 번째 항목 구매 완료

    println("남은 목록: ${groceryList.joinToString(" | ")}")

    // 단어 게임
    val words = mutableListOf("kotlin", "programming", "fun", "easy")

    println("\n단어 게임:")
    println("원본 단어들: ${words.joinToString()}")

    // 길이 순으로 정렬
    val sortedByLength = words.sortedBy { it.length }
    println("길이 순: ${sortedByLength.joinToString()}")

    // 알파벳 순으로 정렬
    println("알파벳 순: ${words.sorted().joinToString()}")

    // 가장 긴 단어와 짧은 단어
    val longestWord = words.maxByOrNull { it.length }
    val shortestWord = words.minByOrNull { it.length }
    println("가장 긴 단어: $longestWord")
    println("가장 짧은 단어: $shortestWord")

    /*************** - 주의사항과 팁 - ****************/

    println("\n=== 주의사항과 팁 ===")

    val testList = mutableListOf(1, 2, 3, 4, 5)

    // subList 주의사항
    println("subList 주의사항:")
    println("원본: $testList")
    println("subList(1, 4): ${testList.subList(1, 4)}")  // [2, 3, 4] - 4번 인덱스는 포함 안됨
    println("subList(0, 2): ${testList.subList(0, 2)}")  // [1, 2] - 2번 인덱스는 포함 안됨

    // 안전한 접근
    println("\n안전한 접근:")
    val emptyList = mutableListOf<Int>()
    println("빈 리스트의 최댓값: ${emptyList.maxOrNull()}")  // null (오류 없음)

    // 리스트 비교 주의사항
    val list1 = mutableListOf(1, 2, 3)
    val list2 = mutableListOf(3, 2, 1)
    println("\n순서가 다른 리스트:")
    println("list1: $list1")
    println("list2: $list2")
    println("같나? ${list1 == list2}")  // false - 순서도 같아야 true!

    /*************** - 정리 - ****************/

    println("\n=== 정리 ===")

    println("MutableList 활용 함수들:")
    println("📤 출력: joinToString()")
    println("🔗 연결: + 연산자, addAll()")
    println("⚖️ 비교: ==, != 연산자")
    println("➕ 추가: add(), += 연산자")
    println("➖ 제거: remove(), removeAt(), clear()")
    println("📋 복사: toMutableList()")
    println("🔍 검색: indexOf(), contains()")
    println("📊 분석: minOrNull(), maxOrNull(), sum()")
    println("📈 정렬: sorted(), sortedDescending()")
    println("✂️ 부분: subList()")

    println("\n기억할 점:")
    println("• val로 선언해도 리스트 내용은 변경 가능")
    println("• 리스트 비교 시 순서도 중요함")
    println("• subList(from, to)에서 to는 포함되지 않음")
    println("• 빈 리스트 처리할 때는 null 체크 함수 사용")
    println("• += 는 add()의 간편한 형태")
}