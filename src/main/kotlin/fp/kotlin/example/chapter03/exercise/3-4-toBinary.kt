package fp.kotlin.example.chapter03.exercise

import java.lang.Exception

/**
 * 연습문제 3-4
 *
 * 10진수 숫자를 입력받아서 2진수로 문자열로 변환하여 반환하는 함수를 작성하라.
 *
 * 힌트: 함수의 선언 타입은 아래와 같다.
 * fun toBinary(n: Int): String
 */

fun main() {
    require("1" == toBinary(1))
    require("10" == toBinary(2))
    require("1010" == toBinary(10))
    require("11011" == toBinary(27))
    require("11111111" == toBinary(255))
}

/**
 * when expression에서 n을 제거하면 boolean으로 변경가능
 */
private fun toBinary(n: Int): String = when {
    n == 0 -> "0"
    n == 1 -> "1"
    n % 2 == 1 -> toBinary(n/2) + "1"
    n % 2 == 0 -> toBinary(n/2) + "0"
    else -> throw Exception()
}

private fun toBinaryRefactoring(n: Int): String = when {
    n < 2 -> n.toString()
    else -> toBinary(n/2) + (n%2).toString()
}