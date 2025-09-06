package io

/**
 * 날짜: 2025-09-01
 * 주제: readln - 표준 입력 처리
 *
 * 배운 내용:
 * - readln() 함수로 표준 입력에서 데이터 읽기
 * - 다양한 데이터 타입으로 변환 (toInt, toLong, toDouble, toBoolean)
 * - 다중 입력 처리 방법
 * - split()을 사용한 한 줄 다중 값 처리
 *
 * 어려웠던 점:
 * - readLine()!!과 readln()의 차이점 이해
 * - 타입 변환 함수들의 적절한 사용
 */

fun main() {

    // 표준 입력은 프로그램으로 들어오는 데이터 스트림으로, 운영 체제에서 지원.
    // 데이터 읽기 -> 데이터 처리 -> 표준 출력

    val line = readln()
    // String 자동변환, 전체 줄 문자 읽기.
    println(line)

    val line1 = readLine()!!
    // Kotlin 1.6 이전
    // 느낌표(!!)는 컴파일러에게 비어 있지 않은 입력을 보장하는 구문
    println(line1)

    val number = readln().toInt()
    // 정수입력 - toInt()
    println(number)

    val cost = readln().toLong()
    // 큰 정수 입력 - toLong()
    println(cost)

    val Double = readln().toDouble()
    // 실수 입력 - toDouble()

    val Bool = readln().toBoolean()
    // 논리값 입력(참,거짓) - toBoolean()

    val a = readln()
    val b = readln().toInt()
    val c = readln()
    print(a)
    print(" ")
    print(b)
    print(" ")
    print(c)
    // 다중 입력 처리

    val (a1, b1) = readln().split(" ")
    println(a1)
    println(b1)

    val (a2, b2, c2, d2) = readln().split(" ")
    println(a2)
    println(b2)
    println(c2)
    println(d2)
    // 한 줄에 여러 값 읽기
}