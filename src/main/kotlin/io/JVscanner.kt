package io

/**
 * 날짜: 2025-08-19
 * 주제: JVscanner
 *
 * 배운 내용:
 * - Scanner를 사용하면 입력을 단어 단위, 숫자 단위 등 다양한 방식으로 읽을 수 있음.
 * - 구분자(useDelimiter)를 사용해 사용자 정의 구분자로 데이터 분리 가능.
 * - hasNext(), hasNextInt() 등으로 안전하게 입력 확인 가능.
 * - https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html
 */

import java.util.Scanner

fun main() {
    // Scanner 생성 (표준 입력)
    val scanner = Scanner(System.`in`)
    // System.`in` : 표준 입력(키보드 입력)

    // 1) 한 줄 읽기
    println("문자열 한 줄 입력:")
    val scannerLine = scanner.nextLine()
    println("nextLine(): $scannerLine")

    // 2) 한 단어 읽기
    println("단어 입력:")
    val scannerWord = scanner.next()
    println("next(): $scannerWord")

    // 3) 정수 읽기
    println("정수 입력:")
    val scannerNum = if (scanner.hasNextInt()) {
        scanner.nextInt()
    } else {
        println("정수가 아닙니다! 기본값 0 반환")
        0
    }
    println("nextInt(): $scannerNum")

    // 4) 사용자 정의 구분자
    val scannerDelimiter = Scanner("123_456")
    scannerDelimiter.useDelimiter("_") // "_" 구분자 설정
    println("Delimiter 예제 → ${scannerDelimiter.nextInt()}, ${scannerDelimiter.nextInt()}")

    // 5) hasNext()를 활용한 안전한 단어 읽기
    val scannerText = Scanner("Hello, Kotlin!")
    println("\n[hasNext() 예제]")
    while (scannerText.hasNext()) {
        println(scannerText.next())
    }

    // 마무리 (리소스 해제)
    scanner.close()
    scannerDelimiter.close()
    scannerText.close()
}
