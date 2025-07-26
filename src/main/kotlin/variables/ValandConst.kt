package variables

/**
 * 날짜: 2025-07-07
 * 주제: ValandConst
 * 
 * 배운 내용:
 * - 상수 변수 : 고정된 값
 * - const, val (var은 안됌 값을 바꿀 수 있는 mutable variable)
 * - val은 불변 변수가 아님, "변수 교체 금지"이지, "내용 변경 금지"가 아니다 라는걸 명심.
 * - 한마디로 자물쇠 걸린 상자 같은 느낌임.
 * - Kotlin의 `val` 변수를 Java의 `final` 변수와 유사하게 생각하는 것
 * - Const : 전역번수 설정, 기본유형 변수만 적용 가능. 컴파일 시점에 결정.
 * 어려웠던 점:
 * - 
 */

    // **컴파일 시간 상수(compile-time constant)**를 선언하기 위해
    // `val` 키워드 앞에 사용되는 `const` **수정자(modifier)**도 있습니다.

    // const` 변수의 값은 컴파일 시간에 알려지며 런타임에 변경되지 않을 것입니다:
    // 전역변수에서만 사용가능
    const val MY_STRING = "This is a constant string"

    // 실행전에 값을 알 수 없음, 상수아님 -> 에러
    // 반대로 값을 알 수 있고 상수의 조건
    //const val MY_STRING2 = readln() // 상수 String이 아님!!!

    // 기본유형 변수에만 적용 가능
    const val CONST_INT = 127
    const val CONST_DOUBLE = 3.14
    const val CONST_CHAR = 'c'
    const val CONST_STRING = "I am constant"
    //const val CONST_ARRAY = arrayOf(1, 2, 3) // 오류: 기본 타입과 문자열만 허용됨

    //모든 함수 외부의 최상위 레벨에서 선언
    const val MY_INT_1 = 1024 // 올바른 줄


fun main() {

    // const val MY_INT_2 = 2048 // 오류: 'const' 수정자는 '지역 변수'에 적용할 수 없음


    val pi = 3.1415
    val helloMsg = "Hello"

    println(pi)       // 3.1415
    println(helloMsg) // Hello

    val pi2 = 3.1415
    //pi2 = 3.1416 // 오류 발생 줄 - val은 수정 X 접근 가능


    val boolFalse: Boolean
    //println(boolFalse) // 오류 발생 줄 - 값을 할당받기 전에 사용되면 컴파일러도 오류를 발생

    val boolFalse2: Boolean // 초기화되지 않음
    boolFalse2 = false      // 초기화됨 - 값을 할당하면 괜찮음.
    println(boolFalse2)     // 여기서 오류 없음


    val count = 10  // `val` 변수의 값은 아무런 제한 없이
    var cnt = count // `var` 변수에 재할당될 수 있으며,
    cnt = 20 // 여기서 오류 없음, cnt는 상수가 아님 - 일반 변수의 값은 필요한 만큼 여러 번 변경가능

    // val은 불변이 아님, 변수 재할당만 불가능임
    // mutable을 통해 객체 내용 변경도 가능
    /**
     * 불변(immutable)은 초기화된 후에 변경할 수 없는 객체 또는 변수의 유형입니다.
     * 데이터의 무결성을 보장하고 의도하지 않은 수정을 방지하는 데 도움
     * e.g 책의 페이지 목록
     *
     * 가변(mutable) 컬렉션은 저장된 항목을 추가, 제거 또는 업데이트하는 등의 변경을 허용합니다
     */
    // 리스트 생성
    val myMutableList = mutableListOf(1, 2, 3, 4, 5)
    // 리스트 업데이트 시도 - 변수 재할당이라 불가능
    //myMutableList = mutableListOf(1, 2, 3, 4, 5, 6) // 오류 발생 줄

    // 새 요소 추가
    myMutableList.add(6)   // 작동함
    // 리스트 출력 - 변수가 아니라, 리스트를 바꿔버림.
    println(myMutableList) // [1, 2, 3, 4, 5, 6]

    // Kotlin의 `val` 변수를 Java의 `final` 변수와 유사하게 생각하는 것
    // 내부 상태를 안전하고 제어된 형식으로 노출할 때 좋음.


    var a = 1
    val b = 2
    val c = 3

    a += b * c
    // 평소에 val 쓰다가 위와같이 필요 시, var 사용
    // 가변 변수 최소화 작성 방식임.

    val numberOfWheels: Int

    val isConnectionAvailable: Boolean

    val userFirstName: String
    // 카멜케이스 사용

    //const val MAX_USER_COUNT = 50

    //const val COMPANY_NAME = "TechCorp"

    //const val VERSION_CODE = 3
    // 대문자 표기, 정적 변경 X
}

