package fp.kotlin.example.chapter03.exercise

import kotlin.math.sqrt

/**
 * 연습문제 3-17
 *
 * 입력값 n의 제곱근을 2로 나눈 값이 1보다 작을때까지 반복하고 최초의 1보다 작은 값을 반환하는 함수를 상호 재귀를 사용하여 구현하라.
 * 이때 입력값 n은 2보다 크다.
 * 힌트:
 * 1) 제곱근을 구하는 함수와 2로 나누는 함수를 쪼개라.
 * 2) 제곱근은 java.lang.Math.sqrt() 함수를 사용하여 구할 수 있다.
 */

fun main() {
    require(0.528685631720282 == squareRoot(5.0))
}

private fun squareRoot(n: Double): Double = when {
    n < 1.0 -> n
    else -> divideTwo(sqrt(n))
}

private fun divideTwo(n: Double): Double  = when {
    n < 1.0 -> n
    else -> squareRoot(n/2.0)
}