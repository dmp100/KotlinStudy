/**
 * 날짜: 2025-09-15
 * 주제: 구조적 동등성 vs. 참조 동등성
 *
 * 배운 내용:
 * - Kotlin 변수는 객체 자체를 담는 것이 아니라 객체를 가리키는 '참조'를 저장한다.
 * - **구조적 동등성(Structural Equality)**: 두 변수가 가리키는 객체의 '상태'가 동일한지 비교한다.
 * - `==` 연산자를 사용한다.
 * - 예: "Hi" == "Hi"는 `true`.
 * - **참조 동등성(Referential Equality)**: 두 변수가 동일한 '객체'를 가리키는지 비교한다.
 * - `===` 연산자를 사용한다.
 * - 예: `val box1 = Box()`, `val box2 = box1`일 때, `box1 === box2`는 `true`.
 * - `val` 키워드는 변수의 '참조'를 재할당할 수 없게 할 뿐, 객체 내부의 '상태'가 변경되는 것을 막지 않는다. 즉, **불변성(Immutability)을 보장하지 않는다.**
 *
 * 어려웠던 점:
 * - `==`와 `===`의 정확한 차이점 이해
 * - `val` 변수가 가리키는 가변(mutable) 객체의 상태 변경 가능성
 * - 기본 타입(Int, String 등)의 객체 동작 방식
 */
fun main() {

    /*************** - 구조적 동등성 vs. 참조 동등성 - ****************/
    println("=== 구조적 동등성 vs. 참조 동등성 ===")

    // Box 클래스 (예제용)
    class Box(var balls: Int) {
        override fun equals(other: Any?): Boolean {
            return (other as? Box)?.balls == this.balls
        }
    }

    val blueBox = Box(3)
    val azureBox = blueBox
    val cyanBox = Box(3)

    // 구조적 동등성: '내용'이 같은가?
    println("blueBox == azureBox : ${blueBox == azureBox}")  // true (같은 내용)
    println("blueBox == cyanBox : ${blueBox == cyanBox}")    // true (같은 내용)

    // 참조 동등성: '같은 객체'인가?
    println("blueBox === azureBox : ${blueBox === azureBox}")  // true (같은 객체를 가리킴)
    println("blueBox === cyanBox : ${blueBox === cyanBox}")    // false (다른 객체를 가리킴)

    // 가변 객체의 상태 변경
    blueBox.balls = 4
    println("\nblueBox.balls = 4로 변경 후:")
    println("blueBox == azureBox : ${blueBox == azureBox}")  // true (둘 다 4)
    println("blueBox == cyanBox : ${blueBox == cyanBox}")    // false (blueBox는 4, cyanBox는 3)
    println("blueBox.balls: ${blueBox.balls}")
    println("azureBox.balls: ${azureBox.balls}")
    println("cyanBox.balls: ${cyanBox.balls}")

    /*************** - val 키워드와 불변성 - ****************/
    println("\n=== val 키워드와 불변성 ===")

    // val은 참조를 재할당할 수 없다.
    val myValBox = Box(10)
    // myValBox = Box(20) // 오류: Val cannot be reassigned

    // 하지만, val이 가리키는 가변 객체의 내부 상태는 변경할 수 있다.
    println("myValBox.balls (변경 전): ${myValBox.balls}")
    myValBox.balls = 20
    println("myValBox.balls (변경 후): ${myValBox.balls}") // 20

    // 불변(immutable) 객체의 경우
    val msg1 = "Hi"
    // msg1 = "Hello" // 오류: Val cannot be reassigned
    val msg2 = "Hi"

    // 불변 객체는 상태가 변하지 않으므로, 여러 변수가 같은 객체를 참조해도 안전하다.
    println("msg1 === msg2 : ${msg1 === msg2}") // true (같은 객체를 가리킬 수 있다)

    /*************** - 기본 타입과 동등성 - ****************/
    println("\n=== 기본 타입과 동등성 ===")

    // Int, Double, String 등은 모두 객체이며 불변 객체처럼 동작한다.
    var a: Int = 100
    val anotherA: Int = a

    // 초기에 동일한 값을 가진 변수는 같은 객체를 참조할 수 있다.
    println("초기: a === anotherA : ${a === anotherA}") // true

    a = 200 // a에 새로운 값(객체)이 할당된다.
    println("a = 200 할당 후: a === anotherA : ${a === anotherA}") // false

    // String 객체도 마찬가지
    val str1 = "Hello"
    val str2 = str1
    val str3 = "Hello"

    println("str1 === str2 : ${str1 === str2}") // true
    println("str1 === str3 : ${str1 === str3}") // true (Kotlin/JVM 최적화)

    /*************** - 결론 - ****************/
    println("\n=== 정리 ===")
    println("- 구조적 동등성(==)은 객체의 상태를 비교하고, 참조 동등성(===)은 객체의 동일성을 비교한다.")
    println("- `val` 키워드는 변수의 '재할당'을 막을 뿐, 가변 객체의 '상태' 변경까지 막지 않는다.")
    println("- 불변 객체는 스레드 안전성, 예측 가능성 등의 장점을 가진다.")
}