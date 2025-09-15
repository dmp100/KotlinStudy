package oop

/**
 * 날짜: 2025-09-15
 * 주제: DeclaringClasses
 *
 * 배운 내용:
 * - 클래스는 새로운 타입을 정의하는 설계도 역할을 한다.
 * - Kotlin에서 클래스 선언은 `class` 키워드를 사용한다.
 * - 클래스 본문이 비어 있으면 중괄호 `{ }`를 생략할 수 있다.
 * - 클래스로부터 객체(인스턴스)를 생성할 수 있으며, `클래스이름()` 형태로 호출한다.
 * - 클래스 내부에는 속성(property)을 정의할 수 있다.
 *   - `var` : 변경 가능한 속성
 *   - `val` : 변경 불가능한 속성
 * - 객체마다 같은 속성을 가지지만, 속성 값은 객체마다 다를 수 있다.
 * - 객체의 속성에는 `객체이름.속성이름` 방식으로 접근하거나 값을 변경할 수 있다.
 *
 * 어려웠던 점:
 * - `val`과 `var`의 차이가 처음엔 헷갈렸음 → `val`은 참조 재할당 불가, 하지만 `var` 속성은 값 변경 가능.
 * - 객체마다 속성이 독립적이라는 점을 코드로 확인하니 이해가 더 쉬워졌다.
 */

// 1. 비어 있는 클래스 선언
class Emptiness
// 위 클래스는 본문이 없으므로 { } 생략 가능

// 2. 속성을 가진 클래스 선언
class Patient {
    var name: String = "Unknown"  // 이름 (기본값: Unknown)
    var age: Int = 0              // 나이 (기본값: 0)
    var height: Double = 0.0      // 키 (기본값: 0.0)
}

fun main() {
    println("DeclaringClasses 학습 시작!\n")

    // 1. 객체 생성
    val empty = Emptiness()  // Emptiness 클래스의 객체 생성
    println("빈 객체 생성: $empty") // 그냥 객체의 참조값 출력됨

    // 2. Patient 객체 생성
    val john = Patient()
    john.name = "John"
    john.age = 30
    john.height = 180.0

    val alice = Patient()
    alice.name = "Alice"
    alice.age = 22
    alice.height = 165.0

    // 3. 속성 출력
    println("${john.name}: ${john.age} yrs, ${john.height} cm")
    println("${alice.name}: ${alice.age} yrs, ${alice.height} cm")

    // 여기서 확인할 점:
    // - john의 속성을 변경해도 alice의 값은 영향을 받지 않는다.
    // - 같은 설계도(Patient 클래스)를 공유하지만, 객체마다 속성 값은 독립적이다.
}
