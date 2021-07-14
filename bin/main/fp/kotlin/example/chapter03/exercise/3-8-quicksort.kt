package fp.kotlin.example.chapter03.exercise

import fp.kotlin.example.tail

/**
 * 연습문제 3-8
 *
 * 퀵정렬 알고리즘의 ``quicksort`` 함수를 작성해 보자.
 *
 * 힌트1: 퀵정렬 알고리즘의 동작 방식은 아래 위키를 참고하자.
 * https://en.wikipedia.org/wiki/Quicksort
 * 힌트2: 리스트를 분할하기 위해 함수 ``partition``을 활용하자.
 */

fun main() {
    require(listOf(1, 2, 3, 4, 5, 6, 7) == quicksort(listOf(5, 3, 7, 6, 2, 1, 4)))
}

private fun quicksort(list: List<Int>): List<Int> = when {
    list.isEmpty() -> listOf()
    else -> {
        val pivot = list.first()
        val partitionList = list.partition { item -> item < pivot }
        val first = partitionList.first
        val second = partitionList.second.drop(1)

        quicksort(first) + listOf(pivot) + quicksort(second)
    }
}

private fun quickSortRefactoring(list: List<Int>): List<Int> = when {
    list.isEmpty() -> list // 기본 반환하는게 객체 생성하지 않고 좋음
    else -> {
        val pivot = list.first()
        // it 표현
        // 먼저 drop시키고 표현하는거
        // pair로 받는거 좋음
        val (first, second) = list.drop(1).partition { it < pivot }
        quicksort(first) + listOf(pivot) + quicksort(second)
    }
}