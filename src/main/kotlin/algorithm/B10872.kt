package algorithm

/**
 * 날짜: 2025-12-03
 * 주제: B10872
 * 
 * 배운 내용:
 * - 
 * 
 * 어려웠던 점:
 * - 
 */
fun main() {

    val n = readln().toInt()

    var result = 1
    for (i in 1..n) {
        result = result * i
    }

    println(result)
}

