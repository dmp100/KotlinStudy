package operators

/**
 * 날짜: 2025-08-20
 * 주제: IncrementAndDecrement
 *
 * 배운 내용:
 * - 복합 할당 연산자(+=, -=, *=, /=, %=): 연산과 할당을 동시에 수행
 * - 복합 할당 연산자는 반드시 초기화된 변수에만 사용 가능
 * - 증감 연산자(++, --): 변수의 값을 1씩 증가/감소
 * - 전위 연산자(++a, --a): 먼저 증감 후 값 사용
 * - 후위 연산자(a++, a--): 먼저 값 사용 후 증감
 * - 전위와 후위 연산자의 차이점과 실행 순서
 *
 * 어려웠던 점:
 * - 전위와 후위 연산자의 차이점 이해하기
 * - 복합 할당 연산자가 초기화된 변수에만 사용 가능한 이유
 */
fun main() {

    // 복합 할당 연산자
    var a = 3 // 초기화해서만 사용해야함
    a = a + 1 //4
    a = a - 1 //3

    a += 2 // 5 - a += 2는 a = a + 2
    a -= 2 // 3- 나머지는 전부 동일
    a *= 2 // 6
    a /= 2 // 3
    a %= 2 // 1

    // 증감 연산자
    var num = 3
    num++  // 4, increment
    // num = num + 1과 같음, 결과: num = 4

    num--  // 3, decrement
    // // num = num - 1과 같음, 결과: num = 3

    var b = 5
    val result = b++  // result = 5, a = 6
    // 후위 연산자(Postfix) : 먼저 a의 현재 값(5)을 result에 할당한 후, a를 증가시킴
    println(b)
    print(result)


    var c = 5
    val result1 = ++c  // result = 6, a = 6
    // 전위 연산자 (Prefix) : 먼저 a를 증가시킨 후, 그 값(6)을 result에 할당
    println(c)
    print(result1)

    var x = 10
    println(x++)  // 출력: 10, x는 이제 11
    println(x)    // 출력: 11

    var y = 10
    println(++y)  // 출력: 11, y는 이제 11
    println(y)    // 출력: 11

}