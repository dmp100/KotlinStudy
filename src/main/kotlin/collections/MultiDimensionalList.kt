package collections

/**
 * 날짜: 2025-09-15
 * 주제: 다차원 리스트 (Multi-dimensional List)
 *
 * 배운 내용:
 * - 다차원 리스트는 "리스트의 리스트"
 * - 2차원 리스트로 표나 행렬 표현 가능
 * - 각 중첩 리스트는 크기가 달라도 됨
 * - 인덱스 접근: [행][열] 형태로 두 개 인덱스 사용
 * - 다양한 타입의 중첩 리스트 생성 가능
 * - joinToString()은 개별 중첩 리스트에 적용
 * - 3차원 이상도 가능 (인덱스 개수 = 차원 수)
 *
 * 어려웠던 점:
 * - 2차원 리스트의 시각적 이해
 * - 인덱스 순서와 접근 방법
 * - 서로 다른 크기의 중첩 리스트
 * - 3차원 이상의 개념적 이해
 */
fun main() {

    /*************** - 다차원 리스트란? - ****************/

    println("=== 다차원 리스트란? ===")

    println("다차원 리스트 = 리스트의 리스트")
    println("활용 예시:")
    println("- 극장 좌석 (행, 열)")
    println("- 게임 지도 좌표 (x, y)")
    println("- 수학 행렬")
    println("- 주차장 위치 (층, 행, 번호)")

    /*************** - 2차원 리스트 만들기 - ****************/
    // 문서의 3x4 0으로 채운 예제

    println("\n=== 2차원 리스트 만들기 ===")

    // 3행 4열의 0으로 채운 리스트
    val mutList2D = mutableListOf(
        mutableListOf<Int>(0, 0, 0, 0),
        mutableListOf<Int>(0, 0, 0, 0),
        mutableListOf<Int>(0, 0, 0, 0)
    )

    println("3x4 표 (0으로 채움):")
    for (row in mutList2D) {
        println(row.joinToString(" "))
    }

    // 시각적 표현
    println("\n시각적 표현:")
    println("0 0 0 0")
    println("0 0 0 0")
    println("0 0 0 0")

    // 각 행의 크기가 다른 예제
    val irregularList = mutableListOf(
        mutableListOf<Int>(0),
        mutableListOf<Int>(1, 2),
        mutableListOf<Int>(3, 4, 5)
    )

    println("\n크기가 다른 행들:")
    for (i in irregularList.indices) {
        println("${i}행: ${irregularList[i].joinToString(" ")}")
    }

    /*************** - 요소 접근하기 - ****************/
    // 문서의 인덱스 접근 예제

    println("\n=== 요소 접근하기 ===")

    val sampleList = mutableListOf(
        mutableListOf<Int>(0, 1, 2),   // [0]행
        mutableListOf<Int>(3, 4, 5)    // [1]행
    )

    println("샘플 리스트:")
    println("0행: ${sampleList[0].joinToString(" ")}")  // 0 1 2
    println("1행: ${sampleList[1].joinToString(" ")}")  // 3 4 5

    println("\n개별 요소 접근:")
    println("sampleList[0][0] = ${sampleList[0][0]}")  // 0 (첫 행, 첫 열)
    println("sampleList[0][1] = ${sampleList[0][1]}")  // 1 (첫 행, 둘째 열)
    println("sampleList[1][2] = ${sampleList[1][2]}")  // 5 (둘째 행, 셋째 열)

    println("\n모든 요소 출력:")
    print("${sampleList[0][0]} ")  // 0
    print("${sampleList[0][1]} ")  // 1
    print("${sampleList[0][2]} ")  // 2
    print("${sampleList[1][0]} ")  // 3
    print("${sampleList[1][1]} ")  // 4
    print("${sampleList[1][2]} ")  // 5
    println()

    /*************** - 다양한 타입의 2차원 리스트 - ****************/

    println("\n=== 다양한 타입의 2차원 리스트 ===")

    // 문자열 리스트
    val mutListOfString2D = mutableListOf(
        mutableListOf<String>("to", "be", "or"),
        mutableListOf<String>("not", "to", "be")
    )

    println("문자열 2차원 리스트:")
    for (row in mutListOfString2D) {
        println(row.joinToString(" "))
    }

    // 문자 리스트
    val mutListOfChar2D = mutableListOf(
        mutableListOf<Char>('A', 'R', 'R'),
        mutableListOf<Char>('A', 'Y', 'S')
    )

    println("\n문자 2차원 리스트:")
    for (row in mutListOfChar2D) {
        println(row.joinToString(" "))
    }

    // 시각적 표현
    println("\n시각적 표현:")
    println("A R R")
    println("A Y S")

    // 다른 타입 혼합 (주의: 실제로는 권장하지 않음)
    println("\n서로 다른 타입 혼합 예제:")
    println("첫 번째 행: 문자열")
    println("두 번째 행: 숫자")

    /*************** - 2차원 리스트 특별 기능들 - ****************/

    println("\n=== 2차원 리스트 특별 기능들 ===")

    // joinToString 사용
    val arrayString = mutableListOf(
        mutableListOf<String>("A", "R", "R", "A", "Y")
    )

    println("특정 행만 문자열로:")
    println(arrayString[0].joinToString())  // A, R, R, A, Y

    // 전체 리스트 출력
    val charList2D = mutableListOf(
        mutableListOf<Char>('k'),
        mutableListOf<Char>('o', 't'),
        mutableListOf<Char>('l', 'i', 'n')
    )

    println("\n전체 리스트 출력:")
    println(charList2D)  // [[k], [o, t], [l, i, n]]

    /*************** - 3차원 리스트 - ****************/
    // 문서의 3차원 예제

    println("\n=== 3차원 리스트 ===")

    val mutList3D = mutableListOf(
        mutableListOf(mutableListOf<Int>(0, 1), mutableListOf<Int>(2, 3)),
        mutableListOf(mutableListOf<Int>(4, 5), mutableListOf<Int>(6, 7))
    )

    println("3차원 리스트:")
    println(mutList3D)  // [[[0, 1], [2, 3]], [[4, 5], [6, 7]]]

    println("\n3차원 인덱스 접근:")
    println("mutList3D[0][0][1] = ${mutList3D[0][0][1]}")  // 1
    println("mutList3D[1][0][1] = ${mutList3D[1][0][1]}")  // 5
    println("mutList3D[1][1][1] = ${mutList3D[1][1][1]}")  // 7

    println("\n3차원 리스트 구조:")
    println("층 0:")
    println("  [0, 1]  [2, 3]")
    println("층 1:")
    println("  [4, 5]  [6, 7]")

    /*************** - 실용적 활용 예제 - ****************/

    println("\n=== 실용적 활용 예제 ===")

    // 교실 좌석표
    val classroom = mutableListOf(
        mutableListOf("김철수", "이영희", "박민수"),
        mutableListOf("최수진", "정대현", "한미영"),
        mutableListOf("장현우", "오세진", "임지은")
    )

    println("교실 좌석표:")
    for (i in classroom.indices) {
        println("${i + 1}행: ${classroom[i].joinToString("  |  ")}")
    }

    println("\n특정 좌석 확인:")
    println("2행 3열: ${classroom[1][2]}")  // 한미영 (인덱스는 0부터)

    // 게임 보드 (틱택토)
    val ticTacToe = mutableListOf(
        mutableListOf("X", "O", "X"),
        mutableListOf("O", "X", "O"),
        mutableListOf("X", "O", "X")
    )

    println("\n틱택토 게임판:")
    for (row in ticTacToe) {
        println(row.joinToString(" | "))
    }

    // 성적표 (학생 x 과목)
    val grades = mutableListOf(
        mutableListOf(85, 92, 78),  // 학생1: 국어, 수학, 영어
        mutableListOf(90, 88, 95),  // 학생2
        mutableListOf(77, 85, 82)   // 학생3
    )

    val subjects = listOf("국어", "수학", "영어")

    println("\n성적표:")
    println("     ${subjects.joinToString("  ")}")
    for (i in grades.indices) {
        println("학생${i + 1}: ${grades[i].joinToString("   ")}")
    }

    println("\n개별 성적 조회:")
    println("학생2의 수학 점수: ${grades[1][1]}")  // 88

    /*************** - 2차원 리스트 조작하기 - ****************/

    println("\n=== 2차원 리스트 조작하기 ===")

    val matrix = mutableListOf(
        mutableListOf(1, 2, 3),
        mutableListOf(4, 5, 6),
        mutableListOf(7, 8, 9)
    )

    println("원본 행렬:")
    for (row in matrix) {
        println(row.joinToString(" "))
    }

    // 특정 요소 변경
    matrix[1][1] = 99  // 가운데 값 변경

    println("\n가운데 값 변경 후:")
    for (row in matrix) {
        println(row.joinToString(" "))
    }

    // 행 추가
    matrix.add(mutableListOf(10, 11, 12))

    println("\n행 추가 후:")
    for (row in matrix) {
        println(row.joinToString(" "))
    }

    // 특정 행의 열 추가
    matrix[0].add(13)

    println("\n첫 번째 행에 열 추가:")
    for (row in matrix) {
        println(row.joinToString(" "))
    }

    /*************** - 2차원 리스트 순회하기 - ****************/

    println("\n=== 2차원 리스트 순회하기 ===")

    val numbers2D = mutableListOf(
        mutableListOf(1, 2, 3),
        mutableListOf(4, 5, 6)
    )

    // 방법 1: 요소 직접 접근
    println("방법 1: 요소 직접 접근")
    for (row in numbers2D) {
        for (element in row) {
            print("$element ")
        }
        println()
    }

    // 방법 2: 인덱스 사용
    println("\n방법 2: 인덱스 사용")
    for (i in numbers2D.indices) {
        for (j in numbers2D[i].indices) {
            print("(${i},${j}):${numbers2D[i][j]} ")
        }
        println()
    }

    // 방법 3: 인덱스와 값 함께
    println("\n방법 3: 좌표와 함께")
    for (i in numbers2D.indices) {
        for (j in numbers2D[i].indices) {
            println("위치 [$i][$j] = ${numbers2D[i][j]}")
        }
    }

    /*************** - 주의사항과 팁 - ****************/

    println("\n=== 주의사항과 팁 ===")

    // 빈 2차원 리스트 만들기
    val empty2D = mutableListOf<MutableList<Int>>()

    // 동적으로 행 추가
    empty2D.add(mutableListOf(1, 2))
    empty2D.add(mutableListOf(3, 4, 5))

    println("동적으로 만든 2차원 리스트:")
    for (row in empty2D) {
        println(row.joinToString(" "))
    }

    // 안전한 접근
    val testMatrix = mutableListOf(
        mutableListOf(1, 2),
        mutableListOf(3, 4, 5)
    )

    fun safeAccess(matrix: MutableList<MutableList<Int>>, row: Int, col: Int): Int? {
        return if (row in 0 until matrix.size && col in 0 until matrix[row].size) {
            matrix[row][col]
        } else {
            null
        }
    }

    println("\n안전한 접근:")
    println("(0,1): ${safeAccess(testMatrix, 0, 1)}")  // 2
    println("(1,2): ${safeAccess(testMatrix, 1, 2)}")  // 5
    println("(2,0): ${safeAccess(testMatrix, 2, 0)}")  // null (범위 초과)

    /*************** - 정리 - ****************/

    println("\n=== 정리 ===")

    println("다차원 리스트 핵심 개념:")
    println("1. 다차원 리스트 = 리스트의 리스트")
    println("2. 접근: [행][열] 형태로 인덱스 사용")
    println("3. 각 행의 크기는 달라도 됨")
    println("4. 다양한 타입 사용 가능")
    println("5. 차원 수 = 필요한 인덱스 개수")

    println("\n활용 분야:")
    println("- 표와 행렬 데이터")
    println("- 게임 보드와 지도")
    println("- 좌석 배치")
    println("- 이미지 픽셀 데이터")
    println("- 수학적 계산")

    println("\n주의사항:")
    println("- 인덱스는 0부터 시작")
    println("- 행과 열 크기 확인 필요")
    println("- 범위 초과 접근 주의")
    println("- 메모리 사용량 고려")
}