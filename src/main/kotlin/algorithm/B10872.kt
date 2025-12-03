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

/**
 *
 * fun main() {
 *     val n = readln().toInt()
 *     println(factorial(n))
 * }
 *
 * fun factorial(n: Int): Int {
 *     if (n == 0 || n == 1) {
 *         return 1  // 종료 조건
 *     }
 *     return n * factorial(n - 1)  // 재귀 호출
 * }
 */