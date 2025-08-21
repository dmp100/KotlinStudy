package operators

/**
 * 날짜: 2025-08-22
 * 주제: operandTor
 * 
 * 배운 내용:
 * - 숫자는 숫자끼리, 문자는 문자끼리 더할 수 있다
 * - 숫자에서 문자열은 불가능
 * 
 * 어려웠던 점:
 * - 
 */
fun main() {

    // 되는 경우

    // 1) Char + String ✅
    val a = 'a' + "bc"       // Char.plus(String)
    println(a)               // "abc"

    // 2) String + Char ✅
    val b = "ab" + 'c'       // String.plus(Char)
    println(b)               // "abc"

    // 3) Int + Int ✅
    val c = 1 + 2            // Int.plus(Int)
    println(c)               // 3

    // 4) String + Int ✅
    val e = "1" + 2          // String.plus(Int)
    println(e)               // "12"

    // 5) Char + Int ✅
    val f = 'a' + 1          // Char.plus(Int)
    println(f)               // 'b'

    // X
    // 1) Char + Char ❌
    // val x = 'a' + 'b'   // Error: none of the following functions can be called

    // 2) Int + Char ❌
    // val y = 1 + 'a'     // Error: none of the following functions can be called

    // 3) Double + Char ❌
    // val z = 1.5 + 'a'   // Error
}

