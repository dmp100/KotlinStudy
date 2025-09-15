package oop

/**
 * 날짜: 2025-09-15
 * 주제: 객체 지향 프로그래밍(OOP)이란 무엇인가
 *
 * 배운 내용:
 * - 객체 지향 프로그래밍(OOP)은 '객체'를 중심으로 프로그램을 설계하는 패러다임이다.
 * - 객체는 '상태'와 '동작'을 가진다. 상태는 필드(field)로, 동작은 메서드(method)로 표현된다.
 * - 클래스(Class)는 객체(Object)를 만들기 위한 '설계도' 또는 '템플릿'이다.
 * - 객체는 클래스의 '인스턴스'다.
 * - OOP의 4대 원칙: 캡슐화, 추상화, 상속, 다형성
 *
 * 어려웠던 점:
 * - 4대 원칙의 개념을 추상적으로 이해하기보다는 실제 코드로 어떻게 구현되는지 파악하는 것이 중요함을 깨달았다.
 * - 특히, 상속과 다형성의 관계를 명확히 이해하는 데 시간이 필요했다.
 */

// ---------------------------------------------------------------------------------------------------------------------
// 1. 객체와 클래스: OOP의 기본 구성 요소
// 현실 세계의 사물(객체)을 모델링하여 클래스를 만들고, 그 클래스로부터 객체를 생성한다.
// ---------------------------------------------------------------------------------------------------------------------

/**
 * Car 클래스는 '자동차' 객체의 설계도 역할을 한다.
 * 이 클래스는 모든 자동차가 공통적으로 가질 수 있는 속성(색상, 속도)과 동작(가속, 정지)을 정의한다.
 */
class Car {
    // 필드(상태): 객체의 현재 상태를 나타내는 속성들
    var color: String = "Blue"
    var speed: Int = 0

    // 메서드(동작): 객체가 수행할 수 있는 기능
    fun accelerate(acceleration: Int) {
        speed += acceleration
        println("가속! 현재 속도: $speed km/h")
    }

    fun brake(deceleration: Int) {
        speed -= deceleration
        if (speed < 0) speed = 0
        println("감속! 현재 속도: $speed km/h")
    }
}

// ---------------------------------------------------------------------------------------------------------------------
// 2. OOP의 4대 원칙을 코드로 구현
// ---------------------------------------------------------------------------------------------------------------------

/**
 * 캡슐화(Encapsulation) 원칙
 * 데이터(balance)와 메서드(deposit, withdraw)를 하나의 클래스(BankAccount)로 묶고,
 * private 접근 제한자를 사용해 외부에서 잔액에 직접 접근할 수 없도록 숨긴다.
 * 이는 데이터의 무결성을 보호하고 코드의 안정성을 높인다.
 */
class BankAccount(private var balance: Double) {
    fun getBalance(): Double {
        return balance
    }
    fun deposit(amount: Double) {
        if (amount > 0) balance += amount
    }
    fun withdraw(amount: Double) {
        if (amount > 0 && balance >= amount) balance -= amount
    }
}

/**
 * 상속(Inheritance) 원칙
 * 'Animal' 클래스를 부모 클래스로 정의하고, 'Dog'와 'Cat' 클래스가 이를 상속받는다.
 * 'Dog'와 'Cat'은 부모 클래스의 메서드(eat)를 재사용할 수 있으며,
 * 동시에 자신들만의 고유한 메서드(bark, meow)를 가질 수 있다.
 */
open class Animal(val name: String) {
    fun eat() {
        println("$name 이/가 밥을 먹습니다.")
    }
}
class Dog(name: String) : Animal(name) {
    fun bark() {
        println("멍멍!")
    }
}
class Cat(name: String) : Animal(name) {
    fun meow() {
        println("야옹!")
    }
}

/**
 * 다형성(Polymorphism) 원칙
 * 'Animal' 타입의 리스트에 'Dog'와 'Cat' 객체를 담을 수 있다.
 * 리스트를 순회하며 각 객체의 'eat()' 메서드를 호출할 때,
 * 모든 객체가 동일한 'eat' 메서드명을 사용하지만, 실제 동작은 각 객체의 타입에 따라 달라질 수 있다.
 * (이 예제에서는 eat 메서드를 override하지 않아 동일하게 동작하지만, 개념적으로 다른 동작을 수행할 수 있음을 보여준다)
 */
fun demonstratePolymorphism() {
    val animals: List<Animal> = listOf(Dog("바둑이"), Cat("나비"))
    animals.forEach { animal ->
        animal.eat() // '바둑이'가 밥을 먹습니다. '나비'가 밥을 먹습니다.
    }
}

/**
 * 추상화(Abstraction) 원칙
 * 'Shape'라는 추상 클래스를 정의하여 'draw'라는 추상 메서드를 포함한다.
 * 'Circle'과 'Square'는 이 클래스를 상속받아 'draw' 메서드를 각자의 방식대로 구현한다.
 * 사용자는 'Shape'라는 인터페이스를 통해 복잡한 내부 구현을 알 필요 없이 'draw' 기능을 사용할 수 있다.
 */
abstract class Shape {
    abstract fun draw()
}
class Circle : Shape() {
    override fun draw() {
        println("원을 그립니다.")
    }
}
class Square : Shape() {
    override fun draw() {
        println("정사각형을 그립니다.")
    }
}

fun main() {
    println("WhatIsOOP 학습 시작!")

    // Car 클래스를 사용한 객체 생성 및 상호작용
    val myCar = Car()
    myCar.accelerate(20)
    myCar.brake(5)

    // BankAccount 클래스를 사용한 캡슐화 예제
    val account = BankAccount(10000.0)
    println("\n현재 잔액: ${account.getBalance()}원")
    account.deposit(5000.0)
    account.withdraw(2000.0)
    println("최종 잔액: ${account.getBalance()}원")

    // Animal 클래스를 사용한 상속 예제
    val myDog = Dog("초코")
    val myCat = Cat("루나")
    println()
    myDog.eat()
    myDog.bark()
    myCat.eat()
    myCat.meow()

    // 다형성 예제 실행
    println("\n다형성 예제:")
    demonstratePolymorphism()

    // 추상화 예제 실행
    println("\n추상화 예제:")
    val circle = Circle()
    val square = Square()
    val shapes: List<Shape> = listOf(circle, square)
    shapes.forEach { it.draw() }
}