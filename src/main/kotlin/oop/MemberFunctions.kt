package oop

/**
 * 날짜: 2025-09-15
 * 주제: MemberFunctions
 *
 * 배운 내용:
 * - 클래스 내부에서 정의된 함수는 멤버 함수(member function)라고 함
 * - 멤버 함수는 객체의 상태(프로퍼티)에 접근 가능
 * - this 키워드는 현재 객체를 가리키지만 생략 가능
 * - 멤버 함수는 일반 함수처럼 매개변수와 반환값 정의 가능
 * - 멤버 함수를 호출하려면 먼저 객체를 생성해야 함
 */

import kotlin.random.Random // 랜덤값 생성을 위한 라이브러리

// 간단한 클래스와 멤버 함수 예제
class MyClass {
    fun printMessage() {
        println("Hello from printMessage")
    }
}

// 프로퍼티를 가진 클래스와 멤버 함수 예제
class MyClassWithProperty(var property: Int) {
    fun printProperty() {
        println("현재 property 값: $property")
    }
}

// 조금 더 복잡한 예제: 고양이 클래스
class Cat(val name: String) {

    /** 현재 고양이 상태: 기본값은 잠들지 않음(false) */
    var sleeping: Boolean = false

    /**
     * 고양이의 울음 함수
     * - 잠들었으면 "zzz" 출력
     * - 깨어있으면 "meow" 출력 후 10% 확률로 잠듦
     */
    fun say() {
        if (sleeping) {
            println("zzz")
        } else {
            println("meow")

            // 랜덤으로 10% 확률로 잠들게 함
            if (Random.nextDouble() < 0.1) {
                sleeping = true
            }
        }
    }

    /** 고양이를 깨우는 함수 */
    fun wakeUp() {
        sleeping = false
    }
}

fun main() {
    println("MemberFunctions 학습 시작!")

    // 단순 객체 생성 후 멤버 함수 호출
    val obj = MyClass()
    obj.printMessage()  // Hello from printMessage

    val objWithProp = MyClassWithProperty(10)
    objWithProp.printProperty() // 현재 property 값: 10

    // Cat 객체 생성 후 멤버 함수 호출
    val pharaoh = Cat("Pharaoh")

    repeat(5) {
        pharaoh.say() // "meow" 또는 "zzz" 출력, 랜덤으로 잠들 수 있음
    }

    pharaoh.wakeUp() // 고양이를 깨움
    pharaoh.say()    // 깨어있으므로 "meow" 출력
}
