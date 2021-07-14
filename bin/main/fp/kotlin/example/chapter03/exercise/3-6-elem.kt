package fp.kotlin.example.chapter03.exercise

import fp.kotlin.example.head
import fp.kotlin.example.tail

/**
 * 연습문제 3-6
 *
 * 입력값 n이 리스트에 존재하는지 확인하는 함수를 재귀로 작성해보자.
 *
 * 힌트: 함수의 선언 타입은 아래와 같다.
 * fun elem(n: Int, list: List<Int>): Boolean
 */

fun main() {
    require(elem(5, listOf(1, 3, 5)))
    require(!elem(5, listOf(1, 3, 7)))
}

/**
 * list의 head, tail은 이 교재의 확장함수..
 * first, drop을 사용해서 구현
 * drop index는 0부터 시작하지 않음..
 */
private fun elem(num: Int, list: List<Int>): Boolean = when {
    list.isEmpty() -> false
    else -> list.first() == num || elem(num, list.drop(1))
}