package operators

/**
 * 날짜: 2025-08-21
 * 주제: ComparingNumRelOper
 * 
 * 배운 내용:
 * -     // 관계 연산자: 값들 사이의 관계를 파악하는 도구 - 부울 값 리턴
 *
 *     // == (같음): 두 값이 정확히 동일한지 확인합니다
 *     // != (같지 않음): 두 값이 서로 다른지 확인합니다
 *     // > (초과): 왼쪽 값이 오른쪽 값보다 큰지 확인합니다
 *     // < (미만): 왼쪽 값이 오른쪽 값보다 작은지 확인합니다
 *     // >= (이상): 왼쪽 값이 오른쪽 값보다 크거나 같은지 확인합니다
 *     // <= (이하): 왼쪽 값이 오른쪽 값보다 작거나 같은지 확인합니다
 *
 * - // 산술 연산자 먼저 계산 후, 관계 연산자 계산
 * - // 타입간 비교는 크기비교만 가능.
 * 어려웠던 점:
 * - 
 */
fun main() {

    // 관계 연산자: 값들 사이의 관계를 파악하는 도구 - 부울 값 리턴

    // == (같음): 두 값이 정확히 동일한지 확인합니다
    // != (같지 않음): 두 값이 서로 다른지 확인합니다
    // > (초과): 왼쪽 값이 오른쪽 값보다 큰지 확인합니다
    // < (미만): 왼쪽 값이 오른쪽 값보다 작은지 확인합니다
    // >= (이상): 왼쪽 값이 오른쪽 값보다 크거나 같은지 확인합니다
    // <= (이하): 왼쪽 값이 오른쪽 값보다 작거나 같은지 확인합니다

    val myScore = 85
    val passingScore = 60
    val perfectScore = 100
    val friendScore = 85

    // 다양한 비교 예시
    val didIPass = myScore >= passingScore        // true (85 >= 60)
    val isPerfect = myScore == perfectScore       // false (85 == 100)
    val betterThanFriend = myScore > friendScore  // false (85 > 85)
    val sameAsFriend = myScore == friendScore     // true (85 == 85)
    val notPerfect = myScore != perfectScore      // true (85 != 100)

    // 산술 연산자, 관계 연산자 우선순위
    val number = 1000
    val result = number + 10 > number + 9
    // 1. number + 10 → 1000 + 10 → 1010 , number + 9 → 1000 + 9 → 1009
    // 2. 1010 > 1009

    // 타입간 비교의 제약 사항
    val intNumber: Int = 42
    val longNumber: Long = 42L

    // 크기 비교는 가능합니다
    val comparison = intNumber < longNumber  // 허용됨
    // 하지만 동등성 비교는 불가능합니다
    // val equality = intNumber == longNumber  // 컴파일 오류!
    // 타입을 맞춰서 비교해야 합니다
    val safeEquality = intNumber == longNumber.toInt()  // 허용됨

    // 복잡한 조건 만들기
    // 잘못된 방법 (컴파일 오류) - 관계 연산자는 부울 값을 반환하기 때문, ( true랑 200이랑 비교 X)
    // val inRange = 100 < number < 200
    // 올바른 방법
    val number1 = 150
    val inRange = number1 > 100 && number1 < 200  // true

}