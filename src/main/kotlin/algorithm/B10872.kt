package algorithm

/**
 * 날짜: 2025-12-03
 * 주제: # [팩토리얼](https://www.acmicpc.net/problem/10872)
 *
 * 배운 내용:
 * - 변수를 반복문 안에 선언하면 매번 초기화되어 값이 누적되지 않는다.
 *   반복문 밖에 선언해야 이전 결과를 계속 사용할 수 있다.
 * - for문의 i 변수를 실제 계산에 활용하는 방법을 배웠다.
 * - 같은 문제를 반복문과 재귀 두 가지 방식으로 풀 수 있다는 것을 알게 되었다.
 *
 * 어려웠던 점:
 * - 결과값을 저장할 변수를 어디에 선언해야 하는지 헷갈렸다.
 * - factorial = N-1이 매번 같은 값만 나오는 문제를 어떻게 해결할지 몰랐다.
 * - for문의 i를 어떻게 곱셈에 사용하는지 감이 안 왔다.
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