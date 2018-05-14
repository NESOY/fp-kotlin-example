package fp.kotlin.example.chapter05.solution

import fp.kotlin.example.chapter05.FunList
import fp.kotlin.example.chapter05.FunList.Cons
import fp.kotlin.example.chapter05.FunList.Nil
import fp.kotlin.example.chapter05.funListOf

/**
 *
 * 연습문제 5-9
 *
 * 앞서 생성한 map을 기반으로, 고차함수가 요소들의 index 값도 같이 받아 올수 있는 indexedMap 함수를 만들자.
 *
 * 힌트: 함수의 선언 타입은 아래와 같다.
 *
 */

fun main(args: Array<String>) {

    val intList = Cons(1, Cons(2, Cons(3, Nil)))
    require(intList.indexedMap { index, elm -> index * elm } == funListOf(0, 2, 6))
}

fun <T, R> FunList<T>.indexedMap(index: Int = 0, f: (Int, T) -> R): FunList<R> = when (this) {
    Nil -> Nil
    is Cons -> Cons(f(index, head), tail.indexedMap(index + 1, f))
}