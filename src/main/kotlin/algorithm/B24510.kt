package algorithm

/**
 * 날짜: 2025-11-12
 * 주제: B24510
 * 
 * 배운 내용:
 * - 추상화 -> 구체적 코드 연결능력 부족
 * - 아직도 for문 헷갈림;
 * 
 * 어려웠던 점:
 * - 오랜만에 코테고 순수하게 내 머리로만 풀려니까 생각이 안나서 복잡했다.
 * - 기본원리를 알아가면서 해야할듯 싶다 (문법도 정확하게 뭘 모를까 체크하면서)
 */


/*
    1. 첫 줄에서 코드의 줄 개수 C를 입력받는다.

    2. C번 반복하면서 각 줄의 코드를 입력받는다.

    3. 각 줄에서 "for"가 몇 번 등장하는지 센다.

    4. "while"이 몇 번 등장하는지도 센다.

    5. 두 개를 합쳐서 현재 줄의 반복문 개수를 구한다.

    6. 지금까지의 최대값과 비교해서 더 크면 갱신한다.

    7. 마지막에 최댓값을 출력한다.
 */
fun main() {


    //val C = readln().toInt() // 코드의 줄 개수 C 입력받기.
    val c = readLine()!!.toInt()
    var maxCount = 0

    /*for(C:Int in 1..100) // 1<C<100 줄까지.
        // 여기서 어케해야하지 ?
     */

    repeat(c)
    {
        val line = readln()

        val countFor = Regex("for").findAll(line).count()
        val countWhile = Regex("while").findAll(line).count()
        val total = countFor + countWhile  // 현재 줄 반복문 총 개수

        // 최대값 갱신
        if (total > maxCount) {
            maxCount = total
        }

    }

    println(maxCount)

}