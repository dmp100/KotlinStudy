package literals

/**
 * 날짜: 2025-06-13
 * 주제: 변수(variable)란 ?
 * 1. 문자열(string), 숫자(number), 또는 다른 것이 될 수 있는 값(value)을 저장하는 저장소
 * 2. 이름(name)또는 식별자(identifier)을 가짐
 * 3. 이름을 통해 값에 접근 가능
 *
 * 배운 내용:
 * - var : mutable variable, 여러번 변경 가능, 같은 자료형끼리만 교체가능
 * - val : value, read-only variable(named value), 초기화 후 변경 불가
 * - const : 컴파일 시간에 알려진 상수, val과 함께 사용
 *
 * Keyword : 언어에서 특별한 의미를 가진 예약어, 프로그래머가 변경 불가
 * ex) fun(함수정의), var(변수정의), val(상수정의) 등
 *
 * 어려웠던 점:
 * - 명시적, 암시적 타입이 메모리와 큰 연관성이 있는지 궁금했으나
 *   성능 측면에서 별 문제없다는 것을 알았다.
 */

fun main() {
    // 변수 정의 방법 : val, var 키워드를 통해 정의

    // 불변 변수 val (읽기 전용)
    val a = 10

    // 가변 변수 var (값 변경 가능)
    var b = 20

    // 명시적 타입 선언 (코드 가독성 향상)
    val 정수: Int = 25
    val 실수: Double = 3.14
    val 문자: Char = 'A'
    val 참거짓: Boolean = true
    val 문자열: String = "안녕"

    var 정수2: Int = 52
    var 실수2: Double = 4.13
    var 문자2: Char = 'F'
    var 참거짓2: Boolean = false
    var 문자열2: String = "잘가"

    // 값 접근 및 출력
    println("정수 값: $정수")

    // var 변수는 재할당 가능
    정수2 = 10 // 52에서 10으로 재할당
    println("변경된 정수2 값: $정수2")

    // 타입 불일치 오류 예시 (주석 처리)
    // 실수2 = "안녕하세요" // Error: Type mismatch, 같은 타입으로만 재할당 가능
}