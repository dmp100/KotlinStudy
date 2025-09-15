package oop

/**
 * 날짜: 2025-09-15
 * 주제: ExtensionFunctions
 *
 * 배운 내용:
 * - 확장 함수는 기존 클래스에 새로운 함수를 추가하는 방법입니다.
 * - 기존 코드를 수정할 수 없거나, 외부 라이브러리 클래스에 기능을 추가할 때 유용합니다.
 * - 문법: ReceiverType.함수이름() = { ... }
 *   - ReceiverType: 확장할 클래스
 *   - 함수 내부에서 this 키워드로 확장 객체(Receiver 객체) 접근 가능
 * - 확장 함수 내부에서는 public/accessible 프로퍼티에만 접근 가능, private 멤버는 접근 불가
 * - 멤버 함수와 동일한 이름의 확장 함수를 정의하면, 호출 시 항상 멤버 함수가 우선됨
 * - 확장 함수도 일반 함수처럼 인자와 반환값 정의 가능
 */

fun main() {
    println("ExtensionFunctions 학습 시작!")

    // 1️⃣ String 클래스에 확장 함수 정의
    fun String.repeated(): String = this + this
    println("ha".repeated())  // 출력: haha
    // 설명: String 객체 "ha"에 repeated() 함수를 호출하면 자기 자신을 두 번 이어 붙인 값을 반환

    // 2️⃣ 커스텀 클래스에 확장 함수 정의
    class Client(val name: String, val age: Int)

    fun Client.getInfo(): String = "이름: $name, 나이: $age"

    val client = Client("John", 32)
    println(client.getInfo()) // 출력: 이름: John, 나이: 32
    // 설명: Client 클래스 자체에는 getInfo() 함수가 없지만, 확장 함수를 통해 정보 출력 기능 추가

    // 3️⃣ 확장 함수 vs 멤버 함수
    class A {
        fun member() = println("hi from member") // 멤버 함수
    }

    fun A.extension() = println("hi from extension") // 확장 함수

    val a = A()
    a.member()    // 출력: hi from member
    a.extension() // 출력: hi from extension
    // 설명: 호출 문법은 동일하지만, 멤버 함수와 확장 함수를 구분하려면 정의 위치를 확인해야 함
    // 멤버 함수가 이미 존재하면 동일 이름의 확장 함수는 무시됨

    // 4️⃣ 주의사항
    // - 멤버 함수와 동일한 이름을 가지는 확장 함수를 정의해도 호출 시 멤버 함수가 우선
    // - 확장 함수는 객체 내부 private 멤버에는 접근 불가
}
