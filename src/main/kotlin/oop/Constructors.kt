package oop

/**
 * 날짜: 2025-09-15
 * 주제: Constructors
 *
 * 배운 내용:
 * - 생성자(Constructor)란? → 객체가 만들어질 때 맨 처음 실행되는 특별한 함수
 * - 생성자의 역할은 "객체의 속성을 처음 상태로 세팅"하는 것
 * - Kotlin에서 생성자는 클래스 이름 옆의 괄호 안에 정의한다
 * - 생성자를 따로 만들지 않아도 컴파일러가 기본 생성자(Default constructor)를 자동으로 넣어준다
 * - Primary constructor(주 생성자): 클래스 이름 옆 괄호에 쓰는 가장 간단한 형태
 * - 생성자 매개변수에 val/var 키워드를 붙이면 자동으로 속성이 된다
 * - 매개변수에 기본값(Default value)을 줄 수 있다
 * - 객체를 만들 때 인자의 순서를 바꾸고 싶으면 이름 있는 인자(Named arguments)를 사용한다
 * - init 블록: 생성자가 끝난 뒤 자동으로 실행되는 초기화 코드 블록
 *
 * 어려웠던 점:
 * - 생성자와 일반 함수의 차이가 처음엔 헷갈렸음 (→ 생성자는 "객체가 생기는 순간 1번만 호출"되는 특별한 함수)
 * - init 블록과 속성 초기화가 실행되는 순서를 눈으로 확인해봐야 이해가 쉬웠음
 */
fun main() {
    println("Constructors 학습 시작!\n")

    // (1) 기본 생성자 호출
    // 생성자에 값을 주지 않으면, 기본값(width=1, height=1)이 사용된다.
    val s1 = Size1()
    println("s1: width=${s1.width}, height=${s1.height}, area=${s1.area}\n")

    // (2) 주 생성자에 값 전달
    // width=3, height=5로 지정하면서 객체 생성
    val s2 = Size(3, 5)
    println("s2: width=${s2.width}, height=${s2.height}, area=${s2.area}\n")

    // (3) 이름 있는 인자 사용
    // 매개변수 순서를 바꿔서 height 먼저 전달 → 순서와 상관없이 값이 잘 들어간다.
    val s3 = Size(height = 10, width = 2)
    println("s3: width=${s3.width}, height=${s3.height}, area=${s3.area}")
}

// Size 클래스: "가로(width), 세로(height)를 가진 사각형"을 표현하는 클래스
// 클래스 이름 옆 ( ... ) 이 바로 '주 생성자' 부분이다.
// 여기서 var width, var height는 "생성자 매개변수"이면서 동시에 "클래스 속성"이 된다.
class Size1(var width: Int = 1, var height: Int = 1) {

    // area는 width * height를 계산해서 저장하는 속성
    val area: Int = width * height

    // init 블록: 객체가 생성될 때 자동으로 실행되는 코드
    // 생성자에서 받은 값을 바탕으로 추가 작업을 할 수 있다.
    init {
        println("👉 Size 객체 생성됨: width=$width, height=$height, area=$area")
    }
}
