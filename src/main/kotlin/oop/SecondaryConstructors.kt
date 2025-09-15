package oop

/**
 * 날짜: 2025-09-15
 * 주제: SecondaryConstructors
 *
 * 배운 내용:
 * - Secondary constructor는 보조 생성자로, 클래스에 여러 종류의 생성자를 만들 수 있게 해줌
 * - primary constructor와 함께 쓰거나 단독으로 쓸 수 있음
 * - this 키워드를 이용해 같은 클래스의 다른 생성자를 호출 가능
 * - initializer(init) 블록은 primary constructor와 함께 실행됨
 */

class Size(val width: Int, val height: Int) {
    // primary constructor에서 width, height 값을 초기화

    var area: Int = width * height
    // area 속성은 width * height로 계산되어 초기화됨

    init {
        // init 블록은 primary constructor 실행 직후 호출됨
        println("Object with area equal to $area is created")
    }

    // secondary constructor: primary constructor와 함께 사용
    constructor(width: Int, height: Int, outerSize: Size) : this(width, height) {
        // this(width, height)로 primary constructor를 먼저 호출
        // 이렇게 해야 secondary constructor 코드 실행 전에 속성 초기화가 완료됨

        // outerSize 객체의 area 값을 secondary constructor 로직으로 수정
        outerSize.area -= this.area
        println("Updated outer object's area is equal to ${outerSize.area}")
    }
}

fun main() {
    println("SecondaryConstructors 학습 시작!")

    // primary constructor로 객체 생성
    val outerObject = Size(5, 8)
    // 실행 순서:
    // 1) width, height 속성 초기화
    // 2) area 계산
    // 3) init 블록 실행 -> "Object with area equal to 40 is created" 출력

    // secondary constructor로 객체 생성
    val innerObject = Size(2, 3, outerObject)
    // 실행 순서:
    // 1) secondary constructor의 this(width, height) 호출 -> primary constructor 실행
    // 2) width, height 속성 초기화
    // 3) area 계산
    // 4) init 블록 실행 -> "Object with area equal to 6 is created" 출력
    // 5) secondary constructor 본문 실행 -> outerObject.area 수정 및 출력
    // 결과: "Updated outer object's area is equal to 34"
}
