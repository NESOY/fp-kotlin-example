package fp.kotlin.example.chapter03.exercise

/**
 * 연습문제 3-16
 *
 * 연습문제 3-6에서 작성한 ``elem`` 함수가 꼬리 재귀인지 확인해보자. 만약 꼬리 재귀가 아니라면 개선해보자.
 */

fun main() {
    require(elem(5, listOf(1, 3, 5)))
    require(!elem(5, listOf(1, 3, 7)))
}

private tailrec fun elem(element: Int, list: List<Int>, acc: Boolean = false): Boolean = when {
    list.isEmpty() -> acc
    else -> elem(element, list.drop(1), acc || list.first() == element)
}

/*
Refactoring
-> Pattern 하나 추가 굳이 acc Parameter를 추가해서 구현하지 않아도 된다.
 */